package ic.doc.templatemethod;

import java.util.Iterator;

public class FibonacciSequence extends NumberSequence {

  @Override
  protected int positiveTerm(int i) {
    if (i < 2) {
      return 1;
    }
    return positiveTerm(i - 1) + positiveTerm(i - 2);
  }


}
