# REACTIVE-SPRING-BOOT-API
## Example of a reactive REST API with Spring Boot 2 (WebFlux)
### Uses Spring Security, WebClient and Swagger 3
### Communicates with Mexican Crypto currency API: BITSO (https://bitso.com/api_info)
- To run locally: 'gradle bootRun'
### Communicates with Cassandra local instance:
- Keyspace: coin_mx  
- Port: 9042

## Support for Docker compose & K8s

### Docker Compose
* Execute the Gradle plugin to generate the project image:
`gradle jibDockerBuild`

* Execute the Docker Compose command to run the project locally:
`docker-compose up` (add `--build` argument at first time).

* See project at http://localhost:8080/

* Remember to terminate your Docker compose run:
`docker-compose down`


### K8s
* Deploy Cassandra to cluster (single node):
`kubectl create -f cassndra.yml`

* Deploy Schema and Data load pod (job) to the cluster:
`kubectl create -f cassandra-keyspace.yml`

* Deploy app to cluster:
`kubectl create -f app.yml`

* See project at http://localhost/