package com.example.http

import spray.http.MediaTypes._
import spray.routing.HttpService

/**
 * @author skovalyov
 */
trait WelcomeRoute extends HttpService {

  val welcomeRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>Spark example</h1>
                <ul>
                  <li>Generate sample POST /generate with body {{&quot;name&quot;: &quot;data set name&quot;}}</li>
                  <li>List of data sets GET /list</li>
                  <li>Sum POST /sum {{&quot;name&quot;: &quot;data set name&quot;}}</li>
                  <li>Min POST /min {{&quot;name&quot;: &quot;data set name&quot;}}</li>
                  <li>Max POST /max {{&quot;name&quot;: &quot;data set name&quot;}}</li>
                  <li>Filter POST /filter {{&quot;name&quot;: &quot;data set name&quot;, &quot;filter&quot;: &quot;filter expression&quot;}}</li>
                </ul>
              </body>
            </html>
          }
        }
      }
    }
}
