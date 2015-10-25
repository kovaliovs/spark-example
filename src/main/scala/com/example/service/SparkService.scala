package com.example.service

import com.example._
import com.example.repository.DataSetRepository
import org.apache.spark.rdd.RDD._
import scala.util.Random

/**
 * @author skovalyov
 */
object SparkService {

  val DataSetSize = 100
  val maxValue = 100

  val random = {
    val random = Random
    random.setSeed(System.currentTimeMillis())
    random
  }

  def generateSample(name: String): String = {
    val data = Stream.continually(random.nextInt(maxValue)).take(DataSetSize).toList
    val rdd = sc.makeRDD(data)
    DataSetRepository.add(name, rdd)
    rdd.collect().mkString("\n")
  }

  def sum(name: String): Double = {
    DataSetRepository.get(name).sum()
  }

  def min(name: String): Int = {
    DataSetRepository.get(name).min()
  }

  def max(name: String): Int = {
    DataSetRepository.get(name).max()
  }

  // TODO: Implement
  def filter(name: String, expression: String): List[Int] = {
    List.empty[Int]
  }

}
