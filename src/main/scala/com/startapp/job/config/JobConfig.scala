package com.startapp.job.config

import com.typesafe.config.ConfigFactory

trait JobConfig {

  private val config= ConfigFactory.load("job")

  val inputPath: String = config.getString("job.inputPath")
  val outputPath: String = config.getString("job.outputPath")

  val minPartitionCharUpperCase: Char = config.getString("job.minPartitionChar")(0).toUpper
  val minPartitionCharLowerCase: Char = minPartitionCharUpperCase.toLower

  val maxPartitionCharUpperCase: Char = config.getString("job.maxPartitionChar")(0).toUpper
  val maxPartitionCharLowerCase: Char = maxPartitionCharUpperCase.toLower

  val partitionRegex: String =
    s"[$minPartitionCharLowerCase-$maxPartitionCharLowerCase$minPartitionCharUpperCase-$maxPartitionCharUpperCase]"

  val numPartitions: Int = 1 + maxPartitionCharUpperCase.hashCode - minPartitionCharUpperCase.hashCode
}
