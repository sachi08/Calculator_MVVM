package com.santiagogarciav.calculator_mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.santiagogarciav.calculator_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


        val sumaObserver = Observer<Double>{suma->
            mainBinding.resultTextView.setText(suma.toString())
        }

        mainViewModel.resultado.observe(this,sumaObserver)

        val errorMsgObserver = Observer<String>{errorMsg->
            Snackbar.make(view, errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction("aceptar"){}
                .show()
        }
        mainBinding.addButton.setOnClickListener{
            mainViewModel.validateNumbers(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString(),1)
        }
        mainBinding.substracButton.setOnClickListener{
            mainViewModel.validateNumbers(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString(),2)
        }
        mainBinding.multiplyButton.setOnClickListener{
            mainViewModel.validateNumbers(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString(),3)
        }
        mainBinding.divideButton.setOnClickListener{
            mainViewModel.validateNumbers(mainBinding.firstNumberEditText.text.toString(), mainBinding.secondNumberEditText.text.toString(),4)
        }

    }
}

