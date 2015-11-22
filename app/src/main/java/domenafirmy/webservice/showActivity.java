package domenafirmy.webservice;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class showActivity extends AppCompatActivity{

    @Bind(R.id.imie)
    protected EditText pierwszeImie;

    @Bind(R.id.nazwisko)
    protected EditText nazwisko;

    @Bind(R.id.telefon)
    protected EditText telefon;

    @Bind(R.id.email)
    protected EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.zapisz)
    public void onClick(final View v)
    {
        //zabezpieczenie przed ponownym kliknienciem
        v.setEnabled(false);

        //budujemy obj dostarczajacy nam implementacje naszych interfacow
        RestAdapter adapter   = new RestAdapter.Builder()
                .setEndpoint("https://szkolenie-android-kontakty.appspot.com/_ah/api")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        ContactWebService webService = adapter.create(ContactWebService.class);

        //obj do wyslania na server
        Contact contact = new Contact();
        contact.setImie(pierwszeImie.getText().toString());
        contact.setNazwisko(nazwisko.getText().toString());
        contact.setNumerTelefonu(telefon.getText().toString());
        contact.setAdresEmail(email.getText().toString());

        //wyslanie obiektu na server
        webService.addContact(contact, new Callback<Void>() {
            @Override
            public void success(Void aVoid, Response response) {
                finish();
            }

            @Override
            public void failure(RetrofitError error) {
                v.setEnabled(true);
                Toast.makeText(showActivity.this,"wystapił błąd",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
