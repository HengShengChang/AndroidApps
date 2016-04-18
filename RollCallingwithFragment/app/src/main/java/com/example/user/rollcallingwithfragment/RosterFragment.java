package com.example.user.rollcallingwithfragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by user on 2015/4/19.
 */
public class RosterFragment extends ListFragment {

    ArrayList<Student> students;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_roster, container, false);
        students = readEntireFile(R.raw.student_name);
        ListView students_listView = (ListView) view.findViewById(R.id.students_listView);
//        ListView students_listView = (ListView) getView().findViewById(R.id.students_listView);
        students_listView.setAdapter(new RosterAdapter(getActivity(), R.layout.fragment_roster, students));
        students_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openProfile(position);
            }
        });
        return (view);
//        return (getView());
    }

    public void random_onClick(View view) {
        int itemNumber = students.size();
        Random random = new Random();
        int position = random.nextInt(itemNumber);
        openProfile(position);
    }

    private void openProfile(int position) {
        Student student = students.get(position);
        Intent intent = new Intent();
        intent.setClass(getActivity().getApplicationContext(), ProfileActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt("picture", student.picture);
        bundle.putString("name", student.name);
        bundle.putString("department", student.department);
        bundle.putString("note", student.note);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        Log.d(getClass().getSimpleName(), "onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getClass().getSimpleName(), "onCreate()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(getClass().getSimpleName(), "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), "onResume()");
    }

    @Override
    public void onPause() {
        Log.d(getClass().getSimpleName(), "onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(getClass().getSimpleName(), "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(getClass().getSimpleName(), "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(getClass().getSimpleName(), "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(getClass().getSimpleName(), "onDetach()");
        super.onDetach();
    }

    private ArrayList<Student> readEntireFile(int id) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner scanner = new Scanner(getResources().openRawResource(id));
        boolean student_flag = false;
        boolean name_flag = false;
        boolean department_flag = false;
        boolean picture_flag = false;
        boolean note_flag = false;
        int picture;
        String name = "", department = "", picture_name = "", note = "";
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            switch (line) {
                case "<student>":
                    student_flag = true;
                    break;
                case "</student>":
                    student_flag = false;
                    break;
                case "<name>":
                    name_flag = true;
                    break;
                case "</name>":
                    name_flag = false;
                    break;
                case  "<department>":
                    department_flag = true;
                    break;
                case "</department>":
                    department_flag = false;
                    break;
                case  "<picture>":
                    picture_flag = true;
                    break;
                case "</picture>":
                    picture_flag = false;
                    break;
                case  "<note>":
                    note_flag = true;
                    break;
                case "</note>":
                    note_flag = false;
                    break;
                default:
                    break;
            }
            if(!student_flag) {
                picture = getResources().getIdentifier(picture_name,  "drawable", getActivity().getPackageName());
                list.add(new Student(picture, name, department, note));
                Log.d("file", "student = " + name + "complete !");
                name = "";
                department = "";
                picture_name = "";
                note = "";
            }
            else if(name_flag) {
                name = line;
                Log.d("file", "name=" + name + " !");
            }
            else if(department_flag) {
                department = line;
                Log.d("file", "department=" + department + " !");
            }
            else if(picture_flag) {
                picture_name = line;
                Log.d("file", "picture_name=" + picture_name + " !");
            }
            else if(note_flag) {
                if(note.equals("<note>"))
                    note = line;
                else
                    note = note + "\n" + line;
                Log.d("file", "note=" + note + "!");
            }
        }
        return list;
    }

}
