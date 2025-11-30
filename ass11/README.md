# q1.java — database student table viewer

This small Java program attempts to connect to a PostgreSQL database and display the contents of the `students` table.

Problem found:
- Running `java Main` on this machine produced a runtime error:
  `java.lang.ClassNotFoundException: org.postgresql.Driver` — the PostgreSQL JDBC driver is missing from the classpath.

How to run correctly (Windows PowerShell):

1. Download the PostgreSQL JDBC driver from https://jdbc.postgresql.org/download.html and place the jar (e.g. `postgresql-42.6.0.jar`) next to `q1.java`.

2. Compile:

```powershell
javac q1.java
```

3. Run with the driver on the classpath:

```powershell
java -cp .;postgresql-<version>.jar Main
```

4. Using Maven (recommended):

  If you have Maven installed you can let Maven download the driver and run the program.

  Compile and run with mvn:

```powershell
mvn compile
mvn exec:java -Dexec.mainClass=Main
```

  Or package into a jar with dependencies and run (example uses the Assembly or Shade plugin — configure as needed):

```powershell
mvn package
java -cp target/q1-1.0.0.jar;path\to\dependency\postgresql-<version>.jar Main
```

Notes:
- If you use a build tool (Maven/Gradle), add the Postgres JDBC dependency instead of manually managing the jar.
- The program now prints a helpful error message if the driver is not available and uses try-with-resources to close database objects automatically.
