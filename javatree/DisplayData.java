package my.javatree;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is for displaying the data.
 *
 * @author Tan Jia Earn
 * @author Ng Shen Meng
 * @author Wong Fang Man
 */
public class DisplayData extends JFrame implements ActionListener {

    String[] header = new String[]{"Country,Other", "Total Cases", "New Cases", "Total Deaths", "New Deaths", "Total Recovered", "Active Cases", "Serious Critical", "Tot Cases/ 1M pop", "Deaths/ 1M pop", "Total Tests", "Tests/ 1M pop", "Population"};

    JTable output;
    DefaultTableModel dtm;
    JScrollPane jsp;
    JButton back, delete, edit;
    JLabel label1, deaths, deathsCount, recovered, recoveredCount;//image
    JPanel button, display;

    static List<DataOfSystem> dOS = new ArrayList<>();

    /**
     * This constructor is for creating GUI of display.
     */
    public DisplayData() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/CoronaVirus.png"));
        setIconImage(icon.getImage());
        displayPanel();
        calculateTotal();
        outputTable();
        buttonPanel();
        setTitle("Display Data");
        setLocation(400, 0);
        setSize(750, 655);
        setLayout(null);
        setResizable(false);
        setVisible(true);
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

        label1 = new JLabel();
        label1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/CoronaVirus.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));
        label1.setBounds(20, 10, 150, 80);
        add(label1);
    }

    /**
     * This method is for creating label in display page.
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
     * This method is for creating a table of data.
     */
    public void outputTable() {
        dtm = new DefaultTableModel(header, 0);
        output = new JTable();

        JTableHeader header = output.getTableHeader();
        int headerHeight = 30;
        header.setPreferredSize(new Dimension(50, headerHeight));
        ((DefaultTableCellRenderer) output.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        output.setModel(dtm);

        for (int i = 0; i <= 12; i++) {
            output.getColumnModel().getColumn(i).setPreferredWidth(150);
        }
        output.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        output.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        output.setDefaultRenderer(Object.class, centerRenderer);
        output.getTableHeader().setReorderingAllowed(false);
        output.getTableHeader().setResizingAllowed(false);
        output.setDefaultEditor(Object.class, null);
        output.setRowHeight(30);

        dtm.setRowCount(0);
        for (DataOfSystem dOS : CoronaVirus.dOS) {
            Object[] objs = {dOS.countryName, dOS.totalCases, dOS.newCases, dOS.totalDeaths, dOS.newDeaths, dOS.totalRecovered, dOS.activeCases, dOS.seriousCritical, dOS.totCases, dOS.deaths, dOS.totalTest, dOS.test, dOS.population};
            dtm.addRow(objs);
        }
        jsp = new JScrollPane();
        jsp.setViewportView(output);
        jsp.setBounds(20, 315, 700, 186);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jsp);

    }

    /**
     * This method is for creating the button on display page.
     */
    public void buttonPanel() {
        button = new JPanel();
        button.setBounds(20, 526, 700, 75);
        button.setLayout(null);
        button.setBorder(BorderFactory.createEtchedBorder());
        add(button);

        edit = new JButton("Edit");
        edit.setBounds(100, 20, 100, 30);
        button.add(edit);
        edit.addActionListener(this);

        delete = new JButton("Delete");
        delete.setBounds(300, 20, 100, 30);
        button.add(delete);
        delete.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(500, 20, 100, 30);
        button.add(back);
        back.addActionListener(this);

        edit.setFont(new Font("Dialog", Font.BOLD, 14));
        delete.setFont(new Font("Dialog", Font.BOLD, 14));
        back.setFont(new Font("Dialog", Font.BOLD, 14));
    }

    /**
     * This method is for calculating the total of death and total of recovered.
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
     * @param e Button function such as delete, edit and back.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        int row = output.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) output.getModel();

        if (e.getSource() == delete) {
            if (CoronaVirus.dOS.isEmpty()) {
                if (e.getSource() == delete) {
                    JOptionPane.showMessageDialog(this, "List is empty", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (e.getSource() == delete) {
                    if (output.getSelectionModel().isSelectionEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please select a row that you want to delete", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the data?", "Corona Virus Counting System", dialogButton);
                        if (dialogResult == 0) {
                            CoronaVirus.dOS.remove(row);
                            model.removeRow(row);
                            CoronaVirus coronaVirus = new CoronaVirus();
                            coronaVirus.fileWriter();
                        }
                    }
                }
            }
        }

        if (e.getSource() == edit) {
            if (CoronaVirus.dOS.isEmpty()) {
                if (e.getSource() == edit) {
                    JOptionPane.showMessageDialog(this, "List is empty", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
                }
            } else if (output.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a row that you want to delete", "Corona Virus Counting System", JOptionPane.ERROR_MESSAGE);
            } else {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to edit the data?(country name cannot be edit)", "Corona Virus Counting System", dialogButton);
                if (dialogResult == 0) {
                    String countryName = String.valueOf(output.getValueAt(output.getSelectedRow(), 0));
                    int newDeaths = Integer.parseInt((String.valueOf(output.getValueAt(output.getSelectedRow(), 3))));
                    int newCases = Integer.parseInt(String.valueOf(output.getValueAt(output.getSelectedRow(), 1)));
                    int totalRevovered = Integer.parseInt(String.valueOf(output.getValueAt(output.getSelectedRow(), 5)));
                    dOS.add(new DataOfSystem(countryName, newDeaths, newCases, row, totalRevovered));
                    new EditData();
                    this.dispose();
                }
            }
        }
        if (e.getSource() == back) {
            new MainMenu();
            this.dispose();
        }
        calculateTotal();
    }

}