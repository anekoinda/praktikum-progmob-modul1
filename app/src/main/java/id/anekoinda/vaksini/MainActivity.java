package id.anekoinda.vaksini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    static int m=0;
    Button button_daftar;
    EditText input_nik, input_nama, input_telepon;
    CheckBox check_tidak, check_flu, check_hamil;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private static final String KEY_NIK = "nik";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_TELEPON = "telepon";
    private static final String KEY_JENKEL = "jenkel";
    private static final String KEY_KONDISI = "kondisi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_nik = findViewById(R.id.input_nik);
        input_nama = findViewById(R.id.input_nama);
        input_telepon = findViewById(R.id.input_telepon);
        button_daftar = findViewById(R.id.button_daftar);
        radioGroup = findViewById(R.id.radio_jenkel);
        check_tidak = findViewById(R.id.check_tidak);
        check_flu = findViewById(R.id.check_flu);
        check_hamil = findViewById(R.id.check_hamil);

        button_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog dialogFragment = new dialog();
                Bundle bundle = new Bundle();

                int selected_jenkel = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selected_jenkel);

                String m = "";
                if(check_flu.isChecked() && check_hamil.isChecked()){
                    m+= "Flu, Hamil";
                }
                else{
                    if(check_tidak.isChecked()) {
                        m += "Tidak ada keluhan";
                    }
                    if(check_flu.isChecked()) {
                        m += "Flu";
                    }
                    if(check_hamil.isChecked()) {
                        m += "Hamil";
                    }
                }
                bundle.putString(KEY_NIK, input_nik.getText().toString());
                bundle.putString(KEY_NAMA, input_nama.getText().toString());
                bundle.putString(KEY_TELEPON, input_telepon.getText().toString());
                bundle.putString(KEY_JENKEL, radioButton.getText().toString());
                bundle.putString(KEY_KONDISI, m);

                dialogFragment.setArguments(bundle);
                dialogFragment.show((MainActivity.this).getSupportFragmentManager(),"Image Dialog");
            }
        });
    }

}