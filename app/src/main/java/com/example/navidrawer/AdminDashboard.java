package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AdminDashboard extends AppCompatActivity {
    Button btnOrders, btnAdminFoodRequests, btnHome, btnDriverAssign, btnDr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        this.setTitle("Admin Dashboard");

        btnOrders = findViewById(R.id.btnOrders);
        btnAdminFoodRequests = findViewById(R.id.adminFoodRequests);
        Button btnNeeder = findViewById(R.id.btn_needer);
        Button btnVacancy = findViewById(R.id.btn_vacancy);
        btnHome = findViewById(R.id.btn_AssignDriver);
        btnDriverAssign = findViewById(R.id.btn_DriverAssign);
        btnDr = findViewById(R.id.btn_Dr);

        //Orders
        btnOrders.setOnClickListener(view -> {
            Intent i = new Intent(AdminDashboard.this, OrdersView.class);
            startActivity(i);
        });

        //Food Requests
        btnAdminFoodRequests.setOnClickListener(view -> {
            Intent i = new Intent(AdminDashboard.this,RecyclerviewDonAdList.class);
            startActivity(i);
        });

        //Needer
        btnNeeder.setOnClickListener(view -> {
            Intent intent = new Intent(AdminDashboard.this,page13NeederRegistration.class);
            startActivity(intent);
        });

        //Vacancies
        btnVacancy.setOnClickListener(view -> {
            Intent intent = new Intent(AdminDashboard.this,Page10AllVacancies.class);
            startActivity(intent);
        });

        //Home
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(AdminDashboard.this,MainActivity.class);
            startActivity(intent);
        });

        //Assign Driver
        btnDriverAssign.setOnClickListener(view -> {
            Intent intent = new Intent(AdminDashboard.this,AssignDriver.class);
            startActivity(intent);
        });

        //Driver
        btnDr.setOnClickListener(view -> {
            Intent intent = new Intent(AdminDashboard.this,UpdateDeliveryNotifications.class);
            startActivity(intent);
        });

        //Report


    }
}