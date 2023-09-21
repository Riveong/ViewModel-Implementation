package com.riveong.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.riveong.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()




        activityMainBinding.btnCalculate.setOnClickListener {

            val width = activityMainBinding.edtWidth.text.toString()
            val height = activityMainBinding.edtHeight.text.toString()
            val length = activityMainBinding.edtLength.text.toString()


            when {
                width.isEmpty() -> { activityMainBinding.edtWidth.error = "kosong bang" }
                height.isEmpty() -> { activityMainBinding.edtHeight.error = "kosong bang" }
                length.isEmpty() -> { activityMainBinding.edtLength.error = "kosong bang" }

                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }


            }


        }




    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }


}

