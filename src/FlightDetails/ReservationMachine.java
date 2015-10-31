package FlightDetails;

import CsvHandler.CsvParsingService;
import CsvHandler.CsvReader;
import FlightDetails.FlightHandler;

import java.io.IOException;

/**
 * Created by Anand on 10/31/2015.
 */
public class ReservationMachine {





    public static void main(String[] args) throws IOException {
        CsvReader csv = new CsvReader();

        CsvParsingService flightHandler = new FlightHandler();
        csv.readFile("sds",flightHandler);


    }


}
