package cl.mac.sharethebook.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import cl.mac.sharethebook.models.Book;

/**
 * Created by Michael on 04-07-2017.
 */

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public Query availableBooks(){
        //Este orden te permite poder mostrar los que estan disponibles.
        //si el libro esta disponible se le muestra al usuario, si no queda como private.

        return root.child("books").orderByChild("availability").equalTo(true);
    }


    public DatabaseReference user(){
        return root.child("users");
    }

    public DatabaseReference books(){
        return root.child("books");
    }

    public Query myBooks(){
        return root.child("books").orderByChild("uid").equalTo(new CurrentUser().uid());
    }




}
