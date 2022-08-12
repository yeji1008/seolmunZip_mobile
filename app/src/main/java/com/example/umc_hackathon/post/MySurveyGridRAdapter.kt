package com.example.umc_hackathon.post

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import com.example.umc_hackathon.FormDetailActivity
import com.example.umc_hackathon.R


class MySurveyGridRAdapter(val mySurveyList: List<MySurveyList>): RecyclerView.Adapter<MySurveyGridRAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_my_survey_item, parent, false)
        Log.d("onCreateViewHolder() / ", "MySurveyGridAdapter에서 메소드 called")

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mySurveyList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("MySurveyGridRAdapter", " - onBindViewHolder() called / position: $position")

        holder.postTitle.text = mySurveyList[position].postTitle
        holder.point.text = mySurveyList[position].point.toString() + "P"
        holder.postResultCount.text = mySurveyList[position].postResultCount.toString() + "명 참여"
        holder.qCount.text = mySurveyList[position].qcount.toString() + "개의 항목  l"
        Log.d("qCount", " : " +  mySurveyList[position].qcount)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitle: TextView = itemView.findViewById(R.id.board_my_survey_item_title_tv)
        val point: TextView = itemView.findViewById(R.id.board_my_survey_item_point_tv)
        val postResultCount: TextView = itemView.findViewById(R.id.board_my_survey_item_people_tv)
        val qCount: TextView = itemView.findViewById(R.id.board_my_survey_item_count_tv)
    }

}