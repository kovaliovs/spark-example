name := "spark-example"

scalaVersion := "2.11.7"

parallelExecution in Test := false

libraryDependencies ++= {
  val sprayVersion = "1.3.3"
  val akkaVersion = "2.3.4"
  val sparkVersion = "1.5.1"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "io.spray" %% "spray-routing" % sprayVersion,
    "io.spray" %% "spray-can" % sprayVersion,
    "io.spray" %% "spray-httpx" % sprayVersion,
    "io.spray" %% "spray-testkit" % sprayVersion % "test",
    "org.json4s" %% "json4s-native" % "3.2.11",
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "junit" % "junit" % "4.12" % "test",
    "org.scalatest" %%  "scalatest" % "2.2.4" % "test"
  )
}