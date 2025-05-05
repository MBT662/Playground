public class Month {
    private int monthNumber;
    String monthName;

    public Month(int monthNumber) {
        setMonthNumber(monthNumber);
        try {
            setMonthName(monthNumber);
        } catch (InvalidMonthNumber e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Month(String monthName) {
        try {
            setMonthName(monthName);
        } catch (InvalidMonthName e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setMonthNumber(int monthNumber) {
        try {
            if (monthNumber < 1 || monthNumber > 12) {
                throw new InvalidMonthNumber(monthNumber);
            }
            this.monthNumber = monthNumber;
        } catch (InvalidMonthNumber e) {
            System.out.println(e.getMessage());
        }
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    // Converts from Number to Name
    public void setMonthName(int monthNumber) throws InvalidMonthNumber {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new InvalidMonthNumber(monthNumber);
        }
        this.monthNumber = monthNumber;
        // Convert month number to month name
        switch (monthNumber) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                throw new InvalidMonthNumber(monthNumber);
        }
    }

    public void setMonthName(String monthName) throws InvalidMonthName {
        switch (monthName) {
            case "January":
                monthNumber = 1;
                break;
            case "February":
                monthNumber = 2;
                break;
            case "March":
                monthNumber = 3;
                break;
            case "April":
                monthNumber = 4;
                break;
            case "May":
                monthNumber = 5;
                break;
            case "June":
                monthNumber = 6;
                break;
            case "July":
                monthNumber = 7;
                break;
            case "August":
                monthNumber = 8;
                break;
            case "September":
                monthNumber = 9;
                break;
            case "October":
                monthNumber = 10;
                break;
            case "November":
                monthNumber = 11;
                break;
            case "December":
                monthNumber = 12;
                break;
            default:
                throw new InvalidMonthName(monthName);
        }

    }

    public String getMonthName() {
        return monthName;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        Month m = new Month(9);
        System.out.println("Month name: " + m.getMonthName() + " Month number: " + m.getMonthNumber());

        Month m2 = new Month("January");
        System.out.println("Month name: " + m2.getMonthName() + " Month number: " + m2.getMonthNumber());

        Month m3 = new Month(13); // Invalid month number
        System.out.println("Month name: " + m3.getMonthName() + " Month number: " + m3.getMonthNumber());
        Month m4 = new Month("InvalidMonth"); // Invalid month name
        System.out.println("Month name: " + m4.getMonthName() + " Month number: " + m4.getMonthNumber());

    }
}

class InvalidMonthNumber extends Exception {
    public InvalidMonthNumber(int monthNumber) {
        super("InvalidMonthNumber: " + monthNumber);
    }
}

class InvalidMonthName extends Exception {
    public InvalidMonthName(String monthName) {
        super("Invalid Month Name: " + monthName);
    }
}