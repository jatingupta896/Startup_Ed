package com.animator_abhi.gcethackathon.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.animator_abhi.gcethackathon.Models.StartupModel;
import com.animator_abhi.gcethackathon.Post.MainActivity;
import com.animator_abhi.gcethackathon.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StartupRegister extends AppCompatActivity {
    Button startup_register;
    FirebaseDatabase database;
    EditText startup_name,startup_founder,startup_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_register);
        database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference();
        startup_name = (EditText) findViewById(R.id.startup_name);
        startup_founder = (EditText) findViewById(R.id.startup_description);
        startup_description = (EditText) findViewById(R.id.startup_founder);
        startup_register = (Button) findViewById(R.id.startup_register);
        startup_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartupModel sm = new StartupModel(startup_name.getText().toString(), startup_founder.getText().toString()
                        , startup_description.getText().toString());
                ref.child("startup").push().child(Prefs.getUserId(StartupRegister.this)).setValue(sm);
                Intent i=new Intent(StartupRegister.this, MainActivity.class);
                startActivity(i);
               // finish();
            }
        });


    }
}
