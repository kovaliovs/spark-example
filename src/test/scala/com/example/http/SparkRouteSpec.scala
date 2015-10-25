package com.example.http

import org.scalatest.{FlatSpec, Matchers}
import spray.http.ContentTypes._
import spray.http._
import spray.testkit.ScalatestRouteTest

/**
 * @author skovalyov
 */
class SparkRouteSpec extends FlatSpec with Matchers with ScalatestRouteTest with SparkRoute {
  def actorRefFactory = system

  "generate POST request" should "return OK with content of created data set" in {
    Post("/generate", HttpEntity(`application/json`, "{\"name\": \"test\"}")) ~> sparkRoute ~> check {
      status should be (StatusCodes.OK)
    }
  }

  "list GET request" should "return OK with all data sets" in {
    Get("/list") ~> sparkRoute ~> check {
      status should be (StatusCodes.OK)
    }
  }

  "min POST request" should "return OK with min value" in {
    Post("/min", HttpEntity(`application/json`, "{\"name\": \"test\"}")) ~> sparkRoute ~> check {
      status should be (StatusCodes.OK)
    }
  }

  "max POST request" should "return OK with max value" in {
    Post("/max", HttpEntity(`application/json`, "{\"name\": \"test\"}")) ~> sparkRoute ~> check {
      status should be (StatusCodes.OK)
    }
  }

  "sum POST request" should "return OK with sum value" in {
    Post("/sum", HttpEntity(`application/json`, "{\"name\": \"test\"}")) ~> sparkRoute ~> check {
      status should be (StatusCodes.OK)
    }
  }
}
