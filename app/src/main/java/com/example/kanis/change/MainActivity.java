package com.example.kanis.change;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
       int cs=0;
    boolean state= true;
    int ps[]={2,2,2,2,2,2,2,2,2};
    int wp[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playAgain(View view)
    {

        cs=0;
        for(int i=0;i<ps.length;i++){
            ps[i]=2;}

        state= true;
        LinearLayout lo=(LinearLayout)findViewById(R.id.linear);
        lo.setVisibility(view.INVISIBLE);
        GridLayout gl=(GridLayout)findViewById(R.id.gridL);
        for(int i=0;i<gl.getChildCount();i++)
        {
            (  (ImageView) gl.getChildAt(i)).setImageResource(0);
        }



    }
    public void change(View view)
    {
        cs++;
        ImageView count=(ImageView)view;
        int c=Integer.parseInt(count.getTag().toString());
       //count.getTranslationY(-1000f);
        if(ps[c]==2&&state) {
            ps[c]=0;
            if (cs % 2== 0){
                count.setImageResource(R.drawable.o);
                ps[c]=1;}
            else{
                count.setImageResource(R.drawable.x);
             ps[c]=0;}
        }
        for(int wps[]:wp)
        {
            if(ps[wps[0]]==ps[wps[1]]&&ps[wps[1]]==ps[wps[2]]&&ps[wps[0]]!=2){
                System.out.println(ps[wps[0]]);
                state=false;
                String win="X";
                if(ps[wps[0]]==1){
                    win="O";}
                Toast.makeText(this,win + "  has won", Toast.LENGTH_LONG).show();
               LinearLayout butt=(LinearLayout)findViewById(R.id.linear);
                butt.setVisibility(view.VISIBLE);

            }
            else {

                boolean gameIsOver = true;

                for (int counterState : ps) {

                    if (counterState == 2) gameIsOver = false;

                }

                if (gameIsOver) {

                    Toast.makeText(this, "its a draw", Toast.LENGTH_SHORT).show();

                    LinearLayout layout = (LinearLayout)findViewById(R.id.linear);

                    layout.setVisibility(View.VISIBLE);

                }
        }}

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
