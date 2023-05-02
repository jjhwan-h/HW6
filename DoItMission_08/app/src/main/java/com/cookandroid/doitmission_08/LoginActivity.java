package com.cookandroid.doitmission_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("로그인하기");

        final Button buttonLogin = findViewById(R.id.buttonLogin);
        final EditText editTextId = findViewById(R.id.editTextId);
        final EditText editTextPassword = findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextId.getText().length() == 0) {
                    Toast toast = Toast.makeText(getBaseContext(), "아이디를 입력하세요.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                if (editTextPassword.getText().length() == 0) {
                    Toast toast = Toast.makeText(getBaseContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == RESULT_OK) {
            String menu = intent.getStringExtra("menu");

            Toast toast = Toast.makeText(getBaseContext(), menu + " 화면에서 보낸 응답", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
