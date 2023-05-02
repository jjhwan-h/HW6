package com.cookandroid.doitmission_08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setTitle("메인메뉴");

        final Button buttonCustomer = findViewById(R.id.buttonCustomer);
        final Button buttonSales = findViewById(R.id.buttonSales);
        final Button buttonProduct = findViewById(R.id.buttonProduct);

        buttonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        buttonSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SalesActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        buttonProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        String menu = intent.getStringExtra("menu");

        if (menu != null) {
            Toast toast = Toast.makeText(getBaseContext(), menu + " 화면에서 보낸 응답", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
