package com.example.assessment2.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Facility(
    @field:Expose @field:SerializedName("name") var name: String,
    @field:Expose @field:SerializedName(
        "facility_id"
    ) var facilityId: String
) {

    @SerializedName("options")
    @Expose
    var options: List<Option>? = null

}