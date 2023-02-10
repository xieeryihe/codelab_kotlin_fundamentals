package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        // findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
        // findViewById<TextView>(R.id.nickname_text).setOnClickListener { updateNickname(it) }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {
            addNickname()
        }
        binding.myName = myName

        binding.nicknameText.setOnClickListener {
            updateNickname()
        }

    }
    private fun addNickname(){
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        // 如果不用 invalidateAll() 函数的话，把它注释掉，使用下面这句也行
        // findViewById<TextView>(R.id.nickname_text).text = binding.myName?.nickname

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)
    }


    private fun updateNickname(){
        // 这里传入的view是nicknameText
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
        }
        // Set the focus to the edit text.
        binding.nicknameEdit.requestFocus()
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }
}