
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SimpleShapeCalculatorGUI extends JFrame 
    {
    private JComboBox<String> shapeTypeDropdown;
    private JTextField paramsTextField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public SimpleShapeCalculatorGUI() 
        {
        super("Simple Shape Calculator");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Initialize the dropdown with shape options
        shapeTypeDropdown = new JComboBox<>(new String[]{"Circle", "Rectangle"});
        // Initialize the parameters text field with a tooltip explaining the format
        paramsTextField = new JTextField();
        paramsTextField.setToolTipText("Enter parameters separated by a comma. E.g., radius for Circle, width,height for Rectangle");
        // Initialize the calculate button
        calculateButton = new JButton("Calculate");
        // Initialize the result label with an initial message
        resultLabel = new JLabel("Enter parameters and click Calculate.");

        add(shapeTypeDropdown);
        add(paramsTextField);
        add(calculateButton);
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() 
            {
            @Override
            public void actionPerformed(ActionEvent e) 
                {
                calculateArea();
                }
            });

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
        }

    private void calculateArea() 
        {
        try {
            String shapeType = (String) shapeTypeDropdown.getSelectedItem();
            String[] parts = paramsTextField.getText().split(",");
            double[] params = new double[parts.length];
            for (int i = 0; i < parts.length; i++) 
                {
                params[i] = Double.parseDouble(parts[i].trim());
                }

            ShapeCalculator calculator = shapeType.equals("Circle") ? new CircleCalculator() : new RectangleCalculator();
            double area = calculator.calculateArea(params);
            resultLabel.setText("Area: " + area);
            } catch (Exception ex) 
                {
                JOptionPane.showMessageDialog(this, "Error calculating area: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        
        public static void main(String[] args)
            {
        SwingUtilities.invokeLater(new Runnable()
            {
            @Override
            public void run()
                {
                new SimpleShapeCalculatorGUI();
                }
            });
            }
    
    }

