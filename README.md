# TouristTelegramBot

The application Telegram bot that displays information (stored in the database) about the entered city.

### Database configuration

1.	Create data base. 

   Predefined data base name - **my_db_bot**;
   
   Predefined username - **root**; 
   
   Predefined password - **root**; 
   
   
 - Change in properties if required (src/main/resources/application.properties) :
 
 a) spring.datasource.url=jdbc:mysql://localhost:3306/**my_db_bot**?useUnicode=true&serverTimezone=UTC&useSSL=false
    
 b) spring.datasource.username=**root**
     
 c) spring.datasource.password=**root**
 
> The application is running on port 8080. If you have this port occupied -> uncomment server.port = **** (located in application.properties) and instead of ****, write down the port that you have free.
  
2.	Run the application

    - Find the telegram bot in the Telegram messenger - **@nicetourist_bot**
    
    - Click start.
    
    - The app has three default cities: "Москва", "Минск", "Санкт-Петербург"
    
 3. Access CityService using next REST requests:(Edit data with Postman or another application) 

a) GET: localhost:8080/api/cities - get all cities 

b) GET: localhost:8080/api/cities/1 - get city with ID 1

c) POST: localhost:8080/api/cities Request body: { "name": "Париж", "description": "Шарль Андрее Жозе́ф Марии де Голль-президент и Аэропорт"}

d) PUT: localhost:8080/api/cities Request body: { "id": 4,"name": "Париж", "description": "Эйфелеву башню называют самой посещаемой платной и самой фотографируемой достопримечательностью мира"}

e) DELETE: localhost:8080/api/cities/2 - delete city with ID 2

### Stack

* Java 11
* Maven
* Spring Boot
* Spring Data
* Spring MVC
* Spring REST
* Hibernate
* MySQL
