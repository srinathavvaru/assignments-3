import java.util.Scanner;

class Organization implements Cloneable {
    private String organizationCode;
    private String organizationName;
    private String organizationAddress;

    // Constructor
    public Organization(String code, String name, String address) {
        this.organizationCode = code;
        this.organizationName = name;
        this.organizationAddress = address;
    }

    // Getters and Setters
    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    // Method to print object details
    public void printDetails() {
        System.out.println("Organization Code: " + organizationCode);
        System.out.println("Organization Name: " + organizationName);
        System.out.println("Organization Address: " + organizationAddress);
    }

    // Override clone method
    @Override
    public Organization clone() throws CloneNotSupportedException {
        return (Organization) super.clone();
    }
}

public class objectclone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting input for organization details
        System.out.println("Enter Organization Code:");
        String code = scanner.nextLine();

        System.out.println("Enter Organization Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Organization Address:");
        String address = scanner.nextLine();

        // Creating an object of Organization class
        Organization org1 = new Organization(code, name, address);

        // Printing original object details
        System.out.println("\nOriginal Object Details:");
        org1.printDetails();
        System.out.println();

        try {
            // Cloning the object
            Organization org2 = org1.clone();

            // Modifying cloned object
            System.out.println("\nEnter modified Organization Name for cloned object:");
            String modifiedName = scanner.nextLine();
            org2.setOrganizationName(modifiedName);

            System.out.println("Enter modified Organization Address for cloned object:");
            String modifiedAddress = scanner.nextLine();
            org2.setOrganizationAddress(modifiedAddress);

            // Printing cloned object details
            System.out.println("\nCloned Object Details:");
            org2.printDetails();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
