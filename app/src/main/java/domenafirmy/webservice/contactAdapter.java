package domenafirmy.webservice;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;

public class contactAdapter extends RecyclerView.Adapter<contactAdapter.CityViewHolder>{

    private List<Contact> dane;
    private LayoutInflater inflater;

    public contactAdapter(Context context, List<Contact> dane) {
        this.dane = dane;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_contact,null);
        return new CityViewHolder(view);

    }


    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        Contact item = dane.get(position);

        holder.imienazwisko.setText(String.format("%s %s",item.getImie(),item.getNazwisko()));
        holder.numerTel.setText(item.getNumerTelefonu());
        holder.adresEmail.setText(item.getAdresEmail());
    }

    @Override
    public int getItemCount() {
        return dane.size();
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.imie_nazwisko)
        private TextView imienazwisko;
        @Bind(R.id.numer_telefonu)
        private TextView numerTel;
        @Bind(R.id.adres_email)
        private TextView adresEmail;
        public CityViewHolder(View itemView) {
            super(itemView);
        }
    }
}
