package com.example.http

import spray.routing.HttpServiceActor

/**
 * @author skovalyov
 */
class SparkServiceRouter extends HttpServiceActor with WelcomeRoute with SparkRoute {

  def receive = runRoute(sparkRoute ~ welcomeRoute)

}
