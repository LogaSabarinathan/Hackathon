package com.firstproject.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView name,time,desc;
    ImageView i1,i2,i3,i4,map;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=this.getIntent();
        i1=(ImageView) findViewById(R.id.sample1);
        i2=(ImageView) findViewById(R.id.sample2);
        i3=(ImageView) findViewById(R.id.sample3);
        i4=(ImageView) findViewById(R.id.sample4);
        map=(ImageView) findViewById(R.id.map);
        name=(TextView) findViewById(R.id.name);
        time=(TextView) findViewById(R.id.time);
        desc=(TextView) findViewById(R.id.desc);
        i1.setImageResource(intent.getIntExtra("sample1",R.drawable.b1));
        i2.setImageResource(intent.getIntExtra("sample2",R.drawable.b2));
        i3.setImageResource(intent.getIntExtra("sample3",R.drawable.b3));
        i4.setImageResource(intent.getIntExtra("sample4",R.drawable.b4));
        map.setImageResource(intent.getIntExtra("map",R.drawable.b_map));
        name.setText(intent.getStringExtra("name"));
        time.setText(intent.getStringExtra("time"));
        desc.setText(intent.getStringExtra("desc"));

        button=(Button) findViewById(R.id.guide);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent1);
            }
        });
    }
}