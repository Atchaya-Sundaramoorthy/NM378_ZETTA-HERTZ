package com.example.agrolens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.agrolens.Fragment.AccountFragment;
import com.example.agrolens.Fragment.CameraFragment;
import com.example.agrolens.Fragment.HomeFragment;

public class Dashboard extends AppCompatActivity {
    MeowBottomNavigation meo;
    private final static int Id_home=1;
    private final static int Id_camera=2;
    private final static int Id_account=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        meo=findViewById(R.id.bottomnavigation);
        meo.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        meo.add(new MeowBottomNavigation.Model(2,R.drawable.camera));
        meo.add(new MeowBottomNavigation.Model(3,R.drawable.account));
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new HomeFragment()).commit();

        meo.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
        meo.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment selected_fragment=null;
                switch (item.getId()){
                    case Id_home:
                        selected_fragment=new HomeFragment();
                        break;
                    case Id_camera:
                        selected_fragment=new CameraFragment();
                        break;
                    case Id_account:
                        selected_fragment=new AccountFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selected_fragment).commit();
            }
        });

    }
}