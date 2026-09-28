package com.herdiawan.f52124016.aplikasi_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PahlawanAdapter extends ArrayAdapter<Pahlawan> {
    private final LayoutInflater inflater;

    public PahlawanAdapter(Context context, List<Pahlawan> data) {
        super(context, 0, data);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_pahlawan, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Pahlawan p = getItem(position);
        if (p != null) {
            holder.imgPahlawan.setImageResource(p.getGambar());
            holder.tvNama.setText(p.getNama());
            holder.tvKeterangan.setText(p.getKeterangan());
            holder.tvAsal.setText(p.getAsal());
        }
        return convertView;
    }

    private static class ViewHolder {
        ImageView imgPahlawan;
        TextView tvNama, tvKeterangan, tvAsal;

        ViewHolder(View view) {
            imgPahlawan = view.findViewById(R.id.imgPahlawan);
            tvNama = view.findViewById(R.id.tvNama);
            tvKeterangan = view.findViewById(R.id.tvKeterangan);
            tvAsal = view.findViewById(R.id.tvAsal);
        }
    }
}
