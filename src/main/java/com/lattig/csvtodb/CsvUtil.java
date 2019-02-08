package com.lattig.csvtodb;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.lattig.csvtodb.CsvToDb.logger;

public class CsvUtil {


    private String csvFile;
    private String newCsvPath;
    private boolean isEmpty;
    private String[] missingDataEntry;
    private List<String[]> badEntries = new ArrayList<>();
    private List<String[]> goodEntries = new ArrayList<>();

    public CsvUtil() {

    }


    /**
     * Takes in .csv file and separates each row into a String array and adds that array into a list of String Arrays
     */
    public void readCsv() {
        long entryCount = 0;
        List<String[]> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(csvFile);
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .build();

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                list.add(line);
                entryCount = entryCount + 1;
            }
            logger.log(Level.INFO, "Records Received: " + entryCount);
            reader.close();
            csvReader.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        filterFileEntries(list);

    }

    /**
     * filters a list of String arrays, based on if the String array has any empty elements, to be processed into a new
     * list of bad entries or a list of good entries
     *
     * @param list of String arrays
     */
    private void filterFileEntries(List<String[]> list) {
        long badCounter = 0;
        long goodCounter = 0;
        for (String[] readLine : list) {
            if (nullCheck(readLine)) {
                missingDataEntry = readLine.clone();
                createBadEntries(missingDataEntry);
                badCounter = badCounter + 1;
            } else {
                String[] transferData = readLine.clone();
                createGoodEntries(transferData);
                goodCounter = goodCounter + 1;
            }
        }
        logger.log(Level.INFO, "Records Failed: " + badCounter);
        logger.log(Level.INFO, "Records Successful: " + goodCounter);
    }

    /**
     * checks String array for empty or null elements
     *
     * @param readEntry String array to be checked
     * @return whether the check passed or failed
     */
    private boolean nullCheck(String[] readEntry) {
        for (String s : readEntry) {
            if (s == null || s.isEmpty()) {
                isEmpty = true;
                break;
            } else {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    /**
     * takes in a String array and adds it to a list of bad String arrays, then writes that list to a .csv file
     *
     * @param missingData String array containing missing elements
     */
    private void createBadEntries(String[] missingData) {
        badEntries.add(missingData);
        writeCSV(badEntries);
    }

    /**
     * takes in a String array and adds it to a list of good String arrays
     *
     * @param goodData
     */
    private void createGoodEntries(String[] goodData) {
        getGoodEntries().add(goodData);

    }

    /**
     * writes list of String arrays containing bad data into a new .csv file
     * @param stringArray list of String arrays containing bad data entries
     */
    public void writeCSV(List<String[]> stringArray) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hhmmssddmmyyyy");
        String fileName = "\\bad-data-" + LocalDateTime.now().format(dateTimeFormatter) + ".csv";
        File file = new File(newCsvPath + fileName);
        try {
            FileWriter outputFile = new FileWriter(file);
            ICSVWriter writer = new CSVWriterBuilder(outputFile).build();
            String[] header = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            writer.writeNext(header);
            for (String[] array : stringArray) {
                writer.writeNext(array);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * fetches list of String arrays containing valid data entries
     * @return
     */
    public List<String[]> getGoodEntries() {
        return goodEntries;
    }

    public String getCsvFile() {
        return csvFile;
    }

    /**
     * sets the file path to fetch the desired .csv file
     * @param csvFile String containing desired filepath
     */
    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
        System.out.println(this.csvFile);
    }

    public String getnewCsvPath() {
        return newCsvPath;
    }

    /**
     * sets the file path to drop new bad .csv file
     * @param newCsvPath String containing desired filepath
     */
    public void setnewCsvPath(String newCsvPath) {
        this.newCsvPath = newCsvPath;
        System.out.println(this.newCsvPath);
    }
}
