package com.cookandroid.mission7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    Button customer;
    Button sales;
    Button goods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setTitle("2021076029 장정환");

        customer = findViewById(R.id.b_customer);
        sales = findViewById(R.id.b_sales);
        goods = findViewById(R.id.b_goods);

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(),"고객 관리",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(),"매출 관리",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(),"상품 관리",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
