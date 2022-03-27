# Spring Boot + Cache with Redis

## The problem

On this simple project I used the Redis as Cache Manager in a Spring Boot application. My intention was to avoid that the database was called every time that a request made, because, the results not updated frequently, therefore, avoiding unnecessary calls on the database.

## The Solution

My solution for this problem was to create a cache on the use case GetActivePlans, using the annotation @Cacheable, thus, on the first call the database will be call, but, on the next calls, the result be from Redis (because of that the property "show-sql" was set as true). When I create another plan, the cache will cleared, for this I used the annotation @CacheEvict on the use case CreatePlan.

## How To

### Requirements

- Docker
- Docker Compose
- Java 11

### Running

Firstly, up the containers:
```bash
$ docker-compose up -d
```

Then, startup the application:
```bash
$ ./gradlew bootRun
```

### Testing

Make two requests to create new plans:

```
POST localhost:8080/plans
```

```json
{
  "code": "planDiamond",
  "name": "Plan Diamond",
  "value": 150,
  "active": true
}
```
```json
{
  "code": "planBronze",
  "name": "Plan Bronze",
  "value": 50,
  "active": false
}
```

Now make a request to get the active plans:
```
GET localhost:8080/plans
```

Repeat this request, but now, the database wasn't called, you can see by the sql log.

## Conclusion

Use the Redis as a Cache Manager is good solution to improve the performance of queries whose the result not updated frequently.