package id.anekoinda.vaksini;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomDialog extends AppCompatActivity {
    TextView txt_nik, txt_nama, txt_telepon, txt_ttl, txt_jenkel, txt_kondisi;
    SharedPreferences preferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NIK = "nik";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_dialog);
        txt_nik = findViewById(R.id.txt_nik);
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String nik = preferences.getString(KEY_NIK, null);
        txt_nik.setText(nik);
    }
}