package com.example.flap;

import static androidx.navigation.Navigation.findNavController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.flap.ui.Cart.CartActivity;
import com.example.flap.ui.DrawerSection.CustomerService.CustomerServiceActivity;
import com.example.flap.ui.DrawerSection.Notification.NotificationActivity;
import com.example.flap.ui.DrawerSection.YourOrder.YourOrderActivity;
import com.example.flap.ui.DrawerSection.merchants.authentic.LoginActivity;
import com.example.flap.ui.DrawerSection.LegalAndAbout.LegalAndAboutActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_menu);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.my_account:
                Toast.makeText(this, "My Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_order:
                startActivity(new Intent(MainActivity.this, YourOrderActivity.class));
                break;
            case R.id.notification:
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;
            case R.id.wish_list:
                Toast.makeText(this, "Wishlist", Toast.LENGTH_SHORT).show();
                break;
            case R.id.merchants:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

                break;
            case R.id.delivery_partner:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.customer_service:
                startActivity(new Intent(MainActivity.this, CustomerServiceActivity.class));
                break;
            case R.id.legal_and_about:
                startActivity(new Intent(MainActivity.this, LegalAndAboutActivity.class));
                break;
            case R.id.log_out:
                FirebaseAuth.getInstance().signOut();
                finish();
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem, menuItem1, menuItem2;
        menuItem = menu.findItem(R.id.search);
        menuItem1 = menu.findItem(R.id.cart);
        menuItem2 = menu.findItem(R.id.notificationBell);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Here..");
        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();

                searchView.clearFocus();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };

        searchView.setOnQueryTextListener(queryTextListener);

        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
                return true;
            }
        });
        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "clicked on Notification", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}