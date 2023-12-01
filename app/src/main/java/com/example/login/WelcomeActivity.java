package com.example.login;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.login.databinding.ActivityWelcomeBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class WelcomeActivity extends AppCompatActivity {
    HomeFragment homeFragment = new HomeFragment();
    DashboardFragment dashboardFragment = new DashboardFragment();
    NotificationsFragment notificationsFragment = new NotificationsFragment();
    WelcomeFragment welcomeFragment = new WelcomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnItemSelectedListener(navigationSelectedListener);

        String user = getIntent().getStringExtra("user");
        String userMail = getIntent().getStringExtra("userMail");
        Bundle bundle = new Bundle();
        bundle.putString("userName", user.toString());
        welcomeFragment.setArguments(bundle);
        dashboardFragment.setArguments(bundle);

        loadFragment(welcomeFragment);




    }

    private final NavigationBarView.OnItemSelectedListener navigationSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_home) {
                loadFragment(homeFragment);
                return true;
            } else if (itemId == R.id.navigation_dashboard) {
                loadFragment(dashboardFragment);
                return true;
            } else if (itemId == R.id.navigation_notifications) {
                loadFragment(notificationsFragment);
                return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment_activity_welcome, fragment);
        transaction.commit();
    }

}