package com.animator_abhi.gcethackathon.Investor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.animator_abhi.gcethackathon.R;

public class InvestorMain extends AppCompatActivity {
    TextView i_n,i_c,i_d,i_p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investor_main);

        i_n = (TextView) findViewById(R.id.i_n);
        i_c = (TextView) findViewById(R.id.i_c);
        i_d = (TextView) findViewById(R.id.i_d);
        i_p = (TextView) findViewById(R.id.i_p);

        Intent i=getIntent();
        String investor_name =i.getStringExtra("i_n");
        String investor_company=i.getStringExtra("i_c");
        String investor_description=i.getStringExtra("i_d");
        String investor_potential=i.getStringExtra("i_p");

        i_n.setText("Investor Name : "+investor_name);
        i_c.setText("Investor Company : "+investor_company);
        i_d.setText("About Investment : "+investor_description);
        i_p.setText("Potential of Investment : "+investor_potential);
    }
}
