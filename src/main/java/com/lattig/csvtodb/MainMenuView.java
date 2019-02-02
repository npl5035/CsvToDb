package com.lattig.csvtodb;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JButton button3;


    public MainMenuView() {
        createUI();
    }

    public void createUI() {
        frame = new JFrame("CsV to Db");
        panel = new JPanel();
        frame.setLayout(new BorderLayout());
        panel.setLayout(new GridBagLayout());

        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createComponents();

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void createComponents() {

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        //**************** Choose File to Load setup ****************

        setButton1(new JButton("open file"));
        //getButton1().addActionListener(f1);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(getButton1(), c);
        setLabel1(new JLabel("no file selected"));
        c.gridx = 1;
        c.gridy = 0;
        panel.add(getLabel1(), c);

        //**************** Choose File Path to Save setup ****************

        setButton2(new JButton("select path"));
        //getButton2().addActionListener(f1);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(getButton2(), c);
        setLabel2(new JLabel("no path selected"));
        c.gridx = 1;
        c.gridy = 1;
        panel.add(getLabel2(), c);

        //**************** Load CSV setup ****************

        setButton3(new JButton("load csv file"));
        //getButton2().addActionListener(f1);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(getButton3(), c);
        setLabel3(new JLabel(""));
        c.gridx = 1;
        c.gridy = 2;
        panel.add(getLabel3(), c);


    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public void setButton2(JButton button2) {
        this.button2 = button2;
    }

    public JLabel getLabel3() {
        return label3;
    }

    public void setLabel3(JLabel label3) {
        this.label3 = label3;
    }

    public JButton getButton3() {
        return button3;
    }

    public void setButton3(JButton button3) {
        this.button3 = button3;
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();

        if(com.equals("open file")) {
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            j.setAcceptAllFileFilterUsed(false);
            j.setDialogTitle("select .csv file");
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .csv files", "csv");
            j.addChoosableFileFilter(restrict);

            int r = j.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                label1.setText(j.getSelectedFile().getAbsolutePath());
            } else {
                label1.setText("operation canclled!");
            }
        }else{

            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int r = j.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                label2.setText(j.getSelectedFile().getAbsolutePath());
            } else {
                label2.setText("operation canclled!");
            }

        }

    }*/


//    private JFrame f;
//    private JPanel p;
//    private JFileChooser j;
//
//    private JButton addFoodBtn, addMoodBtn, viewProfileBtn, editEntriesBtn, viewRecommendationsBtn;
//
//    /**
//     * default constructor for MainMenuUI
//     */
//    public FileChooserUI(){
//        f = new JFrame();
//        p = new JPanel();
//        f.setLayout(new BorderLayout());
//        p.setLayout(new GridBagLayout());
//
//        f.setTitle("FoodMood");
//        f.setSize(1000, 1000); // default size is 0,0
//        //f.setLocation(300, 300); // default is 0,0 (top left corner)
//        f.setLocationRelativeTo(null);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        createComponents();
//
//        f.add(p, BorderLayout.CENTER);
//        f.setVisible(true);
//
//    }
//
//    private void createComponents() {
//        GridBagConstraints c = new GridBagConstraints();
//        c.fill = GridBagConstraints.BOTH;
//
//        c.gridx = 0;
//        c.gridy = 0;
//        j = new JFileChooser();
//        j.showSaveDialog(null);
//        p.add(j, c);
//
//    }
//
//    public JButton getAddFoodBtn() {
//        return addFoodBtn;
//    }
//
//    public JButton getAddMoodBtn() {
//        return addMoodBtn;
//    }
//
//    public JButton getViewProfileBtn() {
//        return viewProfileBtn;
//    }
//
//    public JButton getEditEntriesBtn() {
//        return editEntriesBtn;
//    }
//
////    public JButton getViewNotificationsBtn() {
////       return viewNotificationsBtn;
////    }
//
//    public JButton getViewRecommendationsBtn() {
//        return viewRecommendationsBtn;
//    }
//
//    public JFrame getF() {
//        return f;
//    }
}
