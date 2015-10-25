package com.example.http

import com.example.repository.DataSetRepository
import com.example.service.SparkService
import org.json4s.{DefaultFormats, Formats}
import spray.httpx.Json4sSupport
import spray.routing.HttpService

/**
 * @author skovalyov
 */
trait SparkRoute extends HttpService {
  import Json4sProtocol._

  val sparkRoute =
    path("generate") {
      post {
        entity(as[Generate]) { generate =>
          complete(SparkService.generateSample(generate.name))
        }
      }
    } ~ path("list") {
      get {
        complete(DataSetRepository.list())
      }
    } ~ path("sum") {
      post {
        entity(as[Sum]) { sum =>
          complete(SparkService.sum(sum.name).toString)
        }
      }
    } ~ path("max") {
      post {
        entity(as[Max]) { max =>
          complete(SparkService.max(max.name).toString)
        }
      }
    } ~ path("min") {
      post {
        entity(as[Min]) { min =>
          complete(SparkService.min(min.name).toString)
        }
      }
    } ~ path("filter") {
      post {
        entity(as[Filter]) { filter =>
          complete(SparkService.filter(filter.name, filter.expression))
        }
      }
    }
}

object Json4sProtocol extends Json4sSupport {
  implicit def json4sFormats: Formats = DefaultFormats
}

case class Generate(name: String)
case class Sum(name: String)
case class Max(name: String)
case class Min(name: String)
case class Filter(name: String, expression: String)
