import Dependencies._

ThisBuild / scalaVersion     := "2.13.6"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.rovo98"
ThisBuild / organizationName := "leetcode-solutions"

lazy val root = (project in file("."))
  .settings(
    name := "scala-cp",
    libraryDependencies += scalaTest % Test
  )
