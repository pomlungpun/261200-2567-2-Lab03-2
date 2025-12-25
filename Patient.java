public class Patient {
    private int id;
    private String name;
    private int birthYear;
    private double height;
    private double weight;

    
    private String bloodGroup;
    private String phoneNumber;


    public Patient() {
        this(1, "Unknown", 1, 1.0, 1.0, "Unknown", "Unknown");
    }

    public Patient(int id, String name, int birthYear, double height, double weight) {
        this(id, name, birthYear, height, weight, "Unknown", "Unknown");
    }


    public Patient(int id, String name, int birthYear, double height, double weight, String bloodGroup, String phoneNumber) {
        this.id = id;
        this.name = name;


        if (birthYear <= 0) {
            this.birthYear = 2000;
            System.out.println("--------------birthYear error--------------");
        } else {
            this.birthYear = birthYear;
        }


        if (height <= 0) {
            this.height = 150.0; 
            System.out.println("--------------height error--------------");
        } else {
            this.height = height;
        }


        if (weight <= 0) {
            this.weight = 50.0; 
            System.out.println("--------------weight error--------------");
        } else {
            this.weight = weight;
        }


        if (bloodGroup == null || bloodGroup.isEmpty()) {
            this.bloodGroup = "Unknown";
        } else {
            this.bloodGroup = bloodGroup;
        }


        if (phoneNumber == null || phoneNumber.isEmpty()) {
            this.phoneNumber = "Unknown";
        } else {
            this.phoneNumber = phoneNumber;
        }
    }


    public int id() { return id; }
    public String name() { return name; }
    public int birthYear() { return birthYear; }
    public double height() { return height; }
    public double weight() { return weight; }

    public String getBloodGroup() { return bloodGroup; }
    public String getPhoneNumber() { return phoneNumber; }

    public int getAge(int currentYear) {
        return currentYear - this.birthYear;
    }


    public double getBMI() {
        if (this.height <= 0 || this.weight <= 0) {
            return 0.0;
        }
        
        double heightInMeters = this.height / 100.0;
        return this.weight / (heightInMeters * heightInMeters);
    }

    public void displayDetails(int currentYear) {
        System.out.println("Patient Name: " + name);
        if (getAge(currentYear) > 0) System.out.println("Patient Age: " + getAge(currentYear));
        if (height > 0) System.out.println("Patient Height (cm): " + height);
        if (weight > 0) System.out.println("Patient Weight (kg): " + weight);


        if (!bloodGroup.equals("Unknown")) System.out.println("Patient Blood Group: " + bloodGroup);
        if (!phoneNumber.equals("Unknown")) System.out.println("Patient Phone Number: " + phoneNumber);


        double bmi = getBMI();
        if (bmi > 0) {
            System.out.printf("Patient BMI: %.2f%n", bmi);
        }

        System.out.println("*************************************************************************************************************");
    }


    public static void main(String[] args) {
        int currentYear = 2024;

        Patient patient = new Patient(1001, "John Doe", 1978, 175.5, 78.0);
        patient.displayDetails(currentYear);

        Patient invalidPatient = new Patient(1002, "Joe Dohn", 1990, -160.0, -65.0);
        invalidPatient.displayDetails(currentYear);

    }

}
