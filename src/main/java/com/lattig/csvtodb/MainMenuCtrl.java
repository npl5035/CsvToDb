package com.lattig.csvtodb;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.util.logging.FileHandler;


public class MainMenuCtrl {

    CsvUtil csvUtil;
    private MainMenuView menuView;
    DatabaseCtrl db;

    public MainMenuCtrl(MainMenuView menuView) {
        this.menuView = menuView;
        CsvUtil csvUtil = new CsvUtil();
        this.csvUtil = csvUtil;
        db = new DatabaseCtrl();
        FileHandler handler;
    }

    public void testStatement() {
        System.out.println("CSV Button clicked");
    }

    public void selectCsvButtonActionPerformed() {//GEN-FIRST:event_selectCsvButtonActionPerformed
        String csvFile;
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        j.setAcceptAllFileFilterUsed(false);
        j.setDialogTitle("select .csv file");
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .csv files", "csv");
        j.addChoosableFileFilter(restrict);

        int r = j.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            csvFile = j.getSelectedFile().getAbsolutePath();
            menuView.getCsvFileLabel().setText(csvFile);
            csvUtil.setCsvFile(csvFile);
        } else {
            menuView.getCsvFileLabel().setText("operation cancelled");
        }
    }//GEN-LAST:event_selectCsvButtonActionPerformed

    public void selectOutputButtonActionPerformed() {//GEN-FIRST:event_selectOutputButtonActionPerformed
        String csvPath;
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int r = j.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            csvPath = j.getSelectedFile().getAbsolutePath();
            menuView.getOutputLabel().setText(csvPath);
            csvUtil.setnewCsvPath(csvPath);
        } else {
            menuView.getOutputLabel().setText("operation cancelled!");
        }
    }//GEN-LAST:event_selectOutputButtonActionPerformed

    public void loadButtonActionPerformed() {
        System.out.println("load button pressed");
        csvUtil.readCsv();
        db.createData(csvUtil.getGoodEntries());
    }

    public void closeButtonActionPerformed() {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

    public void databaseButtonActionPerformed() {
        //List<DataModel> data;
        db.viewData();
        //DataModel test[] = new DataModel[data.size()];
        //test = data.toArray(test);
        //for (int i = 0; i < test.length; i++){
//
        //    System.out.println(test[i].getA() + " : " +
        //    test[i].getB()+ " : " +
        //    test[i].getC()+ " : " +
        //    test[i].getD()+ " : " +
        //    test[i].getE()+ " : " +
        //    test[i].getF()+ " : " +
        //    test[i].getG()+ " : " +
        //    test[i].getH()+ " : " +
        //    test[i].getI()+ " : " +
        //    test[i].getJ());
//
        //    //System.out.print(
        //    //        test[i].toString()
        //    //
        //    //);
        //}


    }
}
