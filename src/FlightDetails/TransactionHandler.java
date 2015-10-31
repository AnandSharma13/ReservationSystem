package FlightDetails;

import CsvHandler.CsvParsingService;

import java.util.ArrayList;

import static CsvHandler.Constants.FLIGHT_MODIFICATION_ROW_LENGTH;
import static CsvHandler.Constants.PASSENGER_TRANSACTION_ROW_LENGTH;

/**
 * Created by Anand on 10/31/2015.
 */
public class TransactionHandler implements CsvParsingService {


    private ArrayList<AirlineTransactions> transactionsList;

    public TransactionHandler() {
        transactionsList = new ArrayList<>();
    }

    @Override
    public void parseCsv(String[] csvLine) {
        if (csvLine.length == PASSENGER_TRANSACTION_ROW_LENGTH) {
            String transactionType = csvLine[0];
            String passengerName = csvLine[1];
            String flightOrigin = csvLine[2];
            String flightDestination = csvLine[3];
            AirlineTransactions airlineTransactions = new AirlineTransactions(transactionType, passengerName, flightOrigin, flightDestination);
            this.transactionsList.add(airlineTransactions);
        } else if (csvLine.length == FLIGHT_MODIFICATION_ROW_LENGTH) {
            String transactionType = csvLine[0];
            String flightNumber = csvLine[1];
            int price = Integer.parseInt(csvLine[2]);
            AirlineTransactions airlineTransactions = new AirlineTransactions(transactionType, flightNumber, price);
            this.transactionsList.add(airlineTransactions);
        }
    }

    public ArrayList<AirlineTransactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(ArrayList<AirlineTransactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

}
