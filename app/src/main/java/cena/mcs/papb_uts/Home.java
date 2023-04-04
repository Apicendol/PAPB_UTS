package cena.mcs.papb_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Button regist = (Button) this.findViewById(R.id.register);
        Button ava = (Button) this.findViewById(R.id.avatar);
        Button intent = (Button) this.findViewById(R.id.intent);
        Button rv = (Button) this.findViewById(R.id.recyclerView);

        ava.setOnClickListener(v -> {
            Intent avatar = new Intent(this, Avatar.class);
            this.startActivity(avatar);
        });

        intent.setOnClickListener(v -> {
            Intent in = new Intent(this, Intents.class);
            this.startActivity(in);
        });

        rv.setOnClickListener(v -> {
            Intent recyclerview = new Intent(this, Recycler.class);
            this.startActivity(recyclerview);
        });
    }
}