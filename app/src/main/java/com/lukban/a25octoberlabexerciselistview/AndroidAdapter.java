package com.lukban.a25octoberlabexerciselistview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lukban.a25octoberlabexerciselistview.AndroidCompanies;

import java.util.List;

public class AndroidAdapter extends ArrayAdapter<AndroidCompanies>{
    private Context context;
    private int resource;

    public AndroidAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int logo = getItem(position).getLogo();
        String XcompName = getItem(position).getCompName();
        String XcompCountry = "Country: " + getItem(position).getCompCountry();
        String XcompIndustry = "Industry: " + getItem(position).getCompIndustry();
        String XcompCEO = "CEO: " + getItem(position).getCompCEO();
        String XcompDesc = getItem(position).getCompDesc();


        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView img = convertView.findViewById(R.id.imageView);
        TextView companyName = convertView.findViewById(R.id.compName);
        TextView companyCountry = convertView.findViewById(R.id.compCountry);
        TextView companyIndustry = convertView.findViewById(R.id.compIndustry);
        TextView companyCEO = convertView.findViewById(R.id.compCEO);

        img.setImageResource(logo);
        companyName.setText(XcompName);
        companyCountry.setText(XcompCountry);
        companyIndustry.setText(XcompIndustry);
        companyCEO.setText(XcompCEO);

        return convertView;
    }
}
