package com.jingyu.pay.ui.order

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

import com.jingyu.pay.ui.dashboard.DashboardFragment
import com.tools.payhelper.pay.ui.order.PaymentMatchingData
import com.tools.payhelper.pay.ui.password.SecurityData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PassWordViewModel : ViewModel() {

    var passwordDateModel = PasswordDateModel()

    var  paymentMatchingData = MutableLiveData<PaymentMatchingData>()
    var passWord = MutableStateFlow<SecurityData>(SecurityData())
    var _passWord = passWord

    fun getSecurityData(context: Context) = flow<SecurityData> {
        passwordDateModel.setSecurity(context).flowOn(Dispatchers.IO).catch {  }.collect {

        }
    }

}
