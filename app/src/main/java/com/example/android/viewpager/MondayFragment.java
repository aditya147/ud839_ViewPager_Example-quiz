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

import android.content.DialogInterface;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.description;
import static android.R.id.list;

/**
 * Fragment that displays "Monday".
 */
public class MondayFragment extends Fragment {


    final ArrayList<Subject> subjects =new ArrayList<Subject>();


    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


         View rootView = inflater.inflate(R.layout.fragment_monday, container, false);


        subjects.add(new Subject("Math","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",R.drawable.number_one));
        subjects.add(new Subject("Science","bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",R.drawable.number_two));
        subjects.add(new Subject("Physics","ccbbbbbbbbbbdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd",R.drawable.number_three));
        subjects.add(new Subject("Chemistry","ddrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr",R.drawable.number_four));
        subjects.add(new Subject("Biology","eetttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttd",R.drawable.number_five));
        subjects.add(new Subject("Socialogy","ldddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddl",R.drawable.number_six));
        subjects.add(new Subject("English","ttooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo",R.drawable.number_seven));
        subjects.add(new Subject("Arts","vvffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",R.drawable.number_eight));
        subjects.add(new Subject("Commerce","gmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmg",R.drawable.number_nine));
        subjects.add(new Subject("History","pssfdghjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhp",R.drawable.number_ten));



        final SubjectAdapter myAdapter = new SubjectAdapter(getActivity(),subjects);
        listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder messageDial  = new AlertDialog.Builder(getActivity());
                messageDial.setIcon(android.R.drawable.ic_dialog_dialer);
                messageDial.setTitle("Delete");
                messageDial.setMessage("Do you want to delete this subject?");
                //messageDial.setCancelable()
                messageDial.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myAdapter.remove(subjects.get(position));
                        myAdapter.notifyDataSetChanged();
                    }
                });
                messageDial.show();

            }
        });


        return rootView;

    }

    /*@Override
    public void add(String name, String description) {
        Log.d("Aditya","insidecallback"+name+description);
        subjects.add(new Subject(name,description,R.drawable.number_ten));
        *//*myAdapter = new SubjectAdapter(getActivity(),subjects);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();*//*


    }*/

    @Override
    public void onResume() {
        super.onResume();
       // subjects.add(new Subject("name","description",R.drawable.number_ten));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("Aditya","inside onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        String name=null,description=null;
        Bundle arguments = getArguments();
        Log.d("Aditya","outside arguments"+arguments);
        if(arguments != null){
            Log.d("Aditya","inside arguments");
             name = arguments.getString("keyName");
             description = arguments.getString("keyDescription");
        }



    }


}
