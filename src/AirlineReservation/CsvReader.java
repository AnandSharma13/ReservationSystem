package AirlineReservation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CsvReader {


    public ArrayList<ArrayList<String>> readFile(String path) throws IOException {
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("InputFiles/inputfile1.txt").getFile());
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            try {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(cvsSplitBy);
                    ArrayList<String> list = new ArrayList<String>();
                    for (String e : data) {
                        list.add(e);
                    }
                    result.add(list);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}