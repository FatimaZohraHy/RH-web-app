<u><h2 align="center"><strong>Final Project</strong></h2></u>
 

1. [Introduction](#introduction)
2. [Conception](#conception)
3. [Backend Development](#backend-development)
4. [Frontend Development](#frontend-development)
5. [Application overview](#Application-overview)
6. [Conclusion](#Conclusion)

# Introduction
The human resource department in any organisation plays a crucial role in managing their employees and their management. It caters to large set of activities in simultaneous mode and for this reason, the functioning of HR department is not easy. HR Department has to go through several challenges and various measures to make the company self-sufficient, robust and independent in bringing more profit and revenue.

From managing the employees to handling the risk management of the company, it is the responsibility of human resource department to look after. Getting all the HR activities done in the offline fashion requires lot of time and this will lead to stress, work pressure and error. On the other hand, implementation of an HR software comes with great help. With its vast features the Open HRMS software can provide proper backup for the functioning of the HR department. The Connect HRMS software automates every process happening in the HR department, reducing the workload of HR department, and boosting their productivity. Also all the data about the organisation are digitally stored when the Connect HRMS software comes in to work.

# Conception
The development of conceptual models of an information system requires the use of several diagrams in order to define and visualize these models in a clear and precise manner.

- __USE CASE DIAGRAM :__
A use case diagram is a modeling tool to better understand and describe the functional requirements of the system. It is the first UML step for designing a system.

![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/729d86a5-bcdb-40d0-bc27-cca7b056905b)

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

Spring Security is a powerful and highly configurable module of the Spring Framework that provides a comprehensive security infrastructure for Java applications. It simplifies security management within applications by offering features such as authentication, authorization, protection against attacks, session management, and more.<br>

__Security implemented rules :__<br>
- JSON Web Token (JWT) and Spring Security for authentication and authorization:
  This powerful security module ensures that only authenticated and authorized users gain access to specific resources,  
  employing role-based access control to give permissions.
  when a user authenticate successfully, it generate a web token, this token containe some security keys such as, role, userId, token creation time and expiration.<brr>
  <img width="749" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/118858857/d9ba4dbd-a981-4c97-8bec-3d8c57b68554"> <br>
  The tocken and the userId are stored in the locale storage of the browser:
  <img width="389" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/118858857/1d9aeecd-23a5-4a5b-a132-1f185dda3283"><br>

__Security headers :__
These headers play a crucial role in mitigating risks associated with prevalent threats such as Cross-Site Scripting (XSS) and Cross-Site Request Forgery (CSRF), for that we have implemented a stringent security filter chain that includes the configuration of robust security headers.<br>
<img width="669" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/118858857/0543baa3-4592-48a8-9717-273ea73c5ad5"> <br> <img width="690" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/118858857/cafbba44-7afe-4861-a3dd-80f0a2527eee"><br>

__Strong passwords :__
Reinforce the use of strong passwords and unique accounts for user.<br>

__2FA authentication :__
Implementation of two-factor authentication (2FA) for added security.<br>
<img width="311" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/118858857/8a2b0b73-eb2d-4513-8f9c-8338542bb283"><br>


# Frontend-development
- __Development environment :__
 
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/118858857/c6ca085e-2a87-4bc8-b8bf-9c9991bb9075)<br>
Angular is an open source framework written in JavaScript that allows the creation of web applications, particularly so-called "single page applications". A web application accessible from a single web page. This optimizes the user experience and avoids loading the page with each new action. The framework is based on MVC architecture, allowing you to separate data, images and actions to better manage responsibilities. Extensively proven architecture that enables high maintainability and improved collaboration.
# Application overview

## Admin part :
- __Authentication interface :__
The following figure shows the authentication interface, from which the user can
access your admin or employee space
This is the login interface. After the admin enters their email and password, a token will be generated. This token allows access to the admin's account.<br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/9deabbf5-3cf5-4ac1-ad35-c4b5f5983ac1)<br>
and this is an admin token after the login :<br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/b0b11add-65d8-469e-a7e5-b40f46977dce)<br><br>
And he can simply logout from here : <img width="188" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/e05b46bf-5811-44c2-8259-78cbaa36be5b"><br><br>
- __Departements :__<br>
As we saw already in the class diagram, each admin can have many departments so in nay moments the HRadmib can add another departement same as delete it<br><br>
for example here the admin chose to add a chimie departement :<br><br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/fbbd7a5d-c051-440d-a663-babfcfec9748)<br><br>
and he can get the list of all his departement also :<br>
<img width="960" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/05afb7c3-6e40-4929-87dd-e9db80cda031"><br><br>
And if he would like to remove a department, an alert will appear to confirm the delete in case of mistakes <br><br>
<img width="527" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/bcfc8033-05b3-463d-afc8-2d60da98474d"><br><brr>
If the admin clicks on the 'view' button in a department, he will be able to see all employees that are in this department. Initially, when adding an employee, a department field is required, indicating the department to which the employee belongs. Therefore, each department has a list of employees :<br><br>
<img width="960" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/01f6c2f2-1102-4e14-af57-71f7a16e67ce">
- __Employee add :__<br>
The forum allows the admin to add employees :
<img width="749" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/2f64b7f7-f839-4654-beeb-9d79fe35c728"><br><br>
<img width="481" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/5e9ffb70-7125-4364-a593-264c1ff34890"><bfr><br>

then the employee will be in the departement list the he belongs to, and there the admin have the edit option so he can edit the employee informations : <br><br>
<img width="379" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/d0717cbb-304b-4560-8c55-80355f89a61b"><br><br>
- __Claims and requests:__<br>
The admin can get all the claims that his employees sends, the sames goes with requests<br><br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/63c4fe80-fc44-409f-b7b8-20f1b4575e75)<br><br>
 __Attendance :__<br>
 the admin can have the attendance list of all employees:
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/8c542ac7-b2e7-4d55-999f-999c76c79258)<br><br>

## Employee part :
After the admin successfully creates an account for the employee, the employee can then authenticate through the same login interface as before and gain access to their interfaces, where they can perform transactions.
 __Attendance :__<br>
 the admin can checkin and out for the attendance :<br><br>
 <img width="955" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/b987636f-9c80-4253-b2f4-60de682ac562"><br>

![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/af4eda62-fb57-43cd-a644-84cb5b943b2c)<br>
- __Claims and requests:__<br>
and finally the employee can send claims and request to the admin :<br><br>
<img width="959" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/4b5fecb0-de6d-4941-b514-a64167d426b3"><br><br>
<img width="382" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/6e362501-68ba-42db-935e-80f43c0ff5f7"><br><br>
<img width="958" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/f466475f-7026-408a-a767-bbfb8bfd80aa"><br><br>
<img width="377" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/e3c814fb-1386-42b3-947c-0556d2be9ef0"><br><br>
<img width="960" alt="image" src="https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/b2085fd1-40ba-4bed-a735-86835fce3ad3"><br><br>
# Conclusion:
n summary, the application I created using Spring Boot for the backend, Angular for the frontend, and MongoDB as the database, offers a comprehensive system for administrators. They can effortlessly manage departments, add employees, and authenticate users through a secure login interface. The system ensures accuracy by requiring essential information such as department affiliation during employee creation. The seamless integration of these technologies provides an efficient platform where admins can perform various transactions, fostering a user-friendly and robust management environment.






