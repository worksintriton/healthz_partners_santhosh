package com.triton.healthZpartners.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.triton.healthZpartners.R;
import com.triton.healthZpartners.api.APIClient;
import com.triton.healthZpartners.fragmentvendor.FragmentVendorDashboard;
import com.triton.healthZpartners.interfaces.FamilyMembersDeleteListener;
import com.triton.healthZpartners.interfaces.GotoAddFamilyMembersOldActivityListener;
import com.triton.healthZpartners.responsepojo.FamilyMemberListResponse;
import com.triton.healthZpartners.responsepojo.FetchProductByUserIDResponse;
import com.triton.healthZpartners.vendor.VendorAddProductsActivity;

import java.util.List;


public class VendorProductListAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<FetchProductByUserIDResponse.DataBean> dataBeanList;

    private final Context context;

    FetchProductByUserIDResponse.DataBean currentItem;

    private List<FetchProductByUserIDResponse.DataBean.ProductsImageBean> picBeanList;
    public VendorProductListAdapter(Context context, List<FetchProductByUserIDResponse.DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_vendor_product_list, parent, false);
        return new ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        initLayoutOne((ViewHolderOne) holder, position);


    }

    @SuppressLint({"SetTextI18n", "LogNotTimber"})
    private void initLayoutOne(ViewHolderOne holder, final int position) {

        currentItem = dataBeanList.get(position);

        if (dataBeanList.get(position).getProduct_name() != null) {
            holder.txt_products_title.setText(dataBeanList.get(position).getProduct_name());
        }
        else {

            holder.txt_products_title.setVisibility(View.GONE);
        }

        if (dataBeanList.get(position).getProduct_price() != 0) {
            holder.txt_products_price.setText("\u20B9 "+dataBeanList.get(position).getProduct_price());
        }
        else {

            holder.txt_products_price.setText("\u20B9 0");
        }


        if (dataBeanList.get(position).getPet_threshold() != null) {
            holder.txt_products_price.setText("Quantity "+dataBeanList.get(position).getPet_threshold());
        }
        else {

            holder.txt_products_price.setText("Quantity : 0");
        }



        if (dataBeanList != null && dataBeanList.size() > 0) {
            String TAG = "ManagePetListAdapter";
            Log.w(TAG,"dataBeanList : "+new Gson().toJson(dataBeanList));


            picBeanList =   dataBeanList.get(position).getProducts_image();

            String petImagePath = null;


            Log.w(TAG,"picBeanList : "+new Gson().toJson(picBeanList));

            if(picBeanList != null && picBeanList.size() > 0) {

                for (int j=0;j<picBeanList.size();j++) {

                    petImagePath= picBeanList.get(j).getProduct_img();

                }
            }




            Log.w(TAG,"petImagePath : "+petImagePath);

            if (petImagePath != null && !petImagePath.isEmpty()) {
                Glide.with(context)
                        .load(petImagePath)
                        .into(holder.img_pet_imge);
            }else {
                Glide.with(context)
                        .load(APIClient.PROFILE_IMAGE_URL)
                        .into(holder.img_pet_imge);

            }


        }


        holder.ll_main_root.setOnClickListener(v -> {
            Intent i = new Intent(context, VendorAddProductsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        });


        //closing the setOnClickListener method

        if(position == dataBeanList.size()-1){
            holder.ll_main_root.setVisibility(View.VISIBLE);
        }

       /* holder.cv_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, PetloverPetDetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("id",petListResponseList.get(position).get_id());
                i.putExtra("userid",petListResponseList.get(position).getUser_id());
                i.putExtra("petimage",petListResponseList.get(position).getPet_img().get(0).getPet_img());
                i.putExtra("petname",petListResponseList.get(position).getPet_name());
                i.putExtra("pettype",petListResponseList.get(position).getPet_type());
                i.putExtra("petbreed",petListResponseList.get(position).getPet_breed());
                i.putExtra("petgender",petListResponseList.get(position).getPet_gender());
                i.putExtra("petcolor",petListResponseList.get(position).getPet_color());
                i.putExtra("petweight",petListResponseList.get(position).getPet_weight());
                i.putExtra("petage",petListResponseList.get(position).getPet_age());
                i.putExtra("petdob",petListResponseList.get(position).getPet_dob());
                i.putExtra("vaccinatedstatus",petListResponseList.get(position).isVaccinated());
                i.putExtra("vaccinateddate",petListResponseList.get(position).getLast_vaccination_date());
                i.putExtra("defaultstatus",petListResponseList.get(position).isDefault_status());
                i.putExtra("pet_spayed",petListResponseList.get(position).isPet_spayed());
                i.putExtra("pet_purebred",petListResponseList.get(position).isPet_purebred());
                i.putExtra("pet_frnd_with_dog",petListResponseList.get(position).isPet_frnd_with_dog());
                i.putExtra("pet_frnd_with_cat",petListResponseList.get(position).isPet_frnd_with_cat());
                i.putExtra("pet_microchipped",petListResponseList.get(position).isPet_microchipped());
                i.putExtra("pet_tick_free",petListResponseList.get(position).isPet_tick_free());
                i.putExtra("pet_private_part",petListResponseList.get(position).isPet_private_part());
                i.putExtra("petbio",petListResponseList.get(position).getPetbio());

                Bundle args = new Bundle();
                //int list = petListResponseList.get(position).getPet_img().size();
                args.putSerializable("PETLIST", (Serializable) petListResponseList.get(position).getPet_img());
                i.putExtra("petimage",args);

                context.startActivity(i);

            }
        });*/
    }









    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView txt_deal_status,txt_products_price,txt_products_quantity,txt_products_title;
        public ImageView img_pet_imge,img_settings;
        public RelativeLayout ll_main_root;


        public ViewHolderOne(View itemView) {
            super(itemView);
            img_pet_imge = itemView.findViewById(R.id.img_products_image);
            txt_products_title= itemView.findViewById(R.id.txt_products_title);
            txt_products_price = itemView.findViewById(R.id.txt_products_price);
            txt_products_quantity = itemView.findViewById(R.id.txt_products_quantity);
            txt_deal_status = itemView.findViewById(R.id.txt_deal_status);
            ll_main_root = itemView.findViewById(R.id.ll_main_root);
            ll_main_root.setVisibility(View.GONE);


        }




    }







}
