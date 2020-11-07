# File Partition #
    This job partitions a csv input by its first column (a charecter),
    and sorts the resulting outputs in an ascending order.
## Getting Started ##
    1. Fulfill the following paramters in the resources/job.conf file:
        * inputPath
        * outputPath
        * minPartitionChar
        * maxPartitionChar
    2. run the job