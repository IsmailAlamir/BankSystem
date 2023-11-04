package com.example.banksystem.ui.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.banksystem.R;
import com.example.banksystem.ui.Login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    View headerView;
    TextView navAccountNumber, navUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        fragmentManager = getSupportFragmentManager();

        bottomNavigationView=findViewById(R.id.bottom_nav);

        headerView = navigationView.getHeaderView(0);
        // TODO : make it dynamic
        navUsername = headerView.findViewById(R.id.username_nav_header);
        navUsername.setText("Ismail Al Amir");

        navAccountNumber = headerView.findViewById(R.id.account_number_nav_header);
        navAccountNumber.setText("134567890");


//        String accountNumberPlaceholder = getString(R.string.account_number_nav_header, "1234567890");
//        String usernamePlaceholder = getString(R.string.username_nav_header, "Ismail Al Amir");
//       Log.i("testing text : ", accountNumberPlaceholder);

//        accountNumber.setText("accountNumberPlaceholder");
//        username.setText("usernamePlaceholder");

//        String name="Ismail Al Amir";
//        String usernamePlaceholder = getString(R.string.username_nav_header);
//        String formattedUsername = String.format(usernamePlaceholder, name);
//        Log.i("testing text : ", formattedUsername);


        // default fragment (HomeFragment)
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, new HomeFragment())
                .commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                Fragment fragment = new HomeFragment();

                if(id == R.id.nav_home){
                    fragment = new HomeFragment();
                }
                if(id == R.id.nav_stats){
                    fragment = new StatsFragment();
                }
                if(id == R.id.nav_pay){
                    fragment = new PayFragment();
                }
                displayFragment(fragment);
                return true;
            }

        });




//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    // TODO : modify the navigation
//                int id= item.getItemId();
//                if(id == R.id.nav_home){
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.nav_host_fragment_content_main, new HomeFragment())
//                            .commit();
//                }
//
//                if(id == R.id.nav_pay){
//                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//
//                if(id == R.id.nav_stats){
//                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//                if(id == R.id.nav_sharing){
//                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//                if(id == R.id.nav_settings){
//                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//
//                drawerLayout.closeDrawer(GravityCompat.START);
//                return true;
//            }
//
//
//        });


}

    // Show-Hide the account number
    public void toggleVisibility(View view) {
        TextView accountNumberTextView = findViewById(R.id.account_number_nav_header);

        if (accountNumberTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            accountNumberTextView.setTransformationMethod(null);
            accountNumberTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_visibility_on, 0);
        } else {
            accountNumberTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_visibility_off, 0);
            accountNumberTextView.setTransformationMethod(new PasswordTransformationMethod());
        }
    }

    private void displayFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, fragment).commit();


    }

}