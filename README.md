# SimpleOrderManagementRepo
Assignment for GaragePlug recruitment.


## Here we can separately add Customers by removing Order details(we only need to add customers).
then after creating customer using RESTful api, we will get an unique customer ID.

## Again we need to place orders and each order will generate separate unique ID and  after placing the orders we need to associate the orders with customers
(i.e which order has been placed by which customer by providing customer ID with order Id) 
for example, a Customer can place many orders so ONETOMANY relationship established b/w customer and orders.

## after associating orders with customers if order associated is more than 9 then automatically the TYPE of customer will change to GOLD from REGULAR.
    Similarly orders above 20 will change the type as PLATINUM and particular discount will be given to the customer for each order.

# Tech-Stack
  * Java
  * Spring Boot
  * Hibernate
  * REST API
  * Lombok
  * Swagger UI
