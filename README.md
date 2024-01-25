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
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/175cfa4f-14a3-4c54-a0aa-65bf7a68b508)


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
MongoDB est une base de données NoSQL (Not Only SQL) orientée document, conçue pour stocker, interroger et gérer des données de manière flexible et évolutive. Au lieu d'utiliser des tables et des lignes comme dans les bases de données relationnelles, MongoDB stocke les données sous forme de documents JSON (BSON, en réalité) dans des collections. Cette approche permet une modélisation de données plus dynamique et évolutive, ce qui est particulièrement utile pour les applications nécessitant une évolutivité horizontale et des schémas de données flexibles.<br>
  - __MongoDB Collections:__<br>
    Les collections que nous avons utilisées pour enregistrer les données dans la base de données MongoDB sont les suivantes :<br>
    ![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/6ba80dff-54e2-4b3a-960a-2841d4afbb15)<br>
Les données sont enregistrées sous forme de fichiers JSON, et pour représenter les relations entre les classes, MongoDB utilise des références, exemple :<br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/d31cbdc9-bf13-457c-8986-a35fa2e3e803)<br>
Comme il a déjà été mentionné dans le diagramme de classe, on constate qu'il existe une association entre HRadmin et Employee, où un HRadmin peut avoir plusieurs Employee. Ainsi, MongoDB crée des références pour chaque objet employé en relation avec HRadmin.<br>

- __spring boot :__<br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/9c4cc74c-5c67-4fca-b2eb-780004b374e6)<br>
Spring Boot est un framework de développement d'applications Java basé sur le framework Spring. Il simplifie le processus de création d'applications Java en fournissant des conventions par défaut, des configurations automatiques et un ensemble d'outils prêts à l'emploi. L'objectif principal de Spring Boot est de rendre le développement d'applications Java plus rapide et plus simple en réduisant la configuration boilerplate. Il intègre également bien d'autres projets Spring tels que Spring MVC, Spring Data, et Spring Security, facilitant ainsi le développement d'applications robustes et évolutives. Spring Boot est souvent utilisé pour créer des applications web, microservices et des API RESTful.
- __services :__<br>
Les services dans Spring Boot font référence à des composants logiques qui encapsulent la logique métier de votre application. Un service est généralement utilisé pour traiter des opérations métier spécifiques, déléguant ainsi la logique de traitement depuis les contrôleurs ou les autres composants. Ces services sont généralement annotés avec @Service pour indiquer à Spring qu'ils doivent être gérés comme des composants de service.<br>
Les services que nous avons utilisés dans le backend sont :<br>
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/128602766/03868505-769b-4cc4-89d8-360ddba45c1d)<br>
On prend par exemple EmpService :
On trouve bien qu'il y a des annotations @Autowired , Est ce dernier est utilisé pour effectuer l'injection de dépendances automatique. Elle indique à Spring de rechercher un bean correspondant au type spécifié et de l'injecter automatiquement dans la classe où l'annotation est utilisée. Cela permet d'éviter la création manuelle d'instances de dépendances, simplifiant ainsi la configuration et la gestion des dépendances au sein de l'application.
et pour les fonctions dans les services représentent la logique métier de l'application.<br>

- __controllers :__<br>
un contrôleur Spring Boot est généralement une classe Java annotée avec @Controller ou @RestController. Les méthodes de cette classe, également appelées actions ou endpoints, sont annotées avec des annotations telles que @RequestMapping, @GetMapping, @PostMapping, etc., pour spécifier les URL auxquelles elles répondent et le type de requêtes HTTP qu'elles gèrent, il sont donc une interface entre les requêtes HTTP entrantes et la logique métier de l'application. Ils traitent les demandes des clients, déclenchent les opérations appropriées dans les services, et renvoient généralement une réponse au client, souvent sous forme de données JSON dans le contexte des API RESTful.

- __spring security :__<br>



# Frontend-development
- __Development environment :__
 
![image](https://github.com/FatimaZohraHy/RH-web-app/assets/118858857/c6ca085e-2a87-4bc8-b8bf-9c9991bb9075)
Angular is an open source framework written in JavaScript that allows the creation of web applications, particularly so-called "single page applications". A web application accessible from a single web page. This optimizes the user experience and avoids loading the page with each new action. The framework is based on MVC architecture, allowing you to separate data, images and actions to better manage responsibilities. Extensively proven architecture that enables high maintainability and improved collaboration.
# Application overview
- __Authentication interface :__
The following figure shows the authentication interface, from which the user can
access your admin or employee space

