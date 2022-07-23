package com.example.tictactoemobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0-----X
    // 1-----O
    // 2-----Null

    int activestate=0;
    int gamestate[]={2,2,2,2,2,2,2,2,2};
    int[][] winstate={{0,1,2},{3,4,5},{6,7,8},
                      {0,3,6},{1,4,7},{2,5,8},
                      {0,4,8},{2,4,6}};
    public void onTap(View view){
        ImageView img = (ImageView) view;
        int tap = Integer.parseInt(img.getTag().toString());
        if(gamestate[tap]==2){
            gamestate[tap]=activestate;
            img.setTranslationY(-1000.0f);
            String Turn;
            if(activestate==0){
                img.setImageResource(R.drawable.x);
                Turn="O's turn";
                TextView status = findViewById(R.id.status);
                status.setText(Turn);
                activestate=1;
            }else{
                img.setImageResource(R.drawable.o);
                Turn="X's turn";
                TextView status = findViewById(R.id.status);
                status.setText(Turn);
                activestate=0;
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPosition:winstate){
            if(gamestate[winPosition[0]]== gamestate[winPosition[1]] &&
               gamestate[winPosition[1]]==gamestate[winPosition[2]] &&
               gamestate[winPosition[0]]!=2){
                String winner;
                if(gamestate[winPosition[0]]==0) {
                    winner="X has won";
                    TextView status = findViewById(R.id.status);
                    status.setText(winner);

                }else{
                    winner="O has won";
                    TextView status = findViewById(R.id.status);
                    status.setText(winner);

                }
            }
        }

    }
    public void reset(View view){
        for(int i=0;i<gamestate.length; i++ ){
            gamestate[i]=2;
        }
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        String Turn;
        Turn="X's turn";
        TextView status = findViewById(R.id.status);
        status.setText(Turn);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}