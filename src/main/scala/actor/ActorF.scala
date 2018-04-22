package actor

import akka.actor.{ ActorRef, FSM }
import scala.concurrent.duration._

class ActorF extends FSM[State, Msg] {

  startWith(Off, turnOff)

  when(Off) {
    case Event(turnOn, _) => println("turn ON please!")
    case Event(turnOff,_) => println("we're already OFF")
  }

  onTransition {
    case Off -> On => println("went from Off -> On")
  }
}

// states
sealed trait State
case object On extends State
case object Off extends State

sealed trait Msg
case object turnOff extends Msg
case object turnOn extends Msg