package com.lukban.a25octoberlabexerciselistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] comName, comCountry, comIndustry, comCEO, comDesc;
    final int[] logo = {R.drawable.icbc, R.drawable.jpmc, R.drawable.ccb, R.drawable.abc, R.drawable.boa, R.drawable.apple, R.drawable.pingan, R.drawable.bankofchina, R.drawable.shell, R.drawable.wellsfargo, R.drawable.exxonmobil, R.drawable.att, R.drawable.samsung, R.drawable.citigroup};
    ArrayList<AndroidCompanies> companies = new ArrayList<>();
    ListView listCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comName = getResources().getStringArray(R.array.companyName);
        comCountry = getResources().getStringArray(R.array.companyCountry);
        comIndustry = getResources().getStringArray(R.array.companyIndustry);
        comCEO = getResources().getStringArray(R.array.companyCEO);
        comDesc = getResources().getStringArray(R.array.companyDesc);

        for (int i = 0; i < comName.length; i++) {
            companies.add(new AndroidCompanies(logo[i], comName[i], comCountry[i], comIndustry[i], comCEO[i], comDesc[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.layoutforapp, companies);
        listCompanies = findViewById(R.id.lvAndroid);
        listCompanies.setAdapter(adapter);
        listCompanies.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "companies.txt");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            String userChoice = companies.get(i).getCompName() + " " + companies.get(i).getCompCountry() + " " + companies.get(i).getCompIndustry() + " " + companies.get(i).getCompCEO();
            fos.write(userChoice.getBytes());

            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setIcon(logo[i]);
            dialog.setTitle(comName[i]);
            dialog.setMessage(comDesc[i]);
            dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    try {
                        FileInputStream fis = new FileInputStream(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/companies.txt"));

                        int i;
                        String str = "";

                        while ((i = fis.read()) != -1) {
                            str += Character.toString((char) i);
                        }
                        fis.close();
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                //Toast.makeText(MainActivity.this, comName[i],Toast.LENGTH_LONG).show();

            });
            dialog.create().show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
