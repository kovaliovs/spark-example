package com.example.http

import org.scalatest.{FlatSpec, Matchers}
import spray.http.StatusCodes
import spray.testkit.ScalatestRouteTest

/**
 * @author skovalyov
 */
class WelcomeRouteSpec extends FlatSpec with Matchers with ScalatestRouteTest with WelcomeRoute {
  def actorRefFactory = system

  "welcome GET request" should "return OK with welcome page" in {
    Get("/") ~> welcomeRoute ~> check {
      status should be (StatusCodes.OK)
    }
  }

}
