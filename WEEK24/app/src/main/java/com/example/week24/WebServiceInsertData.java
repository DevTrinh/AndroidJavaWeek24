package com.example.week24;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.week24.interfacee.InterfaceDefaultValue;

import java.util.HashMap;
import java.util.Map;

public class WebServiceInsertData extends AppCompatActivity implements InterfaceDefaultValue {

    EditText etAddId, etAddName, etAddDate, etAddAddress;
    Button btCancel, btConfirm;

    String url = "https://phptojsonlocalhostt.000webhostapp.com/insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_insert_data);

        mapping();

        Toast.makeText(this, "CAllED WebServiceInsertData",
                Toast.LENGTH_SHORT).show();

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteIdText = etAddId.getText().toString();
                String noteNameText = etAddName.getText().toString();
                String noteDateText = etAddDate.getText().toString();
                String noteAddressText = etAddAddress.getText().toString();
                if (testString(noteAddressText) == 0 ||
                        testString(noteIdText) == 0 ||
                        testString(noteNameText) == 0 ||
                        testString(noteDateText) == 0) {
                    Toast.makeText(WebServiceInsertData.this,
                            "You have entered missing data, please re-enter",
                            Toast.LENGTH_SHORT).show();
                } else {
                    addStudentWithVolley(url);
                    finish();
                }
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int testString(@NonNull String string) {
        int i = string.trim().length();
        return i;
    }

    public void mapping() {
        etAddId = findViewById(R.id.et_add_id);
        etAddName = findViewById(R.id.et_add_name);
        etAddDate = findViewById(R.id.et_add_date);
        etAddAddress = findViewById(R.id.et_add_address);
        btCancel = findViewById(R.id.bt_dialog_cancel);
        btConfirm = findViewById(R.id.bt_dialog_confirm);
    }

    private void addStudentWithVolley(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest =
                new StringRequest(Request.Method.POST,
                        url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("SUCCESSFUL")) {
                            Toast.makeText(WebServiceInsertData.this,
                                    "ADD SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(WebServiceInsertData.this,
                                    "a process error occurred", Toast.LENGTH_SHORT).show();
                        }
                        startActivity(new Intent(WebServiceInsertData.this,
                                WebServiceReturnJSON.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(WebServiceInsertData.this,
                                error + "", Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put(ID, etAddId.getText().toString().trim() + "");
                        params.put(NAME, etAddName.getText().toString().trim());
                        params.put(DATE, etAddDate.getText().toString().trim());
                        params.put(ADDRESS, etAddAddress.getText().toString().trim());
                        return params;
                    }
                };
        requestQueue.add(stringRequest);
    }
}