# Harisman Jeyakanthan

**Student ID:** 101325107

---

## Objective

Implement a PostgreSQL database using the provided schema and write an application in Java that connects to this database to perform specific CRUD (Create, Read, Update, Delete) operations for a Gym Management System managing Members, Trainers, and Admins.

---

## Database Schema

### Member Table

| Field      | Type    | Constraints     |
|------------|---------|-----------------|
| memberId   | SERIAL  | PRIMARY KEY     |
| password   | TEXT    | NOT NULL        |
| firstname  | TEXT    | NOT NULL        |
| lastname   | TEXT    | NOT NULL        |
| dob        | DATE    | NOT NULL        |
| gender     | TEXT    | NOT NULL        |
| primPhone  | TEXT    | NOT NULL        |
| secPhone   | TEXT    | *(Optional)*    |

> Additional tables include: `Trainer`, `Admin`, `Biometrics`, `Goal`, `Availabilities`, `Room`, `RoomBooking`, `Billing`, and `BillingLineItem`.  
> All are created and initialized automatically when the program launches.

---

## Initial Data

```sql
INSERT INTO Member (password, firstname, lastname, DOB, gender, primPhone, secPhone)
VALUES 
('12345', 'Alice', 'Smith', '1990-05-15', 'Female', '1234567890', '0987654321');
```

Seeded automatically on program startup.

---

## Project Overview

### Key Files

- `Main.java` – Entry point. Connects to the database and initializes tables and data.
- `MainMenu.java` – Login screen and landing menu.
- `NewUser.java`, `NewTrainer.java`, `NewAdmin.java` – Handle user registration for each role.
- `Dashboard.java` – A member's dashboard for viewing personal info, appointments, biometrics, and goals.
- `Biometrics.java` – Member health tracking input form.
- `Goal.java` – Member goal-setting form and progress tracker.
- `TrainerDashboard.java` – Trainer view for availability and member data.
- `Availability.java` – Used by trainers to set available time slots.
- `AdminDashboard.java` – Used by admins to assign rooms, issue bills, and track payments.

---

## Implemented Functions

### Member Functions

| Function            | Description |
|---------------------|-------------|
| Register             | Create a new member profile with login details |
| Set Health Metrics   | Log current weight, blood pressure, body fat, etc. |
| Set Fitness Goal     | Define weight or body fat % target with a time frame |
| Dashboard            | View personal details, goal progress, recent biometrics |
| Book Session         | Book personal training slot from available times |

---

### Trainer Functions

| Function            | Description |
|---------------------|-------------|
| Set Availability     | Define session timing; prevent self-overlaps |
| View Schedule        | View booked sessions with members |
| Search Members       | Look up assigned members to view their goals/metrics |

---

### Admin Functions

| Function            | Description |
|---------------------|-------------|
| Assign Rooms         | Assign available rooms to booked sessions using session+room constraints |
| Billing              | Generate and view bills using line items |
| Payments             | Mark payments as complete and update billing view |
| Billing Status View  | SQL view to track unpaid bills at a glance |

---

## Running the Program

Make sure PostgreSQL is installed and running locally.

Open `Main.java` and update the database connection values:

```java
String url = "jdbc:postgresql://localhost:5432/postgres";
String user = "postgres";
String password = "your_password";
```

Run `Main.java`. This will:
- Initialize tables
- Create required views and triggers
- Seed the database with sample users and data

---

## Using the Program

After launching, you’ll see the main login screen.

- Click "New User", "New Trainer", or "New Admin" to register new accounts.
- Login with your account based on your role.

Once logged in:

- **Members** can view dashboards, enter biometrics, book sessions, and set goals.
- **Trainers** can view their assigned sessions and register new time slots.
- **Admins** can assign training rooms and manage all billing operations.

Feedback is shown via GUI messages and updated data views.

---

## Demo Video

[Insert your YouTube video link here]

---

**End of README**
