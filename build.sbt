organization := "rapture-io"

name := "rapture-io"

description := "Rapture I/O is a general purpose I/O library for Scala, providing much of the functionality of java.io and java.net, plus comprehensive support for working with JSON."

scalaVersion := "2.10.2"

licenses += ( "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt") )

homepage := Some(url("http://rapture.io"))

val searchTags =  Seq("scala", "io", "http", "url", "json")

scalacOptions ++= List(
  "-encoding", "utf8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-target:jvm-1.6",
  "-language:_"
)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "javax.mail" % "mail" % "1.4" % "optional",
  "org.specs2" %% "specs2" % "2.2.2" % "test" //"org.scalatest" % "scalatest_2.10" % "2.0.RC1" % "test"
)

initialCommands in console := """
  import rapture.io._
  implicit val zone = Zone("console")
"""

seq(flatDirectoriesSettings: _*)

seq(releaseSettings: _*)

seq(bintrayPublishSettings: _*)

bintray.Keys.packageLabels in bintray.Keys.bintray := searchTags

val javaHome = "/Library/Java/JavaVirtualMachines/jdk1.7.0_09.jdk/Contents/Home" /*System.getProperty("JAVA_HOME")*/

val javaRuntimeJar = file("/Library/Java/JavaVirtualMachines/jdk1.7.0_09.jdk/Contents/Home/jre/lib/rt.jar")

apiMappings += (javaRuntimeJar -> url(s"http://www.scala-lang.org/api/${scalaVersion.value}/"))

