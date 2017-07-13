package cl.mac.sharethebook.adapters;

import cl.mac.sharethebook.models.Book;

/**
 * Created by Michael on 08-07-2017.
 */

public interface BooksListener {

    void clicked(Book book);
    void ready();

}
