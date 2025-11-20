package utility;


import java.util.Random;

public class RandomDataUtil {

    private static final Random random = new Random();

    // ---------------------------------------------
    // 1. Random First Name
    // ---------------------------------------------
    public static String getRandomFirstName() {
        String[] firstNames = {
            "Raj", "Amit", "Sagar", "Kiran", "Vikram", "Rohit",
            "Neha", "Pooja", "Anita", "Sonal", "Shubham",
            "Prasad", "Komal", "Sneha", "Meena"
        };
        return firstNames[random.nextInt(firstNames.length)];
    }

    // ---------------------------------------------
    // 2. Random Last Name
    // ---------------------------------------------
    public static String getRandomLastName() {
        String[] lastNames = {
            "Patil", "Sharma", "Reddy", "Jadhav", "Pawar",
            "Yadav", "More", "Deshmukh", "Kulkarni", "Chavan",
            "Gaikwad", "Sawant", "Bhosale", "Mane"
        };
        return lastNames[random.nextInt(lastNames.length)];
    }

    // ---------------------------------------------
    // 3. Random Full Name (Title Case)
    // ---------------------------------------------
    public static String getRandomFullName() {
        return (getRandomFirstName() + " " + getRandomLastName()).trim();
    }

    // ---------------------------------------------
    // 4. Random Mobile Number (Starts with 6/7/8/9)
    // ---------------------------------------------
    public static String getRandomMobile() {
        int firstDigit = 6 + random.nextInt(4); // gives 6–9
        long rest = (long)(random.nextDouble() * 1000000000L);
        return firstDigit + String.format("%09d", rest);
    }

    // ---------------------------------------------
    // 5. Random Email
    // ---------------------------------------------
    public static String getRandomEmail() {
        return "user" + (1000 + random.nextInt(9000)) + "@test.com";
    }

    // ---------------------------------------------
    // 6. Random Password (Strong)
    // ---------------------------------------------
    public static String getRandomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                     + "abcdefghijklmnopqrstuvwxyz"
                     + "0123456789"
                     + "@#$%&*!";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    // ---------------------------------------------
    // 7. Random Alphanumeric
    // ---------------------------------------------
    public static String getRandomAlphaNumeric(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // ---------------------------------------------
    // 8. Random Address
    // ---------------------------------------------
    public static String getRandomAddress() {
        int houseNo = random.nextInt(200) + 1;
        String[] streets = {"MG Road", "Main Street", "Market Road", "Station Road", "Park Street"};
        return houseNo + ", " + streets[random.nextInt(streets.length)];
    }

    // ---------------------------------------------
    // 9. Random City
    // ---------------------------------------------
    public static String getRandomCity() {
        String[] cities = {"Mumbai", "Pune", "Nashik", "Nagpur", "Kolhapur", "Delhi", "Bangalore"};
        return cities[random.nextInt(cities.length)];
    }

    // ---------------------------------------------
    // 10. Random PIN Code (Indian)
    // ---------------------------------------------
    public static String getRandomPinCode() {
        return String.valueOf(100000 + random.nextInt(900000));
    }

    // ---------------------------------------------
    // 11. Random Account Number (12–18 digits)
    // ---------------------------------------------
    public static String getRandomAccountNumber() {
        int length = 12 + random.nextInt(7); // 12–18 digits
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    // ---------------------------------------------
    // 12. Random IFSC Code
    // ---------------------------------------------
    public static String getRandomIFSC() {
        String[] banks = {"HDFC", "ICIC", "SBIN", "MAHB", "PUNB"};
        return banks[random.nextInt(banks.length)] + "0" + getRandomAlphaNumeric(6);
    }

    // ---------------------------------------------
    // 13. Random OTP (4 digits)
    // ---------------------------------------------
    public static String getRandomOTP4() {
        return String.format("%04d", random.nextInt(10000));
    }

    // ---------------------------------------------
    // 14. Random OTP (6 digits)
    // ---------------------------------------------
    public static String getRandomOTP6() {
        return String.format("%06d", random.nextInt(1000000));
    }

    // ---------------------------------------------
    // 15. Random Date of Birth (18–45 age)
    // ---------------------------------------------
    public static String getRandomDOB() {
        int year = 1978 + random.nextInt(27); // Age 18–45
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }
}
