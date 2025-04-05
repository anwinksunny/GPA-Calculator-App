# GPA Calculator (Android App) 

An Android application designed for university students to efficiently calculate their Semester Grade Point Average (SGPA). It features a dedicated calculator tailored for KTU (APJ Abdul Kalam Technological University) syllabus structures and a flexible universal calculator for students from any university.

---

## Requirements

### Runtime Requirements:

*   **Operating System:** Android 5.0 (Lollipop) / API Level 21 or higher.

### Development Requirements (For Building from Source):

*   **IDE:** Android Studio
*   **Language:** Java (JDK 11)
*   **Android SDK:**
    *   `compileSdk`: 35
    *   `minSdk`: 21
    *   `targetSdk`: 34
*   **Build Tools:** Android SDK Build-Tools compatible with SDK 35.

---

## How to Use the Application

1.  **Launch the App:** Open the SGPA Calculator on your Android device.
2.  **Select Calculator Type:** On the main screen, choose between:
    *   **KTU SGPA Calculator:** For students following the KTU syllabus.
    *   **Universal SGPA Calculator:** For students from any other university or grading system.

3.  **Using the KTU SGPA Calculator:**
    *   Select your specific **Branch** (e.g., Computer Science, Mechanical Engineering).
    *   Select the **Semester** for which you want to calculate the SGPA.
    *   The app will display the subjects and credits corresponding to your selected branch and semester.
    *   Enter the **Grade** you obtained for each subject listed.
    *   Tap the "Calculate" button to view your SGPA for that semester. ✨

4.  **Using the Universal SGPA Calculator:**
    *   Use the "Add Course" (+) button to add rows for each subject.
    *   For each subject, enter:
        *   Course Name (Optional, for reference)
        *   Credit Value
        *   Grade Obtained (Ensure this matches your university's grading scale understood by the calculation logic).
    *   Add all necessary courses for the semester.
    *   Tap the "Calculate" button to view the overall SGPA based on the entered data.

---
