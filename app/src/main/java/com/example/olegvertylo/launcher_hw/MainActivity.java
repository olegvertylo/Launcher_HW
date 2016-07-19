package com.example.olegvertylo.launcher_hw;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button btnCall;
    private Button btn;
    private Button btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        btnCall = (Button) findViewById(R.id.btnCall);
        btn = (Button) findViewById(R.id.btn);
        btnSms = (Button) findViewById(R.id.btnSms);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.btn:
                        List<PackageInfo> apps = getPackageManager().getInstalledPackages(0);
                        Intent LaunchApp = getPackageManager().getLaunchIntentForPackage(apps.toString());
                        startActivity( LaunchApp );

                    case R.id.btnCall:
                        String number = "0931111111";
                        Uri call = Uri.parse("tel:" + number);
                        Intent call_number = new Intent(Intent.ACTION_DIAL, call);
                        startActivity(call_number);
                        break;
                    case R.id.btnSms:
                        Intent sms = new Intent(Intent.ACTION_VIEW);
                        sms.setType("vnd.android-dir/mms-sms");
                        sms.putExtra("sms_body", "TEXT SMS");
                        startActivity(sms);
                        break;

                }
            }

            ;


        };

        btn.setOnClickListener(onClickListener);
        btnCall.setOnClickListener(onClickListener);
        btnSms.setOnClickListener(onClickListener);
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


}