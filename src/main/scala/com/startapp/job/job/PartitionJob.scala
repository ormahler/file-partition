package com.startapp.job.job

import com.startapp.job.config.JobConfig
import com.startapp.job.partitioners.LettersPartitioner
import org.apache.flink.api.common.operators.Order
import org.apache.flink.api.scala._
import org.apache.flink.core.fs.FileSystem.WriteMode

object PartitionJob extends App with JobConfig {

    val env = ExecutionEnvironment.getExecutionEnvironment
    val input = env.readCsvFile[(String, Int)](inputPath)

    env.setParallelism(numPartitions)

    val lettersPartitioner = new LettersPartitioner(minPartitionCharUpperCase)

    val output = input
      .filter(_._1.matches(partitionRegex))
      .partitionCustom(lettersPartitioner, _._1)
      .sortPartition(_._2, Order.ASCENDING)
      .map(_._2)
      .writeAsText(outputPath, WriteMode.OVERWRITE)

    env.execute
}
