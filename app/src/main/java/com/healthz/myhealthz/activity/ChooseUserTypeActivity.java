package com.healthz.myhealthz.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.healthz.myhealthz.R;
import com.healthz.myhealthz.adapter.UserTypesListAdapter;
import com.healthz.myhealthz.api.APIClient;
import com.healthz.myhealthz.api.RestApiInterface;
import com.healthz.myhealthz.interfaces.UserTypeSelectListener;
import com.healthz.myhealthz.responsepojo.UserTypeListResponse;
import com.healthz.myhealthz.utils.ConnectionDetector;
import com.healthz.myhealthz.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseUserTypeActivity extends AppCompatActivity implements UserTypeSelectListener, View.OnClickListener {

    private static final String TAG = "ChooseUserTypeActivity";

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.avi_indicator)
    AVLoadingIndicatorView avi_indicator;


    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rv_usertype)
    RecyclerView rv_usertype;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tv_norecords)
    TextView tv_norecords;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_back)
    ImageView img_back;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_change)
    Button btn_change;

    List<UserTypeListResponse.DataBean.UsertypedataBean> usertypedataBeanList = new ArrayList<>();
    private String UserType;
    private int UserTypeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user_type);
        ButterKnife.bind(this);
        avi_indicator.setVisibility(View.GONE);
        img_back.setOnClickListener(this);
        btn_change.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            UserType = extras.getString("UserType");
            UserTypeValue = extras.getInt("UserTypeValue");
            Log.w(TAG,"UserType : "+UserType +"UserTypeValue : "+UserTypeValue);
        }


        if (new ConnectionDetector(ChooseUserTypeActivity.this).isNetworkAvailable(ChooseUserTypeActivity.this)) {
            userTypeListResponseCall(UserTypeValue);
        }


    }

    @SuppressLint("LogNotTimber")
    public void userTypeListResponseCall(int userTypeValue){
        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();
        //Creating an object of our api interface
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<UserTypeListResponse> call = apiInterface.userTypeListResponseCall(RestUtils.getContentType());
        Log.w(TAG,"url  :%s"+ call.request().url().toString());

        call.enqueue(new Callback<UserTypeListResponse>() {
            @SuppressLint("LogNotTimber")
            @Override
            public void onResponse(@NonNull Call<UserTypeListResponse> call, @NonNull Response<UserTypeListResponse> response) {
                avi_indicator.smoothToHide();


                if (response.body() != null) {
                    if(200 == response.body().getCode()){
                        Log.w(TAG,"UserTypeListResponse" + new Gson().toJson(response.body()));


                        if(response.body().getData().getUsertypedata() != null && response.body().getData().getUsertypedata().size()>0){

                            for(int i =0;i<response.body().getData().getUsertypedata().size();i++){

                                Log.w(TAG,"usertype "+response.body().getData().getUsertypedata().get(i).getUser_type_value());

                                if(response.body().getData().getUsertypedata().get(i).getUser_type_value()!=0&&response.body().getData().getUsertypedata().get(i).getUser_type_value()!=1){

                                    UserTypeListResponse.DataBean.UsertypedataBean usertypedataBean  = new UserTypeListResponse.DataBean.UsertypedataBean();

                                    usertypedataBean.set_id(response.body().getData().getUsertypedata().get(i).get_id());

                                    usertypedataBean.setUser_type_title(response.body().getData().getUsertypedata().get(i).getUser_type_title());

                                    usertypedataBean.setUser_type_value(response.body().getData().getUsertypedata().get(i).getUser_type_value());

                                    usertypedataBean.setUser_type_img(response.body().getData().getUsertypedata().get(i).getUser_type_img());

                                    usertypedataBean.setDate_and_time(response.body().getData().getUsertypedata().get(i).getDate_and_time());

                                    usertypedataBean.set__v(response.body().getData().getUsertypedata().get(i).get__v());

                                    usertypedataBeanList.add(usertypedataBean);
                                }

                            }
                            Log.w(TAG,"usertypedataBeanList" + new Gson().toJson(usertypedataBeanList));

                            setView(userTypeValue);
                        }
                    }



                }








            }


            @Override
            public void onFailure(@NonNull Call<UserTypeListResponse> call,@NonNull  Throwable t) {
                avi_indicator.smoothToHide();
                Log.w(TAG,"UserTypeListResponse flr"+t.getMessage());
            }
        });

    }

    @SuppressLint("LogNotTimber")
    private void setView(int userTypeValue) {
        for(int i=0; i<usertypedataBeanList.size();i++){
            if(userTypeValue == usertypedataBeanList.get(i).getUser_type_value()){
                usertypedataBeanList.get(i).setSelected(true);
                break;
            }
        }
        Log.w(TAG, "setView : "+userTypeValue);
        rv_usertype.setLayoutManager(new GridLayoutManager(this, 2));
        rv_usertype.setItemAnimator(new DefaultItemAnimator());
        UserTypesListAdapter userTypesListAdapter = new UserTypesListAdapter(getApplicationContext(), usertypedataBeanList,this,userTypeValue);
        rv_usertype.setAdapter(userTypesListAdapter);
    }


    @SuppressLint("LogNotTimber")
    @Override
    public void userTypeSelectListener(String usertype, int usertypevalue) {
        UserType = usertype;
        UserTypeValue = usertypevalue;
        Log.w(TAG,"userTypeSelectListener : "+" usertype : "+usertype+" usertypevalue : "+usertypevalue);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.btn_change:
                /*if(UserTypeValue ==1 || UserTypeValue ==2 || UserTypeValue == 4){
                    gotoSignup();
                }*/
                gotoSignup();
                break;
        }
    }

    private void gotoSignup() {
        Intent intent = new Intent(ChooseUserTypeActivity.this,SignUpActivity.class);
        intent.putExtra("UserType",UserType);
        intent.putExtra("UserTypeValue",UserTypeValue);
        Log.w(TAG,"gotoSignup UserType : "+UserType +"UserTypeValue : "+UserTypeValue);

        startActivity(intent);
        finish();
    }
}