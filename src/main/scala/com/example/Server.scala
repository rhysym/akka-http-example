package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.example.route.PingRoutes

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

object Server extends App with PingRoutes {
  implicit val system: ActorSystem = ActorSystem("actor-system")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContext = system.dispatcher

  val serverBinding = Http().bindAndHandle(pingRoutes, "localhost", 8080)

  serverBinding.onComplete {
    case Success(bound) =>
      println(s"Ready. Listening to http://${bound.localAddress.getHostString}:${bound.localAddress.getPort}.")
    case Failure(e) =>
      Console.err.println("Failed to start.")
      e.printStackTrace()
      system.terminate()
  }
}

