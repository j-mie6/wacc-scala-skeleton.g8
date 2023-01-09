Global / onChangedBuildSource := ReloadOnSourceChanges

// This is used by `sbt assembly` to generate your runnable jar file
lazy val sbtAssemblySettings = baseAssemblySettings ++ Seq(
  assembly / assemblyOutputPath := baseDirectory.value / "wacc-$groupid$-compiler.jar",
  assembly / assemblyMergeStrategy := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case _                             => MergeStrategy.first
  }
)

lazy val root = (project in file(".")).
  settings(
    name := "WACC $groupid$",
    organization := "uk.ac.imperial.doc",
    scalaVersion := "2.13.10",

    libraryDependencies += "com.github.j-mie6" %% "parsley" % "$parsley_version$",
    libraryDependencies += "org.scalatest" %% "scalatest" % "$scalatest_version$" % Test,

    // Some handy scala compiler flags
    scalacOptions ++= Seq(
        "-deprecation", "-unchecked", "-feature",
        // https://docs.scala-lang.org/overviews/compiler-options/index.html
        "-Xlint:nullary-unit",     // warn when methods without parentheses return Unit
        "-Xlint:nullary-override", // warn when methods without parentheses are overridden by methods with parentheses
        "-Xlint:infer-any",        // warn when a type argument is inferred to be `Any` (probably a mistake!)
        "-Xlint:unused",           // warn when something has been unused (suppress with `@unused` annotation)
        "-Xlint:nonlocal-return",  // warn when a return statement used an exception for control flow
        "-Wdead-code",             // warn when deadcode is found
        "-Wextra-implicit",        // warn when there are multiple sets of implicit argument brackets
        "-Wnumeric-widen",         // warn when a number is implicitly widened (say `Char` to `Int`): use `.toInt` instead!
    ),
  )
