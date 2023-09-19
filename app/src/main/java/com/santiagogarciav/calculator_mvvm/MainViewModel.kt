package com.santiagogarciav.calculator_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //Opcion 1 de declaracion
    val resultado : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    //Opcion 2 de declarion
    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    fun validateNumbers(number1: String, number2: String, option: Int) {
        if(number1.isEmpty() || number2.isEmpty()){
            _errorMsg.value = "Debe digitar dos numeros"

        }  else{
            when (option) {
                1 -> {
                    resultado.value = number1.toDouble() + number2.toDouble()
                }
                2 -> {
                    resultado.value = number1.toDouble() - number2.toDouble()
                }
                3 -> {
                    resultado.value = number1.toDouble() * number2.toDouble()
                }
                4 -> {
                    resultado.value = number1.toDouble() / number2.toDouble()
                }
            }

        }

    }

}