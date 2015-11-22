package domenafirmy.webservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit.RestAdapter;

public class MainActivity extends AppCompatActivity {

    //kliknij "adres bazowy webservice na clab.type
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter adapter   = new RestAdapter.Builder()
                .setEndpoint("https://szkolenie-android-kontakty.appspot.com/_ah/api")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }
}
