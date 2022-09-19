package com.example.assessment2.reporsitory

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.assessment2.models.MainModel
import com.example.assessment2.retrofit.APIClient
import com.example.assessment2.retrofit.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModelRepository {
    private var model: MainModel? = null
    private  var apiInterface: APIInterface? = null
    val mainModelData: MutableLiveData<MainModel?>
        get() {
            apiInterface = APIClient.retrofitClient?.create(APIClient.javaClass)
            callAPI()

            val data = MutableLiveData<MainModel?>()
            data.setValue(model)
            return data
        }

    private fun callAPI() {

        val call = apiInterface?.getFacility()
        call?.enqueue(object : Callback<MainModel?> {
            override fun onResponse(call: Call<MainModel?>, response: Response<MainModel?>) {
                if (response.code() == 200) {
                    model = response.body()
                } else {
                    Log.d("inside", "success")
                }
            }

            override fun onFailure(call: Call<MainModel?>, t: Throwable) {
                Log.d("inside", "fail")
            }
        })
    }

    companion object {

        var instance: MainModelRepository? = null
            get() {
                if (field == null) {
                    field = MainModelRepository()
                }
                return field
            }
            private set
    }
}