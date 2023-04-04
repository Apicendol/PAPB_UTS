package cena.mcs.papb_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MailAdapter extends RecyclerView.Adapter implements Filterable {

    private final Context ctx;
    private List<Mail> mails;
    private List<Mail> mailsFilter;

    public MailAdapter(Context ctx, List<Mail> mails) {
        this.ctx = ctx;
        this.mails = mails;
        this.mailsFilter = mails;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence search) {
                FilterResults results = new FilterResults();
                if (search.toString().length() == 0) {
                    results.values = mails;
                    results.count = mails.size();
                } else {
                    List<Mail> difilter = new ArrayList<>();
                    String key = search.toString().toLowerCase();
                    for (Mail m : mails) {
                        if (m.nama.toLowerCase().contains(key) || m.isi.contains(key))
                            difilter.add(m);
                    }
                    if (difilter.isEmpty()) {
                        Toast.makeText(ctx.getApplicationContext(),"Pencarian Tidak Ditemukan", Toast.LENGTH_SHORT).show();
                    }
                    results.values = difilter;
                    results.count = difilter.size();
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mailsFilter = (List<Mail>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class VHMail extends RecyclerView.ViewHolder {
        private TextView tvInisial;
        private TextView tvNama;
        private TextView tvExcerpt;

        public VHMail(View rowView) {
            super(rowView);
            this.tvInisial = rowView.findViewById(R.id.tvInisial);
            this.tvNama = rowView.findViewById(R.id.tvNama);
            this.tvExcerpt = rowView.findViewById(R.id.tvExcerpt);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(this.ctx).inflate(R.layout.row_content, parent, false);
        return new VHMail(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VHMail vh = (VHMail) holder;
        Mail m = this.mailsFilter.get(position);
        vh.tvNama.setText(m.nama);
        vh.tvExcerpt.setText(m.isi);
        vh.tvInisial.setText(m.inisial());
    }

    @Override
    public int getItemCount() {
        return this.mailsFilter.size();
    }
}
