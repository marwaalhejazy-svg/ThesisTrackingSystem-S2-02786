-- Database Schema for Thesis Tracking System

CREATE DATABASE ThesisTrackingDB;
USE ThesisTrackingDB;

-- Person table (base table for all users)
CREATE TABLE Person (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('Student', 'Supervisor', 'Coordinator', 'Administrator') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Student table
CREATE TABLE Student (
    student_id VARCHAR(20) PRIMARY KEY,
    person_id VARCHAR(20),
    student_number VARCHAR(20) UNIQUE NOT NULL,
    program VARCHAR(100) NOT NULL,
    enrollment_date DATE,
    FOREIGN KEY (person_id) REFERENCES Person(id) ON DELETE CASCADE
);

-- Supervisor table
CREATE TABLE Supervisor (
    supervisor_id VARCHAR(20) PRIMARY KEY,
    person_id VARCHAR(20),
    employee_id VARCHAR(20) UNIQUE NOT NULL,
    department VARCHAR(100),
    FOREIGN KEY (person_id) REFERENCES Person(id) ON DELETE CASCADE
);

-- Program Coordinator table
CREATE TABLE ProgramCoordinator (
    coordinator_id VARCHAR(20) PRIMARY KEY,
    person_id VARCHAR(20),
    coordinator_number VARCHAR(20) UNIQUE NOT NULL,
    program_name VARCHAR(100),
    FOREIGN KEY (person_id) REFERENCES Person(id) ON DELETE CASCADE
);

-- Thesis table
CREATE TABLE Thesis (
    thesis_id VARCHAR(20) PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    field VARCHAR(100),
    start_date DATE,
    status ENUM('In Progress', 'Completed', 'Delayed', 'On Hold') DEFAULT 'In Progress',
    student_id VARCHAR(20),
    supervisor_id VARCHAR(20),
    FOREIGN KEY (student_id) REFERENCES Student(student_id),
    FOREIGN KEY (supervisor_id) REFERENCES Supervisor(supervisor_id)
);

-- Progress Update table
CREATE TABLE ProgressUpdate (
    update_id VARCHAR(20) PRIMARY KEY,
    thesis_id VARCHAR(20),
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    description TEXT NOT NULL,
    document_path VARCHAR(255),
    milestone VARCHAR(100),
    FOREIGN KEY (thesis_id) REFERENCES Thesis(thesis_id) ON DELETE CASCADE
);

-- Indexes for better performance
CREATE INDEX idx_student_program ON Student(program);
CREATE INDEX idx_thesis_status ON Thesis(status);
CREATE INDEX idx_progress_date ON ProgressUpdate(update_date);
