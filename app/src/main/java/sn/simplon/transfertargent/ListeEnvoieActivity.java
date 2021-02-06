package sn.simplon.transfertargent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListeEnvoieActivity extends AppCompatActivity {


    private  ListView laliste ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_envoie);

        this.laliste = (ListView) findViewById(R.id.laliste);
        // Add the request to the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(ListeEnvoieActivity.this);
        String url ="http://172.20.10.3:8088/envoie/api/liste";
        List<Envoie> listeE = new ArrayList<>();

        // Request a string response from the provided URL.
        JsonArrayRequest JsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                 new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i=0; i < response.length(); i++) {
                                Envoie e = new Envoie();
                                JSONObject jsonobject = response.getJSONObject (i);
                                e.setId(jsonobject.getLong("id"));
                                e.setDate(jsonobject.getString("date"));
                                e.setMontant(jsonobject.getDouble("montant"));
                                e.setEmetteur( jsonobject.getJSONObject("emetteur"));
                                e.setRecepteur(jsonobject.getJSONObject("recepteur"));
                                listeE.add(e);
                                laliste.setAdapter(new EnvoieAdapter(ListeEnvoieActivity.this , listeE) );

                            }

                        }catch (JSONException ex){
                            ex.printStackTrace();
                        }
                        // Display the first 500 characters of the response string.
                       // String rest = response.toString();
                        //textView.setText("Response is: "+response );
                       // System.out.println(textView);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String er = error.toString();
                System.out.println(er);
            }

        });
        queue.add(JsonObjectRequest);

    }




}