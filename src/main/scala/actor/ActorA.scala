package actor

import actor.ActorA.IncomingMessage
import akka.actor.{Actor, ActorLogging, Props}

class ActorA extends Actor with ActorLogging {
  override def receive: Receive = {
    case IncomingMessage(a) => { println(s"incoming message=$a"); sender ! s"got $a" }
  }
}

object ActorA {
  val props: Props = Props[ActorA]

  sealed trait AMessage
  case class IncomingMessage(content: String) extends AMessage
}