package ic.doc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;
import java.util.stream.IntStream;

/**
 * @author fsh
 * @version 1.0
 * @time 11/04/2024 21:22
 * @description:
 **/
public class Calculator implements Updatable {

    private TextField output = new TextField(10);

    public static void main(String[] args){
        new Calculator().display();
    }

    // view
    private void display() {
        JFrame frame = new JFrame("Calculator");
        ArithmeticEngine calc = new ArithmeticEngine();

        calc.addObserver(this);
        frame.setSize(350,300);

        JPanel panel = new JPanel();

        addNumberButtons(calc, panel);

        addOperatorButtons(calc, panel);

        panel.add(output);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // controller
    private static void addOperatorButtons(ArithmeticEngine calc, JPanel panel) {
        EnumSet.allOf(Operator.class).forEach(op -> {
            JButton button = new JButton(op.label());
            button.addActionListener(e -> calc.apply(op));
            panel.add(button);
        });
    }

    private static void addNumberButtons(ArithmeticEngine calc, JPanel panel) {
        IntStream.range(1,5).forEach(n -> {
            JButton button = new JButton(String.valueOf(n));
            button.addActionListener(e -> calc.input(n));
            panel.add(button);
        });
    }

    @Override
    public void updateWith(int value) {
        output.setText(String.valueOf(value));
    }
}

