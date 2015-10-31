package FlightDetails;

/**
 * Created by Anand on 10/31/2015.
 */
public class AirlineTransactions {


    private String transactionType;
    private String passengerName;
    private String flightOrigin;
    private String flightDestination;
    private String flightNumber;
    private int price;


    public AirlineTransactions(String transactionType, String flightNumber, int price){
        this.transactionType = transactionType;
        this.flightNumber =flightNumber;
        this.price = price;
    }

    public AirlineTransactions(String transactionType, String passengerName, String flightOrigin, String flightDestination){
        this.transactionType = transactionType;
        this.passengerName = passengerName;
        this.flightOrigin = flightOrigin;
        this.flightDestination = flightDestination;
    }



    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFlightOrigin() {
        return flightOrigin;
    }

    public void setFlightOrigin(String flightOrigin) {
        this.flightOrigin = flightOrigin;
    }

    public String getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
