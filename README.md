# SpringWebflux-SecurityWithJWT-PostgressDB
Spring webflux security application with JWT and R2DBC Postgress

## To run the project
spring.r2dbc.url=r2dbc:postgresql://localhost/javaforest     
spring.r2dbc.username=postgres   
spring.r2dbc.password=12345

Change this credentials according your local

## Testing the functionality
Code will insert 1 data when start
Email : abc.test@abc.com
password : 12345

**cURL** : curl -v -X POST http://localhost:8080/login -H "Content-Type: application/json; charset=UTF-8" -d "{\"username\" :\"abc.test@abc.com\",\"password\" :\"12345\"}"
<br />After geting the token check this endpoint for secure data  
**cURL** : curl -v -X GET http://localhost:8080/resource/user -H "Authorization: Bearer {token}"

## Signup new user
**cURL** : curl -v -X POST http://localhost:8080/signup -H "Content-Type: application/json; charset=UTF-8" -d "{\"email\" : \"mahade@gmail.com\",\"password\" : \"12345\",\"firstName\" : \"mahade\",\"lastName\" :\"hassan\",\"roles\" : [\"ROLE_USER\"],\"address\": \"Bheramara\", \"enabled\": true}"