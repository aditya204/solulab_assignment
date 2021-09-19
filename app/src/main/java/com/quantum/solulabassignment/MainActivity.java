package com.quantum.solulabassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.quantum.solulabassignment.fragments.CollectionFragment;
import com.quantum.solulabassignment.fragments.HomeFragment;
import com.quantum.solulabassignment.fragments.ProfileFragment;
import com.quantum.solulabassignment.fragments.ScanFragment;
import com.quantum.solulabassignment.fragments.WishlistFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        bottomNavigationView=findViewById( R.id.bottom_nav );
        getSupportFragmentManager().beginTransaction().replace( R.id.main_container,new HomeFragment() ).commit();
        bottomNavigationView.setSelectedItemId( R.id.nav_home );
        setNaviagtion();



    }


    private void setNaviagtion(){
        bottomNavigationView.setOnItemSelectedListener( new NavigationBarView.OnItemSelectedListener( ) {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){

                    case R.id.nav_home:
                        fragment=new HomeFragment();
                        break;
                    case R.id.nav_wishlist:
                        fragment=new WishlistFragment();
                        break;
                    case R.id.nav_scan:
                        fragment=new ScanFragment();
                        break;
                    case R.id.nav_collection:
                        fragment=new CollectionFragment();
                        break;
                    case R.id.nav_account:
                        fragment=new ProfileFragment();
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace( R.id.main_container,fragment ).commit();


                return true;
            }
        } );

    }
}