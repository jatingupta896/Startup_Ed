package com.animator_abhi.gcethackathon.Startup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.animator_abhi.gcethackathon.R;

public class StartupMain extends AppCompatActivity {
TextView s_n,s_f,s_d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_main);
        s_n = (TextView) findViewById(R.id.s_n);
        s_f = (TextView) findViewById(R.id.s_f);
        s_d = (TextView) findViewById(R.id.s_d);

        Intent i=getIntent();
        String startup_name =i.getStringExtra("s_n");
        String startup_founder=i.getStringExtra("s_f");
        String startup_description=i.getStringExtra("s_d");

        s_n.setText("Domain : "+startup_name);
        s_f.setText("Founder : "+startup_founder);
        s_d.setText("About Startup : "+startup_description);


    }
}
