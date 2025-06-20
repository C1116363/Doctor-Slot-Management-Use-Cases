# Doctor Slot Management System

This is a Spring Boot-based RESTful application designed to manage doctor appointments, slots, walk-ins,
patient history, recommendations, and slot delegation. The application uses PostgreSQL as the database and follows a modular, service-oriented structure.

---

## ✅ Features Implemented

1. **Doctor Unavailability Management**
2. **Slot Booking & Validation**
3. **Patient Slot History Retrieval**
4. **Slot Delegation Between Doctors**
5. **Walk-in Queue Management**
6. **Slot Recommendation System**
7. **Slot Template-Based Generation**
8. **Clinic Management API**
9. **Patient Registration API**
10. **GitHub Deployment Steps**

---

## 🔗 Postman Workspace Link

👉 [Test All APIs on Postman](https://restless-sunset-18743.postman.co/workspace/Doctor~3996aa99-3e6a-424e-8b35-256231b912ab/collection/17137810-d67d914a-1fd3-4e0e-8af3-a1733034d392?action=share&creator=17137810)

---

## 🚀 API Endpoints

### 👨‍⚕️ Doctor & Slot Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/slot-coordination/delegate` | Delegate a slot to another doctor |
| `POST` | `/api/slot-template/save` | Save a new slot template |
| `POST` | `/api/slot-template/generate` | Generate slots based on template |
| `POST` | `/api/unavailability/mark` | Mark doctor unavailability |

---

### 📅 Booking

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/booking` | Book a slot (requires `patientId` and `slotId`) |

---

### 👤 Patient APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/patient/create` | Register a new patient |
| `GET`  | `/api/patient/history` | View patient's booking history |
| `GET`  | `/api/patient/check` | Get total bookings for a patient |

---

### 🏥 Clinic

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/clinic/create` | Register a new clinic |
| `GET`  | `/api/clinic/all` | List all clinics |

---

### 👥 Walk-in Queue

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/walkin/join` | Join walk-in queue for a slot |
| `GET`  | `/api/walkin/queue` | Get current queue for a slot |

---

### 💡 Recommendations

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/recommendations` | Get available slot recommendations (filter by doctorId, clinicId, date, limit) |

---

## 📦 Technologies Used

- Java 17
- Spring Boot
- PostgreSQL
- JPA (Hibernate)
- REST APIs
- Postman for testing

---

## 🔧 How to Run

```bash
# Clone the repo
https://github.com/C1116363/Doctor-Slot-Management-Use-Cases

# Navigate into project
cd Doctor-Slot-Management-Use-Cases

# Run with Maven
./mvnw spring-boot:run
