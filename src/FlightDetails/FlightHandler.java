package FlightDetails;

import CsvHandler.CsvParsingService;

/**
 * Created by Anand on 10/31/2015.
 */
public class FlightHandler implements CsvParsingService {

    @Override
    public void parseCsv(String[] csvLine) {
        //create all objects here
        String flightNumber = csvLine[0];
        int totalSeats = Integer.parseInt(csvLine[1]);
        int price = Integer.parseInt(csvLine[2]);
        String flightOrigin = csvLine[3];
        String flightDestination = csvLine[4];
        Flight flight = new Flight(flightNumber, totalSeats,price,flightOrigin,flightDestination);
    }

}
