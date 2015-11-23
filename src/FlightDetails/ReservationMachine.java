package FlightDetails;

import CsvHandler.CsvParsingService;
import CsvHandler.CsvReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static CsvHandler.Constants.*;

/**
 * Created by Anand on 10/31/2015.
 *
 * This class is the entry point of execution. It also contains the methods to process transactions.
 */
public class ReservationMachine {

    private ArrayList<AirlineTransactions> airlineTransactions;
    private HashMap<String, ArrayList<String>> invertedFlightMap;
    private HashMap<String, Flight> flightsMap;
    private ArrayList<Passenger> totalPassengers;

    public ReservationMachine() {
        airlineTransactions = new ArrayList<>();
        invertedFlightMap = new HashMap<>();
        flightsMap = new HashMap<>();
        totalPassengers = new ArrayList<>();

    }

    /**
     * Entry point of execution
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ReservationMachine reservationMachine = new ReservationMachine();
        CsvParsingService flightHandler = new FlightHandler();
        reservationMachine.processInputFile(INPUT_FILE1, flightHandler);
        CsvParsingService transactionHandler = new TransactionHandler();
        reservationMachine.processInputFile(INPUT_FILE2, transactionHandler);
        reservationMachine.processTransactions(transactionHandler, flightHandler);
        reservationMachine.writeToFile();

    }

    /**
     * Function to write flight details to a text file
     * @param
     * @throws IOException
     */
    public void writeToFile() {
        Set<String> keys = flightsMap.keySet();
        File file = new File("out/Output.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            for (String key : keys) {
                Flight flight = flightsMap.get(key);
                String flightNumber = flight.getFlightNumber();
                int availableSeats = flight.getAvailableSeats();
                int soldSeats = flight.getTotalSeats() - availableSeats;
                double totalRevenue = flight.getTotalRevenue();
                ArrayList<Passenger> totalPassengers = flight.getPassengersList();
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                String formatStr = "%-20s %-15s %-15s%n";
                try {
                    bw.write("Flight#" + "\t" + flightNumber + "\n");
                    bw.write("Number of available Seats" + "\t" + availableSeats + "\n");
                    bw.write("Sold Seats" + "\t" + soldSeats + "\n");
                    bw.write("TotalRevenue" + "\t$" + totalRevenue + "\n");
                    if (!totalPassengers.isEmpty()) {
                        bw.write(String.format(formatStr, "PassengerName", "Seat", "Price"));
                        for (Passenger p : totalPassengers) {
                            bw.write(String.format(formatStr, p.getPassengerName(), p.getSeatNumber(), p.getBookingPrice()));
                        }
                    }
                    bw.write("\n\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * This function process transactions of INPUT_FILE2
     * Implemented Run time polymorphism for modules reusability
     * @param transactionHandler
     * @param flightHandler
     */
    public void processTransactions(CsvParsingService transactionHandler, CsvParsingService flightHandler) {

        Method method;
        Object value;
        try {
            //Using Java reflection to get the complete list of transactions
            method = transactionHandler.getClass().getMethod("getTransactionsList", null);
            value = method.invoke(transactionHandler, null);
            airlineTransactions = (ArrayList<AirlineTransactions>) value;
            method = flightHandler.getClass().getMethod("getInvertedFlightMap", null);
            value = method.invoke(flightHandler, null);
            invertedFlightMap = (HashMap<String, ArrayList<String>>) value;

            method = flightHandler.getClass().getMethod("getFlightsMap", null);
            value = method.invoke(flightHandler, null);
            flightsMap = (HashMap<String, Flight>) value;

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        for (AirlineTransactions transaction : airlineTransactions) {
            String transactionType = transaction.getTransactionType();
            switch (transactionType) {
                case "BookPassenger": {
                    String passengerName = transaction.getPassengerName();
                    String flightOrigin = transaction.getFlightOrigin();
                    String flightDestination = transaction.getFlightDestination();
                    String key = flightOrigin + " " + flightDestination;
                    //Check if the flight is present or not
                    if (invertedFlightMap.get(key) != null) {
                        ArrayList<String> flightsList = invertedFlightMap.get(key);
                        Flight cheapestFlight = flightsMap.get(flightsList.get(0));
                        for (int i = 1; i < flightsList.size(); i++) {
                            Flight flight = flightsMap.get(flightsList.get(i));
                            if (flight.getPrice() < cheapestFlight.getPrice() && isSeatAvailable(flight))
                                cheapestFlight = flight;
                        }
                        if (isPresent(passengerName, cheapestFlight)) {
                            break;
                        }
                        int maxSeats = cheapestFlight.getTotalSeats();
                        int seatNumber = getSeatNumber(maxSeats);
                        Passenger passenger = new Passenger(passengerName, cheapestFlight.getPrice(), cheapestFlight.getFlightNumber(), seatNumber);
                        totalPassengers.add(passenger);
                        cheapestFlight.getPassengersList().add(passenger);
                        cheapestFlight.setAvailableSeats(cheapestFlight.getAvailableSeats() - ONE);
                        double flightPrice = cheapestFlight.getPrice();
                        double currentRevenue = cheapestFlight.getTotalRevenue();
                        cheapestFlight.setTotalRevenue(currentRevenue + flightPrice);
                    }
                    break;
                }
                case "ChangePrice": {
                    String flightNumber = transaction.getFlightNumber();
                    Flight flight = flightsMap.get(flightNumber);
                    if (flight != null) {
                        flight.setPrice(transaction.getNewPrice());
                    }
                    break;
                }
                case "CancelPassenger": {
                    String passengerName = transaction.getPassengerName();
                    String flightOrigin = transaction.getFlightOrigin();
                    String flightDestination = transaction.getFlightDestination();
                    String key = flightOrigin + " " + flightDestination;
                    if (passengerName.equals("KenHatch"))
                        System.out.println();
                    //Check if the flight is present or not
                    String flightNumber = "";
                    for (Passenger p : totalPassengers) {
                        if (p.getPassengerName().equals(passengerName))
                            flightNumber = p.getFlightNumber();
                    }

                    Flight flight = flightsMap.get(flightNumber);
                    if (flight != null) {
                        flight.setAvailableSeats(flight.getAvailableSeats() + ONE);
                        ArrayList<Passenger> passengersList = flight.getPassengersList();
                        double bookingPrice = ZERO;
                        Iterator<Passenger> iter = passengersList.iterator();
                        while (iter.hasNext()) {
                            Passenger p = iter.next();
                            if (p.getPassengerName().equals(passengerName)) {
                                bookingPrice = p.getBookingPrice();
                                iter.remove();
                            }
                        }
                        flight.setTotalRevenue(flight.getTotalRevenue() - bookingPrice);
                    }
                    break;
                }

            }
        }
    }

    /**
     * Checks the availability of seats in a flight
     * @param flight
     * @return
     */
    public boolean isSeatAvailable(Flight flight) {
        if (flight.getAvailableSeats() < ZERO)
            return true;
        return false;
    }

    /**
     * checks if the passenger is already present in flight
     * @param passengerName
     * @param flight
     * @return
     */
    public boolean isPresent(String passengerName, Flight flight) {
        ArrayList<Passenger> passengerList = flight.getPassengersList();
        for (Passenger p : passengerList) {
            if (passengerName.equals(p.getPassengerName()))
                return true;
        }
        return false;
    }

    /**
     * Randomly Assigns a seat to the passenger
     * @param upperBound
     * @return
     */
    public int getSeatNumber(int upperBound) {
        Random rand = new Random();
        int lowerBound = ZERO;
        int seatNumber = rand.nextInt(upperBound - lowerBound + ONE) + lowerBound;
        return seatNumber;
    }

    /**
     * This function initiates the processing of input files
     * @param inputFile
     * @param transaction
     */
    public void processInputFile(String inputFile, CsvParsingService transaction) {
        CsvReader csv = new CsvReader();
        try {
            csv.readFile(inputFile, transaction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
