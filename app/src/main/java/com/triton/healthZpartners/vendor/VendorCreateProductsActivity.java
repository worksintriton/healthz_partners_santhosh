package com.triton.healthZpartners.vendor;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.triton.healthZpartners.R;
import com.triton.healthZpartners.activity.NotificationActivity;
import com.triton.healthZpartners.api.APIClient;
import com.triton.healthZpartners.api.RestApiInterface;
import com.triton.healthZpartners.appUtils.NumericKeyBoardTransformationMethod;
import com.triton.healthZpartners.requestpojo.ProductVendorCreateRequest;
import com.triton.healthZpartners.responsepojo.CatgoryGetListResponse;
import com.triton.healthZpartners.responsepojo.FetctProductByCatDetailsResponse;
import com.triton.healthZpartners.responsepojo.SuccessResponse;
import com.triton.healthZpartners.sessionmanager.SessionManager;
import com.triton.healthZpartners.utils.ConnectionDetector;
import com.triton.healthZpartners.utils.RestUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VendorCreateProductsActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private  String TAG = "VendorCreateProductsActivity";

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_back)
    ImageView img_back;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_products_image)
    ImageView img_products_image;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txt_product_title)
    TextView txt_product_title;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.edt_product_price)
    EditText edt_product_price;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.edt_product_thresould)
    EditText edt_product_thresould;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.edt_product_descriptions)
    EditText edt_product_descriptions;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_update)
    Button btn_update;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.avi_indicator)
    AVLoadingIndicatorView avi_indicator;


    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_notification)
    ImageView img_notification;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_profile)
    ImageView img_profile;



    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.include_vendor_footer)
    View include_vendor_footer;

    private String userid;
    private List<CatgoryGetListResponse.DataBean> catgoryGetList;

    HashMap<String, String> hashMap_CatTypeid = new HashMap<>();
    private String strCatType;
    private String strCatTypeId;
    private List<FetctProductByCatDetailsResponse.DataBean> fetctProductByCatDetailsList;
    private String productid;
    private String producttitle;
    private String productdesc;
    private String productimage;
    private Dialog alertDialog;


    BottomNavigationView bottom_navigation_view;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_create_products);

        Log.w(TAG,"onCreate : ");

        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            productid = extras.getString("productid");
            producttitle = extras.getString("producttitle");
            productdesc = extras.getString("productdesc");
            productimage = extras.getString("productimage");



            if(producttitle != null){
                txt_product_title.setText(producttitle);
            }
            if(productdesc != null){
                edt_product_descriptions.setText(productdesc);
            }

            if (productimage != null && !productimage.isEmpty()) {
                Glide.with(getApplicationContext())
                        .load(productimage)
                        .into(img_products_image);

            }
            else{
                Glide.with(getApplicationContext())
                        .load(APIClient.PROFILE_IMAGE_URL)
                        .into(img_products_image);

            }

            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addProductValidator();
                }
            });

            img_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });



        }

        img_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                finish();

            }
        });
        img_profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),VendorProfileScreenActivity.class);
                        intent.putExtra("fromactivity",TAG);
                        intent.putExtra("productid",productid);
                        intent.putExtra("producttitle",producttitle);
                        intent.putExtra("productdesc",productdesc);
                        intent.putExtra("productimage",productimage);
                        startActivity(intent);


                    }
                });

        edt_product_thresould.setTransformationMethod(new NumericKeyBoardTransformationMethod());


        SessionManager session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getProfileDetails();
        userid = user.get(SessionManager.KEY_ID);




        img_back.setOnClickListener(v -> onBackPressed());

        fab = include_vendor_footer.findViewById(R.id.fab);
        bottom_navigation_view = include_vendor_footer.findViewById(R.id.bottomNavigation);
        bottom_navigation_view.setOnNavigationItemSelectedListener(this);
        bottom_navigation_view.getMenu().findItem(R.id.shop).setChecked(true);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDirections("1");
            }
        });





    }





    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),VendorAddProductsActivity.class));
        finish();
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                callDirections("1");
                break;
            case R.id.shop:
                callDirections("2");
                break;

            case R.id.community:
                callDirections("3");
                break;


        }
        return true;
    }


    public void callDirections(String tag){
        Intent intent = new Intent(getApplicationContext(), VendorDashboardActivity.class);
        intent.putExtra("tag",tag);
        startActivity(intent);
        finish();
    }

    public void addProductValidator() {
        boolean can_proceed = true;



        if (edt_product_price.getText().toString().isEmpty() && edt_product_descriptions.getText().toString().isEmpty() && edt_product_thresould.getText().toString().isEmpty() ) {
            Toasty.warning(getApplicationContext(), "Please enter the fields", Toast.LENGTH_SHORT, true).show();
            can_proceed = false;
        } else if (edt_product_price.getText().toString().trim().equals("")) {
            edt_product_price.setError("Please enter product price");
            edt_product_price.requestFocus();
            can_proceed = false;
        }
        else if (edt_product_thresould.getText().toString().trim().equals("")) {
            edt_product_thresould.setError("Please enter product thresould");
            edt_product_thresould.requestFocus();
            can_proceed = false;
        }else if (edt_product_descriptions.getText().toString().trim().equals("")) {
            edt_product_descriptions.setError("Please enter product descriptions");
            edt_product_descriptions.requestFocus();
            can_proceed = false;
        }


        if (can_proceed) {
            if (new ConnectionDetector(VendorCreateProductsActivity.this).isNetworkAvailable(VendorCreateProductsActivity.this)) {
                vendor_product_create_ResponseCall();
            }

        }





    }

    @SuppressLint({"LogNotTimber", "LongLogTag"})
    private void vendor_product_create_ResponseCall() {
        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();
        RestApiInterface apiInterface = APIClient.getClient().create(RestApiInterface.class);
        Call<SuccessResponse> call = apiInterface.vendor_product_create_ResponseCall(RestUtils.getContentType(), productVendorCreateRequest());
        Log.w(TAG,"vendor_product_create_ResponseCall url  :%s"+" "+ call.request().url().toString());

        call.enqueue(new Callback<SuccessResponse>() {
            @Override
            public void onResponse(@NonNull Call<SuccessResponse> call, @NonNull Response<SuccessResponse> response) {

                Log.w(TAG,"vendor_product_create_ResponseCall"+ "--->" + new Gson().toJson(response.body()));

                avi_indicator.smoothToHide();

                if (response.body() != null) {
                    if(response.body().getCode() == 200){
                        Toasty.success(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT, true).show();
                        startActivity(new Intent(getApplicationContext(),VendorAddProductsActivity.class));
                        finish();
                    }
                    else{
                        showErrorLoading(response.body().getMessage());
                    }
                }


            }

            @SuppressLint("LongLogTag")
            @Override
            public void onFailure(@NonNull Call<SuccessResponse> call, @NonNull Throwable t) {

                avi_indicator.smoothToHide();
                Log.w(TAG,"productEditResponseCall flr"+"--->" + t.getMessage());
            }
        });

    }
    @SuppressLint({"LogNotTimber", "LongLogTag"})
    private ProductVendorCreateRequest productVendorCreateRequest() {


        /**
         * vendor_id : 6198b507518ad4520ab14790
         * cat_id : 6198b507518ad4520ab14790
         * thumbnail_image : http://google.png
         * product_img : [{"product_img":"http://google.png"},{"product_img":"http://google.png"}]
         * product_name : Good Food
         * cost : 200
         * product_discription : This is good food
         * condition : Testing
         * price_type : Testing
         * addition_detail : ["testing1","testing2","testing3"]
         * date_and_time : 23-10-2021 11:00 AM
         * threshould : 1000
         * mobile_type : Admin
         */

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());

        ProductVendorCreateRequest productVendorCreateRequest = new ProductVendorCreateRequest();
        productVendorCreateRequest.setCat_id(productid);
        productVendorCreateRequest.setCost(Integer.parseInt(edt_product_price.getText().toString()));
        productVendorCreateRequest.setThreshould(edt_product_thresould.getText().toString());
        productVendorCreateRequest.setProduct_discription(edt_product_descriptions.getText().toString());
        productVendorCreateRequest.setVendor_id(APIClient.VENDOR_ID);
        productVendorCreateRequest.setDate_and_time(currentDateandTime);
        productVendorCreateRequest.setMobile_type("Android");
        Log.w(TAG,"productEditRequest"+ "--->" + new Gson().toJson(productVendorCreateRequest));
        return productVendorCreateRequest;
    }

    public void showErrorLoading(String errormesage){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(errormesage);
        alertDialogBuilder.setPositiveButton("ok",
                (arg0, arg1) -> hideLoading());



        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void hideLoading(){
        try {
            alertDialog.dismiss();
        }catch (Exception ignored){

        }
    }

}
