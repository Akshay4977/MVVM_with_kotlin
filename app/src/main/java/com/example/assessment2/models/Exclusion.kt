package com.example.assessment2.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Exclusion(
    @field:Expose @field:SerializedName("options_id") var optionsId: String,
    @field:Expose @field:SerializedName("facility_id") var facilityId: String
)