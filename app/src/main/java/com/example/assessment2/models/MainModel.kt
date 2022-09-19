package com.example.assessment2.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MainModel {
    @SerializedName("facilities")
    @Expose
    var facilities: List<Facility>? = null

    @SerializedName("exclusions")
    @Expose
    var exclusions: List<List<Exclusion>>? = null
}