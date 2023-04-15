package com.example.listview_spinner_autocompletelist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class AutocompleteListviewActivity : AppCompatActivity() {
     lateinit var autocom_txt:AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autocomplete_listview)
        autocom_txt=this.findViewById(R.id.auto_Txtview)
        var list:ArrayList<String> = ArrayList()
        list.add("rose")
        list.add("sunflower")
        list.add("lotus")
        list.add("rtt")
        list.add("suvvghud")
        var adapter1:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        autocom_txt.setAdapter(adapter1)

        //threshold value defines after how much fix character autocomplete list show
        autocom_txt.threshold=1


    }
}