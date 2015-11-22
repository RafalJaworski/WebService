package domenafirmy.webservice;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.Bind;

public class contactAdapter extends RecyclerView.Adapter<contactAdapter.CityViewHolder>{

    private List<String> dane;
    private LayoutInflater inflater;

    public contactAdapter(Context context, List<String> dane) {
        this.dane = dane;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }


    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
