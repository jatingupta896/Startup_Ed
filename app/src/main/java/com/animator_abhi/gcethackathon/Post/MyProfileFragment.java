/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.animator_abhi.gcethackathon.Post;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.animator_abhi.gcethackathon.Login.Prefs;
import com.animator_abhi.gcethackathon.Models.StudentModel;
import com.animator_abhi.gcethackathon.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MyProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        CompanyFragment.ViewHolder.ContentAdapter adapter = new CompanyFragment.ViewHolder.ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        FirebaseDatabase database;
        StudentModel sm;
        public TextView name1;
        public TextView name;
        public TextView email;
        TextView college;
        TextView intrest;
        public TextView description;
        public ImageView picture;
        public TextView projectName;

        StudentModel studentModel;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.profile, parent, false));

            database=FirebaseDatabase.getInstance();
         final   DatabaseReference ref= database.getReference().child("student");

            name1 = (TextView) itemView.findViewById(R.id.student_name);
            email = (TextView) itemView.findViewById(R.id.email);
            college = (TextView) itemView.findViewById(R.id.Student_College);
            intrest = (TextView) itemView.findViewById(R.id.interest);

            picture = (ImageView) itemView.findViewById(R.id.card_image);
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.card_text);
            ref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    sm=dataSnapshot.getValue(StudentModel.class);
                    name1.setText(sm.getEmail());
                  //  name.setText("Custom");
                   email.setText(sm.getStudent_name());
                    college.setText(sm.getCollege());
                    intrest.setText(sm.getIntrest());
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }


        public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {

            private static final int LENGTH = 1;
            private final String[] title;
            private final String[] description;
            private final Drawable[] picture;

            public ContentAdapter(Context context) {
                Resources resources = context.getResources();
                title = resources.getStringArray(R.array.Title);
                description = resources.getStringArray(R.array.Description);
                TypedArray a = resources.obtainTypedArray(R.array.Picture);
                picture = new Drawable[a.length()];
                for (int i = 0; i < picture.length; i++) {
                    picture[i] = a.getDrawable(i);
                }
                a.recycle();
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.name.setText(title[position % title.length]);
                holder.description.setText(description[position % description.length]);
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
                holder.picture.setImageDrawable(picture[position % picture.length]);
                holder.name.setText(title[position % title.length]);
                holder.description.setText(description[position % description.length]);
            }

            @Override
            public int getItemCount() {
                return LENGTH;
            }



        }
    }
}

