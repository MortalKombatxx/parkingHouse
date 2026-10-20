# ParkingHouse

A console program for booking a parking spot. Open the folder in IntelliJ IDEA and run `Main`.

## How a booking works

1. Choose a parking area: Centrum, Universitetet, or Flygplatsen.
2. Choose a vehicle.
3. Enter a registration number.
4. Enter a start time and an end time. The end time has to be after the start time.
5. The program prints a booking confirmation with the total price.

Invalid menu choices and invalid dates are rejected, and the program asks again.

## Prices

The duration is rounded up to the next full hour.

| Vehicle | Rate |
| --- | --- |
| Car (Bil) | 25 kr/hour |
| Motorcycle (Motorcykel) | 15 kr/hour |
| Truck (Lastbil) | 40 kr/hour |

## Run it

The IntelliJ project uses OpenJDK 26. Any current JDK works, since the code only uses the standard library.

In IntelliJ IDEA, open this folder and run `src/Main.java`.

From the project folder:

```powershell
javac -d out src\Main.java src\Booking.java src\fordon.java
java -cp out Main
```
