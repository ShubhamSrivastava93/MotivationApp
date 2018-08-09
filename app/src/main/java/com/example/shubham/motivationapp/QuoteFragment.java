package com.example.shubham.motivationapp;

/*
 * Created by Shubham Srivastava (shubhamvns115@gmail.com)
 */

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.CardView;

import java.util.concurrent.ThreadLocalRandom;

public class QuoteFragment extends Fragment {



    public QuoteFragment() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View quoteView= inflater.inflate(R.layout.fragment_quote,container,false);
        CardView cardView =  quoteView.findViewById(R.id.cart);
        TextView quote= quoteView.findViewById(R.id.quoteText);
        TextView author = quoteView.findViewById(R.id.authorText);
        quote.setText(getArguments().getString("quote"));
        author.setText(getArguments().getString("author"));
        int color [] = new int[]{
          R.color.pink_A200,R.color.red_A100,R.color.cart,R.color.pink_A100

        };
        cardView.setBackgroundResource(getRandomColor(color));
        return quoteView;
    }

    public static QuoteFragment setFragment(String quote, String author){
        QuoteFragment fragment= new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote",quote);
        bundle.putString("author",author);
        fragment.setArguments(bundle);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private int getRandomColor(int color[]){

        int random= ThreadLocalRandom.current().nextInt(color.length);
        return color[random];
    }
}
