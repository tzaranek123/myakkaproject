package actor

import actor.ActorA.IncomingMessage
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

class ActorA(actorB: ActorRef) extends Actor with ActorLogging {
  override def receive: Receive = {
    case IncomingMessage(a) => log.info(s"forwarding message=$a to actorB"); actorB ! s"actorB I got $a"
  }
}

object ActorA {
  //val props: Props = Props[ActorA]
  def props(actorB:ActorRef) = Props(classOf[ActorA],actorB)

  sealed trait AMessage
  case class IncomingMessage(content: String) extends AMessage
}