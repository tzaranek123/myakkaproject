package actor

import actor.ActorA.IncomingMessage
import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

class ActorASpec extends TestKit(ActorSystem("test-system"))
  with FlatSpecLike
  with Matchers
  with BeforeAndAfterAll
  with ImplicitSender {


  override def afterAll(): Unit = {
    super.afterAll()
    TestKit.shutdownActorSystem(system)
  }

  "actorB" should "receive message from actorA" in {
    val probe = TestProbe()
    val actorA = TestActorRef(new ActorA(probe.ref))

    actorA ! IncomingMessage("bleh")

    probe.expectMsg("actorB I got bleh")
  }

}
