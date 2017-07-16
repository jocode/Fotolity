package com.example.fotolity.views;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.fotolity.R;
import com.example.fotolity.views.fragment.HomeFragment;
import com.example.fotolity.views.fragment.ProfileFragment;
import com.example.fotolity.views.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        /**
         * Implementamos la Barra de navegación inferior
         */
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = new HomeFragment();
            switch (item.getItemId()) {
                case R.id.search:
                    fragment = new SearchFragment();
                    replaceFragment(fragment);
                    return true;

                case R.id.home:
                    fragment = new HomeFragment();
                    replaceFragment(fragment);
                    return true;

                case R.id.profile:
                    fragment = new ProfileFragment();
                    replaceFragment(fragment);
                    return true;
                default:
                    replaceFragment(fragment);
                    break;
            }
            return false;
        }

    };

    public void replaceFragment(Fragment  fragment){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

}
