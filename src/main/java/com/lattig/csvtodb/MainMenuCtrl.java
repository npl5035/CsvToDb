package com.lattig.csvtodb;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuCtrl implements ActionListener {

    CsvUtil csvUtil;
    private MainMenuView menuView;

    public MainMenuCtrl(MainMenuView menuView, CsvUtil csvUtil) {

        this.menuView = menuView;
        menuView.getButton1().addActionListener(this);
        menuView.getButton2().addActionListener(this);
        menuView.getButton3().addActionListener(this);
        this.csvUtil = csvUtil;


    }


    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String com = e.getActionCommand();
        String csvFile;
        String csvPath;

        if (com.equals("open file")) {
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            j.setAcceptAllFileFilterUsed(false);
            j.setDialogTitle("select .csv file");
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .csv files", "csv");
            j.addChoosableFileFilter(restrict);

            int r = j.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                menuView.getLabel1().setText(j.getSelectedFile().getAbsolutePath());
                csvFile = menuView.getLabel1().getText();
                csvUtil.setCsvFile(csvFile);
            } else {
                menuView.getLabel1().setText("operation cancelled!");
            }
        } else if (com.equals("select path")) {

            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int r = j.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                menuView.getLabel2().setText(j.getSelectedFile().getAbsolutePath());
                csvPath = menuView.getLabel2().getText();
                csvUtil.setnewCsvPath(csvPath);
            } else {
                menuView.getLabel2().setText("operation cancelled!");
            }
        } else if (com.equals("load csv file")) {
            System.out.println("load button pressed");
            if (csvUtil.getCsvFile() == null || csvUtil.getnewCsvPath() == null) {
                menuView.getLabel3().setText("Please choose a .csv file and a file output folder");
            } else {
                csvUtil.readCsv();
            }
        }
    }
}
