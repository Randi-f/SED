package ic.doc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author fsh
 * @version 1.0
 * @time 11/04/2024 21:32
 * @description:
 **/
public class ArithmeticEngine {
    private final List<Updatable> observers = new ArrayList<>();
    private final Stack<Integer> stack = new Stack<>();
    public void input(int value){

        stack.push(value);

        notifyObservers();
    }

    private void notifyObservers() {
        for(Updatable observer : observers){
            observer.updateWith(stack.peek());
        }
    }

    public void apply(Operator op) {
        stack.push(op.apply(stack.pop(),stack.pop()));
        notifyObservers();
    }

    public void addObserver(Updatable observer) {

        observers.add(observer);
    }
}
