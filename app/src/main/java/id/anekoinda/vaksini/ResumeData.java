package id.anekoinda.vaksini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class ResumeData extends AppCompatActivity {
    TextView txt_nik, txt_nama, txt_telepon, txt_jenkel, txt_kondisi, txt_persentase;
    Button btn_resume;
    private static final String KEY_NIK = "nik";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_TELEPON = "telepon";
    private static final String KEY_JENKEL = "jenkel";
    private static final String KEY_KONDISI = "kondisi";
    private static final String KEY_PERSENTASE = "persentase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_data);

        txt_nik = findViewById(R.id.txt_nik);
        txt_nama = findViewById(R.id.txt_nama);
        txt_telepon =findViewById(R.id.txt_telepon);
        txt_jenkel = findViewById(R.id.txt_jenkel);
        txt_kondisi = findViewById(R.id.txt_kondisi);
        txt_persentase =findViewById(R.id.txt_persentase);
        btn_resume = findViewById(R.id.btn_resume);

        Bundle bundle = getIntent().getExtras();
        String nik = bundle.getString(KEY_NIK, null);
        String nama = bundle.getString(KEY_NAMA, null);
        String telepon = bundle.getString(KEY_TELEPON, null);
        String jenkel = bundle.getString(KEY_JENKEL, null);
        String kondisi = bundle.getString(KEY_KONDISI, null);
        String persentase = bundle.getString(KEY_PERSENTASE, null);

        txt_nik.setText(nik);
        txt_nama.setText(nama);
        txt_telepon.setText(telepon);
        txt_jenkel.setText(jenkel);
        txt_kondisi.setText(kondisi);
        txt_persentase.setText(persentase);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"Mengambil data kembali...", Toast.LENGTH_LONG).show(); //onDestroy Called
        Log.d(TAG, "resume");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(),"Menampilkan data...", Toast.LENGTH_LONG).show(); //onStart Called
        Log.d(TAG, "start");
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"Kembali ke pendaftaran...", Toast.LENGTH_LONG).show(); //onDestroy Called
        Log.d(TAG, "destroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Mengeluarkan aplikasi...", Toast.LENGTH_LONG).show();
        Log.d(TAG, "stop");
    }
}