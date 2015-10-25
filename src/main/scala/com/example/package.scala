package com

import akka.actor.ActorSystem
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

/**
 * @author skovalyov
 */
package object example {

  implicit val system = ActorSystem("spark-system")
  val conf = new SparkConf().setAppName("Simple Application").setMaster("local[4]")
  val sc = new SparkContext(conf)

}
