FROM gradle:7.6-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build -x test

FROM openjdk:17-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=prod
ENV DB_HOST=${DB_HOST:-oracle.fiap.com.br}
ENV DB_PORT=${DB_PORT:-1521}
ENV DB_NAME=${DB_NAME:-ODIN}
ENV DB_USER=${DB_USER:-odin}
ENV DB_PASSWORD=${DB_PASSWORD:-odin123}
CMD ["java", "-jar", "app.jar"]
