package com.example.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> Voter_id=new ArrayList<>();
    int can_1=6;
    int can_2=2;
    int can_3=3;
    TextView candidate_1;
    TextView candidate_2;
    TextView candidate_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        candidate_1=findViewById(R.id.candidate1_vote);
        candidate_2=findViewById(R.id.candidate2_vote);
        candidate_3=findViewById(R.id.candidate3_vote);
        candidate_1.setText("Candidate 1 : "+can_1+" Votes");
        candidate_2.setText("Candidate 2 : "+can_2+" Votes");
        candidate_3.setText("Candidate 3 : "+can_3+" Votes");
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                can_1=data.getExtras().getInt("Updated_1");
                can_2=data.getExtras().getInt("Updated_2");
                can_3=data.getExtras().getInt("Updated_3");
                Voter_id=data.getExtras().getStringArrayList("Updated_Voters");
                Log.d("cand1:",""+can_1);
                Log.d("cand2:",""+can_1);
                Log.d("cand3:",""+can_1);
                Log.d("Voters",""+Voter_id);
                candidate_1.setText("Candidate 1 : "+can_1+" Votes");
                candidate_2.setText("Candidate 2 : "+can_2+" Votes");
                candidate_3.setText("Candidate 3 : "+can_3+" Votes");
            }
        }
    }
    public void Vote(View view){
        Intent intent=new Intent(this,Activity2.class);
        intent.putExtra("Cadidate1_Vote", can_1);
        intent.putExtra("Cadidate2_Vote", can_2);
        intent.putExtra("Cadidate3_Vote", can_3);
        intent.putExtra("Voters_List",Voter_id);
        startActivityForResult(intent,1);
    }
    protected void onDestroy(){

        super.onDestroy();
        Log.d("Main activity", "onDestroy: 1");

    }

    protected void onPause(){
        super.onPause();
        Log.d("Main activity", "onPause: 1");

    }

    protected void onStart(){
        super.onStart();
        Log.d("Main activity", "onStart: 1");

    }

    protected void onStop(){

        super.onStop();
//        Intent intent = getIntent();
//        can_1=intent.getExtras().getInt("Cadidate1_U");
//        can_2=intent.getExtras().getInt("Cadidate2_U");
//        can_3=intent.getExtras().getInt("Cadidate3_U");
        Log.d("Main Activity", "onStop: 1");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d("Main Activity", "onRestart: 1");
    }

    protected void onResume(){
        super.onResume();

        Log.d("Main Activity", "onResume:1 ");
    }

}