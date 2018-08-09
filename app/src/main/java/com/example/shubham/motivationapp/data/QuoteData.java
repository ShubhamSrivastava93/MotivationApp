package com.example.shubham.motivationapp.data;

/*
 * Created by Shubham Srivastava (shubhamvns115@gmail.com)
 */

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.shubham.motivationapp.Listner.QuoteDataListner;
import com.example.shubham.motivationapp.controller.DataController;
import com.example.shubham.motivationapp.model.Quate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuoteData {

    ArrayList<Quate> list= new ArrayList<>();
    String url="https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20";



    public  ArrayList getQuote(final QuoteDataListner callBack){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(JsonArrayRequest.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0;i<response.length();i++){
                    try {

                        JSONObject jsonObject= response.getJSONObject(i);
                        Quate quate= new Quate();
                        quate.setQuote(jsonObject.getString("quote"));
                        quate.setName(jsonObject.getString("name"));
                        list.add(quate);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if(callBack!=null) callBack.onDataReceived(list);

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        DataController.getInstance().addToRequestQueue(jsonArrayRequest);
        return list;

    }

}
