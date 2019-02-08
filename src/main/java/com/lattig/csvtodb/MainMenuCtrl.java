package com.lattig.csvtodb;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class MainMenuCtrl {

    private CsvUtil csvUtil;
    private MainMenuView menuView;
    private DatabaseCtrl db;

    public MainMenuCtrl(MainMenuView menuView) {
        this.menuView = menuView;
        CsvUtil csvUtil = new CsvUtil();
        this.csvUtil = csvUtil;
        db = new DatabaseCtrl();
    }

    /**
     * When the select csv file button is pressed this method will bring up a file chooser to help find the desired file
     * and then set the file path once a file is chosen
     */
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

    /**
     * When the select output directory button is pressed this method will bring up a file chooser to help find the
     * desired path and then set the file path once one is chosen
     */
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

    /**
     * When the load file button is pressed this method will call the CsvUtil method readCsv to read in the selected
     * .csv file and then passes the populated good entry list, via the getGoodEntries method, into the DatabaseCtrl
     * via is createData method
     */
    public void loadButtonActionPerformed() {
        csvUtil.readCsv();
        db.createData(csvUtil.getGoodEntries());
    }

    /**
     * When the close button is pressed this method will exit the entire program
     */
    public void closeButtonActionPerformed() {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     *  When the view database content button is pressed the DatabaseCtrl method viewData is called and a DatabaseView
     *  is generated and populated
     */
    public void databaseButtonActionPerformed() {
        db.viewData();
    }
}
