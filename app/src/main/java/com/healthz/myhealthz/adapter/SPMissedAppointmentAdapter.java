package com.healthz.myhealthz.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthz.myhealthz.R;
import com.healthz.myhealthz.api.APIClient;
import com.healthz.myhealthz.responsepojo.SPAppointmentResponse;
import com.healthz.myhealthz.serviceprovider.SPAppointmentDetailsActivity;

import java.util.List;


public class SPMissedAppointmentAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  String TAG = "SPMissedAppointmentAdapter";
    private List<SPAppointmentResponse.DataBean> missedAppointmentResponseList;
    private Context context;
    private int size;
    String ImagePath;

    SPAppointmentResponse.DataBean currentItem;


    public SPMissedAppointmentAdapter(Context context, List<SPAppointmentResponse.DataBean> missedAppointmentResponseList, RecyclerView inbox_list, int size) {
        this.missedAppointmentResponseList = missedAppointmentResponseList;
        this.context = context;
        this.size = size;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_doctor_missed_appointment, parent, false);
        return new ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        initLayoutOne((ViewHolderOne) holder, position);


    }

    @SuppressLint("SetTextI18n")
    private void initLayoutOne(ViewHolderOne holder, final int position) {

        Log.w(TAG,"Pet name-->"+missedAppointmentResponseList.get(position).getPatient_id().getName());

        currentItem = missedAppointmentResponseList.get(position);
        Log.w(TAG,"Pet name-->"+missedAppointmentResponseList.get(position).getPatient_id().getName());

        currentItem = missedAppointmentResponseList.get(position);
        if(missedAppointmentResponseList.get(position).getPatient_id().getName() != null) {
            holder.txt_petname.setText(missedAppointmentResponseList.get(position).getPatient_id().getName());
        }
        if(missedAppointmentResponseList.get(position).getPatient_id().getRelation() != null) {
            holder.txt_pettype.setText(missedAppointmentResponseList.get(position).getPatient_id().getRelation());
        }
        holder.txt_lbl_type.setText("Service Name");
        if(missedAppointmentResponseList.get(position).getService_name() != null){
            holder.txt_type.setText(missedAppointmentResponseList.get(position).getService_name());
        }
        if(missedAppointmentResponseList.get(position).getService_amount() != null){
            holder.txt_service_cost.setText("\u20B9 "+missedAppointmentResponseList.get(position).getService_amount());
        }

        if(missedAppointmentResponseList.get(position).getMissed_at() != null){
            holder.txt_missed_date.setText("Missed on:"+" "+missedAppointmentResponseList.get(position).getMissed_at());

        }

        Log.w(TAG,"Pet_img : "+missedAppointmentResponseList.get(position).getPatient_id().getPic());

        if (missedAppointmentResponseList.get(position).getPatient_id().getPic() != null && missedAppointmentResponseList.get(position).getPatient_id().getPic().size() > 0) {
            for(int j=0;j<missedAppointmentResponseList.get(position).getPatient_id().getPic().size();j++) {
                ImagePath = missedAppointmentResponseList.get(position).getPatient_id().getPic().get(j).getImage();

            }
        }

        if (ImagePath != null && !ImagePath.isEmpty()) {
            Glide.with(context)
                    .load(ImagePath)
                    .into(holder.img_pet_imge);
        } else{
            Glide.with(context)
                    .load(APIClient.PROFILE_IMAGE_URL)
                    .into(holder.img_pet_imge);

        }

        holder.txt_pettypelabel.setText("Relation Type");

        if(missedAppointmentResponseList.get(position).getAppoinment_status() != null) {
            holder.txt_appointment_status.setText(missedAppointmentResponseList.get(position).getAppoinment_status());
        }

        holder.ll_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SPAppointmentDetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("appointment_id",missedAppointmentResponseList.get(position).get_id());
                i.putExtra("fromactivity",TAG);
                context.startActivity(i);

            }
        });



    }


    @Override
    public int getItemCount() {
        return Math.min(missedAppointmentResponseList.size(), size);
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView txt_petname,txt_pettype,txt_type,txt_appointment_status,txt_service_cost,txt_missed_date,txt_lbl_type,txt_pettypelabel;
        public ImageView img_pet_imge,img_emergency_appointment;
        public Button btn_cancel,btn_complete;
        public LinearLayout ll_new;


        public ViewHolderOne(View itemView) {
            super(itemView);
            img_pet_imge = itemView.findViewById(R.id.img_pet_imge);
            txt_petname = itemView.findViewById(R.id.txt_petname);
            txt_pettype = itemView.findViewById(R.id.txt_pettype);
            txt_lbl_type = itemView.findViewById(R.id.txt_lbl_type);
            txt_type = itemView.findViewById(R.id.txt_type);
            txt_service_cost = itemView.findViewById(R.id.txt_service_cost);
            txt_missed_date = itemView.findViewById(R.id.txt_missed_date);
            txt_pettypelabel = itemView.findViewById(R.id.txt_pettypelabel);
            txt_appointment_status = itemView.findViewById(R.id.txt_appointment_status);
            btn_cancel = itemView.findViewById(R.id.btn_cancel);
            btn_complete = itemView.findViewById(R.id.btn_complete);
            ll_new = itemView.findViewById(R.id.ll_new);

            img_emergency_appointment = itemView.findViewById(R.id.img_emergency_appointment);
            img_emergency_appointment.setVisibility(View.GONE);




        }




    }








}
