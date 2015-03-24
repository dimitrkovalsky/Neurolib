name := "neurolib"

version := "1.0"

lazy val neurolib = (project in file(".")).enablePlugins(PlayJava)

lazy val springVersion = "4.0.7.RELEASE"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.hibernate" % "hibernate-validator" % "5.1.1.Final",
//  "org.springframework" % "spring-context" % springVersion,
//  "org.springframework" % "spring-orm" % springVersion,
//  "org.springframework" % "spring-jdbc" % springVersion,
  "org.springframework" % "spring-tx" % springVersion,
//  "org.springframework" % "spring-expression" % springVersion,                                      l
//  "org.springframework" % "spring-aop" % springVersion,
  "org.springframework" % "spring-webmvc" % springVersion,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final",
  // Neo4j
  "org.springframework.data" % "spring-data-neo4j" % "3.2.1.RELEASE",
  "org.springframework.data" % "spring-data-neo4j-rest" % "3.2.1.RELEASE",
  "org.neo4j" % "neo4j" % "2.1.7",
  // GraphAware Framework
  "com.graphaware.neo4j" % "common" % "2.1.7.28",
  "com.graphaware.neo4j" % "api" % "2.1.7.28",
  "com.graphaware.neo4j" % "runtime" % "2.1.7.28",
  "com.graphaware.neo4j" % "recommendation-engine" % "2.1.7.28.2",
  "com.graphaware.neo4j" % "noderank" % "2.1.7.28.2",
  "com.graphaware.neo4j" % "runtime-api" % "2.1.7.28",
  "com.graphaware.neo4j" % "algorithms" % "2.1.7.28.5",
  "javax.ws.rs" % "javax.ws.rs-api" % "2.0",
  "com.sun.jersey" % "jersey-server" % "1.17.1",
  "com.sun.jersey" % "jersey-core" % "1.17.1",
  "com.sun.jersey" % "jersey-servlet" % "1.17.1"
)

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

resolvers += "neo4j-release-repository" at "http://m2.neo4j.org/content/repositories/releases"
