package ic.doc.catalogues;

import ic.doc.Book;

import java.util.List;

/**
 * @author fsh
 * @version 1.0
 * @time 11/04/2024 20:40
 * @description:
 **/
public interface Catalogue {
    List<Book> searchFor(String query);
}
