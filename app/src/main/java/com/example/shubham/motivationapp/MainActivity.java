package com.example.shubham.motivationapp;

/*
 * Created by Shubham Srivastava (shubhamvns115@gmail.com)
 */

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.shubham.motivationapp.Listner.QuoteDataListner;
import com.example.shubham.motivationapp.controller.PageAdapter;
import com.example.shubham.motivationapp.data.QuoteData;
import com.example.shubham.motivationapp.model.Quate;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager= findViewById(R.id.viewPager);
        pageAdapter=new PageAdapter(getSupportFragmentManager(),getFragmentLists());
        viewPager.setAdapter(pageAdapter);


    }

   private List<Fragment> getFragmentLists(){

        final List<Fragment> fragmentList= new ArrayList<>();
        QuoteData quoteData= new QuoteData();
        quoteData.getQuote(new QuoteDataListner() {
            @Override
            public void onDataReceived(List<Quate> quates) {
                for (int i=0;i<quates.size();i++){

                    QuoteFragment quoteFragment = QuoteFragment.setFragment(quates.get(i).getQuote(),
                            quates.get(i).getName()
                    );
                    fragmentList.add(quoteFragment);
                }
                pageAdapter.notifyDataSetChanged();

            }
        });

      return fragmentList;
    }
}
