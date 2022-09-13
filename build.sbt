Global / cancelable := true

organization := "io.github.maxkar"

version := "0.0.1-SNAPSHOT"

Compile / scalaSource := baseDirectory.value / "src"

Compile / resourceDirectory := baseDirectory.value / "resources"

Test / scalaSource := baseDirectory.value / "test"

Test / fork := true

scalaVersion := "3.1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test"

