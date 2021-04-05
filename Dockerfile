FROM maven:3.6.3-jdk-11-slim AS tests

WORKDIR /tmp
COPY . .
RUN mvn test

FROM frankescobar/allure-docker-service
COPY --from=tests /tmp/allure-results /app/allure-results
ENV CHECK_RESULTS_EVERY_SECONDS=1
ENV KEEP_HISTORY=1

EXPOSE 5050