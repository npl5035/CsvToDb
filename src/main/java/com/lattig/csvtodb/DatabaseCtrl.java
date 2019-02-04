package com.lattig.csvtodb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DatabaseCtrl {


    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public DatabaseCtrl() {
    }

    public void createData(List<String[]> goodEntries) {

        try {
            //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            try {
                Session session = sessionFactory.openSession();
                try {
                    Transaction transaction = session.beginTransaction();

                    //remember to switch db back to in-memory

                    for (String[] goodData : goodEntries) {
                        DataModel data = new DataModel(goodData[0], goodData[1], goodData[2], goodData[3], goodData[4], goodData[5],
                                goodData[6], goodData[7], goodData[8], goodData[9]);
                        session.save(data);
                    }
                    transaction.commit();
                } finally {
                    //session.close();
                }
            } finally {
                //sessionFactory.close();
            }
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            System.out.println("test data inserted");
        }

    }

    public void viewData() {
        List<DataModel> dbEntries = new ArrayList();
        DatabaseView dbView = new DatabaseView();
        try {
            //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            try {
                Session session = sessionFactory.openSession();

                //Transaction transaction = session.beginTransaction();


                dbEntries = (List<DataModel>) session.createSQLQuery("SELECT * FROM data_model").addEntity(DataModel.class).list();


                DataModel test[] = new DataModel[dbEntries.size()];
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

                //System.out.println(test[i].getA() + " : " +
                //        test[i].getB()+ " : " +
                //        test[i].getC()+ " : " +
                //        test[i].getD()+ " : " +
                //        test[i].getE()+ " : " +
                //        test[i].getF()+ " : " +
                //        test[i].getG()+ " : " +
                //        test[i].getH()+ " : " +
                //        test[i].getI()+ " : " +
                //        test[i].getJ());


                //} finally {
                //session.close();
                //}
            } finally {
                //sessionFactory.close();
            }
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        //return dbEntries;


    }
}
