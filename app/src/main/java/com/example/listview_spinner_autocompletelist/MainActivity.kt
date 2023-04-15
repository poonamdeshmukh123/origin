package com.example.listview_spinner_autocompletelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnlistview:Button=this.findViewById(R.id.btn_listview)
        var btnspinner:Button=this.findViewById(R.id.btn_spinner)
        var btnautocomplete:Button=this.findViewById(R.id.btn_autocomplete_txtview)

        btnlistview.setOnClickListener{


            var intent:Intent = Intent(this,LIstViewActivity::class.java)
            startActivity(intent)
        }
        btnspinner.setOnClickListener {
            var intent:Intent = Intent(this,SpinnerActivity::class.java)
            startActivity(intent)
        }
        btnautocomplete.setOnClickListener {
            var intent:Intent = Intent(this,AutocompleteListviewActivity::class.java)
            startActivity(intent)
        }
    }
}