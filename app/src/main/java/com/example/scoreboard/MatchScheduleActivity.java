package com.example.scoreboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MatchScheduleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MatchScheduleAdapter matchScheduleAdapter;

    @Override
    protected void onStart() {

        super.onStart();
        matchScheduleAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        matchScheduleAdapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_schedule_activity);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<ScheduleModel> options = new FirebaseRecyclerOptions.Builder<ScheduleModel>()
                .setQuery(FirebaseDatabase
                        .getInstance("https://scoreboard-c216e-default-rtdb.asia-southeast1.firebasedatabase.app")
                        .getReference()
                        .child("Matches"),ScheduleModel.class)
                .build();
        matchScheduleAdapter = new MatchScheduleAdapter(options);
        recyclerView.setAdapter(matchScheduleAdapter);
    }
}
