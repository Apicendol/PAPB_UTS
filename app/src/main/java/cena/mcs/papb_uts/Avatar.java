package cena.mcs.papb_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class Avatar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        Button btBack = (Button) this.findViewById(R.id.btBack);
        btBack.setOnClickListener((View.OnClickListener) v -> Avatar.this.finish());

        CheckBox _eyebrows = findViewById(R.id.eyebrows);
        ImageView _imgAlis = findViewById(R.id.imgAlis);

        CheckBox _eyes = findViewById(R.id.eyes);
        ImageView _imgMata = findViewById(R.id.imgMata);

        CheckBox _nose = findViewById(R.id.nose);
        ImageView _imgHidung = findViewById(R.id.imgHidung);

        CheckBox _mouth = findViewById(R.id.mouth);
        ImageView _imgMulut = findViewById(R.id.imgMulut);

        _eyebrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_imgAlis.getVisibility() == View.INVISIBLE) {
                    _imgAlis.setVisibility(View.VISIBLE);
                } else {
                    _imgAlis.setVisibility(View.INVISIBLE);
                }
            }
        });
        _eyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_imgMata.getVisibility() == View.INVISIBLE) {
                    _imgMata.setVisibility(View.VISIBLE);
                } else {
                    _imgMata.setVisibility(View.INVISIBLE);
                }
            }
        });
        _nose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_imgHidung.getVisibility() == View.INVISIBLE) {
                    _imgHidung.setVisibility(View.VISIBLE);
                } else {
                    _imgHidung.setVisibility(View.INVISIBLE);
                }
            }
        });
        _mouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_imgMulut.getVisibility() == View.INVISIBLE) {
                    _imgMulut.setVisibility(View.VISIBLE);
                } else {
                    _imgMulut.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}