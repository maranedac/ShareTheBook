package cl.mac.sharethebook.adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

import cl.mac.sharethebook.R;
import cl.mac.sharethebook.data.CurrentUser;
import cl.mac.sharethebook.data.Nodes;
import cl.mac.sharethebook.models.Book;

/**
 * Created by Michael on 06-07-2017.
 */

public class MyBooksAdapter extends FirebaseRecyclerAdapter<Book, MyBooksAdapter.MyBooksHolder> {

    private BooksListener listener;
    private boolean firstTime = true;

    public MyBooksAdapter(BooksListener listener, Query query) {
        super(Book.class, R.layout.list_item_book, MyBooksHolder.class, query);
        this.listener = listener;
    }

    @Override
    protected void populateViewHolder(final MyBooksHolder viewHolder, Book model, int position) {
        TextView textView = (TextView) viewHolder.itemView;
        textView.setText(model.getTitle());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obtenemos la posicion del libro dentro del recycler
                Book auxBook = getItem(viewHolder.getAdapterPosition());
                listener.clicked(auxBook);
            }
        });

    }

    @Override
    protected void onDataChanged() {
        super.onDataChanged();

        if (firstTime) {
            firstTime = false;
            listener.ready();
        }


    }

    public static class MyBooksHolder extends RecyclerView.ViewHolder {

        public MyBooksHolder(View itemView) {
            super(itemView);

        }
    }
}
