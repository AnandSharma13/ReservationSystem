package FlightDetails;

/**
 * Created by Anand on 11/1/2015.
 *
 * Class to maintain the details of passenger
 */
public class Passenger {

    private  String passengerName;
    private double bookingPrice;
    private String flightNumber;

    public Passenger(String passengerName, double bookingPrice, String flightNumber, int seatNumber) {
        this.passengerName = passengerName;
        this.bookingPrice = bookingPrice;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
    }


    public int getSeatNumber() {
        return seatNumber;
    }

    private int seatNumber;

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public double getBookingPrice() {
        return bookingPrice;
    }


}
