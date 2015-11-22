package domenafirmy.webservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.lista_kontaktow)
    protected RecyclerView recyclerView;
    //kliknij "adres bazowy webservice na clab.type
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //budujemy obj dostarczajacy nam implementacje naszych interfacow
        RestAdapter adapter   = new RestAdapter.Builder()
                .setEndpoint("https://szkolenie-android-kontakty.appspot.com/_ah/api")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        //z adaptera pobieramy implementacje concatcWebservice
        ContactWebService webService = adapter.create(ContactWebService.class);

        webService.listcontact(new Callback<ContactWebService.ContactListResponse>() {
            @Override
            public void success(ContactWebService.ContactListResponse contactListResponse, Response response) {
                contactAdapter listAdapter =
                        new contactAdapter(MainActivity.this, contactListResponse.getItems());
                recyclerView.setAdapter(listAdapter);
                Log.d("webservice","Liczba kontaktow");
            }

            @Override
            public void failure(RetrofitError error) {
                //MainActivity this bo this to jest callback teraz wiec musimy miec this z aktywnosci
                Toast.makeText(MainActivity.this,"Błąd",Toast.LENGTH_SHORT).show();
                Log.d("webservice","Liczba błą");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.open_form)
        {
            Intent intent  = new Intent(this, showActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
