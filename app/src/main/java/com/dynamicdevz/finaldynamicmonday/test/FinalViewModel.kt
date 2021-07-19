package com.dynamicdevz.finaldynamicmonday.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dynamicdevz.finaldynamicmonday.RetrofitInstance
import com.dynamicdevz.finaldynamicmonday.test.model.JikanResponse
import com.dynamicdevz.finaldynamicmonday.test.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FinalViewModel : ViewModel() {

    private lateinit var jikanService: RetrofitInstance.JikanService
    private val mutableLiveData = MutableLiveData<List<Result>>()

    val liveData
    get() = mutableLiveData

    fun init(jikanService: RetrofitInstance.JikanService) {
        this.jikanService = jikanService
    }

    fun getData(query: String) {
        println(query)
        jikanService.getResponse(query)
            .enqueue(object : Callback<JikanResponse> {
                override fun onResponse(
                    call: Call<JikanResponse>,
                    response: Response<JikanResponse>
                ) {
                    println("getData....")
                    response.body()?.let {
                        mutableLiveData.postValue(it.results)
                    }?: println("Response was null...")
                }
                override fun onFailure(call: Call<JikanResponse>, t: Throwable) {
                //Failed....

                }
            })

    }


}