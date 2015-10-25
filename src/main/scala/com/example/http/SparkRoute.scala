package com.example.http

import spray.http.MediaTypes._
import spray.routing.HttpService

/**
 * @author skovalyov
 */
trait SparkRoute extends HttpService {

  val sparkRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>Spark example</h1>
                <ul>
                  <li>Generate sample</li>
                  <li>List of data sets</li>
                  <li>Sum</li>
                  <li>Min</li>
                  <li>Max</li>
                  <li>Filter</li>
                </ul>
              </body>
            </html>
          }
        }
      }
    }

}
