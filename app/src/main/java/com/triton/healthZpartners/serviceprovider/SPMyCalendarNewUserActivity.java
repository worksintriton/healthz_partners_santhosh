package com.triton.healthzpartners.serviceprovider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.triton.healthzpartners.R;
import com.triton.healthzpartners.adapter.SPMyCalendarAvailableNewUserAdapter;
import com.triton.healthzpartners.api.APIClient;
import com.triton.healthzpartners.api.RestApiInterface;
import com.triton.healthzpartners.interfaces.OnItemClickSpecialization;
import com.triton.healthzpartners.requestpojo.SPMyCalendarAvlDaysRequest;
import com.triton.healthzpartners.responsepojo.DoctorMyCalendarAvlDaysResponse;
import com.triton.healthzpartners.sessionmanager.SessionManager;
import com.triton.healthzpartners.utils.ConnectionDetector;
import com.triton.healthzpartners.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SPMyCalendarNewUserActivity extends AppCompatActivity implements OnItemClickSpecialization {

    private static final String TAG = "SPMyCalendarNewUserActivity" ;
    RecyclerView rv_doctor_mycalendar_avldays;
    private SharedPreferences preferences;

    private List<DoctorMyCalendarAvlDaysResponse.DataBean> dataBeanList = null;

    private ArrayList<String> dateList = new ArrayList<>();
    private SessionManager session;
    String doctorname = "",doctoremailid = "";
    Button btn_next;
    private String userid;
    AVLoadingIndicatorView avi_indicator;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.include_sp_header)
    View include_sp_header;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_my_calendar);

        ButterKnife.bind(this);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        rv_doctor_mycalendar_avldays = findViewById(R.id.rv_doctor_mycalendar_avldays);

        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getProfileDetails();
        doctorname = user.get(SessionManager.KEY_FIRST_NAME);
        doctoremailid = user.get(SessionManager.KEY_EMAIL_ID);
        userid = user.get(SessionManager.KEY_ID);

        avi_indicator = findViewById(R.id.avi_indicator);
        avi_indicator.setVisibility(View.GONE);

        LinearLayout ll_addholiday = findViewById(R.id.ll_addholiday);
        TextView txtAddHoliday = findViewById(R.id.txtAddHoliday);
        txtAddHoliday.setVisibility(View.GONE);
        ll_addholiday.setVisibility(View.GONE);


        if (new ConnectionDetector(SPMyCalendarNewUserActivity.this).isNetworkAvailable(SPMyCalendarNewUserActivity.this)) {
            spMyCalendarAvlDaysResponseCall();
        }
       btn_next = findViewById(R.id.btn_next);
        btn_next.setVisibility(View.GONE);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                Log.w(TAG,"dateList-->"+new Gson().toJson(dateList));
                if(dateList != null && dateList.size()>0){
                    Intent intent = new Intent(SPMyCalendarNewUserActivity.this, SPMyCalendarTimeActivity.class);
                    intent.putExtra("dateList",dateList);
                    intent.putExtra("fromactivity",TAG);


                    startActivity(intent);
                }else{
                    Toasty.warning(getApplicationContext(), "Please select any one day", Toast.LENGTH_SHORT, true).show();

                }

            }
        });


        ImageView img_back = include_sp_header.findViewById(R.id.img_back);
        ImageView img_notification = include_sp_header.findViewById(R.id.img_notification);
        ImageView img_cart = include_sp_header.findViewById(R.id.img_cart);
        ImageView img_profile = include_sp_header.findViewById(R.id.img_profile);
        TextView toolbar_title = include_sp_header.findViewById(R.id.toolbar_title);
        toolbar_title.setText(getResources().getString(R.string.my_calendar));
        img_notification.setVisibility(View.GONE);
        img_profile.setVisibility(View.GONE);
        img_cart.setVisibility(View.GONE);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });




        }

    @SuppressLint("LongLogTag")
    private void spMyCalendarAvlDaysResponseCall() {
        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();
        RestApiInterface ApiService = APIClient.getClient().create(RestApiInterface.class);
        Call<DoctorMyCalendarAvlDaysResponse> call = ApiService.spMyCalendarAvlDaysResponseCall(RestUtils.getContentType(),spMyCalendarAvlDaysRequest());
        Log.w(TAG,"url  :%s"+" "+call.request().url().toString());

        call.enqueue(new Callback<DoctorMyCalendarAvlDaysResponse>() {
            @SuppressLint({"LongLogTag", "LogNotTimber"})
            @Override
            public void onResponse(@NonNull Call<DoctorMyCalendarAvlDaysResponse> call, @NonNull Response<DoctorMyCalendarAvlDaysResponse> response) {
                avi_indicator.smoothToHide();
                Log.w(TAG,"spMyCalendarAvlDaysResponseCall"+ "--->" + new Gson().toJson(response.body()));


                if (response.body() != null) {
                    if(response.body().getCode() == 200){
                        if(response.body().getData() != null) {
                            dataBeanList = response.body().getData();
                            for (int i = 0; i < dataBeanList.size(); i++) {
                                boolean isStatus = dataBeanList.get(i).isStatus();
                                if (isStatus) {
                                    btn_next.setVisibility(View.GONE);
                                } else {
                                    btn_next.setVisibility(View.VISIBLE);
                                    break;
                                }
                            }
                            if (dataBeanList.size() > 0) {
                                setViewAvlDays();
                            }
                        }

                    }

                }


            }

            @SuppressLint("LongLogTag")
            @Override
            public void onFailure(@NonNull Call<DoctorMyCalendarAvlDaysResponse> call, @NonNull Throwable t) {
                avi_indicator.smoothToHide();

                Log.w(TAG,"spMyCalendarAvlDaysResponseCall flr"+"--->" + t.getMessage());
            }
        });

    }
    @SuppressLint({"LongLogTag", "LogNotTimber"})
    private SPMyCalendarAvlDaysRequest spMyCalendarAvlDaysRequest() {
        /*
         * sp_name : imthi
         * types : 1
         * user_id : 5fe18d0bf9ed795ad2f594941
         */
        SPMyCalendarAvlDaysRequest spMyCalendarAvlDaysRequest = new SPMyCalendarAvlDaysRequest();
        spMyCalendarAvlDaysRequest.setUser_id(userid);
        spMyCalendarAvlDaysRequest.setSp_name(doctorname);
        spMyCalendarAvlDaysRequest.setTypes(1);
        Log.w(TAG,"spMyCalendarAvlDaysRequest"+ "--->" + new Gson().toJson(spMyCalendarAvlDaysRequest));
        return spMyCalendarAvlDaysRequest;
    }

    private void setViewAvlDays() {
        rv_doctor_mycalendar_avldays.setLayoutManager(new LinearLayoutManager(this));
        rv_doctor_mycalendar_avldays.setItemAnimator(new DefaultItemAnimator());
        SPMyCalendarAvailableNewUserAdapter spMyCalendarAvailableNewUserAdapter = new SPMyCalendarAvailableNewUserAdapter(getApplicationContext(), dataBeanList, rv_doctor_mycalendar_avldays, this);
        rv_doctor_mycalendar_avldays.setAdapter(spMyCalendarAvailableNewUserAdapter);

   }

    @SuppressLint("LongLogTag")
    @Override
    public void onItemCheckSpecialization(String item) {
        dateList.add(item);
        Log.w(TAG,"onItemCheckSpecialization : "+item);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onItemUncheckSpecialization(String item) {
        Log.w(TAG,"onItemUncheckSpecialization : "+item);
        dateList.remove(item);


    }

    @Override
    public void onBackPressed() {
        Toasty.warning(getApplicationContext(), "This action is disabled in this screen..", Toast.LENGTH_SHORT, true).show();

       /* super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), DoctorDashboardActivity.class));
        finish();*/
    }
}