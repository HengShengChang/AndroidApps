package com.example.user.chinesezodiac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class ContentActivity extends Activity implements PopupMenu.OnMenuItemClickListener{

    int year=0;
    String zodiac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Bundle bundle = this.getIntent().getExtras();
        year = bundle.getInt("year");
        zodiac = bundle.getString("zodiac");
        TextView year_editText = (TextView) findViewById(R.id.year_editText);
        TextView zodiac_textView = (TextView) findViewById(R.id.zodiac_textView);
        ImageView zodiac_imageView = (ImageView) findViewById(R.id.zodiac_imageView);
        TextView content_textView = (TextView) findViewById(R.id.content_textView);
        TextView wealth_textView = (TextView) findViewById(R.id.wealth_textView);
        TextView work_textView = (TextView) findViewById(R.id.work_textView);
        TextView love_textView = (TextView) findViewById(R.id.love_textView);
        TextView health_textView = (TextView) findViewById(R.id.health_textView);
        TextView relationship_textView = (TextView) findViewById(R.id.relationship_textView);
        String temp;
        switch (year) {
            case 2015 : {
                year_editText.setText(R.string.year_2015_text);
                if(zodiac.equals(getResources().getString(R.string.rat_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.rat);
                    content_textView.setText(R.string.rat_content);
                    temp = getResources().getString(R.string.rat_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.rat_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.rat_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.rat_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.rat_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.ox_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.ox);
                    content_textView.setText(R.string.ox_content);
                    temp = getResources().getString(R.string.ox_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.ox_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.ox_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.ox_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.ox_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.tiger_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.tiger);
                    content_textView.setText(R.string.tiger_content);
                    temp = getResources().getString(R.string.tiger_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.tiger_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.tiger_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.tiger_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.tiger_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.rabbit_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.rabbit);
                    content_textView.setText(R.string.rabbit_content);
                    temp = getResources().getString(R.string.rabbit_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.rabbit_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.rabbit_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.rabbit_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.rabbit_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.dragon_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.dragon);
                    content_textView.setText(R.string.dragon_content);
                    temp = getResources().getString(R.string.dragon_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.dragon_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.dragon_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.dragon_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.dragon_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.snake_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.snake);
                    content_textView.setText(R.string.snake_content);
                    temp = getResources().getString(R.string.snake_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.snake_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.snake_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.snake_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.snake_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.horse_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.horse);
                    content_textView.setText(R.string.horse_content);
                    temp = getResources().getString(R.string.horse_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.horse_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.horse_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.horse_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.horse_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.sheep_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.sheep);
                    content_textView.setText(R.string.sheep_content);
                    temp = getResources().getString(R.string.sheep_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.sheep_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.sheep_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.sheep_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.sheep_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.monkey_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.monkey);
                    content_textView.setText(R.string.monkey_content);
                    temp = getResources().getString(R.string.monkey_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.monkey_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.monkey_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.monkey_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.monkey_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.rooster_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.rooster);
                    content_textView.setText(R.string.rooster_content);
                    temp = getResources().getString(R.string.rooster_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.rooster_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.rooster_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.rooster_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.rooster_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.dog_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.dog);
                    content_textView.setText(R.string.dog_content);
                    temp = getResources().getString(R.string.dog_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.dog_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.dog_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.dog_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.dog_relationship);
                    relationship_textView.append(temp);
                }
                else if (zodiac.equals(getResources().getString(R.string.pig_text))) {
                    zodiac_textView.setText(zodiac);
                    zodiac_imageView.setBackgroundResource(R.drawable.pig);
                    content_textView.setText(R.string.pig_content);
                    temp = getResources().getString(R.string.pig_wealth);
                    wealth_textView.append(temp);
                    temp = getResources().getString(R.string.pig_work);
                    work_textView.append(temp);
                    temp = getResources().getString(R.string.pig_love);
                    love_textView.append(temp);
                    temp = getResources().getString(R.string.pig_health);
                    health_textView.append(temp);
                    temp = getResources().getString(R.string.pig_relationship);
                    relationship_textView.append(temp);
                }
            }
            break;
        }
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
        switch (menuItem.getItemId()) {
            case R.id.year_2015_item :
                editText.setText(R.string.year_2015_text);
                year = 2015;
                break;
        }
        return true;
    }

    public void go_button_onClick(View view) {
        switch (view.getId()) {
            case R.id.rat_imageButton :
                zodiac = getResources().getString(R.string.rat_text);
                break;
            case R.id.ox_imageButton :
                zodiac = getResources().getString(R.string.ox_text);
                break;
            case R.id.tiger_imageButton :
                zodiac = getResources().getString(R.string.tiger_text);
                break;
            case R.id.rabbit_imageButton :
                zodiac = getResources().getString(R.string.rabbit_text);
                break;
            case R.id.dragon_imageButton :
                zodiac = getResources().getString(R.string.dragon_text);
                break;
            case R.id.snake_imageButton :
                zodiac = getResources().getString(R.string.snake_text);
                break;
            case R.id.horse_imageButton :
                zodiac = getResources().getString(R.string.horse_text);
                break;
            case R.id.sheep_imageButton :
                zodiac = getResources().getString(R.string.sheep_text);
                break;
            case R.id.monkey_imageButton :
                zodiac = getResources().getString(R.string.monkey_text);
                break;
            case R.id.rooster_imageButton :
                zodiac = getResources().getString(R.string.rooster_text);
                break;
            case R.id.dog_imageButton :
                zodiac = getResources().getString(R.string.dog_text);
                break;
            case R.id.pig_imageButton :
                zodiac = getResources().getString(R.string.pig_text);
                break;
        }
        Intent intent = new Intent();
        intent.setClass(this, ContentActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("year", year);
        bundle.putString("zodiac", zodiac);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
