package com.example.listview_spinner_autocompletelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class SpinnerActivity : AppCompatActivity() {
    lateinit var spinner:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        spinner=findViewById(R.id.spinner)
        var list:ArrayList<String> = ArrayList()
        list.add("mango")
        list.add("banana")
        list.add("apple")
        list.add("pinapple")
         var adapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,list)
        spinner.adapter=adapter
        spinner.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(this,"position="+position,Toast.LENGTH_LONG).show()
        }

    }
}