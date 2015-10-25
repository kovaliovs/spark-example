package com.example.service

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD._
import scala.util.Random
import com.example._
import com.example.repository.DataSetRepository

/**
 * @author skovalyov
 */
class SparkService {

  val DataSetSize = 1000

  val random = {
    val random = Random
    random.setSeed(System.currentTimeMillis())
    random
  }

  def generateSample(name: String): RDD[Int] = {
    val data = Stream.continually(random.nextInt()).take(DataSetSize).toList
    sc.makeRDD(data)
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
