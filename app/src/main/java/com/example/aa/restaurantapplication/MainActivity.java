package com.example.aa.restaurantapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    RecyclerView.Adapter rAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<Restaurant> restaurantDetails;

    RequestQueue rq;
    String request_url = "http://localhost/testapi.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq = Volley.newRequestQueue(this);
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler_view.setLayoutManager(layoutManager);
        restaurantDetails = new ArrayList<>();

        getDetails();
    }

    public void getDetails(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=22.5852068,88.491205&radius=300&type=restaurant&key=AIzaSyCUA98jhSIi-uvJpsGwFFJ2XKfppObMXro", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jObj = new JSONObject(response.toString());
                            System.out.println("jobj :" + jObj.toString());

                            JSONArray jarr = jObj.optJSONArray("results");
                            System.out.println("Restaurant_Details" +jarr);

                            for (int i = 0; i < jarr.length(); i++) {

                                JSONObject jo = jarr.getJSONObject(i);

                                Restaurant rdata = new Restaurant();


                                rdata.setProduct(jo.optString("name"));
                                rdata.setVicinity(jo.optString("vicinity"));
                                //rdata.setRating(Float.parseFloat(jo.optString("rating")));

                                /*JSONObject jobject = jo.getJSONObject("opening_hours");
                                String job = jobject.optString("open_now");
                                rdata.setOpen(job);
*/
                               /* JSONArray jarray = jo.getJSONArray("photos");
                                for(int j=0; j<jarray.length(); j++) {
                                    JSONArray jarr1 = jarray.getJSONObject(j).getJSONArray("html_attributions");
                                    for(int k=0; k<jarr1.length(); k++){


                                    }
                                }*/

                                restaurantDetails.add(rdata);

                            }
                            rAdapter = new RestaurantAdapter(MainActivity.this, restaurantDetails);
                            recycler_view.setAdapter(rAdapter);

                            System.out.println("total arraylist size : " + restaurantDetails.size());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Error Occur" + error);
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);


    }
    }

