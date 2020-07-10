package my.javatree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is for adding data of corona virus.
 *
 * @author Tan Jia Earn
 * @author Ng Shen Meng
 * @author Wong Fang Man
 */
public class AddData extends JFrame implements ActionListener {

    JLabel countryName, totalDeaths, totalRecovered, activeCases, seriousCritical, totalTests, population, image, deaths, deathsCount, recovered, recoveredCount;
    JTextField cN, tD, tR, aC, sC, tT, pP;
    JButton add, reset, back;
    JPanel display, input, button;

    static List<DataOfSystem> dOS = new ArrayList<>();

    /**
     * This is constructor for class AddData.
     */
    public AddData() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/CoronaVirus.png"));
        setIconImage(icon.getImage());

        setLayout(null);
        setTitle("Add Data");
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

        image = new JLabel();
        image.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/CoronaVirus.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));
        image.setBounds(20, 10, 150, 80);
        add(image);

        displayPanel();
        calculateTotal();
        inputPanel();
        buttonPanel();

        setResizable(false);
        setVisible(true);
        setLocation(400, 0);
        setSize(750, 660);
    }

    /**
     * This method is for creating label in panel.
     */
    public void displayPanel() {
        display = new JPanel();
        display.setBounds(20, 105, 700, 185);
        display.setLayout(null);
        display.setBorder(BorderFactory.createEtchedBorder());
        display.setBackground(Color.white);
        add(display);

        deaths = new JLabel();
        deaths.setText("Deaths:");
        deaths.setFont(new Font(deaths.getFont().getName(), deaths.getFont().getStyle(), 25));
        deaths.setBounds(300, 15, 150, 30);
        display.add(deaths);

        deathsCount = new JLabel();
        deathsCount.setText("");
        deathsCount.setForeground(Color.red);
        deathsCount.setFont(new Font(deathsCount.getFont().getName(), deathsCount.getFont().getStyle(), 25));
        deathsCount.setBounds(300, 45, 150, 30);
        display.add(deathsCount);

        recovered = new JLabel();
        recovered.setText("Recovered:");
        recovered.setFont(new Font(recovered.getFont().getName(), recovered.getFont().getStyle(), 25));
        recovered.setBounds(300, 85, 150, 30);
        display.add(recovered);

        recoveredCount = new JLabel();
        recoveredCount.setText("");
        recoveredCount.setForeground(Color.GREEN);
        recoveredCount.setFont(new Font(recoveredCount.getFont().getName(), recoveredCount.getFont().getStyle(), 25));
        recoveredCount.setBounds(300, 115, 150, 30);
        display.add(recoveredCount);
    }

    /**
     * This method is for user to input data.
     */
    public void inputPanel() {
        input = new JPanel();
        input.setBounds(20, 315, 700, 185);
        input.setLayout(null);
        input.setBorder(BorderFactory.createEtchedBorder());
        add(input);

        countryName = new JLabel("Country Name");
        countryName.setFont(new Font("Dialog", Font.BOLD, 12));
        totalDeaths = new JLabel("Total Deaths");
        totalDeaths.setFont(new Font("Dialog", Font.BOLD, 12));
        totalRecovered = new JLabel("Total Recovered");
        totalRecovered.setFont(new Font("Dialog", Font.BOLD, 12));
        activeCases = new JLabel("Active Cases");
        activeCases.setFont(new Font("Dialog", Font.BOLD, 12));
        seriousCritical = new JLabel("Serious Critical");
        seriousCritical.setFont(new Font("Dialog", Font.BOLD, 12));
        totalTests = new JLabel("Total Tests");
        totalTests.setFont(new Font("Dialog", Font.BOLD, 12));
        population = new JLabel("Population");
        population.setFont(new Font("Dialog", Font.BOLD, 12));

        cN = new JTextField();
        tD = new JTextField();
        tR = new JTextField();
        aC = new JTextField();
        sC = new JTextField();
        tT = new JTextField();
        pP = new JTextField();

        countryName.setBounds(20, 5, 150, 50);
        totalDeaths.setBounds(20, 45, 150, 50);
        totalRecovered.setBounds(20, 85, 150, 50);
        activeCases.setBounds(20, 125, 150, 50);
        seriousCritical.setBounds(370, 5, 150, 50);
        totalTests.setBounds(370, 45, 150, 50);
        population.setBounds(370, 85, 150, 50);

        cN.setBounds(170, 20, 150, 25);
        tD.setBounds(170, 60, 150, 25);
        tR.setBounds(170, 100, 150, 25);
        aC.setBounds(170, 140, 150, 25);
        sC.setBounds(520, 20, 150, 25);
        tT.setBounds(520, 60, 150, 25);
        pP.setBounds(520, 100, 150, 25);

        input.add(countryName);
        input.add(totalDeaths);
        input.add(totalRecovered);
        input.add(activeCases);
        input.add(seriousCritical);
        input.add(totalTests);
        input.add(population);

        input.add(cN);
        input.add(tD);
        input.add(tR);
        input.add(aC);
        input.add(sC);
        input.add(tT);
        input.add(pP);
    }

    /**
     * This method is for creating button.
     */
    public void buttonPanel() {
        add = new JButton("Save");
        reset = new JButton("Reset");
        back = new JButton("Back");
        add.setFont(new Font("Dialog", Font.BOLD, 14));
        reset.setFont(new Font("Dialog", Font.BOLD, 14));
        back.setFont(new Font("Dialog", Font.BOLD, 14));

        button = new JPanel();
        button.setBounds(20, 525, 700, 75);
        button.setLayout(null);
        button.setBorder(BorderFactory.createEtchedBorder());
        add(button);

        add.setBounds(100, 20, 100, 30);
        reset.setBounds(300, 20, 100, 30);
        back.setBounds(500, 20, 100, 30);

        button.add(add);
        button.add(reset);
        button.add(back);

        add.addActionListener(this);
        reset.addActionListener(this);
        back.addActionListener(this);
    }

    /**
     * This method is for calculating total death and total recovered.
     */
    public void calculateTotal() {
        int totalDeathOfAll = 0;
        int totalRecoveredOfAll = 0;

        for (DataOfSystem dOS : CoronaVirus.dOS) {
            totalDeathOfAll += dOS.totalDeaths;

            totalRecoveredOfAll += dOS.totalRecovered;
        }

        deathsCount.setText(String.valueOf(totalDeathOfAll));
        recoveredCount.setText(String.valueOf(totalRecoveredOfAll));
    }

    /**
     * This method is for button function.
     *
     * @param e button function such as add, reset and back.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            try {
                if (cN.getText().isEmpty() || tD.getText().isEmpty() || tR.getText().isEmpty() || aC.getText().isEmpty() || sC.getText().isEmpty() || tT.getText().isEmpty() || pP.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Some fields have not been filled.", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                } else {
                    String countryName = cN.getText();
                    countryName = countryName.toUpperCase();
                    int totalCases = 0;
                    int newCases = 0;
                    int totalDeaths = Integer.parseInt(tD.getText());
                    int newDeaths = 0;
                    int totalRecovered = Integer.parseInt(tR.getText());
                    int activeCases = Integer.parseInt(aC.getText());
                    int seriousCritical = Integer.parseInt(sC.getText());
                    long totCases = 0, deaths = 0, test = 0;
                    int totalTests = Integer.parseInt(tT.getText());
                    int population = Integer.parseInt(pP.getText());
                    for (int i = 0; i < CoronaVirus.dOS.size(); i++) {
                        if (CoronaVirus.dOS.get(i).countryName.equalsIgnoreCase(cN.getText())) {
                            JOptionPane.showMessageDialog(this, "This country is already exist", "Corona Virus Counting System", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    dOS.add(new DataOfSystem(countryName, totalCases, newCases, totalDeaths, newDeaths, totalRecovered, activeCases, seriousCritical, totCases, deaths, totalTests, test, population));
                    clearField();
                    Calculation calculation = new Calculation(countryName, totalCases, newCases, totalDeaths, newDeaths, totalRecovered, activeCases, seriousCritical, totCases, deaths, totalTests, test, population);
                    calculation.calculate();
                    CoronaVirus coronaVirus = new CoronaVirus(countryName, calculation.getTotalCases(), calculation.getNewCases(), calculation.getTotalDeaths(), calculation.getNewDeaths(), totalRecovered, activeCases, seriousCritical, calculation.getTotCases(), calculation.getDeaths(), totalTests, calculation.getTest(), population);
                    JOptionPane.showMessageDialog(this, "Data has been saved.\n" + coronaVirus.toString(), "Corona Virus Counting System", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter an integer.", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
            }
            calculateTotal();
            CoronaVirus coronaVirus = new CoronaVirus();
            coronaVirus.fileWriter();
        }
        if (e.getSource() == reset) {
            clearField();
        }
        if (e.getSource() == back) {
            new MainMenu();
            this.dispose();
        }
    }

    /**
     * This method is for resetting the text field.
     */
    public void clearField() {
        cN.setText(null);
        tD.setText(null);
        tR.setText(null);
        aC.setText(null);
        sC.setText(null);
        tT.setText(null);
        pP.setText(null);
    }

}
