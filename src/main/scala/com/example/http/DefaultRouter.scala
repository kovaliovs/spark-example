package com.example.http

import spray.http.MediaTypes._
import spray.routing.HttpService

/**
 * @author skovalyov
 */
trait DefaultRouter extends HttpService {

  val defaultRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    }

}
