package api

import actor.{ActorA, ActorB}
import actor.ActorA.IncomingMessage
import akka.actor.{ActorSystem, Props}
import akka.stream.ActorMaterializer
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._

object Main extends App {

  implicit val system = ActorSystem("webserver-actor-system")
  implicit val materializer = ActorMaterializer()

  implicit val timeout = Timeout(2.seconds) //for ask

  val actorA = system.actorOf(Props[ActorA], "actorA")
  val actorB = system.actorOf(Props[ActorB], "actorB")

  actorA ! IncomingMessage("aaaa")
  actorA ? IncomingMessage("aaa")
  actorB ! actor.ActorB.IncomingMessage("bbbbb")

}
