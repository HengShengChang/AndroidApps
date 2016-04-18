package com.example.user.tic_tac_toe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import java.util.*;



public class MainActivity extends ActionBarActivity {

    private boolean computer=true;
    private boolean endgame=false;
    private int turn =1;
    private int player1=0, player2=0, games;
    private int[][] button = new int[3][3];
    private ImageButton image_button;
    private ImageView win_lose;
    private ImageView ox;
    private TextView score_text_view;
    private RadioButton radio_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                button[i][j]=0;
            }
        }
        RadioGroup menu_radio_group = (RadioGroup) findViewById(R.id.menu_radioGroup);
        RadioGroup restart_radio_group = (RadioGroup) findViewById(R.id.restart_radioGroup);
        menu_radio_group.setOnCheckedChangeListener(menu_listener);
        restart_radio_group.setOnCheckedChangeListener(restart_listener);
    }

    private RadioGroup.OnCheckedChangeListener menu_listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.player_radioButton:
                    radio_button = (RadioButton) findViewById(R.id.player_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.players_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.player1_radioButton);
                    radio_button.setText("COMPUTER");
                    radio_button = (RadioButton) findViewById(R.id.player2_radioButton);
                    radio_button.setText("PLAYER");
                    radio_button = (RadioButton) findViewById(R.id.player1first_radioButton);
                    radio_button.setText("Computer First");
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.player2first_radioButton);
                    radio_button.setText("Player First");
                    radio_button.setVisibility(View.INVISIBLE);
                    computer=true;
                    turn=1;
                    restart();
                    break;
                case R.id.players_radioButton:
                    radio_button = (RadioButton) findViewById(R.id.player_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.players_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.player1_radioButton);
                    radio_button.setText("PLAYER1");
                    radio_button = (RadioButton) findViewById(R.id.player2_radioButton);
                    radio_button.setText("PLAYER2");
                    radio_button = (RadioButton) findViewById(R.id.player1first_radioButton);
                    radio_button.setText("Player1 First");
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.player2first_radioButton);
                    radio_button.setText("Player2 First");
                    radio_button.setVisibility(View.INVISIBLE);
                    computer=false;
                    restart();
                    turn=1;
                    break;
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener restart_listener = new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.player1first_radioButton:
                    radio_button = (RadioButton) findViewById(R.id.player_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.players_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.player1first_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.player2first_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    turn=1;
                    restart();
                    break;
                case R.id.player2first_radioButton:
                    radio_button = (RadioButton) findViewById(R.id.player_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.players_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.player1first_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    radio_button = (RadioButton) findViewById(R.id.player2first_radioButton);
                    radio_button.setVisibility(View.INVISIBLE);
                    turn=2;
                    restart();
                    break;
            }
        }
    };

    public void menu_image_button(View view){
        radio_button = (RadioButton) findViewById(R.id.player_radioButton);
        radio_button.setVisibility(View.VISIBLE);
        radio_button = (RadioButton) findViewById(R.id.players_radioButton);
        radio_button.setVisibility(View.VISIBLE);
    }

    public void restart_image_button(View view){
        if (endgame)
            restart();
        else{
            radio_button = (RadioButton) findViewById(R.id.player1first_radioButton);
            radio_button.setVisibility(View.VISIBLE);
            radio_button = (RadioButton) findViewById(R.id.player2first_radioButton);
            radio_button.setVisibility(View.VISIBLE);
        }
    }

    private void choose_image_button(int row, int col){
        switch(row) {
            case 0: {
                switch(col) {
                    case 0:
                        image_button = (ImageButton) findViewById(R.id.button00_imageButton);
                        break;
                    case 1:
                        image_button = (ImageButton) findViewById(R.id.button01_imageButton);
                        break;
                    case 2:
                        image_button = (ImageButton) findViewById(R.id.button02_imageButton);
                        break;
                }
                break;
            }
            case 1: {
                switch(col) {
                    case 0:
                        image_button = (ImageButton) findViewById(R.id.button10_imageButton);
                        break;
                    case 1:
                        image_button = (ImageButton) findViewById(R.id.button11_imageButton);
                        break;
                    case 2:
                        image_button = (ImageButton) findViewById(R.id.button12_imageButton);
                        break;
                }
                break;
            }
            case 2: {
                switch(col) {
                    case 0:
                        image_button = (ImageButton) findViewById(R.id.button20_imageButton);
                        break;
                    case 1:
                        image_button = (ImageButton) findViewById(R.id.button21_imageButton);
                        break;
                    case 2:
                        image_button = (ImageButton) findViewById(R.id.button22_imageButton);
                        break;
                }
                break;
            }
        }
    }

    private void set(int row, int col) {
        button[row][col]=turn;
        switch(turn)
        {
            case 1:
                image_button.setBackgroundResource(R.drawable.o);
                image_button.setEnabled(false);
                break;
            case 2:
                image_button.setBackgroundResource(R.drawable.x);
                image_button.setEnabled(false);
                break;
        }
    }

    private boolean check(){
        for(int i=0; i<3; i++){
            if(button[i][0]==button[i][1]&&button[i][1]==button[i][2]&&button[i][0]!=0)
                return over();
            else if(button[0][i]==button[1][i]&&button[1][i]==button[2][i]&&button[0][i]!=0)
                return over();
        }
        if(button[0][0]==button[1][1]&&button[1][1]==button[2][2]&&button[0][0]!=0)
            return over();
        else if(button[0][2]==button[1][1]&&button[1][1]==button[2][0]&&button[0][2]!=0)
            return over();
        else
            return draw_game();
    }

    private boolean draw_game() {
        boolean flag=true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(button[i][j]==0)
                    flag=false;
            }
        }
        if(flag)
        {
            endgame=true;
            win_lose = (ImageView) findViewById(R.id.win_lose_imageView);
            win_lose.setVisibility(View.VISIBLE);

            games++;
            score_text_view= (TextView) findViewById(R.id.player1score_textView);
            score_text_view.setText(player1+"/"+games);
            score_text_view = (TextView) findViewById(R.id.player2score_textView);
            score_text_view.setText(player2+"/"+games);

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    choose_image_button(i, j);
                    image_button.setEnabled(false);
                }
            }
            return true;
        }
        else
            return false;
    }

    private boolean over() {
        endgame=true;
        switch(turn)
        {
            case 1:
                player1++;
                win_lose = (ImageView) findViewById(R.id.win_lose_imageView);
                win_lose.setBackgroundResource(R.drawable.you_lose);
                win_lose.setVisibility(View.VISIBLE);
                break;
            case 2:
                player2++;
                win_lose = (ImageView) findViewById(R.id.win_lose_imageView);
                win_lose.setBackgroundResource(R.drawable.you_win);
                win_lose.setVisibility(View.VISIBLE);
        }
        games++;
        score_text_view= (TextView) findViewById(R.id.player1score_textView);
        score_text_view.setText(player1+"/"+games);
        score_text_view = (TextView) findViewById(R.id.player2score_textView);
        score_text_view.setText(player2+"/"+games);
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                choose_image_button(i, j);
                image_button.setEnabled(false);
            }
        }
        return true;
    }

    private void change() {
        ox = (ImageView) findViewById(R.id.ox_imageView);
        switch(turn)
        {
            case 1:
                radio_button = (RadioButton) findViewById(R.id.player1_radioButton);
                radio_button.setChecked(false);
                radio_button = (RadioButton) findViewById(R.id.player2_radioButton);
                radio_button.setChecked(true);
                ox.setBackgroundResource(R.drawable.x);
                turn=2;
                break;
            case 2:
                radio_button = (RadioButton) findViewById(R.id.player2_radioButton);
                radio_button.setChecked(false);
                radio_button = (RadioButton) findViewById(R.id.player1_radioButton);
                radio_button.setChecked(true);
                ox.setBackgroundResource(R.drawable.o);
                turn=1;
                break;
        }
    }

    private void restart() {
        endgame=false;
        ox = (ImageView) findViewById(R.id.ox_imageView);
        if(turn==1)
            ox.setBackgroundResource(R.drawable.o);
        else
            ox.setBackgroundResource(R.drawable.x);
        win_lose = (ImageView) findViewById(R.id.win_lose_imageView);
        win_lose.setBackgroundResource(R.drawable.tie_game);
        win_lose.setVisibility(View.INVISIBLE);
        radio_button = (RadioButton) findViewById(R.id.player1_radioButton);
        if(turn==1)
            radio_button.setChecked(true);
        else
            radio_button.setChecked(false);
        radio_button = (RadioButton) findViewById(R.id.player2_radioButton);
        if(turn==2)
            radio_button.setChecked(true);
        else
            radio_button.setChecked(false);
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                button[i][j]=0;
                choose_image_button(i, j);
                image_button.setBackgroundResource(R.drawable.empty);
                image_button.setEnabled(true);
            }
        }
        if(computer&&turn==1)
            run();
    }

    private boolean computer_set(int row, int col) {
        choose_image_button(row, col);
        set(row, col);
        return true;
    }

    private boolean win(int k) {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(button[i][j]==button[i][(j+1)%3]&&button[i][j]==k&&button[i][(j+2)%3]==0)
                    return computer_set(i, (j+2)%3);
                else if(button[j][i]==button[(j+1)%3][i]&&button[j][i]==k&&button[(j+2)%3][i]==0)
                    return computer_set((j+2)%3, i);
            }
            if(button[i][i]==button[(i+1)%3][(i+1)%3]&&button[i][i]==k&&button[(i+2)%3][(i+2)%3]==0)
                return computer_set((i+2)%3, (i+2)%3);
            else if(button[i][2-i]==button[(i+1)%3][2-(i+1)%3]&&button[i][2-i]==k&&button[(i+2)%3][2-(i+2)%3]==0)
                return computer_set((i+2)%3, 2-(i+2)%3);
        }
        return false;
    }

    private boolean whatever() {
        Random r = new Random();
        int temp_row, temp_col;
        while(true)
        {
            temp_row=r.nextInt(3);
            temp_col=r.nextInt(3);
            if(button[temp_row][temp_col]==0)
                return computer_set(temp_row, temp_col);
        }
    }

    private void run() {
        if(!win(1)) {
            if (!win(2))
                whatever();
        }
        if(!check())
            change();
    }

    public void onClick_Button(View view) {
        int row=3, col=3;
        switch(view.getId())
        {
            case R.id.button00_imageButton:
                image_button = (ImageButton) findViewById(R.id.button00_imageButton);
                row=0;
                col=0;
                break;
            case R.id.button01_imageButton:
                image_button = (ImageButton) findViewById(R.id.button01_imageButton);
                row=0;
                col=1;
                break;
            case R.id.button02_imageButton:
                image_button = (ImageButton) findViewById(R.id.button02_imageButton);
                row=0;
                col=2;
                break;
            case R.id.button10_imageButton:
                image_button = (ImageButton) findViewById(R.id.button10_imageButton);
                row=1;
                col=0;
                break;
            case R.id.button11_imageButton:
                image_button = (ImageButton) findViewById(R.id.button11_imageButton);
                row=1;
                col=1;
                break;
            case R.id.button12_imageButton:
                image_button = (ImageButton) findViewById(R.id.button12_imageButton);
                row=1;
                col=2;
                break;
            case R.id.button20_imageButton:
                image_button = (ImageButton) findViewById(R.id.button20_imageButton);
                row=2;
                col=0;
                break;
            case R.id.button21_imageButton:
                image_button = (ImageButton) findViewById(R.id.button21_imageButton);
                row=2;
                col=1;
                break;
            case R.id.button22_imageButton:
                image_button = (ImageButton) findViewById(R.id.button22_imageButton);
                row=2;
                col=2;
                break;
        }
        set(row, col);
        if(!check()) {
            change();
            if (computer)
                run();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
