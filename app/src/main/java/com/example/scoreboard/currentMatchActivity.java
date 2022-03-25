package com.example.scoreboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class currentMatchActivity extends AppCompatActivity {
    TextView TeamName;
    TextView Innings;
    TextView Score;
    TextView Wickets;
    TextView Overs;
    TextView crr;
    TextView runrate;
    TextView BowlerName,MaidenBalls,BowlerRuns,BowlerWickets,BowlerER,BowlerOver;
    TextView NonStrikerName,NonStrikerruns,NonStrikerBalls,NonStrikerFours,NonStrikerSix,NonStrikerStrikeRate;
    TextView StrikerName,StrikerBallsPlayed,StrikerFour,StrikerSix,StrikerSR,StrikerRuns;
    DatabaseReference RootDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_match);

        Bundle bundle = getIntent().getExtras();
        int index = 0;
        if(bundle.getString("visitId")!= null)
        {
            index = Integer.valueOf(bundle.getString("visitId"));
        }

        TeamName = findViewById(R.id.teamName);
        Innings = findViewById(R.id.innings);
        Score  = findViewById(R.id.score);
        Wickets = findViewById(R.id.Wickets);
        Overs = findViewById(R.id.overs);
        crr = findViewById(R.id.crr);
        runrate = findViewById(R.id.runrate);
        BowlerName = findViewById(R.id.BowlerName);
        MaidenBalls = findViewById(R.id.MaidenBalls);
        BowlerRuns = findViewById(R.id.BowlerRuns);
        BowlerWickets = findViewById(R.id.BowlerWickets);
        BowlerER = findViewById(R.id.BowlerER);
        BowlerOver = findViewById(R.id.BowlerOver);
        NonStrikerName = findViewById(R.id.NonStrikerName);
        NonStrikerruns = findViewById(R.id.NonStrikerRuns);
        NonStrikerBalls = findViewById(R.id.NonStrikerBallsPlayed);
        NonStrikerFours = findViewById(R.id.NonStrikerFours);
        NonStrikerSix = findViewById(R.id.NonStrikerSix);
        NonStrikerStrikeRate = findViewById(R.id.NonStrikerStrikeRate);
        StrikerName = findViewById(R.id.StrikerName);
        StrikerBallsPlayed = findViewById(R.id.StrikerBallsPlayed);
        StrikerFour = findViewById(R.id.StrikerFour);
        StrikerSix = findViewById(R.id.StrikerSix);
        StrikerRuns = findViewById(R.id.StrikerRuns);
        StrikerSR = findViewById(R.id.StrikerSR);

        TeamName.setText("o000");

        RootDatabaseReference = FirebaseDatabase.getInstance("https://scoreboard-c216e-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Matches").child(index+"");
        RootDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
//                    if(snapshot.getKey().equals("BattingTeam")){

                        TeamName.setText(snapshot.child("BattingTeam").getValue().toString());
                        Log.d("TAG", "onDataChange: "+snapshot.child("BattingTeam").getValue().toString()+"----------------");
//                    }




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("TAG", "onCancelled: 00000000000000000000000000");

            }
        });

        TeamName.setText("000d0d");


    }
}