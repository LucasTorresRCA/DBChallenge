package com.example.desafiodb.network.service

import com.example.desafiodb.model.Login
import com.example.desafiodb.model.ResponseWrapper
import com.example.desafiodb.model.Statement
import com.example.desafiodb.network.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BackendService {
    private val api: IBackendAPI by lazy {
        return@lazy NetworkHelper.create(IBackendAPI::class)
    }

    fun postLogin(username: String, password: String, callback: (Login?, String?) -> Unit) {
        api.postLogin(username, password).enqueue(object: Callback<ResponseWrapper<Login>> {
            override fun onResponse(
                call: Call<ResponseWrapper<Login>>,
                response: Response<ResponseWrapper<Login>>
            ) {
                if (response.isSuccessful) {
                    callback(response.body()?.data, null)
                    return
                }
                callback(null, response.message())
            }

            override fun onFailure(call: Call<ResponseWrapper<Login>>, t: Throwable) {
                callback(null, t.message)
            }
        })
    }

    fun getStatement(token: String, callback: (Statement?, String?) -> Unit) {
        api.getStatement(token).enqueue(object: Callback<ResponseWrapper<Statement>> {
            override fun onResponse(
                call: Call<ResponseWrapper<Statement>>,
                response: Response<ResponseWrapper<Statement>>
            ) {
                if (response.isSuccessful) {
                    callback(response.body()?.data, null)
                    return
                }
                callback(null, response.message())
            }

            override fun onFailure(call: Call<ResponseWrapper<Statement>>, t: Throwable) {
                callback(null, t.message)
            }
        })
    }
}