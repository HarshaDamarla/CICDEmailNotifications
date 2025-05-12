# CICD Email Notifications – Java Jenkins Pipeline

This project demonstrates a simple CI/CD pipeline using Jenkins to compile and execute two basic Java programs and send email notifications based on the pipeline outcome.

---

## 📦 Java Programs

### 1. `SumAndAvg.java`
- Calculates the sum and average of predefined integers.
- Output is printed to the console.

### 2. `PrintElements.java`
- Prints all elements of a predefined integer array.
- Displays the first and last elements.

---

## 🛠️ Jenkins Pipeline

The `Jenkinsfile` in this repository performs the following stages:

1. **Checkout**
   - Clones this GitHub repository
