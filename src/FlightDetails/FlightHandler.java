package FlightDetails;

import CsvHandler.CsvParsingService;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Anand on 10/31/2015.
 *
 * This class implements the CsvParsingService and is used to store objects of the inputfile1.txt into HashMaps.
 */
public class FlightHandler implements CsvParsingService {

    //Inverted index to store the the number of flights from the same origin and destination
    //Key: concatinated string of Origin and destination
    //Value: flight number
    private HashMap<String, ArrayList<String>> invertedFlightMap;

    //HashMap maps every Flight number to it's Object
    //Key: Flight Number
    //Value: Corresponding Flight object
    private HashMap<String, Flight> flightsMap;


    public FlightHandler() {
        invertedFlightMap = new HashMap<>();
        flightsMap = new HashMap<>();
    }


    /**
     * Overridden method of the CsvParsingService interface. Contains the logic to parse the INPUT_FILE1
     * @param csvLine
     */
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

        String mapKey = flightOrigin+" "+flightDestination;
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

    public HashMap<String, ArrayList<String>> getInvertedFlightMap() {
        return invertedFlightMap;
    }

    public void setInvertedFlightMap(HashMap<String, ArrayList<String>> invertedFlightMap) {
        this.invertedFlightMap = invertedFlightMap;
    }

    public HashMap<String, Flight> getFlightsMap() {
        return flightsMap;
    }

    public void setFlightsMap(HashMap<String, Flight> flightsMap) {
        this.flightsMap = flightsMap;
    }
}
