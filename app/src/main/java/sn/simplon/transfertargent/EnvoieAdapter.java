package sn.simplon.transfertargent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class EnvoieAdapter extends BaseAdapter {
    private Context context;
    private List<Envoie> envoieList;
    LayoutInflater inflater;

    public EnvoieAdapter(Context context, List<Envoie> envoieList) {
        this.context = context;
        this.envoieList = envoieList;
        this.inflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return envoieList.size();
    }

    @Override
    public Envoie getItem(int position) {
        return envoieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adapter_item, null);
        // recuperer les infos à propos l'item
        Envoie courrent_envoie = getItem(position);

        String date  = courrent_envoie.getDate();
        Double montant = courrent_envoie.getMontant();
        JSONObject em = courrent_envoie.getEmetteur();
        JSONObject recep = courrent_envoie.getRecepteur();


        TextView itemViewDate = convertView.findViewById(R.id.date);
        itemViewDate.setText("Date :"+date);
        TextView itemViewMontant = convertView.findViewById(R.id.montant);
        itemViewMontant.setText("Montant :"+montant +"fcfa");
        TextView itemViewEmetteur = convertView.findViewById(R.id.emetteur);
        TextView itemViewRecepteur = convertView.findViewById(R.id.recepteur);

        try {
            itemViewEmetteur.setText("Émeteur : "+em.getString("prenomE")+" "+ em.getString("nomE"));
            itemViewRecepteur.setText("Recepteur : "+recep.getString("prenomR")+" "+ recep.getString("nomR"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return convertView;
    }
}
