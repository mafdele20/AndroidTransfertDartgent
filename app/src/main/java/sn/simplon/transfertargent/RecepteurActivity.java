package sn.simplon.transfertargent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import java.io.Serializable;

public class RecepteurActivity extends AppCompatActivity {
    private EditText nomR;
    private EditText  prenomR;
    private EditText  telR;
    private Button suivant2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepteur);
        this.suivant2 = (Button) findViewById(R.id.suivant2);

        this.suivant2 = (Button) findViewById(R.id.suivant2);
        this.nomR= (EditText) findViewById(R.id.nomR);
        this.prenomR= (EditText) findViewById(R.id.prenomR);
        this.telR = (EditText)  findViewById(R.id.telephoneR);
        //Recuperation de l'objet emeteur

        suivant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Recepteur recepteur = new Recepteur();
                recepteur.setNomR(nomR.getText().toString());
                recepteur.setPrenomR(prenomR.getText().toString());
                recepteur.setTelR(telR.getText().toString());

                Intent env = new Intent(getApplicationContext(), EnvoieActivity.class);
                Emetteur emeteur = (Emetteur) getIntent().getSerializableExtra("emeteurObject");
                //Pour passer l'objet emeteur a l'activite suivant
                env.putExtra("emeteurObject",  emeteur);
                env.putExtra("recepteurObject", recepteur);
                startActivity(env);
                finish();
            }
        });
    }
}