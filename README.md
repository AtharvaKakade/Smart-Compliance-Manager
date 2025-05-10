## 1. Project Overview
Compliance Manager is a web application that helps organizations automate, assign, track, and audit compliance tasks efficiently.

## 2. Objectives
- Streamline the compliance process
- Automate task assignment and reminders
- Ensure audit readiness with document proof and history
- Generate reports for stakeholders

## 3. System Features
- Create and assign compliance tasks
- Upload documents/proofs
- Auto-reminders & escalation
- Calendar view
- Reports generation
- Role-based access control
- Audit trail

## 4. Technology Stack

| Layer           | Technology         |
|----------------|--------------------|
| Frontend        | React.js           |
| Backend         | Spring Boot        |
| Database        | MySQL   |
| Authentication  | JWT / Spring Security |
| File Storage    | Local     |
| Reports         | iText / JasperReports (optional) |

## 5. Architecture Diagram
*Diagram to be added*

## 6. Database Design
Entities:
- User
- ComplianceTask
- Document
- Comment
- Notification
- AuditLog

*ER Diagram to be added here*

## 7. API Endpoints

| Endpoint              | Method | Description             |
|-----------------------|--------|-------------------------|
| `/api/tasks`          | GET    | Get all tasks           |
| `/api/tasks/{id}`     | PUT    | Update a task           |
| `/api/upload`         | POST   | Upload a file           |
| `/api/notifications`  | GET    | Fetch notifications     |
*more to be added.....*

## 8. User Roles
- **Admin**: Can create tasks, assign, view reports
- **User**: View & complete assigned tasks
- **Auditor**: Read-only access to reports

## 9. Usage Flow

1. Admin logs in
2. Creates and assigns compliance task
3. User gets notified and uploads documents
4. Admin reviews and marks as complete

*Add a diagram here for visual flow*

## 10. Installation Steps

1. Clone the repository
2. Configure `application.properties`
3. Run backend: `./mvnw spring-boot:run`
4. Run frontend: `npm install && npm start`

## 11. Future Scope
- SMS/WhatsApp notifications
- OCR for uploaded docs
- Analytics dashboard and charts

---
