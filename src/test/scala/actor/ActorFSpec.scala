package actor

import akka.actor.LoggingFSM

//class ActorFSpec extends LoggingFSM[State, Msg] {
//
//  override def logDepth = 12
//  onTermination {
//    case StopEvent(FSM.Failure(_), state, data) ⇒
//      val lastEvents = getLog.mkString("\n\t")
//      log.warning("Failure in state " + state + " with data " + data + "\n" +
//        "Events leading up to this point:\n\t" + lastEvents)
//  }
//}

