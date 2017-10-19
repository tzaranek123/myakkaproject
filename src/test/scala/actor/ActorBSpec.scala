package actor

import actor.ActorB.IncomingBMessage
import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

class ActorBSpec extends TestKit(ActorSystem("test-system"))
  with FlatSpecLike
  with Matchers
  with BeforeAndAfterAll
  with ImplicitSender {

  override def afterAll(): Unit = {
    super.afterAll()
    TestKit.shutdownActorSystem(system)
  }

  "actorB" should "return bleh" in {
    val actorB = TestActorRef(new ActorB)

    actorB ! IncomingBMessage("bleh")
    expectMsg("got bleh")
  }

  "actorB" should "return stringbleh" in {
    val actorB = TestActorRef(new ActorB)

    actorB ! "stringbleh"
  }

}
