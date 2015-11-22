package domenafirmy.webservice;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class showActivity extends AppCompatActivity{

    @Bind(R.id.imie)
    private EditText pierwszeImie;

    @Bind(R.id.nazwisko)
    private EditText nazwisko;

    @Bind(R.id.telefon)
    private EditText telefon;

    @Bind(R.id.email)
    private EditText email;

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
}
