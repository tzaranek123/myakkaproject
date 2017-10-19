name := "myakkaproject"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= {

  val akkaVersion = "2.4.16"
  val akkaHttpVersion = "10.0.1"

  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0" % Test
    //"org.mockito" % "mockito-core" % "2.7.16" % Test
  )
}
