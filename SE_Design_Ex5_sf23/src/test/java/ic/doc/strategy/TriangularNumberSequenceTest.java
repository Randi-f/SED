package ic.doc.strategy;

import ic.doc.templatemethod.TriangularNumberSequence;
import org.junit.Test;

import static ic.doc.matchers.IterableBeginsWith.beginsWith;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class TriangularNumberSequenceTest {

  final TermGenerator termGenerator = new TriangleNumbersTermGenerator();


  @Test
  public void definesFirstTermToBeOne() {
    assertThat(termGenerator.positiveTerm(0), is(1));
  }

  @Test
  public void definesSubsequentTermsToBeTheSumOfZeroToNPlusOne() {

    assertThat(termGenerator.positiveTerm(1), is(3));
    assertThat(termGenerator.positiveTerm(2), is(6));
    assertThat(termGenerator.positiveTerm(3), is(10));
  }


}