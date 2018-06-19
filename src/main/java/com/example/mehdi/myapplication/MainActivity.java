package com.example.mehdi.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NfcAdapter nfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        // vérifie si l'appareil supporte le NFC et s'il est activé
        if(nfcAdapter == null){
            Toast.makeText(this, "NFC n'est pas disponible :'(", Toast.LENGTH_LONG).show();
        }else if(nfcAdapter.isEnabled()){
            Toast.makeText(this, "NFC activé", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "NFC non activé", Toast.LENGTH_LONG).show();
        }

        final ImageView UpArrow = (ImageView) findViewById(R.id.fleche);
        UpArrow.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
    }

        // création de l’intent et vérification de la disponibilité du "NFC" sur l’appareil pour ensuite
        // utiliser la méthode enableForegroundDispatch afin d'activer la réceptions de tags NFC pour notre activité.
        @Override
        protected void onResume() {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            IntentFilter[] intentFilter = new IntentFilter[]{};

            if(nfcAdapter != null) {
                nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter, null);
            }
            super.onResume();
        }

        //méthode contraire à enableForegroundDispatch, elle désactive la reception de tag NFC pour notre activité
        protected void onPause() {
            if (nfcAdapter != null) {
                nfcAdapter.disableForegroundDispatch(this);
            }
            super.onPause();
        }

        //méthode gérant l’action à la suite de la réception d’un intent d’un tag NFC
        @Override
        protected void onNewIntent(Intent intent) {
            // Permet de notifier la reconnaissance d'un TAG NFC
            Toast.makeText(this, "NFC intent reçu!", Toast.LENGTH_LONG).show();
            final ImageView UpArrow = (ImageView) findViewById(R.id.fleche);
            UpArrow.setVisibility(View.VISIBLE); // définir notre flèche de manière visible lorsqu'un intent est détecté
            super.onNewIntent(intent);

        }
    }
