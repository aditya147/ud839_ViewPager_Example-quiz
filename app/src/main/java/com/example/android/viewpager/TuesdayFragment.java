/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.android.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Fragment that displays "Tuesday".
 */
public class TuesdayFragment extends Fragment {

    EditText subjectName;
    EditText subjectDescription;
    Button addButton;
    SubjectFragmentCallback callback;

    public interface SubjectFragmentCallback{

        public void addSubject(String name,String description);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof SubjectFragmentCallback){
            callback = (SubjectFragmentCallback) context;
        }else{
            throw  new IllegalStateException("Activity has not implemented the firstfragmentcallback interface");
        }
    }

    public TuesdayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tuesday, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        subjectName = (EditText) getView().findViewById(R.id.subject_name);
        subjectDescription = (EditText) getView().findViewById(R.id.subject_description);
        addButton = (Button ) getView().findViewById(R.id.add_subject);

        addButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               //Toast.makeText(getActivity(),"first fragment button clicked",Toast.LENGTH_SHORT).show();
                                               String name = subjectName.getText().toString();
                                               String description = subjectDescription.getText().toString();
                                               callback.addSubject(name,description);
                                               Log.d("Aditya","buttonClick in form");
                                           }
                                       }
        );

    }
}
