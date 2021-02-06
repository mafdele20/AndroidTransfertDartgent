package sn.simplon.transfertargent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;

import java.io.Serializable;

public class EmetteurActivity extends AppCompatActivity {

    private EditText  nomE;
    private EditText  prenomE;
    private EditText  telE;
    private EditText  cinE;

    private Button suivant1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emetteur);

        this.suivant1 = (Button) findViewById(R.id.suivant1);
        this.nomE = (EditText) findViewById(R.id.nom);
        this.prenomE = (EditText) findViewById(R.id.prenom);
        this.cinE = (EditText) findViewById(R.id.cin);
        this.telE = (EditText)  findViewById(R.id.telephone);

        suivant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emetteur em = new Emetteur();
                em.setNomE(nomE.getText().toString());
                em.setPrenomE(prenomE.getText().toString());
                em.setCinE(cinE.getText().toString());
                em.setTelE(telE.getText().toString());

                Intent emet = new Intent(getApplicationContext(), RecepteurActivity.class);
                emet.putExtra("emeteurObject", em);
                startActivity(emet);
                finish();
            }
        });
    }
}