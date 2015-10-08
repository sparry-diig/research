/**
 * *************************************************************************
 *
 * Filename : SetupMessage.java 
 * Language : Java 2 v7 
 * Purpose  : This is the message class used to communicate with a philosopher 
 *            to set up it's configuration.
 *
 * (C) COPYRIGHT Decision Insight Information Group, 2014 All Rights Reserved
 *
 ****************************************************************************
 */

package com.diig.shaun.akka;

import akka.actor.ActorRef;

public class SetupMessage {
  
  public enum Side {
    LEFT, RIGHT
  }
  
  private final ActorRef philosopher;
  private final Side side;

  public Side getSide() {
    return side;
  }

  public ActorRef getPhilosopher() {
    return philosopher;
  }

  public SetupMessage(ActorRef philosopher, Side side) {
    this.philosopher = philosopher;
    this.side = side;
  }
}
