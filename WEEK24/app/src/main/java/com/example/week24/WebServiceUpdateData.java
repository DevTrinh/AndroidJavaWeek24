package com.example.week24;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.example.week24.item.ItemStudent;

import java.util.HashMap;
import java.util.Map;

public class WebServiceUpdateData extends AppCompatActivity implements InterfaceDefaultValue {

    EditText etUpdateId, etUpdateName, etUpdateAddress, etUpdateDate;
    Button btUpdateConfirm, btUpdateCancel;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_update_data);

        mapping();

        String url = "https://phptojsonlocalhostt.000webhostapp.com/update.php";

        Intent intent = getIntent();
        ItemStudent student = (ItemStudent) intent.getSerializableExtra(OBJECT_STUDENT);
        etUpdateId.setText(student.getId() + "");
        etUpdateName.setText(student.getName());
        etUpdateDate.setText(student.getAge());
        etUpdateAddress.setText(student.getAddress());
        Toast.makeText(this, student.getName()
                + "", Toast.LENGTH_SHORT).show();

        btUpdateCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btUpdateConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDataStudent(url);
                finish();
            }
        });
    }

    private void updateDataStudent(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("SUCCESSFUL")) {
                    Toast.makeText(WebServiceUpdateData.this
                            , "UPDATE SUCCESSFUL", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WebServiceUpdateData.this
                            , "UPDATE FALSE", Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(
                        WebServiceUpdateData.this, WebServiceReturnJSON.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WebServiceUpdateData.this,
                        error + "", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(ID, etUpdateId.getText().toString());
                params.put(NAME, etUpdateName.getText().toString());
                params.put(DATE, etUpdateDate.getText().toString());
                params.put(ADDRESS, etUpdateAddress.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void mapping() {
        etUpdateId = findViewById(R.id.et_update_id);
        etUpdateName = findViewById(R.id.et_update_name);
        etUpdateAddress = findViewById(R.id.et_update_address);
        etUpdateDate = findViewById(R.id.et_update_date);
        btUpdateCancel = findViewById(R.id.bt_update_dialog_cancel);
        btUpdateConfirm = findViewById(R.id.bt_update_dialog_confirm);
    }
}