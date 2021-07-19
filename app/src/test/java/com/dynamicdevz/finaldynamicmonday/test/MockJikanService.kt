package com.dynamicdevz.finaldynamicmonday.test

import com.dynamicdevz.finaldynamicmonday.RetrofitInstance
import com.dynamicdevz.finaldynamicmonday.test.model.JikanResponse
import com.google.gson.Gson
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MockJikanService : RetrofitInstance.JikanService {

    override fun getResponse(search: String): Call<JikanResponse> {

        return object : Call<JikanResponse> {
            override fun clone(): Call<JikanResponse> {
                return this
            }

            override fun execute(): Response<JikanResponse> {

                println("executing..")
                val inputStream = javaClass.classLoader.getResourceAsStream("mock_response.json")

                val byteArray = ByteArray(inputStream.available())
                inputStream.read(byteArray)
                val json = String(byteArray)
                val jikanResponse = Gson().fromJson(json, JikanResponse::class.java)
                inputStream.close()

                return Response.success(jikanResponse)
            }

            override fun enqueue(callback: Callback<JikanResponse>) {
                println("Enqueue override")
                callback.onResponse(this.clone(), this.execute())
            }


            override fun isExecuted(): Boolean {
                return true
            }

            override fun cancel() {
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request? {
                return null
            }

            override fun timeout(): Timeout {
                return Timeout()
            }

        }
    }

}