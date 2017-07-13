package cl.mac.sharethebook.views.tabs;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.mac.sharethebook.views.book.AddBookActivity;
import cl.mac.sharethebook.R;
import cl.mac.sharethebook.adapters.BooksListener;
import cl.mac.sharethebook.adapters.MyBooksAdapter;
import cl.mac.sharethebook.data.Nodes;
import cl.mac.sharethebook.models.Book;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyBooksFragment extends Fragment implements BooksListener {


    private MyBooksAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;

    public MyBooksFragment() {
        // Required empty public constructor
    }

    public static MyBooksFragment newInstance() {
        return new MyBooksFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_books, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.show();

        recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        adapter = new MyBooksAdapter(this, new Nodes().myBooks());

        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter.cleanup();
    }

    @Override
    public void clicked(Book book) {
        Intent intent = new Intent(getActivity(), AddBookActivity.class);
        intent.putExtra("book", book);
        startActivity(intent);
    }

    @Override
    public void ready() {
        progressDialog.dismiss();
    }

}
