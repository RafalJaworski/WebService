package domenafirmy.webservice;


import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ContactWebService {
    @GET("/list")
    public void listcontact (Callback<ContactListResponse> callback);

    public void addContact();

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
