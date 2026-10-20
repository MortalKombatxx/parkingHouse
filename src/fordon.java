import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

// Klass för fordon
class Fordon {

    enum VehicleTYPE {
        BIL,
        MOTORCYKEL,
        LASTBIL
    }

    private VehicleTYPE vehicleType;
    private String regNumber;

    public Fordon(VehicleTYPE vehicleType, String regNumber) {
        this.vehicleType = vehicleType;
        this.regNumber = regNumber;
    }

    public VehicleTYPE getVehicleType() {
        return vehicleType;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
