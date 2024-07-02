curl -O https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.9.3/junit-platform-console-standalone-1.9.3.jar
javac -cp junit-platform-console-standalone-1.9.3.jar *.java
java -jar junit-platform-console-standalone-1.9.3.jar --classpath . --select-class Tests