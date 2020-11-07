name := "file-partition"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "org.apache.flink" %% "flink-scala" % "1.11.2"

libraryDependencies += "org.apache.flink" %% "flink-clients" % "1.11.2"


run in Compile := Defaults.runTask(fullClasspath in Compile, mainClass in(Compile, run), runner in(Compile, run)).evaluated
runMain in Compile := Defaults.runMainTask(fullClasspath in Compile, runner in(Compile, run)).evaluated
