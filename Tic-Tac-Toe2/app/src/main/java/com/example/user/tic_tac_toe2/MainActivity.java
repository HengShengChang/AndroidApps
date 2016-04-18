package com.example.user.tic_tac_toe2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import java.util.*;


public class MainActivity extends ActionBarActivity {

    private boolean computer=true, player1_first=true, game_start=true, menu_clicked=true, restart_clicked=false;
    private int turn =1;
    private int player1=0, player2=0, draw=0, games=player1+player2+draw;
    private int[][][] button = new int[3][3][3];
    private ImageButton image_button;
    private ImageView image_view;
    private TextView text_view;
    private RadioButton radio_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set_enable_button(false);
    }

    public void onClick_image_Button(View view) {
        set_menu_radio_button_visibility(4);
        set_restart_radio_button_visibility(4);
        game_start = false;
        int x=3, y=3, z=3;
        switch(view.getId()) {
            case R.id.button000_imageButton:
                image_button = (ImageButton) findViewById(R.id.button000_imageButton);
                x=0; y=0; z=0;
                break;
            case R.id.button001_imageButton:
                image_button = (ImageButton) findViewById(R.id.button001_imageButton);
                x=0; y=0; z=1;
                break;
            case R.id.button002_imageButton:
                image_button = (ImageButton) findViewById(R.id.button002_imageButton);
                x=0; y=0; z=2;
                break;
            case R.id.button010_imageButton:
                image_button = (ImageButton) findViewById(R.id.button010_imageButton);
                x=0; y=1; z=0;
                break;
            case R.id.button011_imageButton:
                image_button = (ImageButton) findViewById(R.id.button011_imageButton);
                x=0; y=1; z=1;
                break;
            case R.id.button012_imageButton:
                image_button = (ImageButton) findViewById(R.id.button012_imageButton);
                x=0; y=1; z=2;
                break;
            case R.id.button020_imageButton:
                image_button = (ImageButton) findViewById(R.id.button020_imageButton);
                x=0; y=2; z=0;
                break;
            case R.id.button021_imageButton:
                image_button = (ImageButton) findViewById(R.id.button021_imageButton);
                x=0; y=2; z=1;
                break;
            case R.id.button022_imageButton:
                image_button = (ImageButton) findViewById(R.id.button022_imageButton);
                x=0; y=2; z=2;
                break;
            case R.id.button100_imageButton:
                image_button = (ImageButton) findViewById(R.id.button100_imageButton);
                x=1; y=0; z=0;
                break;
            case R.id.button101_imageButton:
                image_button = (ImageButton) findViewById(R.id.button101_imageButton);
                x=1; y=0; z=1;
                break;
            case R.id.button102_imageButton:
                image_button = (ImageButton) findViewById(R.id.button102_imageButton);
                x=1; y=0; z=2;
                break;
            case R.id.button110_imageButton:
                image_button = (ImageButton) findViewById(R.id.button110_imageButton);
                x=1; y=1; z=0;
                break;
            case R.id.button111_imageButton:
                image_button = (ImageButton) findViewById(R.id.button111_imageButton);
                x=1; y=1; z=1;
                break;
            case R.id.button112_imageButton:
                image_button = (ImageButton) findViewById(R.id.button112_imageButton);
                x=1; y=1; z=2;
                break;
            case R.id.button120_imageButton:
                image_button = (ImageButton) findViewById(R.id.button120_imageButton);
                x=1; y=2; z=0;
                break;
            case R.id.button121_imageButton:
                image_button = (ImageButton) findViewById(R.id.button121_imageButton);
                x=1; y=2; z=1;
                break;
            case R.id.button122_imageButton:
                image_button = (ImageButton) findViewById(R.id.button122_imageButton);
                x=1; y=2; z=2;
                break;

            case R.id.button200_imageButton:
                image_button = (ImageButton) findViewById(R.id.button200_imageButton);
                x=2; y=0; z=0;
                break;
            case R.id.button201_imageButton:
                image_button = (ImageButton) findViewById(R.id.button201_imageButton);
                x=2; y=0; z=1;
                break;
            case R.id.button202_imageButton:
                image_button = (ImageButton) findViewById(R.id.button202_imageButton);
                x=2; y=0; z=2;
                break;
            case R.id.button210_imageButton:
                image_button = (ImageButton) findViewById(R.id.button210_imageButton);
                x=2; y=1; z=0;
                break;
            case R.id.button211_imageButton:
                image_button = (ImageButton) findViewById(R.id.button211_imageButton);
                x=2; y=1; z=1;
                break;
            case R.id.button212_imageButton:
                image_button = (ImageButton) findViewById(R.id.button212_imageButton);
                x=2; y=1; z=2;
                break;
            case R.id.button220_imageButton:
                image_button = (ImageButton) findViewById(R.id.button220_imageButton);
                x=2; y=2; z=0;
                break;
            case R.id.button221_imageButton:
                image_button = (ImageButton) findViewById(R.id.button221_imageButton);
                x=2; y=2; z=1;
                break;
            case R.id.button222_imageButton:
                image_button = (ImageButton) findViewById(R.id.button222_imageButton);
                x=2; y=2; z=2;
                break;
        }
        set(x, y, z);
        if(!check()){
            change();
            if (computer)
                run();
        }
        else {
            if (player1_first)
                turn = 1;
            else
                turn = 2;
        }
    }

    public void menu_image_Button(View view) {
        if(menu_clicked) {
            set_menu_radio_button_visibility(4);
            set_enable_button(true);
        }
        else{
            set_menu_radio_button_visibility(0);
            set_restart_radio_button_visibility(4);
            set_enable_button(false);
        }
    }

    private void set_menu_radio_button_visibility(int visible) {
        if(visible==0)
            menu_clicked = true;
        else if(visible==4)
            menu_clicked = false;
        radio_button = (RadioButton) findViewById(R.id.player_radioButton);
        radio_button.setVisibility(visible);
        radio_button = (RadioButton) findViewById(R.id.players_radioButton);
        radio_button.setVisibility(visible);
    }

    public void player_radio_Button(View view) {
        turn=1;
        text_view = (TextView) findViewById(R.id.player_turn_textView);
        switch(view.getId()) {
            case R.id.player_radioButton:
                text_view.setText(R.string.computer_text);
                computer=true;
                radio_button = (RadioButton) findViewById(R.id.player_radioButton);
                radio_button.setChecked(true);
                radio_button = (RadioButton) findViewById(R.id.players_radioButton);
                radio_button.setChecked(false);
                radio_button = (RadioButton) findViewById(R.id.player1_first_radioButton);
                radio_button.setText(R.string.computer_first_text);
                radio_button.setChecked(true);
                radio_button = (RadioButton) findViewById(R.id.player2_first_radioButton);
                radio_button.setText(R.string.player_first_text);
                radio_button.setChecked(false);
                text_view = (TextView) findViewById(R.id.player1_textView);
                text_view.setText(R.string.computer_text);
                text_view = (TextView) findViewById(R.id.player2_textView);
                text_view.setText(R.string.player_text);

                break;
            case R.id.players_radioButton:
                text_view.setText(R.string.player1_text);
                computer=false;
                radio_button = (RadioButton) findViewById(R.id.player_radioButton);
                radio_button.setChecked(false);
                radio_button = (RadioButton) findViewById(R.id.players_radioButton);
                radio_button.setChecked(true);
                radio_button = (RadioButton) findViewById(R.id.player1_first_radioButton);
                radio_button.setText(R.string.player1_first_text);
                radio_button.setChecked(true);
                radio_button = (RadioButton) findViewById(R.id.player2_first_radioButton);
                radio_button.setText(R.string.player2_first_text);
                radio_button.setChecked(false);
                text_view = (TextView) findViewById(R.id.player1_textView);
                text_view.setText(R.string.player1_text);
                text_view = (TextView) findViewById(R.id.player2_textView);
                text_view.setText(R.string.player2_text);
                break;
        }
        image_view = (ImageView) findViewById(R.id.turn_imageView);
        image_view.setBackgroundResource(R.drawable.o);
        set_menu_radio_button_visibility(4);
        set_restart_radio_button_visibility(0);
        zero_button();
        set_enable_button(false);
    }

    public void restart_image_Button(View view) {
        if(restart_clicked) {
            set_restart_radio_button_visibility(4);
            set_enable_button(true);
        }
        else {
            if (!game_start)
                restart();
            else {
                set_restart_radio_button_visibility(0);
                set_menu_radio_button_visibility(4);
                set_enable_button(false);
            }
        }
    }

    private void set_restart_radio_button_visibility(int visible) {
        if(visible==0)
            restart_clicked = true;
        else if(visible==4)
            restart_clicked = false;
        radio_button = (RadioButton) findViewById(R.id.player1_first_radioButton);
        radio_button.setVisibility(visible);
        radio_button = (RadioButton) findViewById(R.id.player2_first_radioButton);
        radio_button.setVisibility(visible);
    }

    public void first_radio_Button(View view) {
        switch(view.getId()) {
            case R.id.player1_first_radioButton:
                turn=1;
                player1_first=true;
                radio_button = (RadioButton) findViewById(R.id.player1_first_radioButton);
                radio_button.setChecked(true);
                radio_button = (RadioButton) findViewById(R.id.player2_first_radioButton);
                radio_button.setChecked(false);
                break;
            case R.id.player2_first_radioButton:
                turn=2;
                player1_first=false;
                radio_button = (RadioButton) findViewById(R.id.player1_first_radioButton);
                radio_button.setChecked(false);
                radio_button = (RadioButton) findViewById(R.id.player2_first_radioButton);
                radio_button.setChecked(true);
                break;
        }
        set_restart_radio_button_visibility(4);
        restart();
    }

    private void restart() {
        game_start = true;
        image_view = (ImageView) findViewById(R.id.turn_imageView);
        text_view = (TextView) findViewById(R.id.player_turn_textView);
        if(turn==1) {
            image_view.setBackgroundResource(R.drawable.o);
            if(computer)
                text_view.setText(R.string.computer_text);
            else
                text_view.setText(R.string.player1_text);
        }
        else {
            image_view.setBackgroundResource(R.drawable.x);
            if(computer)
                text_view.setText(R.string.player_text);
            else
                text_view.setText(R.string.player2_text);
        }

        text_view = (TextView) findViewById(R.id.turn_textView);
        text_view.setVisibility(View.VISIBLE);

        zero_button();
        set_enable_button(true);
        if(computer&&turn==1)
            run();
    }

    private void zero_button() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    button[i][j][k] = 0;
                    choose_image_button(i, j, k);
                    image_button.setBackgroundResource(R.drawable.empty);
                }
            }
        }
    }

    private void set_enable_button(boolean flag) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    choose_image_button(i, j, k);
                    image_button.setEnabled(flag);
                }
            }
        }
    }

    private void choose_image_button(int x, int y, int z) {
        switch(x) {
            case 0: {
                switch(y) {
                    case 0:
                        switch(z) {
                            case 0:
                                image_button = (ImageButton) findViewById(R.id.button000_imageButton);
                                break;
                            case 1:
                                image_button = (ImageButton) findViewById(R.id.button001_imageButton);
                                break;
                            case 2:
                                image_button = (ImageButton) findViewById(R.id.button002_imageButton);
                                break;
                        }
                        break;
                    case 1:
                        switch(z) {
                            case 0:
                                image_button = (ImageButton) findViewById(R.id.button010_imageButton);
                                break;
                            case 1:
                                image_button = (ImageButton) findViewById(R.id.button011_imageButton);
                                break;
                            case 2:
                                image_button = (ImageButton) findViewById(R.id.button012_imageButton);
                                break;
                        }
                        break;
                    case 2:
                        switch(z) {
                            case 0:
                                image_button = (ImageButton) findViewById(R.id.button020_imageButton);
                                break;
                            case 1:
                                image_button = (ImageButton) findViewById(R.id.button021_imageButton);
                                break;
                            case 2:
                                image_button = (ImageButton) findViewById(R.id.button022_imageButton);
                                break;
                        }
                        break;
                }
                break;
            }
            case 1: {
                switch(y) {
                    case 0:
                        switch(z) {
                            case 0:
                                image_button = (ImageButton) findViewById(R.id.button100_imageButton);
                                break;
                            case 1:
                                image_button = (ImageButton) findViewById(R.id.button101_imageButton);
                                break;
                            case 2:
                                image_button = (ImageButton) findViewById(R.id.button102_imageButton);
                                break;
                        }
                        break;
                    case 1:
                        switch(z) {
                            case 0:
                                image_button = (ImageButton) findViewById(R.id.button110_imageButton);
                                break;
                            case 1:
                                image_button = (ImageButton) findViewById(R.id.button111_imageButton);
                                break;
                            case 2:
                                image_button = (ImageButton) findViewById(R.id.button112_imageButton);
                                break;
                        }
                        break;
                    case 2:
                        switch(z) {
                            case 0:
                                image_button = (ImageButton) findViewById(R.id.button120_imageButton);
                                break;
                            case 1:
                                image_button = (ImageButton) findViewById(R.id.button121_imageButton);
                                break;
                            case 2:
                                image_button = (ImageButton) findViewById(R.id.button122_imageButton);
                                break;
                        }
                        break;
                }
                break;
            }
            case 2: {
                switch(y) {
                    case 0:
                        switch(z) {
                            case 0:
                                image_button = (ImageButton) findViewById(R.id.button200_imageButton);
                                break;
                            case 1:
                                image_button = (ImageButton) findViewById(R.id.button201_imageButton);
                                break;
                            case 2:
                                image_button = (ImageButton) findViewById(R.id.button202_imageButton);
                                break;
                        }
                        break;
                    case 1:
                        switch(z) {
                            case 0:
                                image_button = (ImageButton) findViewById(R.id.button210_imageButton);
                                break;
                            case 1:
                                image_button = (ImageButton) findViewById(R.id.button211_imageButton);
                                break;
                            case 2:
                                image_button = (ImageButton) findViewById(R.id.button212_imageButton);
                                break;
                        }
                        break;
                    case 2:
                        switch(z) {
                            case 0:
                                image_button = (ImageButton) findViewById(R.id.button220_imageButton);
                                break;
                            case 1:
                                image_button = (ImageButton) findViewById(R.id.button221_imageButton);
                                break;
                            case 2:
                                image_button = (ImageButton) findViewById(R.id.button222_imageButton);
                                break;
                        }
                        break;
                }
                break;
            }
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

    private boolean win(int n) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    if(button[i][j][k]==button[i][j][(k+1)%3]&&button[i][j][k]==n&&button[i][j][(k+2)%3]==0)
                        return computer_set(i, j, (k+2)%3);
                    else if(button[j][k][i]==button[j][(k+1)%3][i]&&button[j][k][i]==n&&button[j][(k+2)%3][i]==0)
                        return computer_set(j, (k+2)%3, i);
                    else if(button[k][i][j]==button[(k+1)%3][i][j]&&button[k][i][j]==n&&button[(k+2)%3][i][j]==0)
                        return computer_set((k+2)%3, i, j);
                }
                if(button[i][j][j]==button[i][(j+1)%3][(j+1)%3]&&button[i][j][j]==n&&button[i][(j+2)%3][(j+2)%3]==0)
                    return computer_set(i, (j+2)%3, (j+2)%3);
                else if(button[i][j][2-j]==button[i][(j+1)%3][2-(j+1)%3]&&button[i][j][2-j]==n&&button[i][(j+2)%3][2-(j+2)%3]==0)
                    return computer_set(i, (j+2)%3, 2-(j+2)%3);
                else if(button[j][i][j]==button[(j+1)%3][i][(j+1)%3]&&button[j][i][j]==n&&button[(j+2)%3][i][(j+2)%3]==0)
                    return computer_set((j+2)%3, i, (j+2)%3);
                else if(button[j][i][2-j]==button[(j+1)%3][i][2-(j+1)%3]&&button[j][i][2-j]==n&&button[(j+2)%3][i][2-(j+2)%3]==0)
                    return computer_set((j+2)%3, i, 2-(j+2)%3);
                else if(button[j][j][i]==button[(j+1)%3][(j+1)%3][i]&&button[j][j][i]==n&&button[(j+2)%3][(j+2)%3][i]==0)
                    return computer_set((j+2)%3, (j+2)%3, i);
                else if(button[j][2-j][i]==button[(j+1)%3][2-(j+1)%3][i]&&button[j][2-j][i]==n&&button[(j+2)%3][2-(j+2)%3][i]==0)
                    return computer_set((j+2)%3, 2-(j+2)%3, i);
            }
            if(button[i][i][i]==button[(i+1)%3][(i+1)%3][(i+1)%3]&&button[i][i][i]==n&&button[(i+2)%3][(i+2)%3][(i+2)%3]==0)
                return computer_set((i+2)%3, (i+2)%3, (i+2)%3);
            else if(button[i][i][2-i]==button[(i+1)%3][(i+1)%3][2-(i+1)%3]&&button[i][i][2-i]==n&&button[(i+2)%3][(i+2)%3][2-(i+2)%3]==0)
                return computer_set((i+2)%3, (i+2)%3, 2-(i+2)%3);
            else if(button[i][2-i][i]==button[(i+1)%3][2-(i+1)%3][(i+1)%3]&&button[i][2-i][i]==n&&button[(i+2)%3][2-(i+2)%3][(i+2)%3]==0)
                return computer_set((i+2)%3, 2-(i+2)%3, (i+2)%3);
            else if(button[2-i][i][i]==button[2-(i+1)%3][(i+1)%3][(i+1)%3]&&button[2-i][i][i]==n&&button[2-(i+2)%3][(i+2)%3][(i+2)%3]==0)
                return computer_set(2-(i+2)%3, (i+2)%3, (i+2)%3);
        }
        return false;
    }

    private boolean whatever() {
        Random r = new Random();
        int temp_x, temp_y, temp_z;
        while(true)
        {
            temp_x = r.nextInt(3);
            temp_y = r.nextInt(3);
            temp_z = r.nextInt(3);
            if(button[temp_x][temp_y][temp_z]==0)
                return computer_set(temp_x, temp_y, temp_z);
        }
    }

    private boolean computer_set(int x, int y, int z) {
        choose_image_button(x, y, z);
        set(x, y, z);
        return true;
    }

    private void set(int x, int y, int z) {
        button[x][y][z]=turn;
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

    private boolean check() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(button[i][j][0]==button[i][j][1]&&button[i][j][1]==button[i][j][2]&&button[i][j][0]!=0)
                    return over(i, j, 0, i, j, 1, i, j, 2);
                else if(button[j][0][i]==button[j][1][i]&&button[j][1][i]==button[j][2][i]&&button[j][0][i]!=0)
                    return over(j, 0, i, j, 1, i, j, 2, i);
                else if(button[0][i][j]==button[1][i][j]&&button[1][i][j]==button[2][i][j]&&button[0][i][j]!=0)
                    return over(0, i, j, 1, i, j, 2, i, j);
            }
            if(button[i][0][0]==button[i][1][1]&&button[i][1][1]==button[i][2][2]&&button[i][0][0]!=0)
                return over(i, 0, 0, i, 1, 1, i, 2, 2);
            else if(button[i][0][2]==button[i][1][1]&&button[i][1][1]==button[i][2][0]&&button[i][0][2]!=0)
                return over(i, 0, 2, i, 1, 1, i, 2, 0);
            else if(button[0][i][0]==button[1][i][1]&&button[1][i][1]==button[2][i][2]&&button[0][i][0]!=0)
                return over(0, i, 0, 1, i, 1, 2, i, 2);
            else if(button[0][i][2]==button[1][i][1]&&button[1][i][1]==button[2][i][0]&&button[0][i][2]!=0)
                return over(0, i, 2, 1, i, 1, 2, i, 0);
            else if(button[0][0][i]==button[1][1][i]&&button[1][1][i]==button[2][2][i]&&button[0][0][i]!=0)
                return over(0, 0, i, 1, 1, i, 2, 2, i);
            else if(button[0][2][i]==button[1][1][i]&&button[1][1][i]==button[2][0][i]&&button[0][2][i]!=0)
                return over(0, 2, i, 1, 1, i, 2, 0, i);
        }
        if(button[0][0][0]==button[1][1][1]&&button[1][1][1]==button[2][2][2]&&button[0][0][0]!=0)
            return over(0, 0, 0, 1, 1, 1, 2, 2, 2);
        else if(button[0][0][2]==button[1][1][1]&&button[1][1][1]==button[2][2][0]&&button[0][0][2]!=0)
            return over(0, 0, 2, 1, 1, 1, 2, 2, 0);
        else if(button[0][2][0]==button[1][1][1]&&button[1][1][1]==button[2][0][2]&&button[0][2][0]!=0)
            return over(0, 2, 0, 1, 1, 1, 2, 0, 2);
        else if(button[2][0][0]==button[1][1][1]&&button[1][1][1]==button[0][2][2]&&button[2][0][0]!=0)
            return over(2, 0, 0, 1, 1, 1, 0, 2, 2);
        else
            return draw_game();
    }

    private boolean over(int x1, int y1, int z1, int x2, int y2, int z2, int x3, int y3, int z3) {
        switch(turn) {
            case 1:
                player1++;
                choose_image_button(x1, y1, z1);
                image_button.setBackgroundResource(R.drawable.win_o);
                choose_image_button(x2, y2, z2);
                image_button.setBackgroundResource(R.drawable.win_o);
                choose_image_button(x3, y3, z3);
                image_button.setBackgroundResource(R.drawable.win_o);
                break;
            case 2:
                player2++;
                choose_image_button(x1, y1, z1);
                image_button.setBackgroundResource(R.drawable.win_x);
                choose_image_button(x2, y2, z2);
                image_button.setBackgroundResource(R.drawable.win_x);
                choose_image_button(x3, y3, z3);
                image_button.setBackgroundResource(R.drawable.win_x);
                break;
        }
        games=player1+player2+draw;
        text_view = (TextView) findViewById(R.id.turn_textView);
        text_view.setVisibility(View.INVISIBLE);
        image_view = (ImageView) findViewById(R.id.turn_imageView);
        image_view.setBackgroundResource(R.drawable.win);
        text_view = (TextView) findViewById(R.id.player1_score_textView);
        text_view.setText(player1+"/"+games);
        text_view = (TextView) findViewById(R.id.player2_score_textView);
        text_view.setText(player2+"/"+games);
        text_view = (TextView) findViewById(R.id.draw_score_textView);
        text_view.setText(draw+"/"+games);
        set_enable_button(false);
        return true;
    }

    private boolean draw_game() {
        boolean flag=true;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    if(button[i][j][k]==0)
                        flag=false;
                }
            }
        }
        if(flag) {
            text_view = (TextView) findViewById(R.id.player_turn_textView);
            text_view.setText(R.string.draw_text);
            text_view = (TextView) findViewById(R.id.turn_textView);
            text_view.setVisibility(View.INVISIBLE);
            image_view = (ImageView) findViewById(R.id.turn_imageView);
            image_view.setBackgroundResource(R.drawable.tie_game);

            draw++;
            games=player1+player2+draw;
            text_view = (TextView) findViewById(R.id.player1_score_textView);
            text_view.setText(player1+"/"+games);
            text_view = (TextView) findViewById(R.id.player2_score_textView);
            text_view.setText(player2+"/"+games);
            text_view = (TextView) findViewById(R.id.draw_score_textView);
            text_view.setText(draw+"/"+games);

            set_enable_button(false);
            return true;
        }
        else
            return false;
    }

    private void change() {
        text_view = (TextView) findViewById(R.id.player_turn_textView);
        image_view = (ImageView) findViewById(R.id.turn_imageView);
        if(computer)
            switch(turn) {
                case 1:
                    text_view.setText(R.string.player_text);
                    image_view.setBackgroundResource(R.drawable.x);
                    turn=2;
                    break;
                case 2:
                    text_view.setText(R.string.computer_text);
                    image_view.setBackgroundResource(R.drawable.o);
                    turn=1;
                    break;
            }
        else {
            switch(turn) {
                case 1:
                    text_view.setText(R.string.player2_text);
                    image_view.setBackgroundResource(R.drawable.x);
                    turn = 2;
                    break;
                case 2:
                    text_view.setText(R.string.player1_text);
                    image_view.setBackgroundResource(R.drawable.o);
                    turn = 1;
                    break;
            }
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
