package actor

import actor.ActorA.IncomingMessage
import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
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

  "actorA" should "return bleh" in {
    val actorA = TestActorRef(new ActorA)

    actorA ! IncomingMessage("bleh")
    expectMsg("got bleh")
  }

}
