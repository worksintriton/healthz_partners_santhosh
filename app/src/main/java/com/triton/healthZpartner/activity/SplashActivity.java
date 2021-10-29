package com.triton.healthZpartner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;


import com.triton.healthZpartner.R;
import com.triton.healthZpartner.doctor.DoctorDashboardActivity;
import com.triton.healthZpartner.doctor.DoctorMyOrdrersActivity;

import com.triton.healthZpartner.doctor.DoctorWalkinAppointmentsActivity;
import com.triton.healthZpartner.petlover.PetLoverDashboardActivity;
import com.triton.healthZpartner.petlover.PetMyOrdrersNewActivity;
import com.triton.healthZpartner.petlover.PetMyappointmentsActivity;
import com.triton.healthZpartner.petlover.PetWalkinappointmentsActivity;
import com.triton.healthZpartner.serviceprovider.ServiceProviderDashboardActivity;
import com.triton.healthZpartner.serviceprovider.shop.SPMyOrdrersActivity;
import com.triton.healthZpartner.sessionmanager.SessionManager;
import com.triton.healthZpartner.vendor.VendorDashboardActivity;

import java.util.HashMap;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";
    private static final long SPLASH_TIME_OUT = 3000;
    private SessionManager session;
    private String usertype;

    Boolean isNotifications = false;

    @SuppressLint("LogNotTimber")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        session = new SessionManager(getApplicationContext());
        boolean islogedin = session.isLoggedIn();
        Log.w(TAG,"islogedin-->"+islogedin);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            for(String key: bundle.keySet()){
                Log.w(TAG,"key : "+key);

            }
            isNotifications = true;
            Log.w(TAG,"bundle usertype : "+ bundle.getString("usertype"));
            Log.w(TAG,"bundle appintments : "+ bundle.getString("appintments"));
            Log.w(TAG,"bundle orders : "+ bundle.getString("orders"));

            String user_type = bundle.getString("usertype");
            String appintments = bundle.getString("appintments");
            String orders = bundle.getString("orders");

            if(user_type == null){
                HashMap<String, String> user = session.getProfileDetails();
                user_type = user.get(SessionManager.KEY_TYPE);
                Log.w(TAG,"user_type if :"+user_type);
            }else{
                user_type = bundle.getString("usertype");
                Log.w(TAG,"user_type else :"+user_type);
            }

            if(!islogedin) {
              /*  Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();*/
                Intent i = new Intent(SplashActivity.this, SliderAfterSplashActivity.class);
                startActivity(i);
                finish();
            }else{
                if(user_type != null){
                    if(user_type.equalsIgnoreCase("1")){
                        if(appintments != null && !appintments.isEmpty()){
                            if(appintments.equalsIgnoreCase("Walkin")){
                                Intent intent = new Intent(SplashActivity.this, PetWalkinappointmentsActivity.class);
                                intent.putExtra("appintments",appintments);
                                startActivity(intent);
                                finish();
                            }else{
                                Intent intent = new Intent(SplashActivity.this, PetMyappointmentsActivity.class);
                                intent.putExtra("appintments",appintments);
                                startActivity(intent);
                                finish();
                            }

                        }else if(orders != null && !orders.isEmpty()){
                            Intent intent = new Intent(SplashActivity.this, PetMyOrdrersNewActivity.class);
                            intent.putExtra("orders",orders);
                            startActivity(intent);
                            finish();
                        }else{
                            Intent intent = new Intent(SplashActivity.this, PetLoverDashboardActivity.class);
                            startActivity(intent);
                            finish();
                        }


                    }else if(user_type.equalsIgnoreCase("2")){
                        Log.w(TAG,"appintments : "+appintments);
                        if(appintments != null && !appintments.isEmpty()){
                            Intent intent = new Intent(SplashActivity.this, ServiceProviderDashboardActivity.class);
                            intent.putExtra("appintments",appintments);
                            startActivity(intent);
                            finish();
                        }else if(orders != null && !orders.isEmpty()){
                            Intent intent = new Intent(SplashActivity.this, SPMyOrdrersActivity.class);
                            intent.putExtra("orders",orders);
                            startActivity(intent);
                            finish();
                        }else{
                            Intent intent = new Intent(SplashActivity.this, ServiceProviderDashboardActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    }else if(user_type.equalsIgnoreCase("3")){
                        if(orders != null && !orders.isEmpty()){
                            Intent intent = new Intent(SplashActivity.this, VendorDashboardActivity.class);
                            intent.putExtra("orders",orders);
                            startActivity(intent);
                            finish();
                        }else{
                            Intent intent = new Intent(SplashActivity.this, VendorDashboardActivity.class);
                            startActivity(intent);
                            finish();
                        }


                    }else if(user_type.equalsIgnoreCase("4")){
                        if(appintments != null && !appintments.isEmpty()){
                            if(appintments.equalsIgnoreCase("Walkin")){
                                Intent intent = new Intent(SplashActivity.this, DoctorWalkinAppointmentsActivity.class);
                                intent.putExtra("appintments",appintments);
                                startActivity(intent);
                                finish();
                            }else{
                                Intent intent = new Intent(SplashActivity.this, DoctorDashboardActivity.class);
                                intent.putExtra("appintments",appintments);
                                startActivity(intent);
                                finish();
                            }

                        }else if(orders != null && !orders.isEmpty()){
                            Intent intent = new Intent(SplashActivity.this, DoctorMyOrdrersActivity.class);
                            intent.putExtra("orders",orders);
                            startActivity(intent);
                            finish();
                        }else{
                            Intent intent = new Intent(SplashActivity.this, DoctorDashboardActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                }
            }


        }


        if(!isNotifications){
            new Handler().postDelayed(() -> {

                boolean islogedin1 = session.isLoggedIn();
                if(!islogedin1) {
                   /* Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish(); */
                    Intent i = new Intent(SplashActivity.this, SliderAfterSplashActivity.class);
                    startActivity(i);
                    finish();
                }
                else{

                    session = new SessionManager(getApplicationContext());
                    HashMap<String, String> user = session.getProfileDetails();
                    usertype = user.get(SessionManager.KEY_TYPE);
                    Log.w(TAG,"usertype-->"+usertype);

                    if(usertype != null){
                        if(usertype.equalsIgnoreCase("1")){
                            startActivity(new Intent(SplashActivity.this, PetLoverDashboardActivity.class));
                            finish();

                        }else if(usertype.equalsIgnoreCase("2")){
                            startActivity(new Intent(SplashActivity.this, ServiceProviderDashboardActivity.class));
                            finish();

                        }else if(usertype.equalsIgnoreCase("3")){
                            startActivity(new Intent(SplashActivity.this, VendorDashboardActivity.class));
                            finish();

                        }else if(usertype.equalsIgnoreCase("4")){
                            startActivity(new Intent(SplashActivity.this, DoctorDashboardActivity.class));
                            finish();

                        }

                    }



                }



            }, SPLASH_TIME_OUT);
        }


    }
}