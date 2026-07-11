# Lumorq - Online Course Management Platform

Lumorq is a comprehensive online course management system built with Spring Boot 4.0.6. The platform provides RESTful APIs for managing students, courses, categories, enrollments, and payments in an educational context.

## 🏗️ Architecture

### Technology Stack
- **Framework**: Spring Boot 4.0.6
- **Java Version**: 25
- **Build Tool**: Maven
- **Database**: H2 (in-memory for development/testing), PostgreSQL (production-ready)
- **ORM**: Spring Data JPA with Hibernate
- **Architecture Pattern**: Layered Architecture (Controller → Service → Repository)

### Project Structure
```
lumorq/
├── src/
│   ├── main/
│   │   ├── java/com/lumorq/
│   │   │   ├── entities/           # JPA Entities
│   │   │   │   ├── Category.java
│   │   │   │   ├── Course.java
│   │   │   │   ├── Student.java
│   │   │   │   ├── Enrollment.java
│   │   │   │   ├── EnrollmentItem.java
│   │   │   │   ├── Payment.java
│   │   │   │   └── enums/
│   │   │   │       └── EnrollmentStatus.java
│   │   │   ├── repositories/       # Data Access Layer
│   │   │   │   ├── CategoryRepository.java
│   │   │   │   ├── CourseRepository.java
│   │   │   │   ├── StudentRepository.java
│   │   │   │   ├── EnrollmentRepository.java
│   │   │   │   └── EnrollmentItemRepository.java
│   │   │   ├── services/           # Business Logic Layer
│   │   │   │   ├── CategoryService.java
│   │   │   │   ├── CourseService.java
│   │   │   │   ├── StudentService.java
│   │   │   │   ├── EnrollmentService.java
│   │   │   │   └── exceptions/
│   │   │   │       ├── ResourceNotFoundException.java
│   │   │   │       └── DatabaseException.java
│   │   │   ├── resources/          # REST Controllers
│   │   │   │   ├── CategoryResource.java
│   │   │   │   ├── CourseResource.java
│   │   │   │   ├── StudentResource.java
│   │   │   │   ├── EnrollmentResource.java
│   │   │   │   └── exceptions/
│   │   │   │       ├── ResourceExceptionHandler.java
│   │   │   │       └── StandardError.java
│   │   │   ├── config/
│   │   │   │   └── TestConfig.java
│   │   │   └── LumorqApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-test.properties
│   └── test/
├── pom.xml
├── Dockerfile
├── docker-compose.yml
└── README.md
```

### Entity Relationships
- **Category** ↔ **Course**: Many-to-Many relationship (a course can have multiple categories, a category can have multiple courses)
- **Student** → **Enrollment**: One-to-Many relationship (a student can have multiple enrollments)
- **Enrollment** → **EnrollmentItem**: One-to-Many relationship (an enrollment can have multiple enrollment items)
- **Course** → **EnrollmentItem**: One-to-Many relationship (a course can be in multiple enrollment items)
- **Enrollment** → **Payment**: One-to-One relationship (each enrollment has one payment)
- **EnrollmentItem**: Composite key (Enrollment + Course)

## 📡 API Endpoints

### Base URL
```
http://localhost:8080
```

### Categories
| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| GET | `/categories` | List all categories | None | `List<Category>` |
| GET | `/categories/{id}` | Get category by ID | None | `Category` |

### Courses
| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| GET | `/courses` | List all courses | None | `List<Course>` |
| GET | `/courses/{id}` | Get course by ID | None | `Course` |

### Students
| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| GET | `/students` | List all students | None | `List<Student>` |
| GET | `/students/{id}` | Get student by ID | None | `Student` |
| POST | `/students` | Create new student | `Student` | `Student` |
| PUT | `/students/{id}` | Update student | `Student` | `Student` |
| DELETE | `/students/{id}` | Delete student | None | `204 No Content` |

### Enrollments
| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| GET | `/enrollments` | List all enrollments | None | `List<Enrollment>` |
| GET | `/enrollments/{id}` | Get enrollment by ID | None | `Enrollment` |

### H2 Console (Development)
- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (empty)

## 🚀 How to Run

### Prerequisites
- Java 21 or higher
- Maven 3.9+
- Docker (for containerized deployment)

### Option 1: Using Maven (Local Development)

1. **Clone the repository**
```bash
git clone <repository-url>
cd lumorq
```

2. **Build the project**
```bash
./mvnw clean package
```

3. **Run the application**
```bash
./mvnw spring-boot:run
```

Or run the JAR directly:
```bash
java -jar target/lumorq-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

### Option 2: Using Docker (Recommended)

1. **Build and run with Docker Compose**
```bash
docker-compose up --build
```

This will:
- Build the application using Maven
- Create a Docker image
- Start the container on port 8080
- Configure H2 database for development

2. **Access the application**
- API: `http://localhost:8080`
- H2 Console: `http://localhost:8080/h2-console`

3. **Stop the application**
```bash
docker-compose down
```

### Option 3: Using Docker (Manual)

1. **Build the Docker image**
```bash
docker build -t lumorq-app .
```

2. **Run the container**
```bash
docker run -p 8080:8080 lumorq-app
```

## 🗄️ Database Configuration

### Development (H2)
The application uses H2 in-memory database by default (profile: test). Configuration is in `application-test.properties`:
- Driver: `org.h2.Driver`
- URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (empty)
- H2 Console: Enabled at `/h2-console`

### Production (PostgreSQL)
To use PostgreSQL in production:
1. Add PostgreSQL configuration in `application.properties`
2. Update the Docker Compose file to include a PostgreSQL service
3. Change the active profile from `test` to `prod`

## 🧪 Testing

Run tests with Maven:
```bash
./mvnw test
```

## 📝 Environment Variables

- `SPRING_PROFILES_ACTIVE`: Active Spring profile (default: `test`)

## 🔧 Configuration

Main configuration files:
- `application.properties`: Main application configuration
- `application-test.properties`: Test/Development profile configuration

## 🛠️ Development Tools

- **H2 Console**: Database management UI available at `/h2-console`
- **Spring Boot DevTools**: Hot reload (if added to dependencies)
- **Maven Wrapper**: Included for consistent builds (`./mvnw`)

## 📦 Dependencies

Key dependencies from `pom.xml`:
- Spring Boot Starter Web MVC
- Spring Boot Starter Data JPA
- Spring Boot H2 Console
- H2 Database
- PostgreSQL Driver
- Spring Boot Starter Test (Data JPA & Web MVC)

## 🤝 Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

## 📄 License

This project is proprietary software. All rights reserved.

## 👥 Authors

- Lumorq Development Team

## 📞 Support

For support and questions, please contact the development team.
