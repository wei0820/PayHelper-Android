package com.jingyu.pay.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.tools.payhelper.pay.ui.login.LoginData
import com.tools.payhelper.pay.ui.login.UpdateData
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {


    var homeViewModel = LoginDateModel()
    var  token  = MutableLiveData<LoginData>()
    var  update  = MutableLiveData<UpdateData>()


    fun getUserToken(loginid:String,password:String,code:String) : LiveData<LoginData>{

        homeViewModel.setUserLogin(loginid,password,code, object : LoginDateModel.LoginrResponse {
            override fun getResponse(s: String) {
                if (!s.isEmpty()){
                    viewModelScope.launch {
                        var userData = Gson().fromJson(s, LoginData::class.java)
                        token.value = userData

                    }
                }

            }

        })

        return  token;
    }


    fun getUpdate() :LiveData<UpdateData>{
        homeViewModel.getUpdate(object : LoginDateModel.LoginrResponse {
            override fun getResponse(s: String) {
                viewModelScope.launch {
                    if (!s.isEmpty()){
                        Log.d("Jack",s)
                        var userData = Gson().fromJson(s, UpdateData::class.java)

                        update.value = userData
                    }
                }
            }

        })
        return  update
    }



}