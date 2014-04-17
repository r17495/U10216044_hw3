import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class U10216044_hw3 extends JFrame {
  private JTextField jtfName = new JTextField();
  private JTextField jtfAge = new JTextField();
  private JTextField jtfWeight = new JTextField();
  private JTextField jtfHeight = new JTextField();
  private JTextField jtfBMI = new JTextField();
  private JButton jbtCalculate = new JButton("Calculate!");

  public U10216044_hw3() {
    //A panel allow user to input 
    JPanel p1 = new JPanel(new GridLayout(5, 3));
    p1.add(new JLabel("Name:"));
    p1.add(jtfName);
    p1.add(new JLabel(""));
    p1.add(new JLabel("Age:"));
    p1.add(jtfAge);
    p1.add(new JLabel("years old"));
    p1.add(new JLabel("Weight:"));
    p1.add(jtfWeight);
    p1.add(new JLabel("pounds"));
    p1.add(new JLabel("Height:"));
    p1.add(jtfHeight);
    p1.add(new JLabel("inches"));
    p1.add(new JLabel("BMI:"));
    p1.add(jtfBMI);
    p1.setBorder(new TitledBorder("Enter the following informaintion to calculate BMI"));

    //A panel for the button "Calculate!"
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p2.add(jbtCalculate);

    add(p1, BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);

    jbtCalculate.addActionListener(new ButtonListener());
  }
  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String name = jtfName.getText();
      int age = Integer.parseInt(jtfAge.getText());
      double weight = Double.parseDouble(jtfWeight.getText());
      double height = Double.parseDouble(jtfHeight.getText());
      BMI bmi = new BMI(name, age, weight, height);
      jtfBMI.setText(String.format("%s's BMI is %.2f %s", bmi.getName(), bmi.getBMI(), bmi.getStatus()));
    }
  }
  public static void main(String[] args) {
    JFrame frame = new U10216044_hw3();
    frame.setTitle("BMI Calculater");
    frame.setSize(350, 250);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }  
}
