package com.example.week24;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.week24.adapter.AdapterStudent;
import com.example.week24.interfacee.InterfaceDefaultValue;
import com.example.week24.interfacee.InterfaceSelection;
import com.example.week24.item.ItemStudent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebServiceReturnJSON extends AppCompatActivity implements InterfaceDefaultValue {

    EditText etWebService;
    RecyclerView rvStudent;
    AdapterStudent adapterStudent;
    List<ItemStudent> listStudent;

    String urlGetData;
    String urlDelete;
    int local;
    ImageView ivNavigation;
    ProgressBar pbLoadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_return_json);
        Toast.makeText(this, "Web Service Return JSON Called",
                Toast.LENGTH_SHORT).show();

        mapping();
        pbLoadData.setVisibility(View.VISIBLE);
        urlGetData = "https://phptojsonlocalhostt.000webhostapp.com/getData.php";
        urlDelete = "https://phptojsonlocalhostt.000webhostapp.com/delete.php";

        listStudent = new ArrayList<>();
        getJsonData(urlGetData);
        pbLoadData.setVisibility(View.VISIBLE);
    }

    //    STEP 1:
    private void getJsonData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(Request.Method.GET, url,
                        null, new Response.Listener<JSONArray>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onResponse(JSONArray response) {
                        listStudent.clear();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                listStudent.add(new ItemStudent(object.getInt("id"),
                                        object.getString("name"),
                                        object.getString("age"),
                                        object.getString("address")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        adapterStudent = new AdapterStudent(listStudent, new InterfaceSelection() {
                            @Override
                            public void onClickInsertData(int position) {
                                local = position;
                                showPopUp(findViewById(R.id.iv_item_menu), position, listStudent);
                            }
                        });
                        LinearLayoutManager linearLayoutManager =
                                new LinearLayoutManager(WebServiceReturnJSON.this,
                                        RecyclerView.VERTICAL, false);
                        rvStudent.setLayoutManager(linearLayoutManager);
                        rvStudent.setAdapter(adapterStudent);
                        adapterStudent.notifyItemChanged(local);
                        pbLoadData.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(WebServiceReturnJSON.this,
                                error.toString() + "", Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(jsonArrayRequest);
    }

    private void mapping() {
        etWebService = findViewById(R.id.et_text_webservice);
        rvStudent = findViewById(R.id.rv_student);
        ivNavigation = findViewById(R.id.iv_item_menu);
        pbLoadData = findViewById(R.id.pb_load_data_in_JSON);

    }

    public void showPopUp(View v, int position, List<ItemStudent> list) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().
                inflate(R.menu.mn_nav_student, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.it_nav_update:
                        Intent mainToUpdate = new Intent(WebServiceReturnJSON.this,
                                WebServiceUpdateData.class);
                        mainToUpdate.putExtra(OBJECT_STUDENT, list.get(position));
                        startActivity(mainToUpdate);
                        Toast.makeText(WebServiceReturnJSON.this,
                                list.get(position).getName() + "", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.it_nav_delete:
                        dialogDeleteItemStudent(listStudent, position);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                return false;
            }
        });
    }

    public void dialogDeleteItemStudent(@NonNull List<ItemStudent> list, int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("You want delete student ID: '"
                + list.get(position).getId() + "' ?");
        alertDialog.setPositiveButton("Yes"
                + position, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteItemStudent(urlDelete, position);
            }
        });
        alertDialog.setNegativeButton("Not now",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }

    public void deleteItemStudent(String url, int position) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("SUCCESSFUL")) {
                    getJsonData(urlGetData);
                    Toast.makeText(WebServiceReturnJSON.this, "DELETE SUCCESSFUL",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WebServiceReturnJSON.this,
                            "DELETE FALSE", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WebServiceReturnJSON.this, error + "",
                        Toast.LENGTH_SHORT).show();
            }
        }) {
            @NonNull
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(ID, listStudent.get(position).getId() + "");
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_return_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.it_return_home) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (item.getItemId() == R.id.it_add_person) {
            startActivity(new Intent(this, WebServiceInsertData.class));
        }
        return super.onOptionsItemSelected(item);
    }
}