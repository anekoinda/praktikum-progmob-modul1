package id.anekoinda.vaksini;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class dialog extends DialogFragment {
    TextView txt_nik, txt_nama, txt_telepon, txt_jenkel, txt_kondisi, txt_persentase;
    Button btn_resume;
    private static final String KEY_NIK = "nik";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_TELEPON = "telepon";
    private static final String KEY_JENKEL = "jenkel";
    private static final String KEY_KONDISI = "kondisi";
    private static final String KEY_PERSENTASE = "persentase";

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.fragment_dialog, null);

        txt_nik = v.findViewById(R.id.txt_nik);
        txt_nama = v.findViewById(R.id.txt_nama);
        txt_telepon = v.findViewById(R.id.txt_telepon);
        txt_jenkel = v.findViewById(R.id.txt_jenkel);
        txt_kondisi = v.findViewById(R.id.txt_kondisi);
        txt_persentase = v.findViewById(R.id.txt_persentase);
        btn_resume = v.findViewById(R.id.btn_resume);

        Bundle bundle = getArguments();
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

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);

        btn_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ResumeData.class);
                Bundle bundle = new Bundle();

                bundle.putString(KEY_NIK, nik);
                bundle.putString(KEY_NAMA, nama);
                bundle.putString(KEY_TELEPON, telepon);
                bundle.putString(KEY_JENKEL, jenkel);
                bundle.putString(KEY_KONDISI, kondisi);
                bundle.putString(KEY_PERSENTASE, persentase);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return builder.create();
    }
}