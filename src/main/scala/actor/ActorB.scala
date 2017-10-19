package actor

import actor.ActorB.IncomingBMessage
import akka.actor.{Actor, ActorLogging, Props}

class ActorB extends Actor with ActorLogging {
  override def receive: Receive = {
    case IncomingBMessage(a) => { log.info(s"incoming message=$a"); sender ! s"got $a" }
    case someString:String => log.info(s"2nd match; $someString")
  }
}

object ActorB {
  val props: Props = Props[ActorA]

  sealed trait BMessage
  case class IncomingBMessage(content: String) extends BMessage
}