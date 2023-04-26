package com.example.customemojikeyboard

class ParentItem
{
    // Declaration of the variables
    public var ParentItemTitle: String? = null
    public var ChildItemList: List<ChildItem>? = null

    // Constructor of the class
    // to initialize the variables
    constructor(
        ParentItemTitle: String?,
        ChildItemList: List<ChildItem>?
    ) {
        this.ParentItemTitle = ParentItemTitle
        this.ChildItemList = ChildItemList
    }
}