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
 * This class is for editing the data.
 *
 * @author Tan Jia Earn
 * @author Ng Shen Meng
 * @author Wong Fang Man
 */
public class EditData extends JFrame implements ActionListener {

    JLabel totalDeaths, totalRecovered, activeCases, seriousCritical, totalTests, population, image;
    JTextField tD, tR, aC, sC, tT, pP;
    JButton edit, reset, back;
    JPanel input, button;

    static List<DataOfSystem> dOS = new ArrayList<>();

    public EditData() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/CoronaVirus.png"));
        setIconImage(icon.getImage());

        image = new JLabel();
        image.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/CoronaVirus.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));
        image.setBounds(20, 10, 150, 80);
        add(image);

        inputPanel();
        buttonPanel();

        setLayout(null);
        setTitle("Edit Data");
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

        setResizable(false);
        setVisible(true);
        setLocation(400, 256);
        setSize(750, 400);
    }

    /**
     * This method is for creating label in panel.
     */
    public void inputPanel() {

        input = new JPanel();
        input.setBounds(20, 105, 700, 145);
        input.setLayout(null);
        input.setBorder(BorderFactory.createEtchedBorder());
        add(input);

        totalDeaths = new JLabel("New Total Deaths");
        totalDeaths.setFont(new Font("Dialog", Font.BOLD, 12));
        totalRecovered = new JLabel("New Total Recovered");
        totalRecovered.setFont(new Font("Dialog", Font.BOLD, 12));
        activeCases = new JLabel("New Active Cases");
        activeCases.setFont(new Font("Dialog", Font.BOLD, 12));
        seriousCritical = new JLabel("New Serious Critical");
        seriousCritical.setFont(new Font("Dialog", Font.BOLD, 12));
        totalTests = new JLabel("New Total Tests");
        totalTests.setFont(new Font("Dialog", Font.BOLD, 12));
        population = new JLabel("New Population");
        population.setFont(new Font("Dialog", Font.BOLD, 12));

        tD = new JTextField(10);
        tR = new JTextField(10);
        aC = new JTextField(50);
        sC = new JTextField(60);
        tT = new JTextField(10);
        pP = new JTextField(10);

        totalDeaths.setBounds(20, 5, 150, 50);
        totalRecovered.setBounds(20, 45, 150, 50);
        activeCases.setBounds(20, 85, 150, 50);
        seriousCritical.setBounds(370, 5, 150, 50);
        totalTests.setBounds(370, 45, 150, 50);
        population.setBounds(370, 85, 150, 50);

        tD.setBounds(170, 20, 150, 25);
        tR.setBounds(170, 60, 150, 25);
        aC.setBounds(170, 100, 150, 25);
        sC.setBounds(520, 20, 150, 25);
        tT.setBounds(520, 60, 150, 25);
        pP.setBounds(520, 100, 150, 25);

        input.add(totalDeaths);
        input.add(totalRecovered);
        input.add(activeCases);
        input.add(seriousCritical);
        input.add(totalTests);
        input.add(population);

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

        button = new JPanel();
        button.setBounds(20, 275, 700, 75);
        button.setLayout(null);
        button.setBorder(BorderFactory.createEtchedBorder());
        add(button);

        edit = new JButton("Edit");
        reset = new JButton("Reset");
        back = new JButton("Back");
        edit.setFont(new Font("Dialog", Font.BOLD, 14));
        reset.setFont(new Font("Dialog", Font.BOLD, 14));
        back.setFont(new Font("Dialog", Font.BOLD, 14));
        edit.setBounds(100, 20, 100, 30);
        reset.setBounds(300, 20, 100, 30);
        back.setBounds(500, 20, 100, 30);

        button.add(edit);
        button.add(reset);
        button.add(back);

        edit.addActionListener(this);
        reset.addActionListener(this);
        back.addActionListener(this);
    }

    /**
     * This method is for button function.
     *
     * @param e Button function such as edit, reset and back.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == edit) {
            try {
                if (tD.getText().isEmpty() || tR.getText().isEmpty() || aC.getText().isEmpty() || sC.getText().isEmpty() || tT.getText().isEmpty() || pP.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Some fields have not been filled.", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                } else {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to edit the data?", "Corona Virus Counting System", dialogButton);
                    if (dialogResult == 0) {

                        for (DataOfSystem dOS1 : DisplayData.dOS) {

                            String countryName = dOS1.countryName;
                            countryName = countryName.toUpperCase();
                            int newCases = dOS1.newCases;
                            int newDeaths = dOS1.newDeaths;
                            int row = dOS1.row;
                            int recovered = dOS1.totalRecovered;

                            int totalCases = 0;

                            int totalDeaths = Integer.parseInt(tD.getText());
                            int totalRecovered = Integer.parseInt(tR.getText());
                            int activeCases = Integer.parseInt(aC.getText());
                            int seriousCritical = Integer.parseInt(sC.getText());
                            long totCases = 0, deaths = 0, test = 0;
                            int totalTests = Integer.parseInt(tT.getText());
                            int population = Integer.parseInt(pP.getText());
                            dOS.add(new DataOfSystem(countryName, totalCases, newCases, totalDeaths, newDeaths, totalRecovered, activeCases, seriousCritical, totCases, deaths, totalTests, test, population));
                            Calculation calculation = new Calculation(countryName, totalCases, newCases, totalDeaths, newDeaths, totalRecovered, activeCases, seriousCritical, totCases, deaths, totalTests, test, population);
                            calculation.calculate2();
                            if (newDeaths > calculation.getTotalDeaths()) {
                                JOptionPane.showMessageDialog(this, "Current Total Death must bigger than Previous Death.", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                            } else if (recovered > totalRecovered) {
                                JOptionPane.showMessageDialog(this, "Current Total Recovered must bigger than Previous Recovered.", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                            } else if (newCases > calculation.getTotalCases()) {
                                JOptionPane.showMessageDialog(this, "Current Total cases must bigger than Previous cases.", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                            } else {
                                CoronaVirus.dOS.remove(row);
                                CoronaVirus coronaVirus = new CoronaVirus(countryName, calculation.getTotalCases(), calculation.getNewCases(), calculation.getTotalDeaths(), calculation.getNewDeaths(), totalRecovered, activeCases, seriousCritical, calculation.getTotCases(), calculation.getDeaths(), totalTests, calculation.getTest(), population);
                                JOptionPane.showMessageDialog(this, "Data has been edited.\n" + coronaVirus.toString(), "Corona Virus Counting System", JOptionPane.INFORMATION_MESSAGE);
                                coronaVirus.fileWriter();
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter an integer.", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
            }
            CoronaVirus coronaVirus = new CoronaVirus();
            coronaVirus.fileWriter();
        }
        if (e.getSource() == reset) {
            clearField();
        }
        if (e.getSource() == back) {
            new DisplayData();
            this.dispose();
        }
    }

    /**
     * This method is for resetting the text field.
     */
    public void clearField() {
        tD.setText(null);
        tR.setText(null);
        aC.setText(null);
        sC.setText(null);
        tT.setText(null);
        pP.setText(null);
    }

}

