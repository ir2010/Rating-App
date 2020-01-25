package com.ir_sj.ratingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    float ratings[] = new float[20];
    int i = 0, flag=0;
    float sum=0,avg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RatingBar rate = findViewById(R.id.ratingBar);
        Button btnSub = findViewById(R.id.submit);
        Button btnRes = findViewById(R.id.reset);
        final Button btnAvg = findViewById(R.id.avg);
        final TextView text1 = findViewById(R.id.text1);
        final TextView text2 = findViewById(R.id.text2);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final float rating = rate.getRating();
                ratings[i++] = rating;
                rate.setRating(0);
            }
        });

        btnAvg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                { calculateAvg();
                    text2.setText("Average rating till now: "+avg);
                text1.setText("Number of ratings till now: "+i);
                btnAvg.setText("Okay! Hide Average Now");
                flag =1;}
                else
                {
                    text1.setText(" ");
                    text2.setText(" ");
                    btnAvg.setText("Show Average Rating");
                flag = 0;};
                }
             });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 0;
                sum=0;
                avg=0;
                i=0;
            }
        });

    }

    public void calculateAvg()
    {
        for(int j=0;j<i;j++)
        {
            System.out.println("1");
            System.out.println(ratings[j]);
            sum+=ratings[j];
        }
        if(i!=0)
        avg =  sum/i;
        sum=0;
    }
}
