ThisBuild / scalaVersion := "2.13.12"
organization := "com.blackrise"
ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always
lazy val layers = (project in file("."))
  .settings(
    name := "layers",
  ).enablePlugins(GitVersioning)

coverageEnabled := true
coverageFailOnMinimum := true
coverageMinimumStmtTotal := 95
coverageMinimumBranchTotal := 95

val sparkVersion = "3.3.3"

val sparkDependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

val scalaDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.2.15" % Test,
)

libraryDependencies ++= sparkDependencies ++ scalaDependencies

ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  // For accounts created after Feb 2021:
  // val nexus = "https://s01.oss.sonatype.org/"
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/blakrise/layers"),
    "scm:git@github.com:blakrise/layers.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id    = "Saurabh975",
    name  = "Saurabh Tiwari",
    email = "sktsaurabh975@gmail.com",
    url   = url("https://github.com/Saurabh975")
  )
)