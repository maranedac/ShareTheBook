package cl.mac.sharethebook.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import cl.mac.sharethebook.R;
import cl.mac.sharethebook.data.Nodes;
import cl.mac.sharethebook.models.Book;

/**
 * Created by Michael on 08-07-2017.
 */

public class SharedBooksAdapter extends FirebaseRecyclerAdapter<Book, SharedBooksAdapter.SharedBooksHolder>{

    BooksListener listener;

    public SharedBooksAdapter() {
        super(Book.class, R.layout.list_item_book, SharedBooksHolder.class, new Nodes().availableBooks());
    }

    @Override
    protected void populateViewHolder(final SharedBooksHolder viewHolder, Book model, int position) {
        TextView textView = (TextView) viewHolder.itemView;
        textView.setText(model.getTitle());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book auxBook = getItem(viewHolder.getAdapterPosition());
                listener.clicked(auxBook);
            }
        });
    }


    public static class SharedBooksHolder extends RecyclerView.ViewHolder{

        public SharedBooksHolder(View itemView) {
            super(itemView);
        }
    }


}
