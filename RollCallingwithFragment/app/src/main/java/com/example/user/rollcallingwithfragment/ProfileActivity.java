package com.example.user.rollcallingwithfragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle bundle = this.getIntent().getExtras();
        Student student = new Student(bundle.getInt("picture"), bundle.getString("name"), bundle.getString("department"), bundle.getString("note"));

        ImageView picture_imageView = (ImageView) findViewById(R.id.picture_imageView);
        TextView name_textView = (TextView) findViewById(R.id.name_textView);
        TextView department_textView = (TextView) findViewById(R.id.department_textView);
        EditText note_editText = (EditText) findViewById(R.id.note_editText);

        Bitmap profilePicture = Compressor.decodeSampledBitmapFromResource( getResources(), student.picture, 100, 100);
        picture_imageView.setImageBitmap(profilePicture);
        name_textView.setText(student.name);
        department_textView.setText(student.department);
        note_editText.setText(student.note);
    }


}
