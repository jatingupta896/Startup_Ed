package com.animator_abhi.gcethackathon.Post;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.animator_abhi.gcethackathon.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Upload_Data extends AppCompatActivity   {


    private Button submitButton;
    private EditText title, description;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload__data);
        submitButton = (Button) findViewById(R.id.submitButton);
        title = (EditText) findViewById(R.id.editText1);
        description = (EditText) findViewById(R.id.editText2);
        //attaching listener

        submitButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadFile();
            }
        });
    }

    //method to show file chooser



    private void uploadFile() {
        //if there is a file to upload


        //displaying a progress dialog while upload is going on
        final ProgressDialog progressDialog = new ProgressDialog(Upload_Data.this, R.style.MyTheme);
        progressDialog.setTitle("Uploading");
        final String title_val = title.getText().toString().trim();
        final String desc_val = description.getText().toString().trim();

        if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val)) {
            progressDialog.show();
            databaseReference= FirebaseDatabase.getInstance().getReference().child("Upload");
            final DatabaseReference newPost = databaseReference.push();
            newPost.child("title").setValue(title_val);
            newPost.child("desc").setValue(desc_val);
            progressDialog.dismiss();
            progressDialog.dismiss();
            title.setText(null);
            description.setText(null);

            //and displaying a success toast
            Toast.makeText(getApplicationContext(), "File Uploaded ", Toast.LENGTH_LONG).show();
            //startActivity(new Intent(Upload_Data.this, Web.class));
            finish();


        } else {
            Toast.makeText(getApplicationContext(), "Title and Description are empty..Please Fill It", Toast.LENGTH_LONG).show();
        }



    }


}

