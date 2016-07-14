package akka

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

sealed abstract class Message

case class StartPlaying(pong: ActorRef) extends Message
case class Ping(message: String) extends Message
case class Pong(message: String) extends Message

class PingActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case StartPlaying(pong) => pong ! Ping("Boo")
    case Pong(message) =>
      println(s"PingActor got $message")
      sender ! Ping("Raaa")
    case _ => println("WTF was that")
  }
}

class PongActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case Ping(message) =>
      println(s"PongActor got $message")
      sender ! Pong("Ahh")
    case _ => println("WTF was that")
  }
}

object Akka extends App {

  val system = ActorSystem("pingPong")

  val ping = system.actorOf(Props[PingActor], name = "ping")
  val pong = system.actorOf(Props[PongActor], name = "pong")

  ping ! StartPlaying(pong)

  Thread.sleep(10000)

  system.terminate
}
