package com.mirea.averinka.mireaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Fragment dataFragment;
    private Fragment webViewFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dataFragment = new DataFragment();
        webViewFragment = new WebViewFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, dataFragment)
                    .commit();
            toolbar.setTitle("Информация");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_menu) {
            showPopupMenu();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, toolbar);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(menuItem -> {
            int id = menuItem.getItemId();

            if (id == R.id.nav_data) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, dataFragment)
                        .commit();
                toolbar.setTitle("Информация");
                return true;
            } else if (id == R.id.nav_webview) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, webViewFragment)
                        .commit();
                toolbar.setTitle("WebView");
                return true;
            }

            return false;
        });

        popupMenu.show();
    }
}