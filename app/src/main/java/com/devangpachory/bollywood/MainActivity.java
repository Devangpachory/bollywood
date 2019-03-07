package com.devangpachory.bollywood;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("com.devangpachory.bollywood", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", editText.getText().toString().trim());
        editor.putBoolean("bool", true);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("com.devangpachory.bollywood", MODE_PRIVATE);
        String s = sharedPreferences.getString("name", "user");
        Boolean remember = sharedPreferences.getBoolean("bool", false);
        Toast.makeText(this, "bool" + remember, Toast.LENGTH_SHORT).show();
        editText.setText(s);

    }
}
