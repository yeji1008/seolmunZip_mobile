package com.example.umc_hackathon.survey

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.set
import com.example.umc_hackathon.databinding.ActivityFormCreateBinding
import com.example.umc_hackathon.databinding.AddItemDialogBinding
import com.example.umc_hackathon.post.FormListActivity

class FormCreateActivity : AppCompatActivity() {

    val builderItem by lazy {AddItemDialogBinding.inflate(layoutInflater)}

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFormCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

         // 스피너
        val categoryList = listOf("마케팅", "사회현상", "브랜드", "아이디어")
        binding.formCreateSelectCategorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                println(categoryList[pos] + "입니다")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                println("카테고리를 선택하세요")
            }
        }

        // 리사이클러뷰
//        var questionList = arrayListOf<MyQuestion>()
//        val rAdapter = FormCreateRAdapter(questionList)
//
//        binding.formCreateListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.formCreateListRv.setHasFixedSize(true)
//        binding.formCreateListRv.adapter = FormCreateRAdapter(questionList)
//
//        rAdapter.addItem(MyQuestion(""))

        // 이벤트 리스너
        binding.formCreateCancelTv.setOnClickListener {
            val intent = Intent(this, FormListActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.formCreatePlusIv.setOnClickListener {
            Log.d("항목 추가", " 선택")

            var questionEt = builderItem.dialogQuestionEt

            AlertDialog.Builder(this).run {
                setTitle("항목 추가")
                if (builderItem.root.getParent() != null) {
                    (builderItem.root.getParent() as ViewGroup).removeView(builderItem.root)
                    questionEt.setText("")
                }
                setView(builderItem.root)
                setPositiveButton("항목 저장", DialogInterface.OnClickListener { dialogInterface, i ->
                    Log.d("저장 버튼", questionEt.text.toString())

                })
                setNegativeButton("취소", null)
                show()

            }
        }
    }
}