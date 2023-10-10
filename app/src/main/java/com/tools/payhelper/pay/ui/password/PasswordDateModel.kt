package com.jingyu.pay.ui.order

import android.content.Context
import android.util.Log
import com.tools.payhelper.pay.PayHelperUtils
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class PasswordDateModel {


    var BaseUrl : String = "https://api2.channel-sign.com/"

    fun setSecurity(context: Context) :Flow<String>{

        return callbackFlow {
            var jsonObject= JSONObject()
            jsonObject.put("token","")
            var jsonStr=jsonObject.toString()
            val contentType: MediaType = "application/json".toMediaType()
            //调用请求
            val requestBody = jsonStr.toRequestBody(contentType)
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(BaseUrl + "api/user/GetPaymentMatching")
                .get()
                .header("content-type","application/json")
                .header("Authorization", "Bearer " + PayHelperUtils.getUserToken(context))
                .build()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    offer( response.body?.string()!!)




                }
            })
            awaitClose {

            }
        }


    }

}