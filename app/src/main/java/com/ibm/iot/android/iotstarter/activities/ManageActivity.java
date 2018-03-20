package com.ibm.iot.android.iotstarter.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.ibm.iot.android.iotstarter.R;
import com.ibm.iot.android.iotstarter.restservices.RestManager;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageActivity extends Activity {

    RestManager restManager;
    EditText rNumber;
    EditText gNumber;
    EditText bNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        restManager = new RestManager(this);
        Switch switchManage =(Switch) findViewById(R.id.switch1);
        rNumber=(EditText)findViewById(R.id.redEditText) ;
        gNumber=(EditText)findViewById(R.id.greenEditText);
        bNumber =(EditText)findViewById(R.id.blueEditText);

        switchManage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                restManager.postLightbulb(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(ManageActivity.this, "Good job", Toast.LENGTH_SHORT).show();
                        //500
                        if (response.code() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                            Toast.makeText(ManageActivity.this, "Problem with server. Error 500", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(ManageActivity.this, "Too bad", Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });

    }


    public void manageClick(View view) {

        Integer redNumber=Integer.parseInt(rNumber.getText().toString());
        Integer greenNumber=Integer.parseInt(gNumber.getText().toString());
        Integer blueNumber =Integer.parseInt(bNumber.getText().toString());

        restManager.setLightColor(redNumber, greenNumber, blueNumber, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                   Toast.makeText(ManageActivity.this,"Good work",Toast.LENGTH_SHORT).show();
                if (response.code() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                    Toast.makeText(ManageActivity.this, "Problem with server. Error 500", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    public void defaultClick(View view) {
        restManager.postDefault(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(ManageActivity.this,"Default light",Toast.LENGTH_SHORT).show();
                if (response.code() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                    Toast.makeText(ManageActivity.this, "Problem with server. Error 500", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void setOnClick(View view) {
        restManager.postOn(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(ManageActivity.this,"On",Toast.LENGTH_SHORT).show();
                if (response.code() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                    Toast.makeText(ManageActivity.this, "Problem with server. Error 500", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void setOffClick(View view) {

        restManager.postOff(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(ManageActivity.this,"Off",Toast.LENGTH_SHORT).show();
                if (response.code() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                    Toast.makeText(ManageActivity.this, "Problem with server. Error 500", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
