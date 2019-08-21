package com.example.route

import akka.http.scaladsl.model.{HttpRequest, StatusCodes}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}

class PingRoutesSpec extends FlatSpec with PingRoutes with ScalatestRouteTest with Matchers {
  "GET /ping" should "return 200" in {
    val request = HttpRequest(uri = "/ping")

    request ~> pingRoutes ~> check {
      status shouldBe StatusCodes.OK
      entityAs[String] shouldBe "pong"
    }
  }
}
