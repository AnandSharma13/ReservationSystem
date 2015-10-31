package FlightDetails;

import CsvHandler.CsvParsingService;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Anand on 10/31/2015.
 */
public class FlightHandler implements CsvParsingService {


    HashMap<String, ArrayList<String>> invertedFlightMap = new HashMap<>();

    HashMap<String, Flight> flightsMap = new HashMap<>();


    @Override

    public void parseCsv(String[] csvLine) {
        ArrayList<String> flightNumberList;
        String flightNumber = csvLine[0];
        int totalSeats = Integer.parseInt(csvLine[1]);
        int price = Integer.parseInt(csvLine[2]);
        String flightOrigin = csvLine[3];
        String flightDestination = csvLine[4];
        Flight flight = new Flight(flightNumber, totalSeats, price, flightOrigin, flightDestination);

        flightsMap.put(flightNumber, flight);

        String mapKey = flightOrigin + " " + flightDestination;
        if (invertedFlightMap.containsKey(mapKey)) {
            flightNumberList = invertedFlightMap.get(mapKey);
            flightNumberList.add(flightNumber);
            invertedFlightMap.put(mapKey, flightNumberList);
        } else {
            flightNumberList = new ArrayList<>();
            flightNumberList.add(flightNumber);
            invertedFlightMap.put(mapKey, flightNumberList);
        }
    }
}
