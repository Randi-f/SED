package ic.doc;

import static ic.doc.BookSearchQueryBuilder.books;
import static org.hamcrest.CoreMatchers.is;
import static org.jmock.internal.Cardinality.exactly;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import ic.doc.catalogues.BritishLibraryCatalogue;
import ic.doc.catalogues.Catalogue;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class BookSearchQueryTest {
  private static final List<Book> BOOKS = Arrays.asList(new Book("A Chiristmas Carol","Charles Dickens", 1766));

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  Catalogue catalogue = context.mock(Catalogue.class);

  @Test
  public void searchesForBooksInLibraryCatalogueByAuthorSurname() {
    context.checking(new Expectations(){{
      exactly(1).of(catalogue).searchFor("LASTNAME='dickens' ");will(returnValue(BOOKS));
    }});
    List<Book> books = books().withSurname("dickens").build().execute(catalogue);

    assertThat(books, is(BOOKS));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueByAuthorFirstname() {
    context.checking(new Expectations(){{
      exactly(1).of(catalogue).searchFor("FIRSTNAME='Jane' ");
    }});
    books().withFirstname("Jane").build().execute(catalogue);
  }

  @Test
  public void searchesForBooksInLibraryCatalogueByTitle() {

    List<Book> books = books().withTitle("Two Cities").build().execute(catalogue);

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("dickens"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueBeforeGivenPublicationYear() {

    List<Book> books = books().publishedBefore(1700).build().execute(catalogue);

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("Shakespeare"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueAfterGivenPublicationYear() {

    List<Book> books = books().publishedAfter(1950).build().execute(catalogue);

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("Golding"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueWithCombinationOfParameters() {

    List<Book> books = books().withSurname("dickens").publishedBefore(1840).build().execute(catalogue);

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("charles dickens"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueWithCombinationOfTitleAndOtherParameters() {

    List<Book> books = books().withTitle("of").publishedAfter(1800).publishedBefore(2000).build().execute(catalogue);

    assertThat(books.size(), is(3));
    assertTrue(books.get(0).matchesAuthor("charles dickens"));
  }
}
