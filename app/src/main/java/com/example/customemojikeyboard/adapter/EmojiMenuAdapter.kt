package com.example.customemojikeyboard.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.customemojikeyboard.MyEmojiMenuClick
import com.example.customemojikeyboard.R

class EmojiMenuAdapter(
    private val ChildItemList: List<Int>, var myEmojiMenuClick: MyEmojiMenuClick
) : RecyclerView.Adapter<EmojiMenuAdapter.ChildViewHolder>() {

    companion object {
        var clickedPosition: Int = 0
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): EmojiMenuAdapter.ChildViewHolder {

        // Here we inflate the corresponding
        // layout of the child item
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.emoji_menu_item,
                viewGroup, false
            )
        return ChildViewHolder(view)
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
        var ChildItemTitle: ImageView
        var hightlightview: View

        init {
            ChildItemTitle = itemView.findViewById(
                R.id.emojimenuitem
            )
            hightlightview = itemView.findViewById(R.id.view_hightlight)


        }


    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val childItem = ChildItemList[position]


        holder.ChildItemTitle.setImageResource(childItem)
        holder.ChildItemTitle.setColorFilter(Color.WHITE)
        holder.hightlightview.visibility = View.GONE

        holder.ChildItemTitle.setOnClickListener {


            myEmojiMenuClick.clickmenu(position)
            clickedPosition = position



            Log.v("position", "pos=" + position)

        }

        if (clickedPosition == position) {
            holder.hightlightview.visibility = View.VISIBLE
            holder.ChildItemTitle.setColorFilter(R.color.skyblue)
        } else {
            holder.hightlightview.visibility = View.GONE
            holder.ChildItemTitle.setColorFilter(Color.WHITE)
        }


    }


}