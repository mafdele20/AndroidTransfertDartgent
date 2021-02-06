package sn.simplon.transfertargent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button envoiebtn;
    private Button listeenvoiebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.envoiebtn = (Button) findViewById(R.id.envoie);

        envoiebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(getApplicationContext(), EmetteurActivity.class);
                startActivity(main);
                finish();
            }
        });

        this.listeenvoiebtn = (Button) findViewById(R.id.listerenvoies);

        listeenvoiebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(getApplicationContext(), ListeEnvoieActivity.class);
                startActivity(main);
                finish();
            }
        });
    }


}