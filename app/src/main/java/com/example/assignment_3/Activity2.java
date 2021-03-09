package com.example.assignment_3;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    ArrayList<String> Voters;
    int can_1;
    int can_2;
    int can_3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Intent intent = getIntent();
        can_1=intent.getExtras().getInt("Cadidate1_Vote");
        can_2=intent.getExtras().getInt("Cadidate2_Vote");
        can_3=intent.getExtras().getInt("Cadidate3_Vote");
        Voters=intent.getExtras().getStringArrayList("Voters_List");
        final EditText V_name=findViewById(R.id.vote_name);
        final EditText V_id=findViewById(R.id.vote_id);
        final Spinner sp=findViewById(R.id.Candidate);
        final ToggleButton toggleButton=findViewById(R.id.toggleButton);
        final Button do_vote= findViewById(R.id.Vote);
        do_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text;
                int duration = Toast.LENGTH_LONG;
                String id_obj=V_id.getText().toString();
                String name_obj=V_name.getText().toString();
                String choose=sp.getItemAtPosition(0).toString();
                String Chosen=sp.getSelectedItem().toString();
                if(toggleButton.isChecked() && !id_obj.isEmpty() && !name_obj.isEmpty() && !Chosen.equals(choose)) {
                    if (!Voters.contains(id_obj)) {
                        Voters.add(id_obj);
                        text="Thank you For your vote!!!";
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Log.d("Success", "new id "+id_obj);
                        Log.d("Success", toggleButton.getText().toString());
                        if(Chosen.equals(sp.getItemAtPosition(1).toString())){
                            can_1++;
                            Log.d("Candidate_1", ""+can_1);
                        }
                        else if(Chosen.equals(sp.getItemAtPosition(2).toString())){
                            can_2++;
                            Log.d("Candidate_2", ""+can_2);
                        }
                        else{
                            can_3++;
                            Log.d("Candidate_3", ""+can_3);
                        }
                    } else {
                        text="Sorry!!! Your have already voted";
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Log.d("failed", "duplicate");
                    }
                }
                else{
                    text="Please Fill and Select all required fields";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
        Log.d("cand1:",""+can_1);
        Log.d("cand2:",""+can_1);
        Log.d("cand3:",""+can_1);
    }

    protected void onDestroy(){

        super.onDestroy();
        Log.d("Activity2", "onDestroy: 1");

    }
    @Override
    public void onBackPressed(){
        Log.d("cand1:",""+can_1);
        Log.d("cand2:",""+can_2);
        Log.d("cand3:",""+can_3);
        Intent intent = new Intent();
        intent.putExtra("Updated_1",can_1);
        intent.putExtra("Updated_2",can_2);
        intent.putExtra("Updated_3",can_3);
        intent.putExtra("Updated_Voters",Voters);
        setResult(RESULT_OK, intent);
        finish();
    }

    protected void onPause(){
        super.onPause();
        Log.d("Activity2", "onPause: 1");

    }

    protected void onStart(){
        super.onStart();
        Log.d("Activity2", "onStart: 1");

    }

    protected void onStop(){

        super.onStop();
        Log.d("Activity2", "onStop: 1");
    }

    protected void onRestart(){
        super.onRestart();

        Log.d("Activity2", "onRestart: 1");
    }

    protected void onResume(){
        super.onResume();

        Log.d("Activity2", "onResume:1 ");
    }
}
