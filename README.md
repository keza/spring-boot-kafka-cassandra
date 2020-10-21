![Java CI with Maven](https://github.com/keza/spring-boot-kafka-cassandra/workflows/Java%20CI%20with%20Maven/badge.svg)

# Spring Boot + Kafka + Apache Cassandra 

This is an example **Spring Boot + Apache Kafka + Apache Cassandra** app.

It was made using **Spring Boot**, **Apache Cassandra**, **Apache Kafka**, **Apache ZooKeeper**, **Spring Data Cassandra**, **Spring Kafka**, **Docker** and **Docker Compose**.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Docker]()


### Clone

Run the command below to clone the project:


```sh
git clone https://github.com/keza/spring-boot-kafka-cassandra.git
```

### Run

Build Docker image:

We are using **Docker-Compose** to start the containers. Go to the root folder where 'docker-compose.yml' is located and run the below command:

    mvn clean install -DskipTests

    docker-compose up --build -d
    
*[Optional]* You can either open a separate terminal and follow the logs while systems are initializing:
```
docker-compose logs -f
```
*[Optional]* Or check the starting status:
```
docker-compose ps
```
    
### Create User

```sh
curl --location --request POST 'localhost:8080/user/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name" : "name",
    "surname" : "surname",
    "email" : "a@a.co",
    "phoneNumber" : "5555555555",
    "followerList" : ["5d9a511d-4107-4a87-805b-55c24f3a8abc"]
}'
```

### Stop
Go to the root folder where is *docker-compose.yml*.

To stop all containers execute:
```
docker-compose down
```
