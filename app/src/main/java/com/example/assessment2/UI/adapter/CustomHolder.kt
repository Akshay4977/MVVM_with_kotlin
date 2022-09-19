package com.example.assessment2.UI.adapter

import android.content.Context
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2.R
import com.example.assessment2.models.Facility

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val facility_id: TextView
    private val facility_name: TextView
    private val radioGroupOptions: RadioGroup
    fun setData(model: Facility, context: Context?) {
        facility_name.text = "" + model.name
        for (i in model.options!!) {
            val radioButton = RadioButton(itemView.context)
            radioButton.text = i.name
            radioGroupOptions.addView(radioButton)
        }
    }

    init {
        facility_id = itemView.findViewById(R.id.facility_id)
        facility_name = itemView.findViewById(R.id.facility_name)
        radioGroupOptions = itemView.findViewById(R.id.option_radio_group)
    }
}