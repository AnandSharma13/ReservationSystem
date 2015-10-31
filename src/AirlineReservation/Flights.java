package AirlineReservation;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Anand on 10/31/2015.
 */

public class Flights {

    String flightNumber;
    int totalSeats;
    int price;
    String flightOrigin;
    String flightDestination;
    int availableSeats;

    public Flights(String flightNumber, int totalSeats, int price, String flightOrigin, String flightDestination) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.price = price;
        this.flightOrigin = flightOrigin;
        this.flightDestination = flightDestination;
        this.availableSeats = totalSeats;
    }





    /**
     * @param flightDetailsList
     */
    public void createFlights(ArrayList<ArrayList<String>> flightDetailsList) {
        String flightNumber;
        int totalSeats;
        int price;
        String flightOrigin;
        String flightDestination;
        int availableSeats;

        for (ArrayList<String> flightDetails : flightDetailsList) {
            this.flightNumber = flightDetails.get(0);
            this.totalSeats = Integer.parseInt(flightDetails.get(1));
            this.price = Integer.parseInt(flightDetails.get(2));
            this.flightOrigin = flightDetails.get(3);
            this.flightDestination = flightDetails.get(4);


        }


    }


}
