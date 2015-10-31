package CsvHandler;

import java.io.*;

public class CsvReader {


    public void readFile(String path, CsvParsingService fileType) throws IOException {
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";


        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("InputFiles/inputfile1.txt").getFile());
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            try {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(cvsSplitBy);
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