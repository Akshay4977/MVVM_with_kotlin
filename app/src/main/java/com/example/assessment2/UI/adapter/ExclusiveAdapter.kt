package com.example.assessment2.UI.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2.R
import com.example.assessment2.models.Exclusion

class ExclusiveAdapter(list: ArrayList<Exclusion>?) : RecyclerView.Adapter<ExclusiveHolder>() {
    var list: ArrayList<Exclusion>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExclusiveHolder {
        return ExclusiveHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.exclusive_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExclusiveHolder, position: Int) {
        holder.setData(list!![position])
    }

    override fun getItemCount(): Int {
        return if (list == null) {
            0
        } else {
            list!!.size
        }
    }

    init {
        this.list = list
    }
}