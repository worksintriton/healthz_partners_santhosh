package com.triton.healthzpartners.adapter;

import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.triton.healthzpartners.R;
import com.triton.healthzpartners.api.APIClient;
import com.triton.healthzpartners.interfaces.ManageProductsDealsListener;
import com.triton.healthzpartners.interfaces.OnItemCheckProduct;
import com.triton.healthzpartners.responsepojo.ManageProductsListResponse;
import com.triton.healthzpartners.vendor.EditManageProdcutsActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ManageProductsListAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final String TAG = "ManageProductsListAdapter";
    private final Context context;
    ManageProductsListResponse.DataBean currentItem;
    private final List<ManageProductsListResponse.DataBean> manageProductsListResponseList;
    public static String id = "";
    private int currentSelectedPosition = RecyclerView.NO_POSITION;
    boolean showCheckbox;
    private ArrayList<String> additionalDetailList;

   private final OnItemCheckProduct onItemCheckProduct;
    int count = 0;

    ManageProductsDealsListener manageProductsDealsListener;

    private List<ManageProductsListResponse.DataBean.ProductImgBean> picBeanList;
    private ArrayList<ManageProductsListResponse.DataBean.ProductImgBean> productImageList;
    public ManageProductsListAdapter(Context context, List<ManageProductsListResponse.DataBean> manageProductsListResponseList, boolean showCheckbox,OnItemCheckProduct onItemCheckProduct,ManageProductsDealsListener manageProductsDealsListener) {
        this.context = context;
        this.manageProductsListResponseList = manageProductsListResponseList;
        this.showCheckbox = showCheckbox;
        this.onItemCheckProduct = onItemCheckProduct;
        this.manageProductsDealsListener = manageProductsDealsListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_vendor_productlist_parent_view, parent, false);
        return new ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        initLayoutOne((ViewHolderOne) holder, position);


    }

    @SuppressLint({"SetTextI18n", "LogNotTimber", "LongLogTag"})
    private void initLayoutOne(ViewHolderOne holder, final int position) {
        currentItem = manageProductsListResponseList.get(position);
        if(manageProductsListResponseList.get(position).getProduct_name() != null) {
            holder.txt_prod_name.setText(manageProductsListResponseList.get(position).getProduct_name());
        }
        if(manageProductsListResponseList.get(position).getCost() != 0) {
            holder.txt_prod_price.setText("\u20B9 " + manageProductsListResponseList.get(position).getCost());
        }
        if(manageProductsListResponseList.get(position).getThumbnail_image() != null && !manageProductsListResponseList.get(position).getThumbnail_image().isEmpty()) {
            if (manageProductsListResponseList.get(position).getThumbnail_image() != null && !manageProductsListResponseList.get(position).getThumbnail_image().isEmpty()) {
                Glide.with(context)
                        .load(manageProductsListResponseList.get(position).getThumbnail_image())
                        .into(holder.img_products_image);
            }
        }
        else{
            Glide.with(context)
                    .load(APIClient.BANNER_IMAGE_URL)
                    .into(holder.img_products_image);

        }
     /*   holder.img_expand_arrow.setOnClickListener(v -> {
            currentSelectedPosition = position;
            notifyDataSetChanged();



        });
        if (currentSelectedPosition == position) {
            holder.include_vendor_productlist_childview.setVisibility(View.VISIBLE);
            holder.img_expand_arrow.setImageResource(R.drawable.ic_up);
        }
        else {
            holder.include_vendor_productlist_childview.setVisibility(View.GONE);
            holder.img_expand_arrow.setImageResource(R.drawable.ic_down);
        }*/

      /*  if(manageProductsListResponseList.get(position).getPet_type() != null && manageProductsListResponseList.get(position).getPet_type().size()>0){
            if(manageProductsListResponseList.get(position).getPet_type().get(0).getPet_type_title() != null){
                holder.txt_pet_type.setText(" : "+manageProductsListResponseList.get(position).getPet_type().get(0).getPet_type_title());

            }
        }
        if(manageProductsListResponseList.get(position).getPet_breed() != null && manageProductsListResponseList.get(position).getPet_breed().size()>0) {
            if (manageProductsListResponseList.get(position).getPet_breed().get(0).getPet_breed() != null) {
                holder.txt_pet_breed.setText(" : " + manageProductsListResponseList.get(position).getPet_breed().get(0).getPet_breed());

            }
        }
        if(manageProductsListResponseList.get(position).getPet_age() != null && manageProductsListResponseList.get(position).getPet_age().size()>0) {
            if (manageProductsListResponseList.get(position).getPet_age().get(0) != null) {
                holder.txt_age.setText(" : " + manageProductsListResponseList.get(position).getPet_age().get(0) + "");

            }
        }
       */
        if(manageProductsListResponseList.get(position).getThreshould()!= null){
            holder.txt_products_quantity.setText(" Quantity : "+manageProductsListResponseList.get(position).getThreshould());

        }
        else {

            holder.txt_products_quantity.setText(" Quantity : "+0);

        }

        if(manageProductsListResponseList.get(position).isToday_deal()){
            holder.txt_deal_status.setVisibility(View.VISIBLE);
            holder.txt_deal_status.setText("On Deal");
        }else{
            holder.txt_deal_status.setVisibility(View.GONE);
        }

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if(isChecked){
                if (holder.checkBox.isChecked()) {
                    count++;
                    Log.w(TAG,"ischecked count : "+count);
                    onItemCheckProduct.onItemCheckProduct(count,manageProductsListResponseList.get(position).get_id(),manageProductsListResponseList.get(position).getProduct_name(),manageProductsListResponseList.get(position).getCost());
                }

            }else{
                count--;
                Log.w(TAG,"unchecked count : "+count);
                onItemCheckProduct.onItemUnCheckProduct(count,manageProductsListResponseList.get(position).get_id(),manageProductsListResponseList.get(position).getProduct_name(),manageProductsListResponseList.get(position).getCost());

            }

        });


        holder.img_prodsettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(context, v);


                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup_manageproducts_menu, popup.getMenu());
                if(!manageProductsListResponseList.get(position).isToday_deal()){
                    final Menu menu = popup.getMenu();
                    menu.removeItem(R.id.menu_delete);
                }
                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        String titleName = String.valueOf(item.getTitle());
                        if(titleName.equalsIgnoreCase("Edit")){
                            productImageList= manageProductsListResponseList.get(position).getProduct_img();
                            Log.w(TAG,"productImageList : "+new Gson().toJson(productImageList));
                            additionalDetailList= manageProductsListResponseList.get(position).getAddition_detail();
                            Log.w(TAG,"additionalDetailList : "+new Gson().toJson(additionalDetailList));
                            Intent i = new Intent(context, EditManageProdcutsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.putExtra("productid",manageProductsListResponseList.get(position).get_id());
                            i.putExtra("producttitle",manageProductsListResponseList.get(position).getProduct_name());
                            i.putExtra("productprice",manageProductsListResponseList.get(position).getCost());
                            i.putExtra("productthreshold",manageProductsListResponseList.get(position).getThreshould());
                            i.putExtra("productdesc",manageProductsListResponseList.get(position).getProduct_discription());
                            i.putExtra("productcategoryname",manageProductsListResponseList.get(position).getCat_id().getProduct_cate());
                            i.putExtra("productcategoryid",manageProductsListResponseList.get(position).getCat_id().get_id());
                            i.putExtra("condition",manageProductsListResponseList.get(position).getCondition());
                            i.putExtra("pricetype",manageProductsListResponseList.get(position).getPrice_type());


                            Bundle args = new Bundle();
                            //int list = dataBeanList.get(position).getPet_img().size();
                            args.putSerializable("PRODUCTLIST", (Serializable)productImageList);

                            i.putExtra("productImageList",args);
                            i.putStringArrayListExtra("additionalDetailList",additionalDetailList);

                            context.startActivity(i);

                        } else if(titleName.equalsIgnoreCase("Clear Deals")){
                            if(manageProductsListResponseList.get(position).isToday_deal()){
                                manageProductsDealsListener.manageProductsDealsListener(manageProductsListResponseList.get(position).isToday_deal(),manageProductsListResponseList.get(position).get_id());
                            }
                            else{
                                final Menu menu = popup.getMenu();
                                menu.removeItem(R.id.menu_delete);
                                /*if(item.getItemId() == R.id.menu_delete){
                                    item.setVisible(false);
                                }*/

                            }


                        }
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });


    }









    @Override
    public int getItemCount() {
        return manageProductsListResponseList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView txt_prod_name,txt_prod_price,txt_products_quantity,txt_pet_type,txt_age,txt_pet_breed,txt_threshold,txt_deal_status;
        public ImageView img_products_image,img_prodsettings,img_expand_arrow;
        public View include_vendor_productlist_childview;
        public CheckBox checkBox;
        public ViewHolderOne(View itemView) {
            super(itemView);
            img_products_image = itemView.findViewById(R.id.img_products_image);
            img_prodsettings = itemView.findViewById(R.id.img_prodsettings);
            txt_prod_name = itemView.findViewById(R.id.txt_prod_name);
            txt_prod_price = itemView.findViewById(R.id.txt_prod_price);

            txt_deal_status = itemView.findViewById(R.id.txt_deal_status);
            txt_products_quantity = itemView.findViewById(R.id.txt_products_quantity);

//            include_vendor_productlist_childview.setVisibility(View.GONE);

            txt_deal_status.setVisibility(View.GONE);
            checkBox = itemView.findViewById(R.id.checkBox);

            img_prodsettings.setVisibility(View.VISIBLE);

            if(showCheckbox){
                checkBox.setVisibility(View.VISIBLE);
            } else {

                checkBox.setVisibility(View.GONE);

            }
        }

    }







}
