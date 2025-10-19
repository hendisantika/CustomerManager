# Customer Manager

A modern Spring MVC 6 Customer Management Demo Application with full CRUD operations, built with the latest
technologies.

## Description

Customer Manager is a web-based application built with Spring Framework 6 and Jakarta EE that demonstrates the
implementation of a complete customer management system. The application provides functionality to create, read, update,
delete, and search customer records using a clean MVC architecture with modern Java 25 features.

## Features

- **CRUD Operations**: Complete Create, Read, Update, and Delete functionality for customer records
- **Search Functionality**: Search customers by keyword
- **Docker Support**: Full Docker and Docker Compose support for easy deployment
    - Multi-stage Dockerfile for optimized image size
    - MySQL 9.4.0 container with persistent storage
    - Automated database initialization with sample data
    - Health checks and proper container orchestration
- **Modern Java 25**: Leverages the latest Java features and performance improvements
- **Jakarta EE Compatible**: Fully migrated to Jakarta EE namespace (jakarta.*)
- **Spring Framework 6**: Uses the latest Spring Framework with enhanced features
- **Hibernate 6**: Latest Hibernate ORM with improved performance and Jakarta EE support
- **Responsive UI**: Clean web interface built with Jakarta Server Pages
- **Database Integration**: MySQL database integration using JPA/Hibernate
- **Spring Data JPA**: Leverages Spring Data JPA for simplified data access layer
- **RESTful Architecture**: Clean controller-service-repository pattern

## Technology Stack

### Backend

- **Java**: 25 (Latest LTS release)
- **Spring Framework**: 6.2.12 (Jakarta EE compatible)
- **Spring MVC**: For web layer
- **Spring Data JPA**: 3.5.5
- **Hibernate ORM**: 6.6.6.Final
- **Jakarta Persistence API**: 3.2
- **Maven**: 3.x for build and dependency management

### Frontend

- **JSP**: Jakarta Server Pages for view layer
- **JSTL**: 3.0.2 (Jakarta JSTL API)
- **Jakarta Servlet**: 6.1.0
- **HTML5/CSS**: For modern UI layout

### Database

- **MySQL Connector**: 9.1.0 (mysql-connector-j)
- **Database Name**: sales
- **Driver**: com.mysql.cj.jdbc.Driver

### Additional Libraries

- **Lombok**: 1.18.42 for reducing boilerplate code
- **Jakarta Servlet API**: 6.1.0
- **Jakarta JSP API**: 4.0.0
- **Jakarta JSTL**: 3.0.1 (GlassFish implementation)

### Docker & Deployment

- **Docker**: Multi-stage builds for optimized images
- **MySQL Server** (Docker): 9.4.0
- **Base Images**:
    - Build: Maven 3.9 with Eclipse Temurin JDK 25 on Alpine Linux
    - Runtime: Tomcat 11.0 with JDK 25
- **Docker Compose**: Orchestration for MySQL 9.4.0 and Spring app
- **Container Features**: Health checks, persistent volumes, auto-restart

## Project Structure

```
CustomerManager/
├── src/
│   ├── main/
│   │   ├── java/com/hendisantika/customermanager/
│   │   │   ├── config/
│   │   │   │   ├── JpaConfig.java           # JPA configuration
│   │   │   │   ├── WebAppInitializer.java   # Web application initializer
│   │   │   │   └── WebMvcConfig.java        # Spring MVC configuration
│   │   │   ├── controller/
│   │   │   │   └── CustomerController.java  # Main controller
│   │   │   ├── entity/
│   │   │   │   └── Customer.java            # Customer entity
│   │   │   ├── repository/
│   │   │   │   └── CustomerRepository.java  # Data access layer
│   │   │   └── service/
│   │   │       └── CustomerService.java     # Business logic layer
│   │   └── WebContent/
│   │       └── WEB-INF/
│   │           └── views/                   # JSP views
│   │               ├── index.jsp
│   │               ├── newCustomer.jsp
│   │               ├── editCustomer.jsp
│   │               └── search.jsp
│   └── META-INF/
│       └── persistence.xml                  # JPA persistence configuration
├── init-db/
│   └── 01-init.sql                          # MySQL initialization script
├── Dockerfile                               # Multi-stage Docker build
├── docker-compose.yml                       # Docker Compose orchestration
├── persistence-docker.xml                   # Docker-specific JPA config
├── .dockerignore                            # Docker build exclusions
├── pom.xml                                  # Maven configuration
└── README.md
```

## Database Configuration

The application uses MySQL database with the following default configuration:

```properties
Database=URL: jdbc:mysql://localhost:3306/sales
Username=root
Password=root
Driver=com.mysql.cj.jdbc.Driver
```

### Database Setup

1. Install MySQL server
2. Create the database:

```sql
CREATE
DATABASE sales;
```

3. The application will auto-create the `customer` table with the following structure:
    - `id` (BIGINT, Primary Key, Auto-increment)
    - `name` (VARCHAR)
    - `email` (VARCHAR)
    - `address` (VARCHAR)

To change the database configuration, edit the `src/META-INF/persistence.xml` file.

## Prerequisites

### For Local Development
- **Java 25** or higher
- **Maven 3.9** or higher
- **MySQL Server 8.0** or higher
- **Apache Tomcat 10.1** or higher (Jakarta EE 10 compatible) or **Apache Tomcat 11** (Jakarta EE 11 compatible)
    - **Important**: Tomcat 10+ is required for Jakarta EE support. Older Tomcat versions (9.x or below) use javax.*
      packages and are not compatible.

### For Docker Deployment (Recommended)

- **Docker**: 20.10 or higher
- **Docker Compose**: 2.0 or higher

No need to install Java, Maven, MySQL, or Tomcat when using Docker!

## Installation & Setup

You can deploy this application in two ways: using Docker (recommended) or traditional local deployment.

---

## Option 1: Docker Deployment (Recommended)

This is the fastest and easiest way to get the application running!

### 1. Clone the Repository

```bash
git clone <repository-url>
cd CustomerManager
```

### 2. Start the Application

```bash
docker compose up -d
```

This single command will:

- Build the Spring MVC application using Maven and Java 25
- Create a MySQL 9.4.0 database container
- Deploy the application to Tomcat 11
- Set up networking between containers
- Initialize the database with sample data

### 3. Access the Application

Open your browser and navigate to:

```
http://localhost:8080
```

The application will be ready with 5 sample customers already loaded!

### 4. Manage Docker Containers

**View logs:**

```bash
# View all logs
docker compose logs -f

# View app logs only
docker compose logs -f app

# View MySQL logs only
docker compose logs -f mysql
```

**Stop the application:**

```bash
docker compose down
```

**Stop and remove all data (including database):**

```bash
docker compose down -v
```

**Rebuild after code changes:**

```bash
docker compose up -d --build
```

### Docker Architecture

The Docker setup includes:

- **MySQL Container**: MySQL 9.4.0 database server
    - Port: 3306
    - Database: sales
    - User: root/root
    - Persistent volume for data storage
    - Health checks for reliability
    - Auto-initialization with sample data

- **Spring Application Container**: Tomcat 11 with Java 25
    - Port: 8080
    - Multi-stage build (Maven build + Tomcat runtime)
    - Optimized image size using Alpine Linux for build stage
    - Automatic database connection with health check waiting

---

## Option 2: Local Development Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd CustomerManager
```

### 2. Configure Database

Update the database credentials in `src/META-INF/persistence.xml` if needed:

```xml

<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/sales"/>
<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value="root"/>
```

### 3. Build the Project

```bash
mvn clean package
```

This will create a WAR file at `target/CustomerManager.war`

### 4. Deploy to Tomcat

#### Option A: Manual Deployment

1. Copy the WAR file to your Tomcat's `webapps` directory:
   ```bash
   cp target/CustomerManager.war $TOMCAT_HOME/webapps/
   ```
2. Start Tomcat server
3. Access the application at: `http://localhost:8080/CustomerManager/`

#### Option B: IDE Deployment

1. Import the project into your IDE (IntelliJ IDEA, Eclipse, etc.)
2. Configure Tomcat server
3. Deploy and run the application

## Usage

### Customer List

- Navigate to `http://localhost:8080/CustomerManager/`
- View all customers in a table format
- Search for customers using the search box

### Add New Customer

1. Click "New Customer" link
2. Fill in customer details (Name, Email, Address)
3. Click "Save" button

### Edit Customer

1. Click "Edit" link next to a customer record
2. Modify customer details
3. Click "Save" button

### Delete Customer

1. Click "Delete" link next to a customer record
2. Customer will be removed from the database

### Search Customers

1. Enter a keyword in the search box
2. Click "Search" button
3. View matching results

## API Endpoints

| Endpoint                    | Method | Description               |
|-----------------------------|--------|---------------------------|
| `/`                         | GET    | Display all customers     |
| `/new`                      | GET    | Show new customer form    |
| `/save`                     | POST   | Save new/updated customer |
| `/edit?id={id}`             | GET    | Show edit customer form   |
| `/delete?id={id}`           | GET    | Delete customer by ID     |
| `/search?keyword={keyword}` | GET    | Search customers          |

## Building and Testing

### Compile Only

```bash
mvn clean compile
```

### Run Tests

```bash
mvn test
```

### Package WAR File

```bash
mvn clean package
```

### Clean Build Artifacts

```bash
mvn clean
```

## Configuration Files

### pom.xml

Contains all Maven dependencies and build configuration. Key dependencies include Spring Framework, Hibernate, MySQL
connector, and Lombok.

### persistence.xml

Located in `src/META-INF/`, this file configures the JPA persistence unit, database connection, and Hibernate
properties.

### JpaConfig.java

Java-based configuration for JPA, entity manager factory, and transaction management.

### WebMvcConfig.java

Configures Spring MVC components, view resolvers, and static resource handling.

### Docker Files

#### Dockerfile

Multi-stage Dockerfile that:

1. **Build stage**: Uses Maven 3.9 with Eclipse Temurin Java 25 on Alpine Linux to compile the application
2. **Runtime stage**: Uses Tomcat 11 with JDK 25 to run the application
3. Optimizes image size by separating build and runtime environments

#### docker-compose.yml

Docker Compose configuration that orchestrates:

1. **MySQL 9.4.0 container**: Database server with health checks
2. **Application container**: Spring MVC app running on Tomcat 11
3. **Network configuration**: Bridge network for container communication
4. **Volume management**: Persistent storage for MySQL data

#### persistence-docker.xml

Docker-specific JPA configuration that uses the MySQL container hostname instead of localhost.

## Jakarta EE Migration Notes

This project has been fully migrated from Java EE (javax.*) to Jakarta EE (jakarta.*). Key changes include:

### Package Name Changes

- `javax.persistence.*` → `jakarta.persistence.*`
- `javax.servlet.*` → `jakarta.servlet.*`
- `javax.servlet.jsp.*` → `jakarta.servlet.jsp.*`

### Dependency Updates

- JSTL tag URI: `http://java.sun.com/jsp/jstl/core` → `jakarta.tags.core`
- Hibernate artifact: `org.hibernate:hibernate-core` → `org.hibernate.orm:hibernate-core`
- MySQL Connector: `mysql:mysql-connector-java` → `com.mysql:mysql-connector-j`

### Server Requirements

- **Must use Tomcat 10.1+** or other Jakarta EE 10+ compatible servers
- Tomcat 9.x and earlier versions are NOT compatible (they use javax.* packages)

### Character Encoding

- All JSP files now use UTF-8 encoding instead of ISO-8859-1
- Modern HTML5 DOCTYPE instead of legacy HTML 4.01

## Troubleshooting

### Common Issues

1. **Database Connection Error**
    - Verify MySQL server is running
    - Check database credentials in `persistence.xml`
    - Ensure `sales` database exists

2. **Build Failures**
    - Clear Maven cache: `mvn clean`
    - Update dependencies: `mvn clean install -U`

3. **Deployment Issues**
    - Ensure Tomcat is running
    - Check Tomcat logs in `$TOMCAT_HOME/logs/catalina.out`
    - Verify WAR file is properly deployed

4. **404 Errors**
    - Check the context path matches the WAR file name
    - Verify the application deployed successfully

5. **Jakarta EE / Servlet Compatibility Errors**
    - Ensure you're using Tomcat 10.1+ or another Jakarta EE 10+ compatible server
    - Error like `ClassNotFoundException: jakarta.servlet.*` means your server doesn't support Jakarta EE
    - If using an older Tomcat (9.x or below), you must upgrade to Tomcat 10.1+

6. **JSTL Tag Errors in JSP**
    - Ensure JSP files use `jakarta.tags.core` instead of `http://java.sun.com/jsp/jstl/core`
    - Verify JSTL dependencies are correctly configured in pom.xml
    - Check that both `jakarta.servlet.jsp.jstl` and `jakarta.servlet.jsp.jstl-api` are included

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## License

This project is created for educational and demonstration purposes.

## Docker Quick Reference

### Essential Commands

```bash
# Start the application (builds images if needed)
docker compose up -d

# View logs in real-time
docker compose logs -f

# Stop the application
docker compose down

# Stop and remove all data (including database)
docker compose down -v

# Rebuild after code changes
docker compose up -d --build

# Restart just the app container
docker compose restart app

# Access MySQL container shell
docker compose exec mysql mysql -uroot -proot sales

# View running containers
docker compose ps

# View container resource usage
docker compose stats
```

### Troubleshooting Docker

**Container won't start:**

```bash
# Check logs
docker compose logs app
docker compose logs mysql

# Verify containers status
docker compose ps
```

**Database connection errors:**

```bash
# Ensure MySQL is healthy
docker compose ps mysql

# Check MySQL logs
docker compose logs mysql

# Restart MySQL
docker compose restart mysql
```

**Port already in use:**

```bash
# Find what's using port 8080 or 3306
lsof -i :8080
lsof -i :3306

# Change ports in docker-compose.yml if needed
```

**Clear everything and start fresh:**

```bash
docker compose down -v
docker system prune -a
docker compose up -d --build
```

## Acknowledgments

- Spring Framework team for the excellent documentation
- Hibernate team for the robust ORM solution
- MySQL team for the reliable database system
- Docker and containerization community for deployment best practices
