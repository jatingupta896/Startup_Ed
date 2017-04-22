package com.animator_abhi.gcethackathon.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.animator_abhi.gcethackathon.Models.StudentModel;
import com.animator_abhi.gcethackathon.Post.MainActivity;
import com.animator_abhi.gcethackathon.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentRegister extends AppCompatActivity {
    FirebaseDatabase database;
    Button student_register;
EditText student_name,student_college,student_email,student_interest,student_idea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference();
        student_name = (EditText) findViewById(R.id.Student_Name);
        student_college = (EditText) findViewById(R.id.Student_College);
        student_email = (EditText) findViewById(R.id.Student_Email);
        student_interest = (EditText) findViewById(R.id.Student_Interested_In);
        student_idea = (EditText) findViewById(R.id.Student_Idea);
        student_register=(Button)findViewById(R.id.Student_Register);

        student_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentModel sm = new StudentModel(student_name.getText().toString(), student_college.getText().toString(), student_email.getText().toString(), student_interest.getText().toString(), student_idea.getText().toString());
                ref.child("student").child(Prefs.getUserId(StudentRegister.this)).setValue(sm);
                Intent i=new Intent(StudentRegister.this, MainActivity.class);
                startActivity(i);
                //finish();
            }
        });

    }
}
