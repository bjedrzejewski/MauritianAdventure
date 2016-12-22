#The Mauritian Adventure

I love Mauritius and Spring Boot... So I thought that I will try to write a browser game using Spring Boot, Redis,
Velocity templating engine, Bootstrap and a few other technologies.

Let's see how far it will get. Once there is something playable there, I will host it and if it is fun I may even
use some real front end technologies!

##If you want to get that running without docker you will need to:

Install and run redis with:
`redis-server`
Run the spring boot with:
`mvn spring-boot:run`
The game can than be reached on:
`http://localhost:8080/game`

##If you want to get the docker version running:
`mvn install`
`mvn package`
`mvn docker:build`
`docker run -p 8080:8080 -t jedrus07/mauritian-adventure`

This can be also run from `sh buildAndRunDocker.sh`

The game can than be usually reached on:
`http://192.168.99.100:8080/game`

This assumes that you have installed and you that you know the basics od [Docker](https://docs.docker.com/).
