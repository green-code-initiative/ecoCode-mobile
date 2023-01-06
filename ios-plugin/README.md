# ecoCode iOS SonarQube plugin

ecoCode iOS SonarQube plugin is an "eco-responsibility" static code analyzer for iOS projects written in Swift. Its aim is to detect code smells indicating how the source code can be improved to reduce their environmental and social impact.

## Requirements

- Java JDK 11+
- Maven 3.8 or later
- A local SonarQube instance for local testing

## Main commands

#### Local deployment using Docker

**This implies to have a machine ready to run containerized applications.** Please refer to Docker documentation: https://www.docker.com/.

The project uses a 8.6 docker instance of SonarQube to run.

Pop docker containers by using:

```bash
docker-compose up --build -d && docker ps
```

The tests instance of SonarQube with the plugin will then be available at: http://localhost:9000

#### Packaging

```bash
$ mvn package
```
