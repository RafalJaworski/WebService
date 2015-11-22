package domenafirmy.webservice;


import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ContactWebService {
    @GET("/list")
    public void listcontact (Callback<List<Contact>> callback);
}
