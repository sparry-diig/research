/**
 * *************************************************************************
 *
 * Filename : StateMessage.java 
 * Language : Java 2 v7 
 * Purpose  : This is a simple message used to communicate state changes from 
 *            one philosopher to another.
 *
 * (C) COPYRIGHT Decision Insight Information Group, 2014 All Rights Reserved
 *
 ****************************************************************************
 */

package com.diig.shaun.akka;

import akka.actor.ActorRef;

public class StateMessage {
  
  private ActorRef sender;

  public ActorRef getSender() {
    return sender;
  }

  public void setSender(ActorRef sender) {
    this.sender = sender;
  }
  
  public enum State {
    EATING, THINKING
  }
  
  private State state = State.THINKING;

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

}
