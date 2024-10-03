package com.example.tutorialapp.intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tutorialapp.R;

public class IntentExplicito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_explicito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button btnComprar = findViewById(R.id.btnComprar);
        EditText editTextComida = findViewById(R.id.textInputComida);
        EditText editTextBebida = findViewById(R.id.textInputBebida);



        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentExplicito.this, IntentImplicito.class);
                intent.putExtra("prueba", "Hamburguesa");
                intent.putExtra("comida", editTextComida.getText().toString());
                intent.putExtra("bebida", editTextBebida.getText().toString());
                startActivity(intent);
            }

        });
    }
}