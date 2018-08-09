package com.example.shubham.motivationapp.Listner;

/*
 * Created by Shubham Srivastava (shubhamvns115@gmail.com)
 */

import com.example.shubham.motivationapp.model.Quate;

import java.util.List;

public interface QuoteDataListner {
    public void onDataReceived(List<Quate>quates);
}
