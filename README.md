# MicroService Template

This microservice template can be used to support the below capabilities any microservice would need to support

- Observability using Zipkin
- Monitoring using Prometheus and Grafana
- Security using Client Credentials flow with Keycloak as the IDP
- Messaging using Kafka as the message broker
- Open Api documentation using Swagger UI

## Documentation
The documentation and design for this service is available : TBD


## Build Dependencies
The service is built using
- JDK 17
- Spring Boot 3.0.1
- Open API 3.0

## Build and Run

Start your server as an simple java application  using the below command
<BR>
`
mvn spring-boot:run
`
</BR>

## OpenAPI / Swagger UI

You can view the Openapi UI documentation in swagger-ui by pointing to  
http://localhost:8080/swagger-ui/index.html

Change default port value in application.properties]()
