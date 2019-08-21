package com.example.route

import akka.http.scaladsl.server.{Directives, Route}

trait PingRoutes extends Directives {
  lazy val pingRoutes: Route = path("ping") {
    get {
      complete("pong")
    }
  }
}
