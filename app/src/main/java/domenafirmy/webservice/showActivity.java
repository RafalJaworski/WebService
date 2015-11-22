package domenafirmy.webservice;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RestAdapter;

public class showActivity extends AppCompatActivity{

    @Bind(R.id.imie)
    protected EditText pierwszeImie;

    @Bind(R.id.nazwisko)
    protected EditText nazwisko;

    @Bind(R.id.telefon)
    protected EditText telefon;

    @Bind(R.id.email)
    protected EditText email;

    @OnClick(R.id.zapisz)
    public void saveOnClick()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.zapisz)
    public void onClick()
    {
        //budujemy obj dostarczajacy nam implementacje naszych interfacow
        RestAdapter adapter   = new RestAdapter.Builder()
                .setEndpoint("https://szkolenie-android-kontakty.appspot.com/_ah/api")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }
}
