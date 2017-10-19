package actor

import actor.ActorA.{IncomingMessage, SomeClass}
import actor.ActorB.IncomingBMessage
import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit, TestProbe}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

class ActorASpec extends TestKit(ActorSystem("test-system"))
  with FlatSpecLike
  with Matchers
  with BeforeAndAfterAll
  with ImplicitSender
  with MockFactory {

  override def afterAll(): Unit = {
    super.afterAll()
    TestKit.shutdownActorSystem(system)
  }

  "actorB" should "receive message from actorA" in {
    val probe = TestProbe()
    val actorA = TestActorRef(new ActorA(probe.ref)())

    actorA ! IncomingMessage("bleh")

    probe.expectMsg(IncomingBMessage("actorB, I received bleh and btw defaultvalue"))

  }

  "actorB" should "receive message from actorA with optional parameter mocked" in {
    implicit val mockedSomeClass = mock[SomeClass]
    (mockedSomeClass.getSomeVal _).expects().returning("knownvalue")
    //this is same as when(mockedSomeClass.getSomeVal()).return("knownvalue") if using Mockito

    val probe = TestProbe()
    val actorA = TestActorRef(new ActorA(probe.ref)(mockedSomeClass))

    actorA ! IncomingMessage("bleh")

    probe.expectMsg(IncomingBMessage("actorB, I received bleh and btw knownvalue"))
  }



}
