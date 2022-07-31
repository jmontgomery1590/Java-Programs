package FutureValueFrame;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class FutureValueFrame extends JFrame {
    private JTextField monthlyInvestment;
    private JTextField yearlyInterestRate;
    private JComboBox numYearsComboBox;
    private JList futureValueList;
    private DefaultListModel<String> futureValueModel;

    public FutureValueFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Future Value Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        monthlyInvestment = new JTextField();
        yearlyInterestRate = new JTextField();
        numYearsComboBox = new JComboBox();
        futureValueList = new JList();
        futureValueModel = new DefaultListModel<>();
        JScrollPane futureValuePane = new JScrollPane(futureValueList);

        monthlyInvestment.setEditable(true);
        yearlyInterestRate.setEditable(true);
        numYearsComboBox.setEditable(true);

        Dimension dim1 = new Dimension(180, 20);
        monthlyInvestment.setPreferredSize(dim1);
        yearlyInterestRate.setPreferredSize(dim1);
        numYearsComboBox.setPreferredSize(dim1);
        monthlyInvestment.setMinimumSize(dim1);
        yearlyInterestRate.setMinimumSize(dim1);
        numYearsComboBox.setMinimumSize(dim1);

        Dimension dim2 = new Dimension(180, 100);
        futureValuePane.setPreferredSize(dim2);
        futureValuePane.setMinimumSize(dim2);

        JButton calculateButton = new JButton("Calculate");
        JButton exitButton = new JButton("Exit");

        calculateButton.addActionListener(e -> calculateButtonClicked());
        exitButton.addActionListener(e -> exitButtonClicked());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);
        
        for (int i = 1; i <= 30; ++i) {
            numYearsComboBox.addItem(i);
        }
        numYearsComboBox.setSelectedIndex(2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setLayout(new GridBagLayout());
        panel.add(new JLabel("Monthly Investment: "), getConstraints(0, 0));
        panel.add(monthlyInvestment, getConstraints(1,0));
        panel.add(new JLabel("Yearly Interest Rate: "), getConstraints(0, 1));
        panel.add(yearlyInterestRate, getConstraints(1,1));
        panel.add(new JLabel("Years: "), getConstraints(0, 2));
        panel.add(numYearsComboBox, getConstraints(1,2));
        panel.add(new JLabel("Future Value: "), getConstraints(0, 3));
        panel.add(futureValuePane, getConstraints(1,3));

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(new Dimension(400, 300));
        setVisible(true);
    }

    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;

    }

    private void calculateButtonClicked() {
        Validation val = new Validation();
        String errorMsg = "";
        errorMsg += val.isDouble(monthlyInvestment.getText(), "Monthly Investment");
        errorMsg += val.isDouble(yearlyInterestRate.getText(), "Yearly Interest Rate");

        if (errorMsg.isEmpty()) {
            double investment = Double.parseDouble(monthlyInvestment.getText());
            double interestRate = Double.parseDouble(yearlyInterestRate.getText());
            int years = (int) numYearsComboBox.getSelectedItem();

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            futureValueModel.clear();
            double futureValue;
            String yearlyString;
            for (int year = 1; year <= years; ++year) {
                futureValue = FinancialCalculations.calculateFutureValue(investment, interestRate, year);
                yearlyString = "Year " + year + ": " + currency.format(futureValue);
                futureValueModel.addElement(yearlyString);
            }
            futureValueList.setModel(futureValueModel);
        } else {
            JOptionPane.showMessageDialog(this, errorMsg, "Invalid Data", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exitButtonClicked() {
        System.exit(0);
    }
}
