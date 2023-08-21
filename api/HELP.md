# Book API
This project is an API manage books.

### Requires ###
* Java 17
* Docker - https://docs.docker.com/install/
* Docker compose - https://docs.docker.com/compose/install/
* Maven - https://maven.apache.org/download.cgi

## Execute docker-compose for local environment
The docker-compose file its located at the project root.
```sh
docker-compose up -d
```
This command it's going to start:
- Postgres server.

### Start application server from code by maven ###
```sh
mvn spring-boot:run
```

After the application started access the url:
```sh
http://localhost:8080/swagger-ui/index.html#
```
You should see the swagger documentation

### Tests ###
To run test open the file AppControllerTest in src/test/java/com.larissafalcao.bookproject