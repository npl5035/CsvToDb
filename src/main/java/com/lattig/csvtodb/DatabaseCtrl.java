package com.lattig.csvtodb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DatabaseCtrl {


    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public DatabaseCtrl() {
    }

    /**
     * takes in a list of String arrays and parses them into the created database
     *
     * @param goodEntries list of String arrays containing valid data entries
     */
    public void createData(List<String[]> goodEntries) {

        try {
            Session session = sessionFactory.openSession();
            try {
                Transaction transaction = session.beginTransaction();
                for (String[] goodData : goodEntries) {
                    DataModel data = new DataModel(goodData[0], goodData[1], goodData[2], goodData[3], goodData[4], goodData[5],
                            goodData[6], goodData[7], goodData[8], goodData[9]);
                    session.save(data);
                }
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * Queries the database for all entries and feeds them to the DataBaseView
     */
    public void viewData() {
        List<DataModel> dbEntries;
        DatabaseView dbView = new DatabaseView();
        try {
            Session session = sessionFactory.openSession();
            dbEntries = (List<DataModel>) session.createSQLQuery("SELECT * FROM data_model").addEntity(DataModel.class).list();
            DataModel[] test = new DataModel[dbEntries.size()];
            test = dbEntries.toArray(test);
            for (int i = 0; i < test.length; i++) {
                dbView.getModel().addRow(new Object[]{test[i].getA(),
                        test[i].getB(),
                        test[i].getC(),
                        test[i].getD(),
                        test[i].getE(),
                        test[i].getF(),
                        test[i].getG(),
                        test[i].getH(),
                        test[i].getI(),
                        test[i].getJ()});
            }
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
    }
}
