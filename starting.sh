
docker run --rm \
  --name microservice_mvn \
  -e POSTGRES_PASSWORD=secret \
  -e POSTGRES_USER=user \
  -e POSTGRES_DB=db \
  -p 5423:5432 \
  -v $(pwd)/datapg:/var/lib/postgresql/data \
  -d \
  postgres:13.4-alpine3.14
