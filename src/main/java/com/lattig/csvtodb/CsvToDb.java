package com.lattig.csvtodb;

import java.io.IOException;
import java.util.logging.*;


public class CsvToDb {


    final static Logger logger = Logger.getLogger(CsvToDb.class.getName());
    private static Handler handler;

    public static void main(String[] args) {

        try {
            handler = new FileHandler("%h/csvtodb_%g.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
        logger.setLevel(Level.INFO);
        logger.log(Level.INFO, "Begin Log");
        MainMenuView menuUI = new MainMenuView();
    }
}
