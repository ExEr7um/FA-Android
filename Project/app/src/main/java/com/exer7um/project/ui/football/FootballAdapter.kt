package com.exer7um.project.ui.football

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exer7um.project.R
import java.time.LocalDateTime

class FootballAdapter(val context: Context, val matchesList: List<FootballResponse>) :
    RecyclerView.Adapter<FootballAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var team1: TextView = itemView.findViewById(R.id.team1)
        var team2: TextView = itemView.findViewById(R.id.team2)
        var time: TextView = itemView.findViewById(R.id.time)
        var date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.match_card, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.team1.text = matchesList[position].teams.home.name
        holder.team2.text = matchesList[position].teams.away.name
        holder.time.text =
            LocalDateTime.parse(matchesList[position].fixture.date.split('+')[0]).toLocalTime()
                .toString()
        holder.date.text =
            LocalDateTime.parse(matchesList[position].fixture.date.split('+')[0]).toLocalDate()
                .toString()
    }

    override fun getItemCount(): Int {
        return matchesList.size
    }
}