package com.learn.volleytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyler_view);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callWs();
//dfdffdf
            }


        });




    }

    public  void callWs()
    {
        //                Map<String, String> mHeaderParams = new HashMap<>();
//                mHeaderParams.put(NetworkUtility.TAGS.USER_ID, userDetails.userID);
//                mHeaderParams.put(NetworkUtility.TAGS.X_API_KEY, PreferenceUtility.getInstance(mContext).getXAPIKey());
//
//                //Add Params
//                Map<String, String> mParams = new HashMap<>();
//                mParams.put(TASK_ID, taskId);
//                mParams.put(NetworkUtility.TAGS.REASON, reason);

        VolleyNetworkRequest mVolleyNetworkRequest = new VolleyNetworkRequest("https://simplifiedcoding.net/demos/view-flipper/heroes.php"
                , mCallCancelTaskWSErrorListener
                , mCallCancelTaskWSResponseListener
                , null
                , null
                , null);
        Volley.getInstance(getBaseContext()).addToRequestQueue(mVolleyNetworkRequest);
    }


    Response.Listener mCallCancelTaskWSResponseListener =new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            try
            {
                JSONObject jsonObject = new JSONObject(response.toString());
                JSONArray aaa=new JSONArray(jsonObject.optString("heroes"));
                ArrayList<HeroModel> data = GsonUtility.getObjectListFromJsonString(jsonObject.optString("heroes"), HeroModel[].class);
                ArrayList<HeroModel.Hero> data1 = GsonUtility.getObjectListFromJsonString(aaa.toString(), HeroModel.Hero[].class);

                Log.e("TAG", "data: =" + data1.get(0).getName());
                RecyclerViewAdapter adapter =new RecyclerViewAdapter(data1);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(adapter);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    };

    Response.ErrorListener mCallCancelTaskWSErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error)
        {

            System.out.println("-----------"+error);
        }
    };

}
