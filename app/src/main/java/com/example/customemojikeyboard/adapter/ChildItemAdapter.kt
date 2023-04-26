package com.example.customemojikeyboard.adapter

import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.emoji2.text.EmojiCompat
import androidx.recyclerview.widget.RecyclerView

import com.example.customemojikeyboard.ChildItem
import com.example.customemojikeyboard.R
import com.example.customemojikeyboard.ReturnEmoji


class ChildItemAdapter
internal constructor(private val ChildItemList: List<ChildItem>,var returnemoji:ReturnEmoji) :
    RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ChildViewHolder {

        // Here we inflate the corresponding
        // layout of the child item
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.child_item,
                viewGroup, false
            )
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(
        childViewHolder: ChildViewHolder,
        position: Int
    ) {


        val childItem = ChildItemList[position]
        Log.v("unicode","unicode="+childItem.ChildItemTitle)
        childViewHolder.ChildItemTitle.text= EmojiCompat.get().process(Html.fromHtml(childItem.ChildItemTitle))
        childViewHolder.ChildItemTitle.setOnClickListener {
            returnemoji.returnemoji(childViewHolder.ChildItemTitle.text.toString())
        }


    }

    override fun getItemCount(): Int {

        // This method returns the number
        // of items we have added
        // in the ChildItemList
        // i.e. the number of instances
        // of the ChildItemList
        // that have been created
        return ChildItemList.size
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    inner class ChildViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var ChildItemTitle: Button

        init {
            ChildItemTitle = itemView.findViewById(
                R.id.img_child_item
            )
        }
    }
}
