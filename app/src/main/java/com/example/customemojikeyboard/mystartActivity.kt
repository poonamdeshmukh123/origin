package com.example.customemojikeyboard

import android.os.Bundle
import android.text.Html
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.emoji2.text.EmojiCompat


class mystartActivity : AppCompatActivity(), ReturnEmoji {
    lateinit var bottomSheet: Bottomsheetfragment
    lateinit var menuclick: MyEmojiMenuClick
    lateinit var btnemoji: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mystart)
        var btn: Button = findViewById(R.id.clickbtn)
        btnemoji = findViewById(R.id.btnsetemoji)
        bottomSheet = Bottomsheetfragment()


        btn.setOnClickListener {

            bottomSheet.show(
                supportFragmentManager,
                "ModalBottomSheet"
            )
        }


    }

    override fun returnemoji(unicode: String) {

        btnemoji.text = EmojiCompat.get().process(Html.fromHtml(unicode))
        bottomSheet.dismiss()

    }


}