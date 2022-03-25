package com.example.scoreboard;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MatchScheduleAdapter extends FirebaseRecyclerAdapter<ScheduleModel,MatchScheduleAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MatchScheduleAdapter(@NonNull FirebaseRecyclerOptions<ScheduleModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i, @NonNull ScheduleModel scheduleModel) {
        myViewHolder.MatchNumber.setText(String.valueOf(scheduleModel.getMatchNumber()));
        myViewHolder.Team1Name.setText(String.valueOf(scheduleModel.getTeam1Name()));
        myViewHolder.Team2Name.setText(String.valueOf(scheduleModel.getTeam2Name()));
        myViewHolder.Team1Score.setText(String.valueOf(scheduleModel.getTeam1Score())+"-"+String.valueOf(scheduleModel.getTeam1WicketsFallen()));
        myViewHolder.Team2Score.setText(String.valueOf(scheduleModel.getTeam2Score())+"-"+String.valueOf(scheduleModel.getTeam2WicketsFallen()));
        myViewHolder.Team1Over.setText(String.valueOf(scheduleModel.getTeam1Over()));
        myViewHolder.Team2Over.setText(String.valueOf(scheduleModel.getTeam2Over()));


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String visitId = getRef(myViewHolder.getAdapterPosition()).getKey();
                Intent currentMatchIntent = new Intent(myViewHolder.itemView.getContext(), currentMatchActivity.class);
                currentMatchIntent.putExtra("visitId", visitId);
                myViewHolder.itemView.getContext().startActivity(currentMatchIntent);
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_view_page2,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView MatchNumber,Team1Name,Team2Name,Team1Score,Team2Score,Team1Over,Team2Over;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            MatchNumber = (TextView)itemView.findViewById(R.id.matchNumber);
            Team1Name = (TextView)itemView.findViewById(R.id.team1Name);
            Team2Name = (TextView)itemView.findViewById(R.id.team2Name);
            Team1Score = (TextView)itemView.findViewById(R.id.team1Score_Wickets);
            Team2Score = (TextView)itemView.findViewById(R.id.team2Score_Wickets);
            Team1Over = (TextView)itemView.findViewById(R.id.team1Over);
            Team2Over = (TextView)itemView.findViewById(R.id.team2Overs);


        }
    }


}
