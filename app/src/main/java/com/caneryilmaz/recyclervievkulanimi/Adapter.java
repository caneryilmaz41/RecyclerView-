package com.caneryilmaz.recyclervievkulanimi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MeyvelerHolder> {

    private ArrayList<Meyveler>meyvelerList;

    public Adapter(ArrayList<Meyveler> meyvelerList, Context context) {
        this.meyvelerList = meyvelerList;
        this.context = context;
    }

    private Context context;
    private OnItemClickListener listener;



    @NonNull
    @Override
    public MeyvelerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.meyveler_item,parent,false);

        return new MeyvelerHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MeyvelerHolder holder, int position) {
        Meyveler meyveler=meyvelerList.get(position);
        holder.setData(meyveler);

    }

    @Override
    public int getItemCount() {
        return meyvelerList.size();
    }

    class MeyvelerHolder extends RecyclerView.ViewHolder{
        TextView meyveIsmi,meyveKalori;
        ImageView meyveResmi;


        public MeyvelerHolder(@NonNull View itemView) {
            super(itemView);
            meyveIsmi=(TextView)itemView.findViewById(R.id.textViewMeyveIsmi);
            meyveKalori=(TextView) itemView.findViewById(R.id.textViewMeyveKalori);
            meyveResmi=(ImageView) itemView.findViewById(R.id.meyveler_item_imageViewResim);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    if (listener!=null && position!= RecyclerView.NO_POSITION)
                        listener.onItemClick(meyvelerList.get(position),position);
                }
            });

        }
        public void setData(Meyveler meyveler){
            this.meyveIsmi.setText(meyveler.getName());
            this.meyveKalori.setText(String.valueOf(meyveler.getKalori()));
            this.meyveResmi.setBackgroundResource(meyveler.getmImage());
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Meyveler meyveler,int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;

    }
}
