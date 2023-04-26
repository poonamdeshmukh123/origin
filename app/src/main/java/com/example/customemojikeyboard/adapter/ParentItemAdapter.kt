package com.example.customemojikeyboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.customemojikeyboard.ParentItem
import com.example.customemojikeyboard.R
import com.example.customemojikeyboard.mystartActivity


class ParentItemAdapter(
    private var itemList: List<ParentItem>, var context: mystartActivity

) :
    RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder>() {
    // An object of RecyclerView.RecycledViewPool
    // is created to share the Views
    // between the child and
    // the parent RecyclerViews
    private val viewPool = RecycledViewPool()

    var positionmenu: Int = -1

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ParentViewHolder {

        // Here we inflate the corresponding
        // layout of the parent item
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.parent_item,
                viewGroup, false
            )
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(
        parentViewHolder: ParentViewHolder,
        position: Int
    ) {
        var position1: Int = position
        callElement(parentViewHolder, itemList, position1)
    }

    private fun callElement(
        parentViewHolder: ParentItemAdapter.ParentViewHolder,
        itemList: List<ParentItem>,
        position1: Int
    ) {
        val parentItem = itemList[position1]

        // For the created instance,
        // get the title and set it
        // as the text for the TextView
        parentViewHolder.ParentItemTitle.text = parentItem.ParentItemTitle


        // Create a layout manager
        // to assign a layout
        // to the RecyclerView.

        // Here we have assigned the layout
        // as LinearLayout with vertical orientation
        val layoutManager = GridLayoutManager(
            parentViewHolder.ChildRecyclerView
                .context,
            8
        )

        // Since this is a nested layout, so
        // to define how many child items
        // should be prefetched when the
        // child RecyclerView is nested
        // inside the parent RecyclerView,
        // we use the following method
        layoutManager.initialPrefetchItemCount = parentItem.ChildItemList!!.size


        // Create an instance of the child
        // item view adapter and set its
        // adapter, layout manager and RecyclerViewPool
        val childItemAdapter = ChildItemAdapter(
            parentItem.ChildItemList!!, context

        )
        parentViewHolder.ChildRecyclerView.layoutManager = layoutManager
        parentViewHolder.ChildRecyclerView.adapter = childItemAdapter
        parentViewHolder.ChildRecyclerView
            .setRecycledViewPool(viewPool)


    }

    // This method returns the number
    // of items we have added in the
    // ParentItemList i.e. the number
    // of instances we have created
    // of the ParentItemList
    override fun getItemCount(): Int {
        return itemList.size
    }

    fun updatelist(parentItemList: List<ParentItem>) {
//        positionmenu = position;
        itemList = parentItemList
        notifyDataSetChanged()

    }

    // This class is to initialize
    // the Views present in
    // the parent RecyclerView
    inner class ParentViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        public val ParentItemTitle: TextView
        val ChildRecyclerView: RecyclerView

        init {
            ParentItemTitle = itemView
                .findViewById(
                    R.id.parent_item_title
                )
            ChildRecyclerView = itemView
                .findViewById(
                    R.id.child_recyclerview
                )
        }
    }
}
