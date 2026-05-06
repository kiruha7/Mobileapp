package com.mirea.averinka.mireaproject;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private Fragment dataFragment;
    private Fragment webViewFragment;
    private Fragment backgroundTaskFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        dataFragment = new DataFragment();
        webViewFragment = new WebViewFragment();
        backgroundTaskFragment = new BackgroundTaskFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, dataFragment)
                    .commit();
            setTitle("Информация");
        }

        findViewById(R.id.buttonMenu).setOnClickListener(v ->
                drawerLayout.openDrawer(GravityCompat.START)
        );

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_data) {
                openFragment(dataFragment, "Информация");

            } else if (id == R.id.nav_webview) {
                openFragment(webViewFragment, "WebView");

            } else if (id == R.id.nav_background) {
                openFragment(backgroundTaskFragment, "Фоновая задача");
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    private void openFragment(Fragment fragment, String title) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .commit();
        setTitle(title);
    }
}