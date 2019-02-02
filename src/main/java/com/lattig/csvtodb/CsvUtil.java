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
import java.util.Arrays;
import java.util.List;

public class CsvUtil {

    private String csvFile;
    private String newCsvPath;
    private boolean isEmpty;
    private String[] missingDataEntry;
    private List<String[]> badEntries = new ArrayList<>();
    private List<String[]> goodEntries = new ArrayList<>();

    public CsvUtil() {
        //setCsvFile("D:/PSU files/Independent Projects/MS3 coding challenge/ms3TestData.csv");
    }

    public CsvUtil(String csvFile) {
        this.setCsvFile(csvFile);
    }


    public void readCsv() {

        List<String[]> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(csvFile);
            // CSVParser parser = new CSVParserBuilder()
            //         .withSeparator(',')
            //         .withIgnoreQuotations(true)
            //         .build();
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .build();

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                list.add(line);
            }
            reader.close();
            csvReader.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        filterFileEntries(list);

    }

    private void filterFileEntries(List<String[]> list) {

        for (String[] readLine : list) {

            if (nullCheck(readLine)) {
                missingDataEntry = readLine.clone();
                createBadEntries(missingDataEntry);

            } else {
                String[] transferData = readLine.clone();
                createGoodEntries(transferData);
            }
            System.out.println("************************");
        }

    }

    private boolean nullCheck(String[] readEntry) {

        for (String s : readEntry) {
            if (s == null || s.isEmpty()) {
                //System.out.println("Missing Data!!");
                isEmpty = true;
                break;
            } else {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    private void createBadEntries(String[] missingData) {
        System.out.println("New bad entry added");
        badEntries.add(missingData);
        System.out.println("Bad Entry: " + Arrays.toString(missingData));
        writeCSV(badEntries);
    }

    private void createGoodEntries(String[] goodData) {

        System.out.println("New good entry added");

        getGoodEntries().add(goodData);
        System.out.println("Good Entry: " + Arrays.toString(goodData));

    }

    public void writeCSV(List<String[]> stringArray) {
        //newCsvFile = "C:/Users/Nate/Documents/NetBeansProjects/CsvToDb/";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hhmmssddmmyyyy");
        String fileName = "\\bad-data-" + LocalDateTime.now().format(dateTimeFormatter) + ".csv";
        File file = new File(newCsvPath + fileName);
        try {
            FileWriter outputFile = new FileWriter(file);
            //CSVParser parser = new CSVParserBuilder()
            //        .withSeparator(',')
            //        .withIgnoreQuotations(false)
            //        .build();
            ICSVWriter writer = new CSVWriterBuilder(outputFile)
                    //    .withParser(parser)
                    .build();
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

    public List<String[]> getGoodEntries() {
        return goodEntries;
    }

    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
        System.out.println(this.csvFile);
    }

    public String getnewCsvPath() {
        return newCsvPath;
    }

    public void setnewCsvPath(String newCsvPath) {
        this.newCsvPath = newCsvPath;
        System.out.println(this.newCsvPath);
    }
}
