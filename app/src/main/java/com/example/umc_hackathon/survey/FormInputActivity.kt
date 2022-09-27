package com.example.umc_hackathon.survey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_hackathon.FormDetailActivity
import com.example.umc_hackathon.R
import com.example.umc_hackathon.databinding.ActivityFormInputBinding
import com.example.umc_hackathon.post.FormListActivity

class FormInputActivity : AppCompatActivity(), FormDetailView {

    private lateinit var binding: ActivityFormInputBinding
    private var postId: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 설문조사 상세 페이지에서 살문 조사 참여 페이지로 넘어올 때 넘어오는 것
        postId = intent.getLongExtra("postId", postId)

        // 어댑터
        binding.formInputRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.formInputRv.setHasFixedSize(true)
        getFormDetail()

        // 이벤트 리스너
        binding.formInputCancelBtn.setOnClickListener {
            val intent = Intent(this, FormListActivity::class.java)
            intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }

        binding.formInputSubmitBtn.setOnClickListener {
            val intent = Intent(this, FormListActivity::class.java)
            intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }
    }

    private fun getJwt(): String? {
        val spf = this.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
        return spf!!.getString("jwt", "")
    }

    private fun getFormDetail() {
        val formService = FormService()
        formService.setFormDetailView(this)
        formService.getFormDetail(postId, getJwt()!!)
    }

    override fun onFormDetailSuccess(formDetailResponse: FormDetailResponse) {
        binding.formInputRv.adapter = FormDetailRAdapter(formDetailResponse.result)
        Toast.makeText(this, "설문 조사 문항 불러오기에 성공했습니다", Toast.LENGTH_SHORT).show()
    }

    override fun onFormDetailFailure() {
        Toast.makeText(this, "설문 조사 문항 불러오기에 실패했습니다", Toast.LENGTH_SHORT).show()
    }
}