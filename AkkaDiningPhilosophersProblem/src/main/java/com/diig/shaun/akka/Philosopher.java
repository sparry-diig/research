/**
 * *************************************************************************
 *
 * Filename : Philosopher.java 
 * Language : Java 2 v7 
 * Purpose  : Implements a Philosopher as an Akka Actor.
 *
 * (C) COPYRIGHT Decision Insight Information Group, 2014 All Rights Reserved
 *
 ****************************************************************************
 */
package com.diig.shaun.akka;

import akka.actor.ActorRef;
import akka.actor.Cancellable;
import akka.actor.UntypedActor;
import java.util.concurrent.TimeUnit;
import scala.concurrent.duration.Duration;

public class Philosopher extends UntypedActor {

  private ActorRef leftPhilosopher;
  private ActorRef rightPhilosopher;

  private final StateMessage state = new StateMessage();
  private StateMessage leftState;
  private StateMessage rightState;

  @Override
  public void onReceive(Object msg) throws Exception {
    if (msg instanceof SetupMessage) {
      //configures the left and right philosopher
      if (((SetupMessage) msg).getSide() == SetupMessage.Side.LEFT) {
        leftPhilosopher = ((SetupMessage) msg).getPhilosopher();
      } else {
        rightPhilosopher = ((SetupMessage) msg).getPhilosopher();
      }
    } else if (msg instanceof StateMessage) {
      //philosopher status message
      StateMessage smpMsg = (StateMessage) msg;
      if (smpMsg.getSender() == null) {
        //indicates that it's not from a philosopher
        //but is an initialisation
        state.setSender(getSelf());
        state.setState(smpMsg.getState());
      } else {
        //indicates that it's from another philosopher
        if (leftPhilosopher != null && smpMsg.getSender().equals(leftPhilosopher)) {
          leftState = smpMsg;
        } else if (rightPhilosopher != null && smpMsg.getSender().equals(rightPhilosopher)) {
          rightState = smpMsg;
        }
      }
      updateState();
    } else {
      unhandled(msg);
    }
  }

  private void updateState() {
    StateMessage.State newState = StateMessage.State.THINKING;
    //if the philosopher on both sides are thinking...
    if (rightState != null && rightState.getState() == StateMessage.State.THINKING
        && leftState != null && leftState.getState() == StateMessage.State.THINKING) {
      //then I must be eating...
      newState = StateMessage.State.EATING;
    }
    if (state.getState() != newState) {
      state.setState(newState);
      System.out.println("Change state: " + getSelf().toString() + " " + state.getState().toString());
      if (state.getState() == StateMessage.State.EATING) {
        //if I'm eating, set a timer to change my state back to thinking 
        //after 20 seconds
        StateMessage thinkingMessage = new StateMessage();
        thinkingMessage.setState(StateMessage.State.THINKING);
        getContext().system().scheduler()
                .scheduleOnce(Duration.create(5, TimeUnit.SECONDS),
                              getSelf(), thinkingMessage, getContext().dispatcher(), null);
      } 
    }
    //and let my neighbours know my current state
    leftPhilosopher.tell(state, getSelf());
    rightPhilosopher.tell(state, getSelf());
  }

}
