package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private CheckBox mhouse,mmoney,mhappy;
private RadioGroup mradiogroup;
private ProgressBar mprogressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    mhouse = findViewById(R.id.house);
    mmoney = findViewById(R.id.money);
    mhappy = findViewById(R.id.happy);
    mradiogroup = findViewById(R.id.radiogroup);
   mprogressbar = findViewById(R.id.progressbar);

   Thread thread = new Thread(new Runnable() {
       @Override
       public void run() {
          for(int i=0;i<10;i++){
              mprogressbar.incrementProgressBy(10);
              SystemClock.sleep(500);
          }
       }
   });
   thread.start();
    //before clicking on any radio button if the radio button is clicked we have to show the toast
        int i = mradiogroup.getCheckedRadioButtonId();
        switch (i){
            case R.id.firstRadio:
                Toast.makeText(MainActivity.this,"First Option is Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.secondRadio:
                Toast.makeText(MainActivity.this,"Second Option is Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.threeRadio:
                Toast.makeText(MainActivity.this,"Third Option is Clicked",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    mradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.firstRadio:
                    Toast.makeText(MainActivity.this,"First Option is Clicked",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.secondRadio:
                    Toast.makeText(MainActivity.this,"Second Option is Clicked",Toast.LENGTH_SHORT).show();

                    break;
                case R.id.threeRadio:
                    Toast.makeText(MainActivity.this,"Third Option is Clicked",Toast.LENGTH_SHORT).show();

                    break;
                default:
                    break;
            }
        }
    });
    if(mhouse.isChecked()){
        Toast.makeText(MainActivity.this,"You Have Bought House",Toast.LENGTH_SHORT).show();
    }else{
        Toast.makeText(MainActivity.this,"You Hava to  Buy House",Toast.LENGTH_SHORT).show();
    }
    mhouse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                Toast.makeText(MainActivity.this,"You Have Bought House",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this,"You Hava to  Buy House",Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}