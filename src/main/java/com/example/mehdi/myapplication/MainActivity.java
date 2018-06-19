package com.example.mehdi.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NfcAdapter nfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        // vérifie si l'appareil supporte le NFC et s'il est activé
        if (nfcAdapter == null) {
            Toast.makeText(this, "NFC n'est pas disponible :'(", Toast.LENGTH_LONG).show();
        } else if (nfcAdapter.isEnabled()) {
            Toast.makeText(this, "NFC activé", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "NFC non activé", Toast.LENGTH_LONG).show();
        }
        
        final ImageView UpArrowEntry = (ImageView) findViewById(R.id.flecheEntrée);
        final ImageView UpArrowC1 = (ImageView) findViewById(R.id.flecheC1);
        final ImageView UpArrowC2 = (ImageView) findViewById(R.id.flecheC2);
        final ImageView UpArrowC3 = (ImageView) findViewById(R.id.flecheC3);
        final ImageView UpArrowE1 = (ImageView) findViewById(R.id.flecheE1);
        final ImageView UpArrowE2 = (ImageView) findViewById(R.id.flecheE2);
        final ImageView UpArrowE3 = (ImageView) findViewById(R.id.flecheE3);
        final ImageView UpArrowG1 = (ImageView) findViewById(R.id.flecheG1);
        final ImageView UpArrowG2 = (ImageView) findViewById(R.id.flecheG2);
        final ImageView UpArrowG3 = (ImageView) findViewById(R.id.flecheG3);
        final ImageView UpArrowH1 = (ImageView) findViewById(R.id.flecheH1);
        final ImageView UpArrowH2 = (ImageView) findViewById(R.id.flecheH2);
        final ImageView UpArrowH3 = (ImageView) findViewById(R.id.flecheH3);
        final ImageView UpArrowGMP = (ImageView) findViewById(R.id.flecheGMP);
        final ImageView UpArrowAmphi = (ImageView) findViewById(R.id.flecheAmphi);
        final TextView InfoTAG = (TextView) findViewById(R.id.infoPos);
        UpArrowEntry.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowC1.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowC2.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowC3.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowE1.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowE2.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowE3.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowG1.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowG2.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowG3.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowH1.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowH2.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowH3.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowGMP.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        UpArrowAmphi.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
        InfoTAG.setVisibility(View.INVISIBLE); // définir nos infos de manière invisible
    }

    // création de l’intent et vérification de la disponibilité du "NFC" sur l’appareil pour ensuite
    // utiliser la méthode enableForegroundDispatch afin d'activer la réceptions de tags NFC pour notre activité.
    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, this.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        IntentFilter[] filters = null;
        String[][] techListArray = null;
        nfcAdapter.enableForegroundDispatch(this, pIntent, filters, techListArray);

    }

    //méthode contraire à enableForegroundDispatch, elle désactive la reception de tag NFC pour notre activité
    protected void onPause() {
        super.onPause();
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
    }

    //méthode gérant l’action à la suite de la réception d’un intent d’un tag NFC
    @Override
    protected void onNewIntent(Intent intent) {

        // Permet de notifier la reconnaissance d'un TAG NFC
        //Toast.makeText(this, "NFC intent reçu!", Toast.LENGTH_LONG).show();

        final ImageView UpArrowEntry = (ImageView) findViewById(R.id.flecheEntrée);
        final ImageView UpArrowC1 = (ImageView) findViewById(R.id.flecheC1);
        final ImageView UpArrowC2 = (ImageView) findViewById(R.id.flecheC2);
        final ImageView UpArrowC3 = (ImageView) findViewById(R.id.flecheC3);
        final ImageView UpArrowE1 = (ImageView) findViewById(R.id.flecheE1);
        final ImageView UpArrowE2 = (ImageView) findViewById(R.id.flecheE2);
        final ImageView UpArrowE3 = (ImageView) findViewById(R.id.flecheE3);
        final ImageView UpArrowG1 = (ImageView) findViewById(R.id.flecheG1);
        final ImageView UpArrowG2 = (ImageView) findViewById(R.id.flecheG2);
        final ImageView UpArrowG3 = (ImageView) findViewById(R.id.flecheG3);
        final ImageView UpArrowH1 = (ImageView) findViewById(R.id.flecheH1);
        final ImageView UpArrowH2 = (ImageView) findViewById(R.id.flecheH2);
        final ImageView UpArrowH3 = (ImageView) findViewById(R.id.flecheH3);
        final ImageView UpArrowGMP = (ImageView) findViewById(R.id.flecheGMP);
        final ImageView UpArrowAmphi = (ImageView) findViewById(R.id.flecheAmphi);
        final TextView InfoTAG = (TextView) findViewById(R.id.infoPos);
        final TextView RecupTag = (TextView) findViewById(R.id.datarecup);

        String action = intent.getAction();

        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);

            // only one message sent during the beam
            NdefMessage msg = (NdefMessage) rawMsgs[0];

            // record 0 contains the MIME type, record 1 is the AAR, if present
            Log.d("msg", msg.getRecords()[0].getPayload().toString());

            byte[] payload = msg.getRecords()[0].getPayload();
            String msgtext = null;

            try {

                //Get the Text Encoding
                String textEncoding = ((payload[0] & 0200) == 0) ? "UTF-8" : "UTF-16";

                //Get the Language Code
                int languageCodeLength = payload[0] & 0077;
                String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");

                //Get the Text
                msgtext = new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
                RecupTag.setText(msgtext);

                UpArrowEntry.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowC1.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowC2.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowC3.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowE1.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowE2.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowE3.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowG1.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowG2.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowG3.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowH1.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowH2.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowH3.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowGMP.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                UpArrowAmphi.setVisibility(View.INVISIBLE); // définir notre flèche de manière invisible
                InfoTAG.setVisibility(View.INVISIBLE); // définir nos infos de manière invisible
                switch(msgtext){

                    case"1":
                        UpArrowEntry.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Entrée de l'IUT\n\rEtage : RDC");
                        break;
                    case "2":
                        UpArrowC1.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Début bâtiment C\n\rEtage : RDC");
                        break;
                    case "3":
                        UpArrowC2.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Milieu bâtiment C\n\rEtage : RDC");
                        break;
                    case"4":
                        UpArrowC3.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Fin bâtiment C\n\rEtage : RDC");
                        break;
                    case"5":
                        UpArrowGMP.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Bâtiment GMP\n\rEtage : RDC");
                        break;
                    case"6":
                        UpArrowE1.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Début bâtiment E\n\rEtage : RDC");
                        break;
                    case"7":
                        UpArrowE2.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Milieu bâtiment E\n\rEtage : RDC");
                        break;
                    case"8":
                        UpArrowE3.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Fin bâtiment E\n\rEtage : RDC");
                        break;
                    case"9":
                        UpArrowG1.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Début bâtiment G\n\rEtage : RDC");
                        break;
                    case"10":
                        UpArrowG2.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Milieu bâtiment G\n\rEtage : RDC");
                        break;
                    case"11":
                        UpArrowG3.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Fin bâtiment G\n\rEtage : RDC");
                        break;
                    case"12":
                        UpArrowH1.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Début bâtiment H\n\rEtage : RDC");
                        break;
                    case"13":
                        UpArrowH2.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Milieu bâtiment H\n\rEtage : RDC");
                        break;
                    case"14":
                        UpArrowH3.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Fin bâtiment H\n\rEtage : RDC");
                        break;
                    case"15":
                        UpArrowAmphi.setVisibility(View.VISIBLE);
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Bâtiment Amphithéâtre\n\rEtage : RDC");
                        break;

                    default:
                        InfoTAG.setVisibility(View.VISIBLE);
                        InfoTAG.setText("Tag non valide");
                        break;
                }
            } catch (Exception e) { }
        }
    }
}


