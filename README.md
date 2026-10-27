# BeSkillled Java Programming Internship — Week 3

**Topic:** Data Structures & File Handling  
**Language:** Java  
**Level:** Beginner-friendly

## Contents

### Assignment 1 — Student Marks Record Program
Folder: `01-StudentMarksRecord`

- Stores subject marks in an `ArrayList<Integer>`.
- Validates that the number of subjects is positive and marks are between 0 and 100.
- Calculates highest marks, lowest marks, and average marks.

### Assignment 2 — File I/O and Word Frequency
Folder: `02-FileIO-WordFrequency`

- Reads words from `input.txt`.
- Counts each word's frequency using a `LinkedHashMap`.
- Writes the report to `word_frequency_output.txt`.
- Handles file-reading and file-writing errors.

### Mini Project — Employee Management System
Folder: `03-EmployeeManagementSystem`

- Stores employee ID, name, department, and salary.
- Uses `HashMap<Integer, Employee>` for employee records.
- Adds employees, lists records, and searches by ID.
- Saves and loads records using `employees.txt`.
- Handles invalid input and malformed file records.

## Requirements

- JDK 8 or later
- VS Code with Java support, or another Java IDE
- Terminal / command prompt

## How to run

Open a terminal in the relevant folder.

### 1. Student Marks Record

```bash
cd 01-StudentMarksRecord
javac StudentMarksRecord.java
java StudentMarksRecord
```

### 2. File I/O and Word Frequency

Make sure `input.txt` is in the same folder as the Java file.

```bash
cd 02-FileIO-WordFrequency
javac FileIOWordFrequency.java
java FileIOWordFrequency
```

The program creates `word_frequency_output.txt` in that folder.

### 3. Employee Management System

```bash
cd 03-EmployeeManagementSystem
javac Employee.java EmployeeManagementSystem.java
java EmployeeManagementSystem
```

The program creates or updates `employees.txt` in the folder. Choose option `0` to save and exit.

> Run each `cd` command from the project root in a separate terminal session, or return to the root folder before moving to another assignment.

## Concepts practised

- Java Collections Framework: `ArrayList`, `HashMap`, and `LinkedHashMap`
- Searching and sorting employee records
- File handling with `BufferedReader`, `BufferedWriter`, and `Files`
- Exception handling with `try-catch`, `throw`, and validation
- Classes, constructors, encapsulation, loops, and methods

## Example: word frequency

Given this input:

```text
Java is useful.
Java is easy.
```

The report will contain counts similar to:

```text
java : 2
is : 2
useful : 1
easy : 1
```

## Suggested GitHub repository name

`BeSkilled-Java-Internship-Week-3`

## Push to GitHub

1. Create a **new public repository** named `Beeskilled-java-assignment3` on GitHub. Do not initialize it with another README if you already have this README locally.
2. Open this project folder in VS Code.
3. Open **Terminal → New Terminal**.
4. Run these commands one at a time, replacing `ashrita-patro` with your GitHub username:

```bash
git init
git add .
git commit -m "Complete Week 3 Java internship assignments"
git branch -M main
git remote add origin https://github.com/ashrita-patro/Beeskilled-java-assignment3.git
git push -u origin main
```

If Git says `remote origin already exists`, run:

```bash
git remote set-url origin https://github.com/ashrita-patro/Beeskilled-java-assignment3.git
git push -u origin main
```

## Before submitting

- Run each Java program and confirm it works.
- Check that `README.md`, all `.java` files, and `input.txt` are pushed to GitHub.
- Do not commit generated `.class` files if you can avoid them.
- Open the GitHub repository link and confirm the files are visible.
- Follow your internship LMS instructions for the actual submission format.
