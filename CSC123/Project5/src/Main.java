public class Main {
    public static void main(String[] args) {
        System.out.println("===== Testing Person Class =====");
        testPersonClass();
        
        System.out.println("\n===== Testing Customer Class =====");
        testCustomerClass();
    }
    
    private static void testPersonClass() {
        try {
            System.out.println("Creating person with valid data:");
            Person person = new Person("John Doe", "123 Main Street", "1234567890");
            System.out.println("Person created successfully");
            
            System.out.println("\nTesting getter methods:");
            System.out.println("Name: " + person.getName());
            System.out.println("Address: " + person.getAddress());
            System.out.println("Telephone: " + person.getTelephoneNumber());
            
            System.out.println("\nTesting toString method:");
            System.out.println(person);
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        
        try {
            System.out.println("\nTesting invalid name (with numbers):");
            Person person = new Person("John123", "123 Main Street", "1234567890");
            System.out.println("Error: Exception wasn't thrown");
        } catch (NameException e) {
            System.out.println("NameException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception type: " + e.getMessage());
        }
        
        try {
            System.out.println("\nTesting invalid address format:");
            Person person = new Person("John Doe", "Main Street", "1234567890");
            System.out.println("Error: Exception wasn't thrown");
        } catch (AddressException e) {
            System.out.println("AddressException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception type: " + e.getMessage());
        }
        
        try {
            System.out.println("\nTesting invalid telephone (too short):");
            Person person = new Person("John Doe", "123 Main Street", "12345");
            System.out.println("Error: Exception wasn't thrown");
        } catch (TelephoneNumberException e) {
            System.out.println("TelephoneNumberException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception type: " + e.getMessage());
        }
        
        try {
            Person person = new Person("John Doe", "123 Main Street", "1234567890");
            
            System.out.println("\nChanging name to valid value:");
            person.setName("Jane Smith");
            System.out.println("New name: " + person.getName());
            
            System.out.println("\nChanging name to invalid value:");
            person.setName("Jane123");
            System.out.println("Error: Exception wasn't thrown");
        } catch (NameException e) {
            System.out.println("NameException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        
        try {
            Person person = new Person("John Doe", "123 Main Street", "1234567890");
            
            System.out.println("\nChanging address to valid value:");
            person.setAddress("456 Oak Avenue");
            System.out.println("New address: " + person.getAddress());
            
            System.out.println("\nChanging address to invalid value:");
            person.setAddress("Invalid Address");
            System.out.println("Error: Exception wasn't thrown");
        } catch (AddressException e) {
            System.out.println("AddressException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        
        try {
            Person person = new Person("John Doe", "123 Main Street", "1234567890");
            
            System.out.println("\nChanging telephone to valid value:");
            person.setTelephoneNumber("9876543210");
            System.out.println("New telephone: " + person.getTelephoneNumber());
            
            System.out.println("\nChanging telephone to invalid value:");
            person.setTelephoneNumber("123abc4567");
            System.out.println("Error: Exception wasn't thrown");
        } catch (TelephoneNumberException e) {
            System.out.println("TelephoneNumberException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }
    
    private static void testCustomerClass() {
        try {
            System.out.println("Creating customer with valid data:");
            Customer customer = new Customer("John Doe", "123 Main Street", "1234567890", "CUS001", true);
            System.out.println("Customer created successfully");
            
            System.out.println("\nTesting getter methods:");
            System.out.println("Name: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Telephone: " + customer.getTelephoneNumber());
            System.out.println("ID Number: " + customer.getIdNumber());
            System.out.println("On Mailing List: " + customer.isOnMailingList());
            
            System.out.println("\nTesting setter methods:");
            customer.setIdNumber("CUS002");
            System.out.println("Updated ID Number: " + customer.getIdNumber());
            
            customer.setOnMailingList(false);
            System.out.println("Updated Mailing List Status: " + customer.isOnMailingList());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        try {
            System.out.println("\nTesting customer with invalid name:");
            Customer customer = new Customer("John123", "123 Main Street", "1234567890", "CUS001", true);
            System.out.println("Error: Exception wasn't thrown");
        } catch (NameException e) {
            System.out.println("NameException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }
}

class Customer extends Person {
    private String idNumber;
    private boolean onMailingList;
    
    public Customer(String name, String address, String telephone, String idNumber, boolean onMailingList) throws NameException, AddressException, TelephoneNumberException {
        super(name, address, telephone);
        this.idNumber = idNumber;
        this.onMailingList = onMailingList;
    }
    
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    public String getIdNumber() {
        return idNumber;
    }
    
    public void setOnMailingList(boolean onMailingList) {
        this.onMailingList = onMailingList;
    }
    
    public boolean isOnMailingList() {
        return onMailingList;
    }
}

class NameException extends Exception {
    public NameException(String message) {
        super(message);
    }
}

class AddressException extends Exception {
    public AddressException(String message) {
        super(message);
    }
}

class TelephoneNumberException extends Exception {
    public TelephoneNumberException(String message) {
        super(message);
    }
}

class Person {
    private String name;
    private String address;
    private String telephoneNumber;

    public Person(String name, String address, String telephoneNumber)
            throws NameException, AddressException, TelephoneNumberException {
        setName(name);
        setAddress(address);
        setTelephoneNumber(telephoneNumber);
    }

    public void setName(String name) throws NameException {
        if (name == null || !name.matches("[a-zA-Z ]+")) {
            throw new NameException("Name must contain only letters and spaces");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) throws AddressException {
        if (address == null) {
            throw new AddressException("Address cannot be null");
        }

        if (!address.matches("^[0-9]+\\s[a-zA-Z ]+$")) {
            throw new AddressException("Address must consist of numbers followed by a space followed by letters and spaces");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setTelephoneNumber(String telephoneNumber) throws TelephoneNumberException {
        if (telephoneNumber == null) {
            throw new TelephoneNumberException("Telephone number cannot be null");
        }

        if (!telephoneNumber.matches("^[0-9]{10}$")) {
            throw new TelephoneNumberException("Telephone number must consist of exactly 10 digits");
        }
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}