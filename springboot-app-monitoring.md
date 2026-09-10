# Spring Boot App Monitoring

## Run the application

```bash
docker run -it -d --name springboot -p 8081:80 atozdevopstraining/spring-boot-app:latest
```

Check the app locally:

```bash
http://localhost:8081/
http://localhost:8081/actuator
http://localhost:8081/actuator/prometheus
```

## Run Prometheus

```bash
docker run --name prometheus -d -p 9090:9090 \
  -v ./monitoring/prometheus.yml:/etc/prometheus/prometheus.yml \
  prom/prometheus
```

## Prometheus scrape config

If Prometheus is running on the same host machine as the app, use:

```yaml
scrape_configs:
  - job_name: 'MyAppMetrics'
    metrics_path: '/actuator/prometheus'
    scrape_interval: 3s
    scheme: http
    static_configs:
      - targets: ['localhost:8081']
        labels:
          application: 'My Spring Boot Application'
```

If Prometheus is running inside Docker, use the host gateway instead of localhost:

```yaml
- targets: ['host.docker.internal:8081']
```

## Important note

`localhost` inside Prometheus means the Prometheus container or pod itself, not the Spring Boot app. If both services are running on the same machine, `localhost:8081` is valid. If Prometheus runs in Docker or Kubernetes, use `host.docker.internal` or the correct service DNS/IP instead.

## Validate the metrics endpoint

```bash
curl http://localhost:8081/actuator/prometheus
```

This should return Prometheus-formatted metrics and should be reachable from the target configured in Prometheus.

## Prometheus URL

```bash
http://localhost:9090/
```