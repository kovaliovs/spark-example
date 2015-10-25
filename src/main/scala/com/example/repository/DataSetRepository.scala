package com.example.repository

import org.apache.spark.rdd.RDD

/**
 * @author skovalyov
 */
object DataSetRepository {

  // TODO: sync or actor
  private var dataSets = Map.empty[String, RDD[Int]]

  def add(name: String, rdd: RDD[Int]): Unit = {
    dataSets += name -> rdd
  }

  def delete(name: String): Unit = {
    dataSets -= name
  }

  def get(name: String): RDD[Int] = {
    dataSets(name)
  }

  def list(): List[String] = {
    dataSets.keys.toList
  }

}
