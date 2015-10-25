package com.example

import akka.actor.Props
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import com.example.http.SparkServiceRouter
import spray.can.Http

import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
 * @author skovalyov
 */
object Boot extends App {

  implicit val timeout = Timeout(5.seconds)
  implicit val context = system.dispatcher

  val endpoint = system.actorOf(Props[SparkServiceRouter], "endpoint")

  IO(Http) ? Http.Bind(endpoint, interface = "0.0.0.0", port = 9000) onComplete {
    case Success(_) =>
      Runtime.getRuntime.addShutdownHook(new Thread() {
        override def run() = {
          IO(Http) ! Http.CloseAll
          system.shutdown()
        }
      })
    case Failure(e) =>
      system.shutdown()
  }

}
