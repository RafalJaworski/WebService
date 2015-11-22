package domenafirmy.webservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    //kliknij "adres bazowy webservice na clab.type
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Log.d("webservice","Liczba kontaktow");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("webservice","Liczba błą");
            }
        });
    }


}
