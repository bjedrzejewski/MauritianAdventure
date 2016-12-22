mvn install
mvn package
mvn docker:build
docker run -p 8080:8080 -t jedrus07/mauritian-adventure
