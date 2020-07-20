package com.dm.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getPreferences(Context.MODE_PRIVATE);

        Button saveBtn = findViewById(R.id.saveBtn);
        final EditText editText = findViewById(R.id.editText);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.edit()
                        .putString(getString(R.string.shared_pref_key_note), editText.getText().toString())
                        .apply();
            }
        });

        editText.setText(preferences.getString(getString(R.string.shared_pref_key_note), ""));
    }
}