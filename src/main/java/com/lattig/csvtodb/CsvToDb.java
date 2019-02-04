package com.lattig.csvtodb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

        //MainMenuView1 uiTest= new MainMenuView1();

        //CsvUtil csvUtil = new CsvUtil();
        //MainMenuCtrl menuCtrl = new MainMenuCtrl(csvUtil, this.);
        MainMenuView menuUI = new MainMenuView();

        //CsvUtil csvUtil = new CsvUtil();
        //csvUtil.readCsv();
        //createData(csvUtil.getGoodEntries());
        //connect();
    }

    //public static void createData(List<String[]> goodEntries) {
    //   SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    //   Session session = sessionFactory.openSession();
    //   Transaction transaction = session.beginTransaction();

    //   //remember to switch db back to in-memory

    //   for (String[] goodData : goodEntries) {
    //       DataModel data = new DataModel(goodData[0], goodData[1], goodData[2], goodData[3], goodData[4], goodData[5],
    //               goodData[6], goodData[7], goodData[8], goodData[9]);
    //       session.save(data);
    //   }
    //   transaction.commit();
    //   System.out.println("test data inserted");
    //   session.close();
    //   sessionFactory.close();
    //}

    public static void connect() {

        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite::memory:";
            con = DriverManager.getConnection(url);
            System.out.println("Connection to sqlite has been established!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
