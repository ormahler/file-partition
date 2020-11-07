package com.startapp.job.partitioners

import org.apache.flink.api.common.functions.Partitioner

class LettersPartitioner(lowerLetter: Char) extends Partitioner[String] {

  override def partition(key: String, numPartitions: Int): Int =
    key.toUpperCase.hashCode - lowerLetter.hashCode
}
