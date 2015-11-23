package FlightDetails;

import java.util.ArrayList;

/**
 * Created by Anand on 10/31/2015.
 */

public class Flight {


    private String flightNumber;
    private int totalSeats;
    private double price;
    private String flightOrigin;
    private String flightDestination;
    private int availableSeats;
    private ArrayList<Passenger> passengersList;
    private double totalRevenue;

    public Flight(){}
    public Flight(String flightNumber, int totalSeats, int price, String flightOrigin, String flightDestination) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.price = price;
        this.flightOrigin = flightOrigin;
        this.flightDestination = flightDestination;
        this.availableSeats = totalSeats;
        passengersList = new ArrayList<Passenger>();
        totalRevenue = 0;
    }

    public double getPrice() {
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
    public ArrayList<Passenger> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(ArrayList<Passenger> passengersList) {
        this.passengersList = passengersList;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
