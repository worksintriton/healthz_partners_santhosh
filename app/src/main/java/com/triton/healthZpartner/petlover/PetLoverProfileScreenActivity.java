package com.triton.healthZpartner.petlover;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.triton.healthZpartner.R;
import com.triton.healthZpartner.activity.LoginActivity;
import com.triton.healthZpartner.activity.NotificationActivity;
import com.triton.healthZpartner.activity.location.AddMyAddressOldUserActivity;
import com.triton.healthZpartner.activity.location.EditMyAddressActivity;
import com.triton.healthZpartner.activity.location.ManageAddressActivity;
import com.triton.healthZpartner.activity.location.PickUpLocationActivity;
import com.triton.healthZpartner.activity.location.PickUpLocationEditActivity;
import com.triton.healthZpartner.adapter.ManagePetListAdapter;
import com.triton.healthZpartner.api.APIClient;
import com.triton.healthZpartner.api.RestApiInterface;

import com.triton.healthZpartner.interfaces.PetDeleteListener;
import com.triton.healthZpartner.petlover.myaddresses.MyAddressesListActivity;
import com.triton.healthZpartner.requestpojo.DefaultLocationRequest;
import com.triton.healthZpartner.requestpojo.PetDeleteRequest;
import com.triton.healthZpartner.requestpojo.PetListRequest;
import com.triton.healthZpartner.responsepojo.PetDeleteResponse;
import com.triton.healthZpartner.responsepojo.PetListResponse;
import com.triton.healthZpartner.responsepojo.SuccessResponse;
import com.triton.healthZpartner.sessionmanager.SessionManager;
import com.triton.healthZpartner.utils.ConnectionDetector;
import com.triton.healthZpartner.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetLoverProfileScreenActivity extends AppCompatActivity implements View.OnClickListener, PetDeleteListener {
    private  String TAG = "PetLoverProfileScreenActivity";


    /* Petlover Bottom Navigation */
    /* Petlover Bottom Navigation */

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rl_home)
    RelativeLayout rl_home;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rl_care)
    RelativeLayout rl_care;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.title_care)
    TextView title_care;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_care)
    ImageView img_care;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rl_service)
    RelativeLayout rl_service;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.title_serv)
    TextView title_serv;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_serv)
    ImageView img_serv;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rl_shop)
    RelativeLayout rl_shop;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.title_shop)
    TextView title_shop;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_shop)
    ImageView img_shop;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rl_comn)
    RelativeLayout rl_comn;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.title_community)
    TextView title_community;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_community)
    ImageView img_community;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rl_homes)
    RelativeLayout rl_homes;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_usrname)
    TextView txt_usrname;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_mail)
    TextView txt_mail;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_phn_num)
    TextView txt_phn_num;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_manage_address)
    TextView txt_manage_address;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_my_addresses)
    TextView txt_my_addresses;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_change_password)
    TextView txt_change_password;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.avi_indicator)
    AVLoadingIndicatorView avi_indicator;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.rv_pet)
    RecyclerView rv_pet;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_no_records)
    TextView txt_no_records;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_logout)
    TextView txt_logout;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ll_add)
    LinearLayout ll_add;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.include_petlover_footer)
    View include_petlover_footer;

    BottomNavigationView bottom_navigation_view;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_edit_profile)
    TextView txt_edit_profile;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_profile1)
    ImageView img_profile1;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_edit_image)
    TextView txt_edit_image;






    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.include_petlover_header)
    View include_petlover_header;



    private SessionManager session;
    String name,emailid,phoneNo,userid;
    private List<PetListResponse.DataBean> petList;
    private Dialog dialog;
    private String profileimage;
    private String fromactivity;
    private String doctorid,doctorname,strdistance;

    private String catid;
    private String spid;
    private String from;

    private static final int REQUEST_PHONE_CALL =1 ;
    private String sosPhonenumber;
    private String active_tag;

    private int distance;
    private int reviewcount;
    private int Count_value_start;
    private int Count_value_end;
    private String spuserid;
    private String _id;

    ArrayList<Integer> product_idList;
    private int product_id;
    private String orderid;
    private String cancelorder;
    private String latlng,CityName,AddressLine,PostalCode,nickname;

    String locationtype;
    private String pincode,cityname,address;
    private boolean defaultstatus;
    private String id;
    double latitude, longtitude;

    String appointment_id;
    String appoinment_status;
    private String bookedat;
    private String startappointmentstatus;
    private String appointmentfor;
    private String userrate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_lover_profile_screen);
        ButterKnife.bind(this);


        ImageView img_back = include_petlover_header.findViewById(R.id.img_back);
        ImageView img_sos = include_petlover_header.findViewById(R.id.img_sos);
        ImageView img_notification = include_petlover_header.findViewById(R.id.img_notification);
        ImageView img_cart = include_petlover_header.findViewById(R.id.img_cart);
        ImageView img_profile = include_petlover_header.findViewById(R.id.img_profile);
        TextView toolbar_title = include_petlover_header.findViewById(R.id.toolbar_title);
        toolbar_title.setText(getResources().getString(R.string.profile));
        img_sos.setVisibility(View.GONE);
        img_cart.setVisibility(View.GONE);



        Log.w(TAG,"onCreate : ");
        avi_indicator.setVisibility(View.GONE);
        ll_add.setVisibility(View.GONE);


        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getProfileDetails();
        String firstname = user.get(SessionManager.KEY_FIRST_NAME);
        String lastname = user.get(SessionManager.KEY_LAST_NAME);
        name = firstname+" "+lastname;
        emailid = user.get(SessionManager.KEY_EMAIL_ID);
        phoneNo = user.get(SessionManager.KEY_MOBILE);
        userid = user.get(SessionManager.KEY_ID);
        profileimage = user.get(SessionManager.KEY_PROFILE_IMAGE);
        Log.w(TAG,"profileimage"+ "--->" + profileimage);




        txt_usrname.setText(name);
        txt_mail.setText(emailid);
        txt_phn_num.setText(phoneNo);

        if(profileimage != null && !profileimage.isEmpty()){
            Glide.with(PetLoverProfileScreenActivity.this)
                    .load(profileimage)
                    .into(img_profile1);
        }else{
            Glide.with(PetLoverProfileScreenActivity.this)
                    .load(APIClient.PROFILE_IMAGE_URL)
                    .into(img_profile1);

        }





        if (new ConnectionDetector(getApplicationContext()).isNetworkAvailable(getApplicationContext())) {
            petListResponseCall();
        }


        img_back.setOnClickListener(this);
        txt_manage_address.setOnClickListener(this);
        txt_my_addresses.setOnClickListener(this);

        txt_change_password.setOnClickListener(this);
        txt_logout.setOnClickListener(this);
        ll_add.setOnClickListener(this);
        txt_edit_profile.setOnClickListener(this);
        txt_edit_image.setOnClickListener(this);

        img_notification.setOnClickListener(this);
        img_cart.setOnClickListener(this);
        img_profile1.setOnClickListener(this);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            fromactivity = extras.getString("fromactivity");
            active_tag = extras.getString("active_tag");
            /*DoctorClinicDetailsActivity*/
            doctorid = extras.getString("doctorid");
            doctorname = extras.getString("doctorname");
            strdistance = extras.getString("distance");
            Log.w(TAG,"fromactivity : "+fromactivity+" active_tag : "+active_tag);

            /*SelectedServiceActivity*/
            catid = extras.getString("catid");
            from = extras.getString("from");
            distance = extras.getInt("distance");
            reviewcount = extras.getInt("reviewcount");
            Count_value_start = extras.getInt("Count_value_start");
            Count_value_end = extras.getInt("Count_value_end");

            /*Service_Details_Activity*/
            spid = extras.getString("spid");
            catid = extras.getString("catid");
            from = extras.getString("from");

            spuserid = extras.getString("spuserid");
            _id = extras.getString("_id");

            Log.w(TAG,"distance : "+distance);

            _id = extras.getString("_id");
            orderid = extras.getString("orderid");
            product_id = extras.getInt("product_id");
            cancelorder = extras.getString("cancelorder");
            Log.w(TAG,"_id : "+_id);
            product_idList = getIntent().getIntegerArrayListExtra("product_idList");


            latlng = extras.getString("latlng");
            CityName = extras.getString("CityName");
            AddressLine = extras.getString("AddressLine");
            PostalCode = extras.getString("PostalCode");
            nickname = extras.getString("nickname");

            id = extras.getString("id");
            locationtype = extras.getString("locationtype");
            defaultstatus = extras.getBoolean("defaultstatus");
            latitude = extras.getDouble("lat");
            longtitude = extras.getDouble("lon");
            pincode = extras.getString("pincode");
            cityname = extras.getString("cityname");
            address = extras.getString("address");

            /*PetAppointmentDetailsActivity*/
            appointment_id = extras.getString("appointment_id");
            bookedat = extras.getString("bookedat");
            startappointmentstatus = extras.getString("startappointmentstatus");
            appointmentfor = extras.getString("appointmentfor");
            userrate = extras.getString("userrate");
            from = extras.getString("from");








        }


        /*home*/
        title_care.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
        img_care.setImageResource(R.drawable.grey_care);
        title_serv.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
        img_serv.setImageResource(R.drawable.grey_servc);
        title_shop.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
        img_shop.setImageResource(R.drawable.grey_shop);
        title_community.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
        img_community.setImageResource(R.drawable.grey_community);


        if(active_tag != null){
            if(active_tag.equalsIgnoreCase("3")) {
//                bottom_navigation_view.getMenu().findItem(R.id.services).setChecked(true);
                /*serv*/
                title_care.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
                img_care.setImageResource(R.drawable.grey_care);
                title_shop.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
                img_shop.setImageResource(R.drawable.grey_shop);
                title_community.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
                img_community.setImageResource(R.drawable.grey_community);
                title_serv.setTextColor(getResources().getColor(R.color.new_gree_color,getTheme()));
                img_serv.setImageResource(R.drawable.green_serv);


            }else if(active_tag.equalsIgnoreCase("4")) {
//                bottom_navigation_view.getMenu().findItem(R.id.care).setChecked(true);
    /*Care*/
                title_serv.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
                img_serv.setImageResource(R.drawable.grey_servc);
                title_shop.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
                img_shop.setImageResource(R.drawable.grey_shop);
                title_community.setTextColor(getResources().getColor(R.color.darker_grey_new,getTheme()));
                img_community.setImageResource(R.drawable.grey_community);
                title_care.setTextColor(getResources().getColor(R.color.new_gree_color,getTheme()));
                img_care.setImageResource(R.drawable.green_care);

            }

        }

        rl_home.setOnClickListener(this);

        rl_care.setOnClickListener(this);

        rl_service.setOnClickListener(this);

        rl_shop.setOnClickListener(this);

        rl_comn.setOnClickListener(this);


        rl_homes.setOnClickListener(this);







    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(fromactivity != null && fromactivity.equalsIgnoreCase("DoctorClinicDetailsActivity")){
            Intent intent = new Intent(getApplicationContext(),DoctorClinicDetailsActivity.class);
            intent.putExtra("doctorid",doctorid);
            intent.putExtra("doctorname",doctorname);
            intent.putExtra("distance",distance);
            startActivity(intent);
            finish();
        }
        else if(fromactivity != null && fromactivity.equalsIgnoreCase("SelectedServiceActivity")){
            Intent intent = new Intent(getApplicationContext(),SelectedServiceActivity.class);
            intent.putExtra("catid",catid);
            intent.putExtra("from",from);
            intent.putExtra("distance",distance);
            intent.putExtra("reviewcount",reviewcount);
            intent.putExtra("Count_value_start",Count_value_start);
            intent.putExtra("Count_value_end",Count_value_end);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("Service_Details_Activity")){
            Intent intent = new Intent(getApplicationContext(),Service_Details_Activity.class);
            intent.putExtra("spid",spid);
            intent.putExtra("catid",catid);
            intent.putExtra("from",from);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PetMyappointmentsActivity")){
            Intent intent = new Intent(getApplicationContext(),PetMyappointmentsActivity.class);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("MedicalHistoryActivity")){
            Intent intent = new Intent(getApplicationContext(),MedicalHistoryActivity.class);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PetloverPaymentDetailsActivity")){
            Intent intent = new Intent(getApplicationContext(),PetloverPaymentDetailsActivity.class);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PetServiceAppointment_Doctor_Date_Time_Activity")){
            Intent intent = new Intent(getApplicationContext(),PetServiceAppointment_Doctor_Date_Time_Activity.class);
            intent.putExtra("spuserid",spuserid);
            intent.putExtra("spid",spid);
            intent.putExtra("catid",catid);
            intent.putExtra("distance",distance);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("ManageAddressActivity")){
            Intent intent = new Intent(getApplicationContext(),ManageAddressActivity.class);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PetMyOrdrersNewActivity")){
            Intent intent = new Intent(getApplicationContext(),PetMyOrdrersNewActivity.class);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("ServiceBookAppointmentActivity")){
            Intent intent = new Intent(getApplicationContext(),ServiceBookAppointmentActivity.class);
            intent.putExtra("spuserid",spuserid);
            intent.putExtra("spid",spid);
            intent.putExtra("catid",catid);
            intent.putExtra("distance",distance);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PetAppointment_Doctor_Date_Time_Activity")){
            Intent intent = new Intent(getApplicationContext(),PetAppointment_Doctor_Date_Time_Activity.class);
            intent.putExtra("doctorid",doctorid);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("BookAppointmentActivity")){
            Intent intent = new Intent(getApplicationContext(),BookAppointmentActivity.class);
            intent.putExtra("doctorid",doctorid);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PetLoverVendorOrderDetailsActivity")){
            Intent intent = new Intent(getApplicationContext(),PetLoverVendorOrderDetailsActivity.class);
            intent.putExtra("_id",_id);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PetVendorCancelOrderActivity")){
            Intent intent = new Intent(getApplicationContext(),PetVendorCancelOrderActivity.class);
            intent.putExtra("_id",_id);
            intent.putExtra("orderid",orderid);
            intent.putExtra("product_id",product_id);
            intent.putExtra("cancelorder",cancelorder);
            intent.putExtra("product_idList",product_idList);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PickUpLocationActivity")){
            Intent intent = new Intent(getApplicationContext(), PickUpLocationActivity.class);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("AddMyAddressOldUserActivity")){
            Intent intent = new Intent(getApplicationContext(), AddMyAddressOldUserActivity.class);
            intent.putExtra("latlng",latlng);
            intent.putExtra("CityName",CityName);
            intent.putExtra("AddressLine",AddressLine);
            intent.putExtra("PostalCode",PostalCode);
            intent.putExtra("userid",userid);
            intent.putExtra("nickname",nickname);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("EditMyAddressActivity")){
            Intent intent = new Intent(getApplicationContext(), EditMyAddressActivity.class);
            intent.putExtra("id",id);
            intent.putExtra("userid",userid);
            intent.putExtra("nickname",nickname);
            intent.putExtra("locationtype",locationtype);
            intent.putExtra("defaultstatus",defaultstatus);
            intent.putExtra("lat",latitude);
            intent.putExtra("lon",longtitude);
            intent.putExtra("pincode",pincode);
            intent.putExtra("cityname",cityname);
            intent.putExtra("address",address);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PickUpLocationEditActivity")){
            Intent intent = new Intent(getApplicationContext(), PickUpLocationEditActivity.class);
            intent.putExtra("id",id);
            intent.putExtra("userid",userid);
            intent.putExtra("nickname",nickname);
            intent.putExtra("locationtype",locationtype);
            intent.putExtra("defaultstatus",defaultstatus);
            intent.putExtra("lat",latitude);
            intent.putExtra("lon",longtitude);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PetloverFavListActivity")){
            Intent intent = new Intent(getApplicationContext(), PetloverFavListActivity.class);
            startActivity(intent);
            finish();
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("PetAppointmentDetailsActivity")){
            Intent intent = new Intent(getApplicationContext(), PetAppointmentDetailsActivity.class);
            intent.putExtra("fromactivity",TAG);
            intent.putExtra("appointment_id",appointment_id);
            intent.putExtra("bookedat",bookedat);
            intent.putExtra("startappointmentstatus",startappointmentstatus);
            intent.putExtra("appointmentfor",appointmentfor);
            intent.putExtra("userrate",userrate);
            intent.putExtra("from",from);
            startActivity(intent);
            finish();
        } else if(active_tag != null){
            callDirections(active_tag);
        }else if(fromactivity != null && fromactivity.equalsIgnoreCase("TrackOrderActivity")){
            Intent intent = new Intent(getApplicationContext(), TrackOrderActivity.class);
            intent.putExtra("_id",_id);
            intent.putExtra("orderid",orderid);
            startActivity(intent);

        }else{
            Intent intent = new Intent(getApplicationContext(), PetLoverDashboardActivity.class);
            startActivity(intent);
            finish();
        }



    }



    private void showLogOutAppAlert() {
        try {

            dialog = new Dialog(PetLoverProfileScreenActivity.this);
            dialog.setContentView(R.layout.alert_logout_layout);
            Button btn_no = dialog.findViewById(R.id.btn_no);
            Button btn_yes = dialog.findViewById(R.id.btn_yes);

            btn_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    gotoLogout();

                }
            });
            btn_no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();

        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }




    }


    private void gotoMyAddresses() {
        startActivity(new Intent(PetLoverProfileScreenActivity.this, MyAddressesListActivity.class));

    }

    private void gotoAddYourPet() {
        Intent i = new Intent(getApplicationContext(), BasicPetDetailsActivity.class);
        startActivity(i);
        //startActivity(new Intent(getApplicationContext(),AddYourPetOldUserActivity.class));
    }

    private void gotoManageAddress() {
        startActivity(new Intent(PetLoverProfileScreenActivity.this, ManageAddressActivity.class));
    }

    private void confirmLogoutDialog(){
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(PetLoverProfileScreenActivity.this);
        alertDialogBuilder.setMessage("Are you sure want to logout?");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1)
                    {

                        gotoLogout();


                    }
                });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialogBuilder.setCancelable(true);
            }
        });

        android.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
    private void gotoLogout() {
      /*  session.logoutUser();
        session.setIsLogin(false);
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();*/
        logoutResponseCall();


    }

    @SuppressLint("LogNotTimber")
    private void logoutResponseCall() {
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<SuccessResponse> call = apiInterface.logoutResponseCall(RestUtils.getContentType(), defaultLocationRequest());
        Log.w(TAG,"SignupResponse url  :%s"+" "+ call.request().url().toString());
        call.enqueue(new Callback<SuccessResponse>() {
            @SuppressLint("LogNotTimber")
            @Override
            public void onResponse(@NonNull Call<SuccessResponse> call, @NonNull Response<SuccessResponse> response) {
                Log.w(TAG,"SuccessResponse" + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (200 == response.body().getCode()) {
                        session.logoutUser();
                        session.setIsLogin(false);
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();


                    }
                }


            }

            @Override
            public void onFailure(@NonNull Call<SuccessResponse> call,@NonNull Throwable t) {

                Log.e("SuccessResponse flr", "--->" + t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private DefaultLocationRequest defaultLocationRequest() {
        DefaultLocationRequest defaultLocationRequest = new DefaultLocationRequest();
        defaultLocationRequest.setUser_id(userid);

        Log.w(TAG,"defaultLocationRequest "+ new Gson().toJson(defaultLocationRequest));
        return defaultLocationRequest;
    }
    private void petListResponseCall() {
        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<PetListResponse> call = apiInterface.petListResponseCall(RestUtils.getContentType(), petListRequest());
        Log.w(TAG,"PetListResponse url  :%s"+" "+ call.request().url().toString());

        call.enqueue(new Callback<PetListResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<PetListResponse> call, @NonNull Response<PetListResponse> response) {

                Log.w(TAG,"PetListResponse"+ "--->" + new Gson().toJson(response.body()));

                avi_indicator.smoothToHide();

                if (response.body() != null) {
                    if(response.body().getCode() == 200){

                        if(response.body().getData() != null && response.body().getData().size()>0){
                            txt_no_records.setVisibility(View.GONE);
                            rv_pet.setVisibility(View.VISIBLE);
                            ll_add.setVisibility(View.GONE);
                            petList = response.body().getData();
                            setView();

                        }
                        else{
                            txt_no_records.setVisibility(View.VISIBLE);
                            txt_no_records.setText(getResources().getString(R.string.no_new_pets));
                            ll_add.setVisibility(View.VISIBLE);
                            rv_pet.setVisibility(View.GONE);
                        }



                    }

                }


            }

            @Override
            public void onFailure(@NonNull Call<PetListResponse> call, @NonNull Throwable t) {

                avi_indicator.smoothToHide();
                Log.w(TAG,"PetListResponse flr"+"--->" + t.getMessage());
            }
        });

    }
    private PetListRequest petListRequest() {
        PetListRequest petListRequest = new PetListRequest();
        petListRequest.setUser_id(userid);
        Log.w(TAG,"petListRequest"+ "--->" + new Gson().toJson(petListRequest));
        return petListRequest;
    }
    private void setView() {
        rv_pet.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

      //  rv_pet.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv_pet.setItemAnimator(new DefaultItemAnimator());
        ManagePetListAdapter managePetListAdapter = new ManagePetListAdapter(getApplicationContext(), petList, this);
        rv_pet.setAdapter(managePetListAdapter);

    }


    @Override
    public void petDeleteListener(boolean status, String petid) {
        if(petid != null){
            showStatusAlert(petid);
        }

    }

    private void showStatusAlert(final String petid) {

        try {

            dialog = new Dialog(PetLoverProfileScreenActivity.this);
            dialog.setContentView(R.layout.alert_approve_reject_layout);
            TextView tvheader = (TextView)dialog.findViewById(R.id.tvInternetNotConnected);
            tvheader.setText(R.string.deletepetmsg);
            Button dialogButtonApprove = (Button) dialog.findViewById(R.id.btnApprove);
            dialogButtonApprove.setText("Yes");
            Button dialogButtonRejected = (Button) dialog.findViewById(R.id.btnReject);
            dialogButtonRejected.setText("No");

            dialogButtonApprove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();

                    petDeleteResponseCall(petid);


                }
            });
            dialogButtonRejected.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();




                }
            });
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();

        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }




    }
    @SuppressLint("LogNotTimber")
    private void petDeleteResponseCall(String petid) {
        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();

        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<PetDeleteResponse> call = apiInterface.petDeleteResponseCall(RestUtils.getContentType(),petDeleteRequest(petid));

        Log.w(TAG,"url  :%s"+call.request().url().toString());

        call.enqueue(new Callback<PetDeleteResponse>() {
            @SuppressLint("LogNotTimber")
            @Override
            public void onResponse(@NotNull Call<PetDeleteResponse> call, @NotNull Response<PetDeleteResponse> response) {
                avi_indicator.smoothToHide();
                Log.w(TAG,"PetDeleteResponse"+ "--->" + new Gson().toJson(response.body()));

                if (response.body() != null) {
                    if(response.body().getCode() == 200){
                        Toasty.success(getApplicationContext(), "Pet Removed Successfully", Toast.LENGTH_SHORT, true).show();
                        finish();
                        overridePendingTransition( 0, 0);
                        startActivity(getIntent());
                        overridePendingTransition( 0, 0);

                    }
                }



            }

            @Override
            public void onFailure(@NotNull Call<PetDeleteResponse> call, @NotNull Throwable t) {
                avi_indicator.smoothToHide();

                Log.w(TAG,"PetDeleteResponse flr"+"--->" + t.getMessage());
            }
        });

    }
    @SuppressLint("LogNotTimber")
    private PetDeleteRequest petDeleteRequest(String petid) {

        /*
          _id : 5f05d911f3090625a91f40c7
         */
        PetDeleteRequest petDeleteRequest = new PetDeleteRequest();
        petDeleteRequest.set_id(petid);
        Log.w(TAG,"petDeleteRequest"+ "--->" + new Gson().toJson(petDeleteRequest));
        return petDeleteRequest;
    }

//    @SuppressLint("NonConstantResourceId")
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.home:
//                callDirections("1");
//                break;
//            case R.id.shop:
//                callDirections("2");
//                break;
//            case R.id.services:
//                callDirections("3");
//                break;
//            case R.id.care:
//                callDirections("4");
//                break;
//            case R.id.community:
//                callDirections("5");
//                break;
//
//            default:
//                return  false;
//        }
//        return true;
//    }
    public void callDirections(String tag){
        Intent intent = new Intent(getApplicationContext(), PetLoverDashboardActivity.class);
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
            case R.id.rl_service:
                callDirections("3");
                break;

            case R.id.rl_care:
                callDirections("4");
                break;

            case R.id.rl_comn:
                callDirections("5");
                break;

            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.txt_manage_address:
                gotoManageAddress();
                break;
            case R.id.txt_my_addresses:
                gotoMyAddresses();
                break;
            case R.id.txt_change_password:
                break;
            case R.id.txt_logout:
                showLogOutAppAlert();
                //  confirmLogoutDialog();
                break;
            case R.id.ll_add:
                gotoAddYourPet();
                break;
            case R.id.txt_edit_profile:
                startActivity(new Intent(getApplicationContext(), PetLoverEditProfileActivity.class));
                break;
            case R.id.txt_edit_image:
                startActivity(new Intent(getApplicationContext(), PetLoverEditProfileImageActivity.class));
                break;

            case R.id.img_notification:
                startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                break;
        }
    }


    private void setMargins(RelativeLayout rl_layout, int i, int i1, int i2, int i3) {

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)rl_layout.getLayoutParams();
        params.setMargins(i, i1, i2, i3);
        rl_layout.setLayoutParams(params);
    }


}