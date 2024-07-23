
import Dependencies._

val commonSettings = Seq(
  resolvers := Seq(
    artifactoryResolver,
    codeArtifactoryResolver
  ),
  externalResolvers := Seq(
    artifactoryResolver,
    codeArtifactoryResolver
  ),
  fullResolvers := Seq(
    artifactoryResolver,
    codeArtifactoryResolver
  ),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  credentials := Seq(artifactoryCreds, codeArtifactoryCreds),
  publishTo := Some(artifactoryResolver),
)
lazy val r = commonSettings ++ Seq(
  name := "test-app",
  publishArtifact := true,
  Universal / packageName := "test-app",
  libraryDependencies ++= commonDeps,
  excludeDependencies ++= Seq(
    "io.netty" % "netty"
  ),
)
lazy val root = Project(id = "root", base = file(".")).settings(r)
