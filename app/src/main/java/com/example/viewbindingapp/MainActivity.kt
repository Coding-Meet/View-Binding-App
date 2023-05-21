package com.example.viewbindingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbindingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.printBtn.setOnClickListener {
            if (mainBinding.edTitle.text.toString().isEmpty()){
                mainBinding.edTitle.error = "Required"
            }else if (mainBinding.edDesc.text.toString().isEmpty()){
                mainBinding.edDesc.error = "Required"
            }else{
                mainBinding.titleTxt.text = mainBinding.edTitle.text.toString()
                mainBinding.descTxt.text = mainBinding.edDesc.text.toString()
            }
        }

        mainBinding.viewBindingFragmentBtn.setOnClickListener {
            startActivity(Intent(this,LoadBlankActivity::class.java))
        }
    }
}