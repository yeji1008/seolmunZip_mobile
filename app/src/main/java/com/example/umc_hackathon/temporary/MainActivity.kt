package com.example.umc_hackathon.temporary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_hackathon.LoginActivity
import com.example.umc_hackathon.MySurvey
import com.example.umc_hackathon.databinding.ActivityMainBinding
import com.example.umc_hackathon.post.FormListActivity

class MainActivity : AppCompatActivity(), SurveyListView {

    val TAG: String = "<MainActivity>"
    var modelList = ArrayList<MySurvey>()
    // 서버 값으로 변경

    private lateinit var binding: ActivityMainBinding
    private lateinit var surveyListAdapter: WaitingSurveyListRAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainProfileIv.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.mainPopularSurveyLl.setOnClickListener {
            val intent = Intent(this, FormListActivity::class.java)
            startActivity(intent)
        }

        binding.mainWaitingSurveyListHeaderLl.setOnClickListener {
            val intent = Intent(this, FormListActivity::class.java)
            startActivity(intent)
        }

        // 스크롤뷰 시작 위치 상단으로 고정하기
        binding.mainSv.post {
            binding.mainSv.fullScroll(ScrollView.FOCUS_UP)
        }


//        // 리스트 생성
//        for (i in 1..10){
//            val mySurvey = MySurvey(title = "사회현상에 대한 소비자 인식 $i")
//            this.modelList.add(mySurvey)
//        }
//
//        binding.mainWaitingSurveyListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.mainWaitingSurveyListRv.setHasFixedSize(true)
//        binding.mainWaitingSurveyListRv.adapter = WaitingSurveyListRAdapter(modelList)
    }

    override fun onStart() {
        super.onStart()
        getSurveyList()
    }

    private fun initRecyclerView(result: SurveyListResult) {
        surveyListAdapter = WaitingSurveyListRAdapter(result)
        binding.mainWaitingSurveyListRv.adapter = surveyListAdapter
    }

    private fun getSurveyList() {
        val surveyListService = SurveyListService()
        surveyListService.setSurveyListView(this)
        surveyListService.getSurveyList()
    }

    override fun onGetSurveyListSuccess(code: Int, result: SurveyListResult) {
        Log.d("SurveyList/Success", result.toString())
        initRecyclerView(result)
    }

    override fun onGetSurveyListFailure(code: Int, message: String) {
        Log.d("SurveyList/Fail", message)
    }
}