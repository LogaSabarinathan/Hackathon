package com.firstproject.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.firstproject.hackathon.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId={R.drawable.y1,R.drawable.g1,R.drawable.k1,R.drawable.b1};
        int[] map={R.drawable.y_map,R.drawable.g_map,R.drawable.k_map,R.drawable.b_map};
        int[][] sample={{R.drawable.y1,R.drawable.y2,R.drawable.y3,R.drawable.y4},{R.drawable.g1,R.drawable.g2,R.drawable.g3,R.drawable.g4},{R.drawable.k1,R.drawable.k2,R.drawable.k3,R.drawable.k4},{R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4}};
        String[] time={"6am–8pm","4am–2pm, 3pm–9pm","4am–9pm","6am–12pm, 4pm–9pm"};
        String[] temple={"YAMUNOTRI","GANGOTRI","KEDDARNATH","BADRINATH"};
        String[] desc={"Yamunotri temple has a shrine dedicated to the goddess. There is also an 18th-century temple at Gangotri, it was built by garhwal naresh Pratap Shah, it was damaged and re-innovated in the 19th century. The temple has been destroyed twice by snow and floods before being rebuilt.","According to Hindu legends, the most sacred of all rivers, Ganges (or Ganga), descended from heaven to earth at Gangotri, when Lord Shiva released the mighty river from his locks. The actual origin of the river is at Gaumukh in the Gangotri glacier, 19 km away from Gangotri and is accessible by trekking.","The Kedarnath temple has a Garbha Griha for worship and a Mandap, apt for assemblies of pilgrims and visitors. A conical rock formation inside the temple is worshipped as Lord Shiva in his Sadashiva form.\" \"An imposing sight, standing in the middle of a wide plateau surrounded by lofty snow covered peaks","Dedicated to Lord Vishnu, the Badrinath Temple is one of the most important pilgrimage sites in India. It is among the four holy places or char dham, which are much revered by Hindus. Devotees"};

        ArrayList<User> userArrayList=new ArrayList<>();
        for(int i=0;i<imageId.length;i++){
            User user=new User(temple[i],desc[i],imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter=new ListAdapter(MainActivity.this,userArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name",temple[position]);
                intent.putExtra("desc",desc[position]);
                intent.putExtra("time",time[position]);
                intent.putExtra("img",imageId[position]);
                intent.putExtra("sample1",sample[position][0]);
                intent.putExtra("sample2",sample[position][1]);
                intent.putExtra("sample3",sample[position][2]);
                intent.putExtra("sample4",sample[position][3]);
                intent.putExtra("map",map[position]);
                startActivity(intent);
            }
        });
    }
}