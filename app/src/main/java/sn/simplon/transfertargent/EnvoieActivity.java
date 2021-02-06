package sn.simplon.transfertargent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.DTDHandler;

import java.util.Date;

public class EnvoieActivity extends AppCompatActivity {

    private Button envoitTxt;
    private TextView txt_envoie;
    private EditText montant;
    private String date;
    private EnvoieActivity env;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoie);
        this.env = this;
        this.envoitTxt =  findViewById(R.id.send);
        this.montant = findViewById(R.id.montant);

      envoitTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FaireEnvoie();
                AlertDialog.Builder popup = new AlertDialog.Builder(env);
                popup.setTitle("sucess");
                popup.setMessage("Envoie réussit");
                popup.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // new HttpRepTask().execute();
                        Toast.makeText(getApplicationContext(),"merci de votre fidélité",Toast.LENGTH_SHORT).show();
                        Intent env = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(env);
                        finish();
                    }
                });
                popup.show();

            }
        });
    }

    // Cette fonction nous permet de poster des donnes a notre api
    public void FaireEnvoie() {
        Emetteur emeteur = (Emetteur) getIntent().getSerializableExtra("emeteurObject");
            Recepteur recepteur = (Recepteur) getIntent().getSerializableExtra("recepteurObject");
        Envoie envoiee = new Envoie();
        envoiee.setMontant(Double.parseDouble(montant.getText().toString()));
        envoiee.setDate(new Date().toString());
        txt_envoie = (TextView) findViewById(R.id.txt_envoie);
        //new Gson().toJson(info);
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject envoie = new JSONObject();

        try {
            //C'est ici qu'on va preciser les param qu'on envoie a la partie back-end


            //renseigner les infos emetteur
            envoiee.setEmetteur(new JSONObject());
            envoiee.getEmetteur().put("nomE", emeteur.getNomE());
            envoiee.getEmetteur().put("prenomE", emeteur.getPrenomE());
            envoiee.getEmetteur().put("cinE", emeteur.getCinE());
            envoiee.getEmetteur().put("telE", emeteur.getTelE());

            //renseigner les infos recepteur
            envoiee.setRecepteur(new JSONObject());
            envoiee.getRecepteur().put("nomR", recepteur.getNomR());
            envoiee.getRecepteur().put("prenomR", recepteur.getPrenomR());
            envoiee.getRecepteur().put("telR", recepteur.getTelR());

            //renseigner les infos de l'envoie
            envoie.put("date",envoiee.getDate() );
            envoie.put("montant",envoiee.getMontant() );
            envoie.put("emetteur",envoiee.getEmetteur() );
            envoie.put("recepteur", envoiee.getRecepteur());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // URL pour acceder a l'api
        String url = "http://172.20.10.3:8088/envoie/api/add";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, envoie,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        txt_envoie.setText("String Response : "+ response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txt_envoie.setText("Error getting response");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }





}