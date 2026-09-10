
```
docker run -it -d --name sprintboot -p 8081:80 atozdevopstraining/spring-boot-app:latest

```

http://localhost:8081/
http://localhost:8081/actuator
http://localhost:8083/actuator/prometheus


docker run --name prometheus -d -p 9090:9090 -v ./monitoring/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus



