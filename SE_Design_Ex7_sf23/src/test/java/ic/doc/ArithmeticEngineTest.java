package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author fsh
 * @version 1.0
 * @time 11/04/2024 21:36
 * @description:
 **/
public class ArithmeticEngineTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    Updatable display = context.mock(Updatable.class);
    @Test
    public void updateDisplayWhenNewNumberIsInput() {
        ArithmeticEngine calc = new ArithmeticEngine();
        calc.addObserver(display);

        context.checking(new Expectations(){{
            exactly(1).of(display).updateWith(5);
        }});
        calc.input(5);
    }

    @Test
    public void supportsAddingTwoValues() {
        ArithmeticEngine calc = new ArithmeticEngine();
        calc.addObserver(display);

        context.checking(new Expectations(){{
            allowing(display).updateWith(5);
            allowing(display).updateWith(3);
            exactly(1).of(display).updateWith(8);
        }});
        calc.input(5);
        calc.input(3);
        calc.apply(Operator.PLUS);
    }

    @Test
    public void supportsSubstractingTwoValues() {
        ArithmeticEngine calc = new ArithmeticEngine();
        calc.addObserver(display);

        context.checking(new Expectations(){{
            allowing(display).updateWith(5);
            allowing(display).updateWith(3);
            exactly(1).of(display).updateWith(2);
        }});
        calc.input(5);
        calc.input(3);
        calc.apply(Operator.MINUS);
    }
}