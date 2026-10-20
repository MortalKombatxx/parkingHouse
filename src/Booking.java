// Klass för bokning

import java.time.Duration;
import java.time.LocalDateTime;

class Bokning {

    private Fordon fordon;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String parkeringsOmrade;

    public Bokning(Fordon fordon, LocalDateTime startTime,
                   LocalDateTime endTime, String parkeringsOmrade) {
        this.fordon = fordon;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parkeringsOmrade = parkeringsOmrade;
    }

    public double calculateTotalPrice() {
        long minuter = Duration.between(startTime, endTime).toMinutes();
        double timmar = Math.ceil(minuter / 60.0);

        double prisPerTimme;

        switch (fordon.getVehicleType()) {
            case BIL:
                prisPerTimme = 25;
                break;
            case MOTORCYKEL:
                prisPerTimme = 15;
                break;
            case LASTBIL:
                prisPerTimme = 40;
                break;
            default:
                prisPerTimme = 25;
        }

        return timmar * prisPerTimme;
    }

    public void visaBokning() {
        System.out.println("\n--- Bokningsbekräftelse ---");
        System.out.println("Registreringsnummer: " + fordon.getRegNumber());
        System.out.println("Fordonstyp: " + fordon.getVehicleType());
        System.out.println("Parkeringsområde: " + parkeringsOmrade);
        System.out.println("Starttid: " + startTime);
        System.out.println("Sluttid: " + endTime);
        System.out.printf("Totalt pris: %.2f kr%n", calculateTotalPrice());
    }
}
