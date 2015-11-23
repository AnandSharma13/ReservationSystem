package FlightDetails;

/**
 * Created by Anand on 10/31/2015.
 *
 * Class store the transactions of the system
 */
public class AirlineTransactions {


    private String transactionType;
    private String passengerName;
    private String flightOrigin;
    private String flightDestination;
    private String flightNumber;
    private int newPrice;


    /**
     * Constructs an object to modify the price of a flight
     * @param transactionType
     * @param flightNumber
     * @param newPrice
     */
    public AirlineTransactions(String transactionType, String flightNumber, int newPrice){
        this.transactionType = transactionType;
        this.flightNumber =flightNumber;
        this.newPrice = newPrice;
    }

    /**
     * Constructs an object of a user transactions (BookPassenger, CancelPassenger)
     * @param transactionType
     * @param passengerName
     * @param flightOrigin
     * @param flightDestination
     */
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

    public String getFlightDestination() {
        return flightDestination;
    }

    public String getTransactionType() {
        return transactionType;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public int getNewPrice() {
        return newPrice;
    }

}
