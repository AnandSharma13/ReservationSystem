package AirlineReservation;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Anand on 10/31/2015.
 */
public class ReservationMachine {



    public static void main(String[] args) throws IOException {
        CsvReader csv = new CsvReader();
        ArrayList<ArrayList<String>> result = csv.readFile("sds");
        System.out.println(result);
    }


}
