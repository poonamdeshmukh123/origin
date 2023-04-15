package com.example.listview_spinner_autocompletelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class LIstViewActivity : AppCompatActivity() {
    lateinit var listview:ListView
    lateinit var listnames:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        listview=this.findViewById(R.id.listview)
        listnames.add("poonma")
        listnames.add("sonlai")
        listnames.add("nikita")
        listnames.add("gayatri")

        val arradapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,listnames);
        listview.adapter=arradapter

        //click on item perform action

        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"position="+position,Toast.LENGTH_LONG).show()
        }
    }
}