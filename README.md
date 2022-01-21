# Springboot-JPA-H2-OpenApiSpec
## Spring Boot Rest CRUD API with Maven that use Spring Data JPA to interact with H2 database
- H2 Console on http://localhost:8080/h2-console
- Swagger UI url http://localhost:8080/swagger-ui/index.html
- Below are the APIs:

| Method  |                    URL                      |         Actions         |
|---------|---------------------------------------------|-------------------------|
|PUT      |http://localhost:8080/updateCustomer         |Update Customer          |
|POST     |http://localhost:8080/createCustomers        |Create Customers         |
|POST     |http://localhost:8080/createCustomer         |Create Customer          |
|GET      |http://localhost:8080/findCustomerbyIdAndName/{id}/{name}|Find Customer by {id} and {name}|
|GET      |http://localhost:8080/findCustomerByNameContaining/{exp}|Find Customers contain {exp} in name|
|GET      |http://localhost:8080/findCustomerByAgeGreaterthan/{age}|Find Customers have age greater than {age}|
|GET      |http://localhost:8080/findAll                |Find all the Customers   |
|DELETE   |http://localhost:8080/deleteCustomer/{id}    |Delete Customer by {id}  |


