# GiftCertificatesREST

Business Requirements
Develop server application for Gift Certificates system with the following entities:
1.	Gift Certificate:
a.	name
b.	description
c.	price
d.	date of creation
e.	date of modification
f.	duration in days (expiration period)
2.	Tag



The system should expose REST APIs to perform the following operations:
1.	CRUD operations for Gift Certificate.
a.	If new tags are passed during creation or modification of a Gift Certificate, then they should be created in the database.
2.	CRD operations for Tag.
3.	Get certificates. All request parameters are optional and can be used in conjunction.
a.	Get certificates by tag.
b.	Search certificates by part of the name or description (should be implemented using database function call).
c.	Sort certificates by date or name.
 
Technical requirements 
General Requirements:
1.	Code should be clean and should not contain any “developer-purpose” constructions. 
2.	Application should be designed and written with respect to OOD and SOLID principles.
3.	Code should contain valuable comments where appropriate.
4.	Public APIs should be documented using Javadoc.
5.	A clear layered structure should be used: responsibilities of each application layer should be defined.
6.	JSON should be used as a format of client-server communication messages. 
7.	Convenient error and exception handling mechanism should be implemented: all errors should be meaningful and localized on backend side.
8.	Abstraction should be used to avoid code duplication.

Tools and Implementation Requirements:
Please note that only GA versions of tools, frameworks, and libraries are allowed.
1.	JDK version: 8. Use Streams, java.time.*, etc. where it is appropriate.
2.	Application package root: com.epam.esm
3.	Custom connection pool implementation should be used: 
a.	It should support lazy concurrent loading.
b.	It should be created once per JVM (exposed as a Spring Bean).
c.	If Proxy pattern is used, it should be implemented without code duplication (JDK Proxy or any other).
4.	JDBC or Spring JDBC Template should be used for data access.
5.	Java Code Convention is mandatory. Exception: margin size – 120 chars.
6.	Build tool: Apache Maven 3.5+. Multi-module project.
7.	Web server: Apache Tomcat.
8.	Application container: Spring IoC. Spring Framework 4.+
9.	Database: PostgreSQL 9.+ or 10.+
10.	Testing: JUnit 4.+ or 5.+, Mockito.
11.	Service layer should be covered with unit tests. Unit tests coverage should be not less than 80%.
12.	Repository layer should be tested using integration tests with an in-memory embedded database. All operations with certificates should be covered with integration tests.
13.	APIs should be demonstrated using Postman tool. Postman collections with APIs should be prepared for the demo.

Restrictions
It is forbidden to use:
1.	Spring Boot,
2.	Spring Data Repositories,
3.	JPA,
4.	Lombok,
5.	Powermock.
