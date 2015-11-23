package CsvHandler;

import java.io.*;

import static CsvHandler.Constants.csvSplit;


public class CsvReader {

    /**
     * Function to read a CSV file
     * @param fileName
     * @param fileType
     * @throws IOException
     */
    public void readFile(String fileName, CsvParsingService fileType) throws IOException {
        BufferedReader br = null;
        String line;
       File file = new File(fileName);

        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            try {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSplit);
                    fileType.parseCsv(data);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}