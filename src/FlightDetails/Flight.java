package FlightDetails;

/**
 * Created by Anand on 10/31/2015.
 */

public class Flight  {

    String flightNumber;
    int totalSeats;
    int price;
    String flightOrigin;
    String flightDestination;
    int availableSeats;

    public Flight(){}
    public Flight(String flightNumber, int totalSeats, int price, String flightOrigin, String flightDestination) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.price = price;
        this.flightOrigin = flightOrigin;
        this.flightDestination = flightDestination;
        this.availableSeats = totalSeats;
    }
}
