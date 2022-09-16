package com.example.umc_hackathon.post

import android.app.Activity
import android.app.AppComponentFactory
import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_hackathon.FormDetailActivity
import com.example.umc_hackathon.R
import com.example.umc_hackathon.databinding.BoardListItemBinding

class FormListRAdapter(val postList: List<PostList>): RecyclerView.Adapter<FormListRAdapter.MyViewHolder>() {

    private lateinit var binding: BoardListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_list_item, parent, false)
        Log.d("onCreateViewHolder() / ", "FormListRAdapter에서 메소드 called")

        return MyViewHolder(view).apply {
            itemView.setOnClickListener {
//                val currentPosition: Int = postList[adapterPosition].postId //수정!!!!!! postId로 받아오기
                val intent = Intent(itemView?.context, FormDetailActivity::class.java)
                intent.putExtra("list_item_post_id", postList[adapterPosition].postId)
                Log.d("list_item_post_id", postList[adapterPosition].postId.toString());
                startActivity(itemView.context, intent, null)
            }
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("onBindViewHolder() / ", " called / position: $position")

        if (postList[position].status == "ACTIVE") {
            if (postList[position].dday == 0) {
                holder.dday.text = "D - DAY"
            }
            else {
                holder.dday.text = "D - " + postList[position].dday.toString()
                holder.dday.setTextColor(Color.parseColor("#9b9999"))
                holder.title.setTextColor(Color.parseColor("#9b9999"))
                holder.qCount.setTextColor(Color.parseColor("#9b9999"))
                holder.point.setTextColor(Color.parseColor("#9b9999"))
            }
        }
        else {
            holder.dday.text = "마감됨"
            holder.dday.setTextColor(Color.parseColor("#9b9999"))
            holder.title.setTextColor(Color.parseColor("#9b9999"))
            holder.qCount.setTextColor(Color.parseColor("#9b9999"))
            holder.point.setTextColor(Color.parseColor("#9b9999"))
            //val drawable : Drawable? = ContextCompat.getDrawable(holder.ll?.context!!, R.drawable.background)
            //holder.ll.background. = drawable//.draw(Canvas())
        }
        holder.title.text = postList[position].title
        holder.qCount.text = postList[position].qcount.toString() + "개의 항목"
        holder.point.text = postList[position].point.toString() + "P"
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.board_list_item_title_tv)
        val qCount: TextView = itemView.findViewById(R.id.board_list_item_count_tv)
        val point: TextView = itemView.findViewById(R.id.board_list_item_coin_tv)
        val dday: TextView = itemView.findViewById(R.id.board_list_item_deadline_tv)
        val cv: CardView = itemView.findViewById(R.id.board_list_item_cv)
        val ll: LinearLayout = itemView.findViewById(R.id.board_list_item_ll)
    }

}