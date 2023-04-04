package cena.mcs.papb_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        List<Mail> mails = new ArrayList<>();
        mails.add(new Mail("Ando", "Isi surat dari Ando..."));
        mails.add(new Mail("Andi", "Surat dari Andi..."));
        mails.add(new Mail("Afi", "Surat dari Afi..."));
        mails.add(new Mail("Alip", "Surat dari Alip..."));
        mails.add(new Mail("Diana", "Surat dari Diana..."));
        mails.add(new Mail("Neyla", "Surat dari Neyla..."));
        mails.add(new Mail("Ira", "Surat dari Ira..."));
        mails.add(new Mail("Silfi", "Surat dari Silfi..."));
        mails.add(new Mail("Shandra", "Surat dari Shandra..."));
        mails.add(new Mail("Tiyah", "Surat dari Tiyah..."));
        mails.add(new Mail("Silvy", "Surat dari Silvy..."));
        mails.add(new Mail("Herza", "Surat dari Herza..."));
        mails.add(new Mail("Icha", "Surat dari Icha..."));
        mails.add(new Mail("Patur", "Surat dari Patur..."));
        mails.add(new Mail("Duwik", "Surat dari Duwik..."));

        MailAdapter mAdapter = new MailAdapter(this, mails);

        RecyclerView rvMail = this.findViewById(R.id.rvMail);

        rvMail.setLayoutManager(new LinearLayoutManager(this));

        rvMail.setAdapter(mAdapter);

        EditText etFilter = this.findViewById(R.id.editTextFilter);
        etFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mAdapter.getFilter().filter(editable.toString());
            }
        });

        FloatingActionButton openDialog = (FloatingActionButton) this.findViewById(R.id.floatingActionButton);
        openDialog.setOnClickListener(v -> {
            Dialog dialog = new Dialog(Recycler.this);
            dialog.setContentView(R.layout.modal_add);
            EditText name = dialog.findViewById(R.id.nama);
            EditText pesan = dialog.findViewById(R.id.pesan);
            Button simpan = dialog.findViewById(R.id.save);

            simpan.setOnClickListener(v1 -> {
                String username = name.getText().toString();
                String userpesan = pesan.getText().toString();
                mails.add(new Mail(username, userpesan));
                mAdapter.notifyItemInserted(mails.size()-1);
                rvMail.scrollToPosition(mails.size()-1);
                dialog.dismiss();
            });
            dialog.show();
        });
    }
}