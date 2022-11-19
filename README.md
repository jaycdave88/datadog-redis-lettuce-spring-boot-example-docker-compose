# Datadog Redis cache with Spring-Boot on Docker-compose

This repo sample spring-boot project to demonstrate redis cache with spring-boot & Datadog Java APM and used the Datadog Java APM TraceInterceptor to ignore the Redis Resource for "EXISTS".

## Requirements
* Java 8
* Apache Maven 3.5.0 or higher

## How to Run

- Clone the project
- Configure Redis password in application.yml
- Build the project  
```
mvn clean install
```
- Run the application
```
java -jar target/redis-0.0.1-SNAPSHOT.jar
```
- Make sure your redis-server is up and running
- Use the postman collection located in /src/main/resources directory to test the application.

## Using docker

- Build the project  
```
mvn clean install
```
- Run using docker-compose
```
docker-compose up --build 
```
## Make requests to the API
### Create a user 
1. Launch PostMan
2. Create a POST request to: 
    ``` 
    http://localhost:8080/api/v1/otp/generate
    ```
    with the raw body of: 
    ```
    {
       "email":"user@gmail.com"
    }
    ```
### Query the user
1. Create a POST request to: 

    ```
    http://localhost:8080/api/v1/otp/verify
    ```
This will create traces to the Redis service. 

### Reference Documentation
- [Datadog Extending Java Tracer](https://docs.datadoghq.com/tracing/trace_collection/custom_instrumentation/java/#extending-tracers)
   - The location of ther Datadog Java APM TraceInterceptor class is: 
      - RedisTraceInterceptor under: ``` src/main/java/com/rkdevblog/interceptors/RedisTraceInterceptor.java```
      - The TraceInterceptor is registered under: ```src/main/redis/RedisApplication.java```
