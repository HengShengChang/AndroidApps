package com.example.user.rollcallingwithfragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by user on 2015/4/19.
 */
public class RosterAdapter extends ArrayAdapter<Student> {
    public RosterAdapter(Context context, int layoutResourcedId, ArrayList<Student> student) {super(context, layoutResourcedId, student);}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Student student = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_students, parent, false);
            viewHolder.picture_imageView = (ImageView) convertView.findViewById(R.id.picture_imageView);
            viewHolder.name_textView = (TextView) convertView.findViewById(R.id.name_textView);
            viewHolder.department_textView = (TextView) convertView.findViewById(R.id.department_textView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();

        try {
            Bitmap profilePicture = Compressor.decodeSampledBitmapFromResource(getContext().getResources(), student.picture, 60, 60);
            viewHolder.picture_imageView.setImageBitmap(profilePicture);
            viewHolder.name_textView.setText(student.name);
            viewHolder.department_textView.setText(student.department);
        } catch (Exception e) {
            Log.d("errorMan", student.name);
        }

        return (convertView);
    }
}