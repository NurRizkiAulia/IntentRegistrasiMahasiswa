package id.ac.poliban.mi.aulia.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1000;
    private String mhs;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);assert data != null;

        if(requestCode==REQUEST_CODE && resultCode == Activity.RESULT_OK && data.getExtras() != null)
            mhs =  "NIM     : " + data.getStringExtra("nim") + "\n";
            mhs += "Nama    : " +data.getStringExtra("nama") + "\n";
            mhs += "Alamat  : " +data.getStringExtra("alamat") + "\n";
            mhs += "Telp    : " +data.getStringExtra("telp") + "\n";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btShowInput = findViewById(R.id.btShowInput);
        Button btShowMhs = findViewById(R.id.btShowMhs);


        btShowInput.setOnClickListener(v -> {
            Intent intent = new Intent(this, MhsActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });

        btShowMhs.setOnClickListener(v -> {
            new  AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage(mhs)
                    .setPositiveButton("OK", null).show();
        });

    }
}
