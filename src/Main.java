import java.time.LocalDateTime;
import java.time.Duration;
import java.util.Scanner;

// Huvudklass för parkeringssystemet
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Parkeringssystem ===");

        String omrade = chooseParkingSpot();
        Fordon.VehicleTYPE type = chooseVehicle();

        System.out.print("Ange registreringsnummer: ");
        String regNumber = scanner.nextLine().trim();

        if (regNumber.isEmpty()) {
            System.out.println("Registreringsnummer får inte vara tomt.");
            return;
        }

        Fordon fordon = new Fordon(type, regNumber);

        LocalDateTime startTime = chooseTime("Ange starttid");
        LocalDateTime endTime = chooseTime("Ange sluttid");

        if (!endTime.isAfter(startTime)) {
            System.out.println("Sluttiden måste vara efter starttiden.");
            return;
        }

        Bokning bokning = new Bokning(
                fordon, startTime, endTime, omrade
        );

        bokning.visaBokning();
    }

    // Välj parkeringsområde
    public static String chooseParkingSpot() {
        System.out.println("\nVälj parkeringsområde:");
        System.out.println("1. Centrum");
        System.out.println("2. Universitetet");
        System.out.println("3. Flygplatsen");

        int val = readChoice(1, 3);

        switch (val) {
            case 1:
                return "Centrum";
            case 2:
                return "Universitetet";
            default:
                return "Flygplatsen";
        }
    }

    // Välj fordon
    public static Fordon.VehicleTYPE chooseVehicle() {
        System.out.println("\nVälj fordon:");
        System.out.println("1. Bil (25 kr/timme)");
        System.out.println("2. Motorcykel (15 kr/timme)");
        System.out.println("3. Lastbil (40 kr/timme)");

        int val = readChoice(1, 3);

        switch (val) {
            case 1:
                return Fordon.VehicleTYPE.BIL;
            case 2:
                return Fordon.VehicleTYPE.MOTORCYKEL;
            default:
                return Fordon.VehicleTYPE.LASTBIL;
        }
    }

    // Välj datum och tid
    public static LocalDateTime chooseTime(String message) {
        while (true) {
            try {
                System.out.println(message);
                System.out.print("År (t.ex. 2026): ");
                int year = Integer.parseInt(scanner.nextLine());

                System.out.print("Månad (1-12): ");
                int month = Integer.parseInt(scanner.nextLine());

                System.out.print("Dag (1-31): ");
                int day = Integer.parseInt(scanner.nextLine());

                System.out.print("Timme (0-23): ");
                int hour = Integer.parseInt(scanner.nextLine());

                System.out.print("Minut (0-59): ");
                int minute = Integer.parseInt(scanner.nextLine());

                return LocalDateTime.of(
                        year, month, day, hour, minute
                );
            } catch (Exception e) {
                System.out.println(
                        "Ogiltigt datum eller tid. Försök igen."
                );
            }
        }
    }

    // Kontrollerar att användaren väljer ett giltigt alternativ
    private static int readChoice(int min, int max) {
        while (true) {
            System.out.print("Ditt val: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice >= min && choice <= max) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
                // Användaren måste ange ett nummer
            }

            System.out.println(
                    "Välj ett nummer mellan " + min + " och " + max + "."
            );
        }
    }
}
