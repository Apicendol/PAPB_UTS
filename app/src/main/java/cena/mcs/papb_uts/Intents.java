package cena.mcs.papb_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Intents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Button btWeb = (Button) this.findViewById(R.id.web);
        Button btCall = (Button) this.findViewById(R.id.call);
        Button btSms = (Button) this.findViewById(R.id.sms);
        EditText input = (EditText) this.findViewById(R.id.inputUser);

//        String inputUser = input.getText().toString();

        btWeb.setOnClickListener(v -> {
            Uri uri = Uri.parse("http://filkom.ub.ac.id");
            Intent it = new Intent(Intent.ACTION_VIEW, uri);
            this.startActivity(it);
        });

        btCall.setOnClickListener(v -> {
            String inputUser = input.getText().toString();
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + inputUser));
            this.startActivity(i);
        });

        btSms.setOnClickListener(v -> {
            String inputUser = input.getText().toString();
            Uri uri = Uri.parse("smsto:" + inputUser);
            Intent in = new Intent(Intent.ACTION_SENDTO, uri);
            in.putExtra("sms_body", "Hello!");
            this.startActivity(in);
        });
    }
}