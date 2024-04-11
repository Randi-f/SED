package ic.doc.templatemethod;

public class TriangularNumberSequence extends NumberSequence {

  @Override
  protected int positiveTerm(int i) {
    return (i + 1) * (i + 2) / 2;
  }

}
