# url_shortener
Install PostgreSQL

Create user and database

		CREATE USER username WITH PASSWORD 'Your-PaSsWoRd';

		CREATE DATABASE url;

		GRANT ALL PRIVILEGES ON DATABASE url TO urlShort;

		CREATE TABLE faculties(
		id SERIAL PRIMARY KEY,
		url VARCHAR);


Change authentication data in src\main\resources\application.properties

		spring.datasource.username=username
		spring.datasource.password=Your-PaSsWoRd

In command line from project root directory run

		mvnw spring-boot:run
	
REST server available at

	http://localhost:8080/
	
Swagger doc 

	http://localhost:8080/swagger-ui/index.html
	
Open api

	http://localhost:8080/v3/api-docs/