package com.example.user.chinesezodiac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;


public class MainActivity extends Activity implements PopupMenu.OnMenuItemClickListener {

    int year=0;
    String zodiac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void year_editText_onClick(View view) {
        PopupMenu popupMenu= new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.year_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean  onMenuItemClick(MenuItem menuItem) {
        EditText editText = (EditText) findViewById(R.id.year_editText);
        TextView textView;
        switch (menuItem.getItemId()) {
            case R.id.year_2015_item :
                editText.setText(R.string.year_2015_text);
                year=2015;
                textView = (TextView) findViewById(R.id.rat_luck_textView);
                textView.setText(R.string.good_text);
                textView = (TextView) findViewById(R.id.ox_luck_textView);
                textView.setText(R.string.fine_text);
                textView = (TextView) findViewById(R.id.tiger_luck_textView);
                textView.setText(R.string.good_text);
                textView = (TextView) findViewById(R.id.rabbit_luck_textView);
                textView.setText(R.string.great_text);
                textView = (TextView) findViewById(R.id.dragon_luck_textView);
                textView.setText(R.string.good_text);
                textView = (TextView) findViewById(R.id.snake_luck_textView);
                textView.setText(R.string.fine_text);
                textView = (TextView) findViewById(R.id.horse_luck_textView);
                textView.setText(R.string.great_text);
                textView = (TextView) findViewById(R.id.sheep_luck_textView);
                textView.setText(R.string.fine_text);
                textView = (TextView) findViewById(R.id.monkey_luck_textView);
                textView.setText(R.string.good_text);
                textView = (TextView) findViewById(R.id.rooster_luck_textView);
                textView.setText(R.string.fine_text);
                textView = (TextView) findViewById(R.id.dog_luck_textView);
                textView.setText(R.string.fine_text);
                textView = (TextView) findViewById(R.id.pig_luck_textView);
                textView.setText(R.string.great_text);
                break;
        }
        return true;
    }

    public void zodiac_editText_setText(View view) {
        EditText editText = (EditText) findViewById(R.id.zodiac_editText);
        switch (view.getId()) {
            case R.id.rat_linearLayout :
                editText.setText(R.string.rat_text);
                zodiac = getResources().getString(R.string.rat_text);
                break;
            case R.id.ox_linearLayout :
                editText.setText(R.string.ox_text);
                zodiac = getResources().getString(R.string.ox_text);
                break;
            case R.id.tiger_linearLayout :
                editText.setText(R.string.tiger_text);
                zodiac = getResources().getString(R.string.tiger_text);
                break;
            case R.id.rabbit_linearLayout :
                editText.setText(R.string.rabbit_text);
                zodiac = getResources().getString(R.string.rabbit_text);
                break;
            case R.id.dragon_linearLayout :
                editText.setText(R.string.dragon_text);
                zodiac = getResources().getString(R.string.dragon_text);
                break;
            case R.id.snake_linearLayout :
                editText.setText(R.string.snake_text);
                zodiac = getResources().getString(R.string.snake_text);
                break;
            case R.id.horse_linearLayout :
                editText.setText(R.string.horse_text);
                zodiac = getResources().getString(R.string.horse_text);
                break;
            case R.id.sheep_linearLayout :
                editText.setText(R.string.sheep_text);
                zodiac = getResources().getString(R.string.sheep_text);
                break;
            case R.id.monkey_linearLayout :
                editText.setText(R.string.monkey_text);
                zodiac = getResources().getString(R.string.monkey_text);
                break;
            case R.id.rooster_linearLayout :
                editText.setText(R.string.rooster_text);
                zodiac = getResources().getString(R.string.rooster_text);
                break;
            case R.id.dog_linearLayout :
                editText.setText(R.string.dog_text);
                zodiac = getResources().getString(R.string.dog_text);
                break;
            case R.id.pig_linearLayout :
                editText.setText(R.string.pig_text);
                zodiac = getResources().getString(R.string.pig_text);
                break;
        }
    }

    public void go_button_onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ContentActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("year", year);
        bundle.putString("zodiac", zodiac);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
