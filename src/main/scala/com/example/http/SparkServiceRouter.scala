package com.example.http

import spray.routing.HttpServiceActor

/**
 * @author skovalyov
 */
class SparkServiceRouter extends HttpServiceActor with DefaultRouter {

  def receive = runRoute(defaultRoute)

}
