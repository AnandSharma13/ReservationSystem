package FlightDetails;

import CsvHandler.CsvParsingService;
import CsvHandler.CsvReader;

import java.io.IOException;
import java.util.ArrayList;

import static CsvHandler.Constants.INPUT_FILE1;
import static CsvHandler.Constants.INPUT_FILE2;

/**
 * Created by Anand on 10/31/2015.
 */
public class ReservationMachine {

    private ArrayList<AirlineTransactions> airlineTransactions;

    ReservationMachine(){

        airlineTransactions = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {

        ReservationMachine reservationMachine = new ReservationMachine();
        CsvParsingService flightHandler = new FlightHandler();
        reservationMachine.processInputFile(INPUT_FILE1, flightHandler);

        CsvParsingService transactionHandler = new TransactionHandler();
        reservationMachine.processInputFile(INPUT_FILE2, transactionHandler);

        return;
    }

    public  void processTransactions(TransactionHandler transactionHandler){
        airlineTransactions = transactionHandler.getTransactionsList();


        for (AirlineTransactions transaction : airlineTransactions){



        }
    }

    public void processInputFile(String inputFile, CsvParsingService transaction) {
        CsvReader csv = new CsvReader();
        try {
            csv.readFile(inputFile, transaction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
