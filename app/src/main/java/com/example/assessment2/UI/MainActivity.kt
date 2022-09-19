package com.example.assessment2.UI


import android.os.Bundle
import android.os.Handler

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2.R
import com.example.assessment2.UI.adapter.CustomAdapter
import com.example.assessment2.UI.adapter.ExclusiveAdapter
import com.example.assessment2.models.Exclusion
import com.example.assessment2.models.Facility
import com.example.assessment2.viewmodel.MainActivityViewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var exclusiveRecyclerView: RecyclerView? = null
    private var textViewExclusion: TextView? = null
    private var textView: TextView? = null
    private var list: ArrayList<Facility>? = null
    private var exclusiveList: ArrayList<Exclusion>? = null
    private var button: Button? = null
    private var mainActivityViewModel: MainActivityViewModel? = null
    private var customAdapter: CustomAdapter? = null
    private var exclusiveAdapter: ExclusiveAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        exclusiveRecyclerView = findViewById(R.id.exclusive_recycler_view)
        textView = findViewById(R.id.facility_text)
        textViewExclusion = findViewById(R.id.exclusion_text)
        button = findViewById(R.id.button_offline_load)

        mainActivityViewModel =  ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel!!.init()

        Handler().postDelayed({
            setRecyclerView()
            setRecyclerViewForExclusion();
        }, 3000)
        mainActivityViewModel!!.mainModelLiveData?.observe(this) {

            customAdapter?.notifyDataSetChanged()
            exclusiveAdapter?.notifyDataSetChanged()
        }
    }


    private fun setRecyclerView() {
        if (mainActivityViewModel!!.mainModelLiveData != null && mainActivityViewModel!!.mainModelLiveData.value != null && mainActivityViewModel!!.mainModelLiveData.value!!.facilities != null) {
            list =
                mainActivityViewModel!!.mainModelLiveData.value!!.facilities as ArrayList<Facility>?
            textView!!.visibility = View.VISIBLE
            textViewExclusion!!.visibility = View.VISIBLE
            customAdapter = CustomAdapter(list, applicationContext)
            recyclerView!!.layoutManager = LinearLayoutManager(baseContext)
            recyclerView!!.hasFixedSize()
            recyclerView!!.adapter = customAdapter
        } else {
            Log.d("inside", "else")
        }
    }

    private fun setRecyclerViewForExclusion() {
        exclusiveList =
            mainActivityViewModel!!.mainModelLiveData.value!!.exclusions!![0] as ArrayList<Exclusion>
        exclusiveAdapter = ExclusiveAdapter(exclusiveList)
        exclusiveRecyclerView!!.layoutManager = LinearLayoutManager(baseContext)
        exclusiveRecyclerView!!.hasFixedSize()
        exclusiveRecyclerView!!.adapter = exclusiveAdapter
    }
}