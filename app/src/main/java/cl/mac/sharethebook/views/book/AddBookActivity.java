package cl.mac.sharethebook.views.book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import cl.mac.sharethebook.R;
import cl.mac.sharethebook.data.CurrentUser;
import cl.mac.sharethebook.models.Book;

public class AddBookActivity extends AppCompatActivity implements BookCallback {

    EditText titleEt;
    EditText descriptionEt;
    private Switch aSwitch;
    Button saveBtn;
    private String bookKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        //declaracion de vistas
        titleEt = (EditText) findViewById(R.id.titleEt);
        descriptionEt = (EditText) findViewById(R.id.descriptionEt);
        aSwitch = (Switch) findViewById(R.id.shareSw);
        saveBtn = (Button) findViewById(R.id.saveBtn);

        //obtencion de intent book
        final Book book = (Book) getIntent().getSerializableExtra("book");

        if (book != null) {
            bookKey = book.getKey();
            getSupportActionBar().setTitle(book.getTitle());

            //seteo de vistas
            titleEt.setText(book.getTitle());
            descriptionEt.setText(book.getDescription());
            aSwitch.setChecked(book.isAvailability());

            if (!new CurrentUser().uid().equals(book.getUid())){
                saveBtn.setVisibility(View.GONE);
                aSwitch.setVisibility(View.GONE);
                titleEt.setEnabled(false);
                descriptionEt.setEnabled(false);
            }
        }

        //añade un book
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obtencion de inputs
                String title = titleEt.getText().toString();
                String description = descriptionEt.getText().toString();
                boolean availability = aSwitch.isChecked();

                new BookValidation(AddBookActivity.this).addBook(title, description, availability, book);
            }
        });

    }


    @Override
    public void success() {
        Toast.makeText(this, "Libro agregado y/o actualizado", Toast.LENGTH_SHORT).show();
    }


}
