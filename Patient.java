public class Patient {
    private int id;
    private String name;
    private int birthYear;
    private double height;
    private double weight;

    // New Fields
    private String bloodGroup;
    private String phoneNumber;

    // 1. Default Constructor (No arguments)
    public Patient() {
        this(1, "Unknown", 1, 1.0, 1.0, "Unknown", "Unknown");
    }

    // 2. Compatibility Constructor (5 arguments)
    // This makes your provided main method work without changing it.
    // It sets bloodGroup and phoneNumber to "Unknown".
    public Patient(int id, String name, int birthYear, double height, double weight) {
        this(id, name, birthYear, height, weight, "Unknown", "Unknown");
    }

    // 3. Master Constructor (7 arguments)
    // Initializes all fields including the new ones.
    public Patient(int id, String name, int birthYear, double height, double weight, String bloodGroup, String phoneNumber) {
        this.id = id;
        this.name = name;

        // BirthYear Validation
        if (birthYear <= 0) {
            this.birthYear = 2000;
            System.out.println("--------------birthYear error--------------");
        } else {
            this.birthYear = birthYear;
        }

        // Height Validation
        if (height <= 0) {
            this.height = 150.0; // Default if invalid
            System.out.println("--------------height error--------------");
        } else {
            this.height = height;
        }

        // Weight Validation
        if (weight <= 0) {
            this.weight = 50.0; // Default if invalid
            System.out.println("--------------weight error--------------");
        } else {
            this.weight = weight;
        }

        // BloodGroup Validation
        if (bloodGroup == null || bloodGroup.isEmpty()) {
            this.bloodGroup = "Unknown";
        } else {
            this.bloodGroup = bloodGroup;
        }

        // PhoneNumber Validation
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            this.phoneNumber = "Unknown";
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    // Getters
    public int id() { return id; }
    public String name() { return name; }
    public int birthYear() { return birthYear; }
    public double height() { return height; }
    public double weight() { return weight; }

    // New Getters
    public String getBloodGroup() { return bloodGroup; }
    public String getPhoneNumber() { return phoneNumber; }

    public int getAge(int currentYear) {
        return currentYear - this.birthYear;
    }

    // BMI Method
    public double getBMI() {
        if (this.height <= 0 || this.weight <= 0) {
            return 0.0;
        }
        // Convert height from cm to meters
        double heightInMeters = this.height / 100.0;
        return this.weight / (heightInMeters * heightInMeters);
    }

    public void displayDetails(int currentYear) {
        System.out.println("Patient Name: " + name);
        if (getAge(currentYear) > 0) System.out.println("Patient Age: " + getAge(currentYear));
        if (height > 0) System.out.println("Patient Height (cm): " + height);
        if (weight > 0) System.out.println("Patient Weight (kg): " + weight);

        // Display new fields if they are known
        if (!bloodGroup.equals("Unknown")) System.out.println("Patient Blood Group: " + bloodGroup);
        if (!phoneNumber.equals("Unknown")) System.out.println("Patient Phone Number: " + phoneNumber);

        // Display BMI
        double bmi = getBMI();
        if (bmi > 0) {
            System.out.printf("Patient BMI: %.2f%n", bmi);
        }

        System.out.println("*************************************************************************************************************");
    }

    // Your Main Method for Testing
    public static void main(String[] args) {
        int currentYear = 2024;

        // Test Case 1: Valid Data (using 5-arg constructor)
        Patient patient = new Patient(1001, "John Doe", 1978, 175.5, 78.0);
        patient.displayDetails(currentYear);

        // Test Case 2: Invalid Data (using 5-arg constructor)
        Patient invalidPatient = new Patient(1002, "Joe Dohn", 1990, -160.0, -65.0);
        invalidPatient.displayDetails(currentYear);

        // Optional Test Case 3: Using the new 7-arg constructor
        // Patient newPatient = new Patient(1003, "Jane Smith", 1995, 165.0, 55.0, "O+", "081-234-5678");
        // newPatient.displayDetails(currentYear);
    }
}