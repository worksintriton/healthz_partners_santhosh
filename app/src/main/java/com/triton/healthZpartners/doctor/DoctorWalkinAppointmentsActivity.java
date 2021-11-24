package com.triton.healthZpartners.doctor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.triton.healthZpartners.R;
import com.triton.healthZpartners.activity.NotificationActivity;
import com.triton.healthZpartners.fragmentdoctor.walkinappointments.FragmentDoctorWalkinCompletedAppointment;
import com.triton.healthZpartners.fragmentdoctor.walkinappointments.FragmentDoctorWalkinMissedAppointment;
import com.triton.healthZpartners.fragmentdoctor.walkinappointments.FragmentDoctorWalkinNewAppointment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorWalkinAppointmentsActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "DoctorWalkinAppointmentsActivity";

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tablayout)
    TabLayout tablayout;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.viewPager)
    ViewPager viewPager;



    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.include_doctor_footer)
    View include_doctor_footer;


    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.include_doctor_header)
    View include_doctor_header;



    String orders;
    private int someIndex = 0;


    @SuppressLint({"LogNotTimber", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_walkinappointments);
        Log.w(TAG,"onCreate");
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            orders = bundle.getString("orders");
            Log.w(TAG,"orders : "+orders);
        }



        ImageView img_back = include_doctor_header.findViewById(R.id.img_back);
        ImageView img_notification = include_doctor_header.findViewById(R.id.img_notification);
        ImageView img_cart = include_doctor_header.findViewById(R.id.img_cart);
        ImageView img_profile = include_doctor_header.findViewById(R.id.img_profile);
        TextView toolbar_title = include_doctor_header.findViewById(R.id.toolbar_title);
        toolbar_title.setText(getResources().getString(R.string.walking_appointments));
        img_cart.setVisibility(View.GONE);

        img_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
            }
        });

        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new Intent(getApplicationContext(), DoctorProfileScreenActivity.class));
                intent.putExtra("fromactivity",TAG);
                startActivity(intent);
            }
        });

        setupViewPager(viewPager);
        if(orders != null && orders.equalsIgnoreCase("New")){
            someIndex = 0;
        }
        else if(orders != null && orders.equalsIgnoreCase("Completed")){
            someIndex = 1;
        }
        else if(orders != null && orders.equalsIgnoreCase("Cancelled")){
            someIndex = 2;
        }

        tablayout.setupWithViewPager(viewPager);
        TabLayout.Tab tab = tablayout.getTabAt(someIndex);
        tab.select();

        img_back.setOnClickListener(v -> onBackPressed());





    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentDoctorWalkinNewAppointment(), "New");
        adapter.addFragment(new FragmentDoctorWalkinCompletedAppointment(), "Completed");
        adapter.addFragment(new FragmentDoctorWalkinMissedAppointment(), "Cancelled");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(DoctorWalkinAppointmentsActivity.this, DoctorDashboardActivity.class);
        startActivity(i);
        finish();
    }
    public void callDirections(String tag){
        Intent intent = new Intent(getApplicationContext(), DoctorDashboardActivity.class);
        intent.putExtra("tag",tag);
        startActivity(intent);
        finish();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.rl_homes:
                callDirections("1");
                break;

            case R.id.rl_home:
                callDirections("1");
                break;

            case R.id.rl_shop:
                callDirections("2");
                break;

            case R.id.rl_comn:
                callDirections("3");
                break;

        }

    }
    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public @NotNull Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}