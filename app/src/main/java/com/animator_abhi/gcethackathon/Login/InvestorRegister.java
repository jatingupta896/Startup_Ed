package com.animator_abhi.gcethackathon.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.animator_abhi.gcethackathon.R;
import com.animator_abhi.gcethackathon.Startup.StartupMain;

public class InvestorRegister extends AppCompatActivity {
    Button investor_register;
    EditText investor_name, investor_company, investor_description, investor_potential;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investor_register);
        investor_name = (EditText) findViewById(R.id.investor_name);
        investor_company = (EditText) findViewById(R.id.investor_company);
        investor_description = (EditText) findViewById(R.id.investor_description);
        investor_potential = (EditText) findViewById(R.id.investor_potential);
        investor_register = (Button) findViewById(R.id.investor_register);

        investor_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InvestorRegister.this, StartupMain.class);
                i.putExtra("i_n", investor_name.getText().toString());
                i.putExtra("i_c", investor_company.getText().toString());
                i.putExtra("i_d", investor_description.getText().toString());
                i.putExtra("i_p", investor_potential.getText().toString());
                startActivity(i);
            }
        });

    }
}
