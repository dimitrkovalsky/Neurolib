# Neurolib
Neurolib project

To start download and run neo4j Community : http://neo4j.com/download.

Install scala plugin in IntelliJ.

Import project as sbt project to IDE.

After that run preloaders.PreloaderRunner to fill database. After that you can execute :

```MATCH (g:Genre)--(b:Book)--(a:Author) RETURN b,a,g```
in ```http://localhost:7474/browser/```

To test Recomendation engine run Main.

To test full application run controllers.Application as Play 2 App in Intellij. After that you should see list of genres in ```http://localhost:9000```
