package com.example.assessment2.retrofit

import com.example.assessment2.models.MainModel
import retrofit2.Call
import retrofit2.http.GET

 public interface APIInterface {

     @GET("db")
     fun getFacility(): Call<MainModel>
 }
