// give the user a nice default project!
ThisBuild / organization := "uk.ac.imperial"
ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file(".")).
  settings(
    name := "WACC Scala Skeleton"
  )
