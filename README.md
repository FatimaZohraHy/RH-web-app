<u><p align="center"><strong>Projet de fin de module</strong></p></u>
 

1. [Introduction](#introduction)
2. [Conception](#conception)
3. [Backend Development](#backend-development)
4. [Frontend Development](#frontend-development)
5. [Usage](#usage)
6. [Installation](#installation)
7. [Configuration](#configuration)
8. [Contributing](#contributing)
9. [License](#license)

# Introduction
The human resource department in any organisation plays a crucial role in managing their employees and their management. It caters to large set of activities in simultaneous mode and for this reason, the functioning of HR department is not easy. HR Department has to go through several challenges and various measures to make the company self-sufficient, robust and independent in bringing more profit and revenue.

From managing the employees to handling the risk management of the company, it is the responsibility of human resource department to look after. Getting all the HR activities done in the offline fashion requires lot of time and this will lead to stress, work pressure and error. On the other hand, implementation of an HR software comes with great help. With its vast features the Open HRMS software can provide proper backup for the functioning of the HR department. The Connect HRMS software automates every process happening in the HR department, reducing the workload of HR department, and boosting their productivity. Also all the data about the organisation are digitally stored when the Connect HRMS software comes in to work.

# Conception
The development of conceptual models of an information system requires the use of several diagrams in order to define and visualize these models in a clear and precise manner.

- __USE CASE DIAGRAM :__
A use case diagram is a modeling tool to better understand and describe the functional requirements of the system. It is the first UML step for designing a system.


- __SEQUENCE DIAGRAMS :__
A sequence diagram is a type of interaction diagram that describes the sequence of actions that occur between different objects or actors in a system. It shows how different objects or actors interact with each other by exchanging messages in an ordered sequence.

![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/25d9314c-5fa9-4c23-be11-bdea9b2c2774)



![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/90a3c532-16f9-430d-8191-7a859b84589e)

- __CLASS DIAGRAM :__
A class diagram is a visual tool used in software engineering to represent the structure and relationships between classes in a system. It shows classes, their attributes and operations using rectangles divided into three sections. Classes are linked together by lines to indicate associations, inheritances, or dependencies between them.
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/b5a2bc40-e740-48e2-b627-7e0657ab1f6a)
# Backend-development
- __MongoDB :__<br>
  ![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/3cf82906-6a33-4c9c-9838-77752edba38b) <br>
MongoDB is a document-oriented NoSQL (Not Only SQL) database designed to store, query, and manage data in a flexible and scalable manner. Instead of using tables and rows as in relational databases, MongoDB stores data in the form of JSON documents (actually BSON) within collections. This approach allows for a more dynamic and scalable data modeling, particularly beneficial for applications requiring horizontal scalability and flexible data schemas.<br>
  - __MongoDB Collections:__<br>
    The collections we used to record data in the MongoDB database are the following :<br>
    ![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/6ba80dff-54e2-4b3a-960a-2841d4afbb15)<br>
The data is stored in the form of JSON files, and to represent relationships between classes, MongoDB uses references. For example : <br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/d31cbdc9-bf13-457c-8986-a35fa2e3e803)<br>
As previously mentioned in the class diagram, it is observed that there is an association between HRadmin and Employee, where an HRadmin can have multiple Employees. Thus, MongoDB creates references for each employee object in relation to HRadmin.<br>

- __spring boot :__<br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/9c4cc74c-5c67-4fca-b2eb-780004b374e6)<br>
Spring Boot is a Java application development framework based on the Spring framework. It simplifies the process of creating Java applications by providing default conventions, automatic configurations, and a set of ready-to-use tools. The primary goal of Spring Boot is to make Java application development faster and simpler by reducing boilerplate configuration. It also integrates well with other Spring projects such as Spring MVC, Spring Data, and Spring Security, making it easier to develop robust and scalable applications. Spring Boot is commonly used for building web applications, microservices, and RESTful APIs.
- __services :__<br>
"Services in Spring Boot refer to logical components that encapsulate the business logic of your application. A service is typically used to handle specific business operations, thereby delegating the processing logic away from controllers or other components. These services are usually annotated with @Service to inform Spring that they should be managed as service components.<br>

The services we utilized in the backend include:"<br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/03868505-769b-4cc4-89d8-360ddba45c1d)<br>
We take, for example, EmpService:<br>
there are @Autowired annotations. The latter is used for automatic dependency injection. It instructs Spring to look for a bean matching the specified type and inject it automatically into the class where the annotation is used. This avoids the manual creation of dependency instances, simplifying the configuration and management of dependencies within the application. Additionally, the functions in the services represent the business logic of the application.<br>

- __controllers :__<br>
A Spring Boot controller is typically a Java class annotated with @Controller or @RestController. The methods in this class, also referred to as actions or endpoints, are annotated with annotations such as @RequestMapping, @GetMapping, @PostMapping, etc., to specify the URLs they respond to and the type of HTTP requests they handle. They serve as an interface between incoming HTTP requests and the business logic of the application. Controllers handle client requests, trigger appropriate operations in services, and typically return a response to the client, often in the form of JSON data in the context of RESTful APIs.

- __spring security :__<br>

Spring Security is a powerful and highly configurable module of the Spring Framework that provides a comprehensive security infrastructure for Java applications. It simplifies security management within applications by offering features such as authentication, authorization, protection against attacks, session management, and more.


# Frontend-development
- __Development environment :__
 
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/118858857/c6ca085e-2a87-4bc8-b8bf-9c9991bb9075)
Angular is an open source framework written in JavaScript that allows the creation of web applications, particularly so-called "single page applications". A web application accessible from a single web page. This optimizes the user experience and avoids loading the page with each new action. The framework is based on MVC architecture, allowing you to separate data, images and actions to better manage responsibilities. Extensively proven architecture that enables high maintainability and improved collaboration.
# Application overview
- __Authentication interface :__
The following figure shows the authentication interface, from which the user can
access your admin or employee space

