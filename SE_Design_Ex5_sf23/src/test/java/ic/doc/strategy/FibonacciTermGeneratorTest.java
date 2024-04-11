package ic.doc.strategy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FibonacciTermGeneratorTest {

  final TermGenerator termGenerator = new FibonacciTermGenerator();

  @Test
  public void definesFirstTwoTermsToBeOne() {

    assertThat(termGenerator.positiveTerm(0), is(1));
    assertThat(termGenerator.positiveTerm(1), is(1));
  }

  @Test
  public void definesSubsequentTermsToBeTheSumOfThePreviousTwo() {

    assertThat(termGenerator.positiveTerm(2), is(2));
    assertThat(termGenerator.positiveTerm(3), is(3));
    assertThat(termGenerator.positiveTerm(4), is(5));
  }


}