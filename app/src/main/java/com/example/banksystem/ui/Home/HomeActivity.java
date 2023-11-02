package com.example.banksystem.ui.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.banksystem.R;
import com.example.banksystem.ui.Login.LoginActivity;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navView;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.navigation_view);
        fragmentManager = getSupportFragmentManager();


        // default fragment (HomeFragment)
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, new HomeFragment())
                .commit();
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    // TODO : modify the navigation
                int id= item.getItemId();
                if(id == R.id.nav_personal_information){
                    fragmentManager.beginTransaction()
                            .replace(R.id.nav_host_fragment_content_main, new HomeFragment())
                            .commit();
                }

                if(id == R.id.nav_account_management){
                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

                if(id == R.id.nav_notifications){
                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                if(id == R.id.nav_sharing){
                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                if(id == R.id.nav_settings){
                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


                // Close the drawer
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }


        });

}
}