package domenafirmy.webservice;


import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ContactWebService {
    @GET("/list")
    public void listcontact (Callback<ContactListResponse> callback);

    //przekazujemy kontakt do domadnia
    //mowimy ze ten m=parametr ma byc przekazany jako tresc
    //retrofit wykona to w sobnym watku
    @POST("/add")
    public void addContact(@Body Contact contact,Callback<Void> callback);

    //webservice nie zwraca nam listy wiec piszemy klase do zwracania
    public static class ContactListResponse
    {
        private List<Contact> items;

        public List<Contact> getItems() {
            return items;
        }

        public void setItems(List<Contact> items) {
            this.items = items;
        }




    }
}
