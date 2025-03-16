package com.example.url;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.edit_text_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenBrowser();
            }
        });
    }

    private void OpenBrowser(){
        String adress = editText.getText().toString().trim();
        if(!adress.isEmpty())
        {
            Uri uri_adress = adress.contains("https://") ? Uri.parse(adress) : Uri.parse("https://"+adress);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri_adress);
            startActivity(Intent.createChooser(intent, "Выберите приложение"));
        }
        else
            Toast.makeText(this, "Текст пустой", Toast.LENGTH_SHORT).show();
    }
}