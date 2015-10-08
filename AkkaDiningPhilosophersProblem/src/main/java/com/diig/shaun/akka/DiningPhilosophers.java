/**
 * *************************************************************************
 *
 * Filename : DiningPhilosophers.java 
 * Language : Java 2 v7 
 * Purpose  : Illustrates how Akka actors can be used to implement a solution
 *            to the dining philosophers problem 
 *            (http://en.wikipedia.org/wiki/Dining_philosophers_problem).
 *
 * (C) COPYRIGHT Decision Insight Information Group, 2014 All Rights Reserved
 *
 ****************************************************************************
 */
package com.diig.shaun.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class DiningPhilosophers {

  public static void main(String args[]) {
    //create the actor environment
    ActorSystem system = ActorSystem.create("DiningPhilosophers");

    //create five philosophers as actors using the Philosopher class
    ActorRef philosopher1 = system.actorOf(new Props(Philosopher.class), "philosopher1");
    ActorRef philosopher2 = system.actorOf(new Props(Philosopher.class), "philosopher2");
    ActorRef philosopher3 = system.actorOf(new Props(Philosopher.class), "philosopher3");
    ActorRef philosopher4 = system.actorOf(new Props(Philosopher.class), "philosopher4");
    ActorRef philosopher5 = system.actorOf(new Props(Philosopher.class), "philosopher5");
    
    //connect the philosophers together in a ring 1 - 2 - 3 - 4 - 5 - 1
    philosopher1.tell(new SetupMessage(philosopher2, SetupMessage.Side.LEFT), null);
    philosopher1.tell(new SetupMessage(philosopher5, SetupMessage.Side.RIGHT), null);
    philosopher2.tell(new SetupMessage(philosopher3, SetupMessage.Side.LEFT), null);
    philosopher2.tell(new SetupMessage(philosopher1, SetupMessage.Side.RIGHT), null);
    philosopher3.tell(new SetupMessage(philosopher4, SetupMessage.Side.LEFT), null);
    philosopher3.tell(new SetupMessage(philosopher2, SetupMessage.Side.RIGHT), null);
    philosopher4.tell(new SetupMessage(philosopher5, SetupMessage.Side.LEFT), null);
    philosopher4.tell(new SetupMessage(philosopher3, SetupMessage.Side.RIGHT), null);
    philosopher5.tell(new SetupMessage(philosopher1, SetupMessage.Side.LEFT), null);
    philosopher5.tell(new SetupMessage(philosopher4, SetupMessage.Side.RIGHT), null);

    //set them all to thinking and two of them should start eating
    StateMessage thinkingMessage = new StateMessage();
    thinkingMessage.setState(StateMessage.State.THINKING);
    philosopher1.tell(thinkingMessage, null);
    philosopher2.tell(thinkingMessage, null);
    philosopher3.tell(thinkingMessage, null);
    philosopher4.tell(thinkingMessage, null);
    philosopher5.tell(thinkingMessage, null);
    
    //alternatively, set them all to eating and see what happens
//    StateMessage eatingMessage = new StateMessage();
//    eatingMessage.setState(StateMessage.State.EATING);
//    philosopher1.tell(eatingMessage, null);
//    philosopher2.tell(eatingMessage, null);
//    philosopher3.tell(eatingMessage, null);
//    philosopher4.tell(eatingMessage, null);
//    philosopher5.tell(eatingMessage, null);
    
  }

}
