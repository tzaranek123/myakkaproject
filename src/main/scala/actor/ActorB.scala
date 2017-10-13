package actor

import actor.ActorB.IncomingMessage
import akka.actor.{Actor, ActorLogging, Props}

class ActorB extends Actor with ActorLogging {
  override def receive: Receive = {
    case IncomingMessage(a) => { log.info(s"incoming message=$a"); sender ! s"got $a" }
  }
}

object ActorB {
  val props: Props = Props[ActorA]

  sealed trait BMessage
  case class IncomingMessage(content: String) extends BMessage
}