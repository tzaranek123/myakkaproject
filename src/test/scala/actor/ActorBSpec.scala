package actor

import actor.ActorB.IncomingMessage
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

  "actorA" should "return bleh" in {
    val actorB = TestActorRef(new ActorB)

    actorB ! IncomingMessage("bleh")
    expectMsg("got bleh")
  }

}
