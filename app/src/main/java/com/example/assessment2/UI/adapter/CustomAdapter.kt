package com.example.assessment2.UI.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2.R
import com.example.assessment2.models.Facility


class CustomAdapter(list: ArrayList<Facility>?, context: Context) :
    RecyclerView.Adapter<CustomHolder>() {
    var list: ArrayList<Facility>? = null
    private val context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        return CustomHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        holder.setData(list!![position], context)
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
        this.context = context
    }
}