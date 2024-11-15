# Vidhyavistar: A School Management Platform

## Intro
Vidhyavistar is an open-source school management website designed to simplify the process of managing schools, colleges, and universities. Our goal is to create a comprehensive platform that streamlines administrative tasks, enhances student engagement, and fosters a collaborative learning environment.

## Project Structure
Our project is divided into several modules, each with its own set of features and functionalities. The following is a high-level overview of our project structure:

- Backend: Our backend is built using Spring Boot, a popular Java framework for building web applications. It provides a robust and scalable architecture for our application.
- Frontend: Our frontend is built using React, a popular JavaScript library for building user interfaces. It provides a responsive and interactive interface for our application.
Microservices: Our application is divided into several microservices, each responsible for a specific functionality. This allows us to scale and maintain our application more efficiently.

## Modules
Our project consists of the following modules:

- Authentication Service (Auth): Responsible for handling user authentication and authorization.
- Payment Service: Responsible for managing payment processing and transactions.
- School Admin Service: Responsible for managing school administration tasks, including student enrollment, attendance, and grades.
- Teacher Service: Responsible for managing teacher data, including course assignments, attendance, and grades.
- Student Service: Responsible for managing student data, including enrollment, attendance, and grades.
- Absolute Admin Service: Responsible for managing the overall website and its settings.

## Frontend Dashboards
Our frontend is divided into several dashboards, each tailored to a specific role:

- Auth Dashboard: Provides a login and registration interface for users.
- School Admin Dashboard: Provides a comprehensive interface for school administrators to manage school tasks, including student enrollment, attendance, and grades.
- Teacher Dashboard: Provides a interface for teachers to manage their course assignments, attendance, and grades.
- Student Dashboard: Provides a interface for students to view their enrollment, attendance, and grades.
- Absolute Admin Dashboard: Provides a comprehensive interface for the absolute admin to manage the overall website and its settings.

### Vidhyavistar Directory Structure
```vidhyavistar/
├── vidhyavistar-backend/
│   ├── pom.xml
│   ├── src/
│   └── ...
├── vidhyavistar-frontend/
│   ├── package.json
│   ├── src/
│   └── ...
├── vidhyavistar-microservices/
│   ├── authentication-service/
│   │   ├── pom.xml
│   │   ├── src/
│   │   └── ...
│   ├── student-service/
│   │   ├── pom.xml
│   │   ├── src/
│   │   └── ...
│   ├── teacher-service/
│   │   ├── pom.xml
│   │   ├── src/
│   │   └── ...
│   └── course-service/
│       ├── pom.xml
│       ├── src/
│       └── ...
└── README.md
```


## Collaboration Guidelines
We welcome contributions from anyone who is interested in helping us build Vidhyavistar. Here are some guidelines to keep in mind:

- Code of Conduct: We expect all contributors to adhere to our code of conduct, which includes being respectful, professional, and inclusive.
- Issue Tracking: We use GitHub issues to track bugs, feature requests, and other tasks. Please create a new issue for any changes you'd like to make.
- Pull Requests: We use pull requests to review and merge changes. Please create a new pull request for any changes you'd like to make.
- Code Reviews: We require code reviews for all pull requests. Please review the code carefully and provide feedback before merging.

## Getting Started
To get started with Vidhyavistar, please follow these steps:

- Clone the repository: `git clone https://github.com/your-username/vidhyavistar.git`
- Install dependencies: `npm install or yarn install`
- Start the application: `npm start or yarn start`
