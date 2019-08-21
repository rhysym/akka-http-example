import sbt._

object Dependencies {
  private val akkaHttpVersion = "10.1.9"
  private val akkaVersion = "2.5.25"

  private val compileDependencies = Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion
  )

  private val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % "3.0.8",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  )

  val dependencies: Seq[ModuleID] = compileDependencies ++ testDependencies.map(_ % Test)
}
