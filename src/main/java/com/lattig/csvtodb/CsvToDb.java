package com.lattig.csvtodb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class CsvToDb {


    public static void main(String[] args) throws IOException {

        CsvUtil csvUtil = new CsvUtil();
        csvUtil.readCsv();
        //createData();
        //connect();

        //Douglas	Stone	dstone0@wix.com	Male	data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29mdHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAALrSURBVDjLbZJZSFRhGIYNRyK6iC7aLiK8qG4MifZuylxaVOymjZQKDYbEJE1nskITEpeCFAy98KIJl8LUyn0Hzd3EbVKcxlnOuMyZcUads4xzznn7Z4JJzQMv3+E/3/t87/n4fQD4rBdjqIlmNOV1zHSJYXk0n7MPZvK27lSrtSNhdKlLkbG53/vC6qoPsNovDTzVAJelF8LqL4icHhJvgGCfAj9bD2tLPBaqb2ot7YqADQBG/22nY0Y1sEZ3QXQaiHTEPAmRHYHg6CfqJWdqSGs0VgbegVIFWxfblfu8AIe6KIc31pIGE0R+hlQKkmAHJKdHkmAjsDG4lmsB0Qrz93hQn27XewHLw9mUyzZGemfIpFlILgsxLXmMHrlo8k1HAI1EFeBNg9AUnOW8gKUfz50iOwuB6YPADpP4ahJ7HMLKCDEMkB10w7XSDN78HpwpCaLDgKmc45IXYGlPNDoX+8n0CXDGF2RCFmxf78NWJ4etNhaWsghwVCYYzR2s0bngDIOYzjvxL4GlU5lt68sjcS3g9AqYiwPB6lOInoLRyklNxlzWDqxOhkGSNDB9ToS2OKLDC7D3ZMgW6+RTqxOlZIEa0B/Oesws9QiMIQasLgkL+XshMp1Y/lkJdcZRnqpKPLzhHtBtysD5ymh6dbwM9qqHfwFkstvM6p5gOuM0eu4eQuslGVqubrc0hfoqNwDcMjelnNSWP5ifKwkD1x4Oce4yRFMQ9PnnMJp8BlzdW0jqRjAVSRiMPyY0B8sSfDZfzY7y1+GFr2LXPhamoSj3PN6kn0LNtV1giRkFkYBiN5DlDzr3IppCfLX/Adx6qZAbVKVlUKkqUFRcQmL7QRquwvrHlr7f/TvSlgDF43s9La2tMJtpDA0Noz5qDxwlsQAx8ak+WCLSy31B9kBtCWgpz465cf0KExoaIgUFXZCyowJc/XFHxDmFP8zP/PA7bhvaImVCY6hv2paArdR966CSTJx1xybV6Da7z/8A2VoHSyUsj6sAAAAASUVORK5CYII=	switch	$0.02 	TRUE	FALSE	Cangzhou


    }

    public static void createData(List<String[]> goodEntries) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        DataModel data = new DataModel();
        data.setId(1);
        data.setA("Douglas");
        data.setB("Stone");
        data.setC("dstone0@wix.com");
        data.setD("Male");
        data.setE("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29mdHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAALrSURBVDjLbZJZSFRhGIYNRyK6iC7aLiK8qG4MifZuylxaVOymjZQKDYbEJE1nskITEpeCFAy98KIJl8LUyn0Hzd3EbVKcxlnOuMyZcUads4xzznn7Z4JJzQMv3+E/3/t87/n4fQD4rBdjqIlmNOV1zHSJYXk0n7MPZvK27lSrtSNhdKlLkbG53/vC6qoPsNovDTzVAJelF8LqL4icHhJvgGCfAj9bD2tLPBaqb2ot7YqADQBG/22nY0Y1sEZ3QXQaiHTEPAmRHYHg6CfqJWdqSGs0VgbegVIFWxfblfu8AIe6KIc31pIGE0R+hlQKkmAHJKdHkmAjsDG4lmsB0Qrz93hQn27XewHLw9mUyzZGemfIpFlILgsxLXmMHrlo8k1HAI1EFeBNg9AUnOW8gKUfz50iOwuB6YPADpP4ahJ7HMLKCDEMkB10w7XSDN78HpwpCaLDgKmc45IXYGlPNDoX+8n0CXDGF2RCFmxf78NWJ4etNhaWsghwVCYYzR2s0bngDIOYzjvxL4GlU5lt68sjcS3g9AqYiwPB6lOInoLRyklNxlzWDqxOhkGSNDB9ToS2OKLDC7D3ZMgW6+RTqxOlZIEa0B/Oesws9QiMIQasLgkL+XshMp1Y/lkJdcZRnqpKPLzhHtBtysD5ymh6dbwM9qqHfwFkstvM6p5gOuM0eu4eQuslGVqubrc0hfoqNwDcMjelnNSWP5ifKwkD1x4Oce4yRFMQ9PnnMJp8BlzdW0jqRjAVSRiMPyY0B8sSfDZfzY7y1+GFr2LXPhamoSj3PN6kn0LNtV1giRkFkYBiN5DlDzr3IppCfLX/Adx6qZAbVKVlUKkqUFRcQmL7QRquwvrHlr7f/TvSlgDF43s9La2tMJtpDA0Noz5qDxwlsQAx8ak+WCLSy31B9kBtCWgpz465cf0KExoaIgUFXZCyowJc/XFHxDmFP8zP/PA7bhvaImVCY6hv2paArdR966CSTJx1xybV6Da7z/8A2VoHSyUsj6sAAAAASUVORK5CYII=");
        data.setF("switch");
        data.setG("$0.02");
        data.setH(true);
        data.setI(false);
        data.setJ("Cangzhou");
        session.save(data);
        transaction.commit();
        System.out.println("test data inserted");

        Transaction transaction2 = session.beginTransaction();
        DataModel loadedData = session.get(DataModel.class, 1);
        System.out.println(loadedData.getA());
        System.out.println(loadedData.getB());
        System.out.println(loadedData.getC());
        System.out.println(loadedData.getD());
        System.out.println(loadedData.getE());
        System.out.println(loadedData.getF());
        System.out.println(loadedData.getG());
        System.out.println(loadedData.isH());
        System.out.println(loadedData.isI());
        System.out.println(loadedData.getJ());

        transaction2.commit();

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
