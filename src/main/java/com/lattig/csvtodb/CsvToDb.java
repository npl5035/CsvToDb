package com.lattig.csvtodb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class CsvToDb {


    public static void main(String[] args) {

        CsvUtil csvUtil = new CsvUtil();
        csvUtil.readCsv();
        createData(csvUtil.getGoodEntries());
        //connect();
    }

    public static void createData(List<String[]> goodEntries) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //remember to switch db back to in-memory

        for (String[] goodData : goodEntries) {
            DataModel data = new DataModel(goodData[0], goodData[1], goodData[2], goodData[3], goodData[4], goodData[5],
                    goodData[6], goodData[7], goodData[8], goodData[9]);
            session.save(data);
        }
        transaction.commit();
        System.out.println("test data inserted");
        session.close();
        sessionFactory.close();
    }

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
