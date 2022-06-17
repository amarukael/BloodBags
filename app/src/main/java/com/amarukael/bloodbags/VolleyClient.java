package com.amarukael.bloodbags;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyClient {
    RequestQueue requestQueue;
    static VolleyClient mInstance;
    private VolleyClient(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleyClient getmInstance(Context context){

        if (mInstance == null){
            mInstance = new VolleyClient(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){return requestQueue;}
}
