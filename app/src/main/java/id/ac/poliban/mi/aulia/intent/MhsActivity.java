package id.ac.poliban.mi.aulia.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MhsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhs);

        EditText etNim = findViewById(R.id.edNim);
        EditText etNama = findViewById(R.id.edNama);
        EditText etAlamat = findViewById(R.id.edAlamat);
        EditText etTelp = findViewById(R.id.edTelp);
        Button btSend = findViewById(R.id.btSend);



        btSend.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("nim", etNim.getText().toString());
            intent.putExtra("nama", etNama.getText().toString());
            intent.putExtra("alamat", etAlamat.getText().toString());
            intent.putExtra("telp", etTelp.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });



        if(getSupportActionBar() != null)
            getSupportActionBar().setTitle("Input Data");
    }
}
