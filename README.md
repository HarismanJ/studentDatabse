Harisman Jeyakanthan
101325107

**Objective:** Implement a PostgreSQL database using the provided schema and write an application in your language of choice that connects to this database to perform specific CRUD (Create, Read, Update, Delete) operations.
Implement a PostgreSQL database using the provided schema and write an application in Java that connects to this database to perform specific CRUD (Create, Read, Update, Delete) operations.

**Database Schema: **
| Field | Type | Constraints |
|--------|--------|-------------|
| student_id | SERIAL | PRIMARY KEY |
| first_name | TEXT | NOT NULL |
| last_name | TEXT | NOT NULL |
| email | TEXT | NOT NULL, UNIQUE |
| enrollment_date | DATE | — |
