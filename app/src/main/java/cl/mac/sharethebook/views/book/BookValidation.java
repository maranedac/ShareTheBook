package cl.mac.sharethebook.views.book;

import com.google.firebase.auth.FirebaseUser;

import cl.mac.sharethebook.data.CurrentUser;
import cl.mac.sharethebook.data.Nodes;
import cl.mac.sharethebook.models.Book;

/**
 * Created by Michael on 08-07-2017.
 */

public class BookValidation {

    private BookCallback callback;

    public BookValidation(BookCallback callback) {
        this.callback = callback;
    }


    public void addBook(String title, String description, boolean availability, Book book){
        //Generamos la Key de Book
        String key = (book != null) ? book.getKey() : new Nodes().books().push().getKey(); //operador ternario

        //Traemos el UID del usuario logeado currentUser
        FirebaseUser currentUser = new CurrentUser().getCurrent();
        String uid = currentUser.getUid();

        //creamos el nuevo libro
        book = new Book();
        book.setKey(key); //va a quedar con su key.
        book.setUid(uid); //va a quedar con la UID del usuario.

        book.setTitle(title);
        book.setDescription(description);
        book.setAvailability(availability);

        //añadimos el nuevo libro con el uid del usuario
        //new Nodes().books().child(uid).child(key).setValue(book);
        new Nodes().books().child(key).setValue(book);

        callback.success();
    }

}
