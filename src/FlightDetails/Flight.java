package FlightDetails;

/**
 * Created by Anand on 10/31/2015.
 */

public class Flight  {


    private String flightNumber;
    private int totalSeats;
    private int price;
    private String flightOrigin;
    private String flightDestination;
    private int availableSeats;

    public Flight(){}
    public Flight(String flightNumber, int totalSeats, int price, String flightOrigin, String flightDestination) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.price = price;
        this.flightOrigin = flightOrigin;
        this.flightDestination = flightDestination;
        this.availableSeats = totalSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getFlightOrigin() {
        return flightOrigin;
    }

    public void setFlightOrigin(String flightOrigin) {
        this.flightOrigin = flightOrigin;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
