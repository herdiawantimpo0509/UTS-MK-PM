package com.herdiawan.f52124016.aplikasi_uts;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private PahlawanAdapter adapter;
    private final ArrayList<Pahlawan> semuaPahlawan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listViewPahlawan);
        EditText etSearch = findViewById(R.id.etSearch);

        isiDataPahlawan();
        adapter = new PahlawanAdapter(this, new ArrayList<>(semuaPahlawan));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Pahlawan p = adapter.getItem(position);
            if (p != null) {
                Toast.makeText(this, p.getNama() + "\n" + p.getAsal(), Toast.LENGTH_SHORT).show();
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterPahlawan(s.toString());
            }
            @Override public void afterTextChanged(Editable s) { }
        });
    }

    private void isiDataPahlawan() {
        semuaPahlawan.add(new Pahlawan(
                "KH. Ahmad Dahlan", "Pahlawan Nasional", "Yogyakarta",
                R.drawable.ahmad_dahlan));
        semuaPahlawan.add(new Pahlawan(
                "Jenderal Ahmad Yani", "Pahlawan Revolusi", "Jawa Tengah",
                R.drawable.ahmad_yani));
        semuaPahlawan.add(new Pahlawan(
                "Bung Tomo", "Pahlawan Nasional", "Jawa Timur",
                R.drawable.bung_tomo));
        semuaPahlawan.add(new Pahlawan(
                "Jenderal Gatot Subroto", "Pahlawan Nasional", "Jawa Tengah",
                R.drawable.gatot_subroto));
        semuaPahlawan.add(new Pahlawan(
                "Ki Hadjar Dewantara", "Pahlawan Nasional", "Yogyakarta",
                R.drawable.ki_hadjar_dewantara));
        semuaPahlawan.add(new Pahlawan(
                "Mohammad Hatta", "Pahlawan Nasional", "Sumatera Barat",
                R.drawable.mohammad_hatta));
        semuaPahlawan.add(new Pahlawan(
                "Jenderal Sudirman", "Pahlawan Nasional", "Jawa Tengah",
                R.drawable.sudirman));
        semuaPahlawan.add(new Pahlawan(
                "Soekarno", "Pahlawan Nasional", "Jawa Timur",
                R.drawable.sukarno));
        semuaPahlawan.add(new Pahlawan(
                "Prof. Soepomo", "Pahlawan Nasional", "Jawa Tengah",
                R.drawable.supomo));
    }

    private void filterPahlawan(String keyword) {
        String query = keyword.trim().toLowerCase();
        List<Pahlawan> hasil = new ArrayList<>();
        for (Pahlawan p : semuaPahlawan) {
            if (p.getNama().toLowerCase().contains(query)
                    || p.getAsal().toLowerCase().contains(query)) {
                hasil.add(p);
            }
        }
        adapter.clear();
        adapter.addAll(hasil);
        adapter.notifyDataSetChanged();
    }
}
