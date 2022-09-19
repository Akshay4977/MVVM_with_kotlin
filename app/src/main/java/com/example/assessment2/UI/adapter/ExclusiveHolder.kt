package com.example.assessment2.UI.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2.R
import com.example.assessment2.models.Exclusion

class ExclusiveHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val facility_id: TextView
    private val option_id: TextView
    fun setData(model: Exclusion) {
        facility_id.text = "" + model.facilityId
        option_id.text = model.optionsId
    }

    init {
        facility_id = itemView.findViewById(R.id.facility_id)
        option_id = itemView.findViewById(R.id.option_id)
    }
}