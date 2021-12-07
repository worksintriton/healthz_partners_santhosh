package com.triton.healthzpartners.adapter;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.triton.healthzpartners.R;
import com.triton.healthzpartners.interfaces.OnItemSelectedTime;
import com.triton.healthzpartners.customer.PetServiceAppointment_Doctor_Date_Time_Activity;
import com.triton.healthzpartners.responsepojo.PetDoctorAvailableTimeResponse;
import com.triton.healthzpartners.responsepojo.SPAvailableTimeResponse;

import java.util.List;

import es.dmoral.toasty.Toasty;


public class PetServiceMyCalendarAvailableAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ONE = 1;
    private static final int TYPE_LOADING = 5;
    private  String TAG = "PetServiceMyCalendarAvailableAdapter";


    private List<SPAvailableTimeResponse.DataBean.TimesBean> timesBeanList;



    private Context context;

    PetDoctorAvailableTimeResponse.DataBean currentItem;
    String strMSgdaystime;
    String strMsg;

    private Boolean isPoll = false;
    String formatedDate,formatedStartDate = "";
    Dialog dialog;
    private OnItemSelectedTime mCallback;
    private int selectedPosition =-1;


    public PetServiceMyCalendarAvailableAdapter(Context context, List<SPAvailableTimeResponse.DataBean.TimesBean> timesBeanList, RecyclerView inbox_list, PetServiceAppointment_Doctor_Date_Time_Activity petServiceAppointment_doctor_date_time_activity) {
        this.timesBeanList = timesBeanList;
        this.context = context;
        this.mCallback = (OnItemSelectedTime)petServiceAppointment_doctor_date_time_activity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pet_mycalendar_available_cardview, parent, false);
        return new ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        initLayoutOne((ViewHolderOne) holder, position);


    }

    private void initLayoutOne(ViewHolderOne holder, final int position) {

        if(timesBeanList != null && timesBeanList.size()>0) {
            // currentItem = dataBeanList.get(position);
            for (int i = 0; i < timesBeanList.size(); i++) {
                if(timesBeanList.get(position).getTime() != null ) {
                    holder.txt_days.setText(timesBeanList.get(position).getTime());
                    Log.w(TAG, "Times : " + timesBeanList.get(position).getTime());
                }

            }
        }

        holder.txt_days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timesBeanList.get(position).isBook_status()) {
                    mCallback.onItemSelectedTime(timesBeanList.get(position).getTime());
                    selectedPosition = position;
                    notifyDataSetChanged();
                }else{
                    Toasty.warning(context, "Slot Not Available", Toast.LENGTH_SHORT, true).show();

                }




            }
        });

        if(selectedPosition==position){
            holder.txt_days.setBackgroundResource(R.drawable.button_blue_rounded_corner_without_stroke);
            holder.txt_days.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else{
            holder.txt_days.setBackgroundResource(R.drawable.white_corner_background_solid);
            holder.txt_days.setTextColor(ContextCompat.getColor(context, R.color.black));

        }

        if(!timesBeanList.get(position).isBook_status()){
            holder.txt_days.setBackgroundResource(R.drawable.button_gray_rounded_corner);

        }







    }









    @Override
    public int getItemCount() {
        return timesBeanList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView txt_days;




        public ViewHolderOne(View itemView) {
            super(itemView);

            txt_days = itemView.findViewById(R.id.txt_days);












        }




    }














}
