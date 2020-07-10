package my.javatree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is for manipulating Main Menu.
 *
 * @author Tan Jia Earn
 * @author Ng Shen Meng
 * @author Wong Fang Man
 */
public class MainMenu extends JFrame implements ActionListener {

    JButton add, search, display, exit;
    JLabel label;

    /**
     * This constructor is for creating button.
     */
    public MainMenu() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/CoronaVirus.png"));
        setIconImage(icon.getImage());

        label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/CoronaVirus.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));
        label.setBounds(20, 10, 150, 80);
        add(label);

        add = new JButton("Add Data");
        search = new JButton("Search");
        display = new JButton("Display Records");
        exit = new JButton("Exit");

        add.setFont(new Font("Dialog", Font.BOLD, 14));
        search.setFont(new Font("Dialog", Font.BOLD, 14));
        display.setFont(new Font("Dialog", Font.BOLD, 14));
        exit.setFont(new Font("Dialog", Font.BOLD, 14));

        add.setBounds(55, 120, 180, 40);
        search.setBounds(55, 175, 180, 40);
        display.setBounds(55, 230, 180, 40);
        exit.setBounds(55, 285, 180, 40);

        add(add);
        add(search);
        add(display);
        add(exit);

        add.addActionListener(this);
        search.addActionListener(this);
        display.addActionListener(this);
        exit.addActionListener(this);

        fileReader();
        setLayout(null);
        setTitle("Main Menu");
        setResizable(false);
        setVisible(true);
        setLocation(650, 250); //frame location
        setSize(300, 390); //size of frame
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Corona Virus Counting System", dialogButton);
                if (dialogResult == 0) {
                    System.exit(0);
                }
            }
        });

    }

    /**
     * This method is for button function.
     *
     * @param e Button function such as add, search, display and exit.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            new AddData();
            this.dispose();
        }
        if (e.getSource() == search) {
            if (e.getSource() == search) {
                if (CoronaVirus.dOS.isEmpty()) {
                    if (e.getSource() == search) {
                        JOptionPane.showMessageDialog(this, "List is empty", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    String input = JOptionPane.showInputDialog(this, "Search for Country Name:", "Corona Virus Counting System", JOptionPane.QUESTION_MESSAGE);
                    if (input != null) {
                        if (input.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Please enter the country name", "Corona Virus Counting System", JOptionPane.WARNING_MESSAGE);
                        } else {
                            for (int i = 0; i < CoronaVirus.dOS.size(); i++) {
                                if (CoronaVirus.dOS.get(i).countryName.equalsIgnoreCase(input)) {
                                    String a = "Country Name: " + CoronaVirus.dOS.get(i).countryName + "\n"
                                            + "Total Cases: " + CoronaVirus.dOS.get(i).totalCases + "\n"
                                            + "New Cases: " + CoronaVirus.dOS.get(i).newCases + "\n"
                                            + "Total Deaths: " + CoronaVirus.dOS.get(i).totalDeaths + "\n"
                                            + "New Deaths: " + CoronaVirus.dOS.get(i).newDeaths + "\n"
                                            + "Total Recovered: " + CoronaVirus.dOS.get(i).totalRecovered + "\n"
                                            + "Active Cases: " + CoronaVirus.dOS.get(i).activeCases + "\n"
                                            + "Serious Critical: " + CoronaVirus.dOS.get(i).seriousCritical + "\n"
                                            + "Tot Cases/ 1M pop: " + CoronaVirus.dOS.get(i).totCases + "\n"
                                            + "Deaths/ 1M pop: " + CoronaVirus.dOS.get(i).deaths + "\n"
                                            + "Total Tests: " + CoronaVirus.dOS.get(i).totalTest + "\n"
                                            + "Test/ 1M pop: " + CoronaVirus.dOS.get(i).test + "\n"
                                            + "Population: " + CoronaVirus.dOS.get(i).population;
                                    JOptionPane.showMessageDialog(this, "Data for " + input.toUpperCase() + "\n" + a, "Corona Virus Counting System", JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Not Found", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
        if (e.getSource() == display) {
            new DisplayData();
            this.dispose();

        }
        if (e.getSource() == exit) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Corona Virus Counting System", dialogButton);
            if (dialogResult == 0) {
                System.exit(0);
            }
        }
    }

    /**
     * This method is for reading the data.
     */
    public void fileReader() {
        try {
            boolean create;
            File newFile = new File("Covid19.txt");
            create = newFile.createNewFile();

            if (create) {
                System.out.println("\nCreate Covid19.txt");
            }

            CoronaVirus.dOS.clear();
            FileReader cus = new FileReader("Covid19.txt");

            StringBuffer sb = new StringBuffer();
            while (cus.ready()) {
                char c = (char) cus.read();
                if (c == '\n') {
                    String[] dataArr = sb.toString().split(",");
                    CoronaVirus.dOS.add(new DataOfSystem(dataArr[0], Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2]), Integer.parseInt(dataArr[3]), Integer.parseInt(dataArr[4]), Integer.parseInt(dataArr[5]), Integer.parseInt(dataArr[6]), Integer.parseInt(dataArr[7]), Long.parseLong(dataArr[8]), Long.parseLong(dataArr[9]), Integer.parseInt(dataArr[10]), Long.parseLong(dataArr[11]), Integer.parseInt(dataArr[12])));
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is for creating a nimbus design for the main class.
     *
     * @param args The String[] args parameter is an array of Strings passed as parameters when you are running your application through command line in the OS.
     */
    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> new MainMenu().setVisible(true));
    }

}

