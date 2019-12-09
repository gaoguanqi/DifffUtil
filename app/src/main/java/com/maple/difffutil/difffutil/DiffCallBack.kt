package com.maple.difffutil.difffutil

import androidx.recyclerview.widget.DiffUtil
import com.maple.difffutil.entity.MapleEntity

/**
 * author: gaogq
 * time: 2019/4/22 16:02
 * description:
 */
class DiffCallBack: DiffUtil.Callback {

     var mOldDatas:List<MapleEntity>?
     var mNewDatas:List<MapleEntity>?

    constructor(oldDatas:List<MapleEntity>?,newDatas:List<MapleEntity>?){
        this.mOldDatas = oldDatas
        this.mNewDatas = newDatas
    }

    //老数据集 size
    override fun getOldListSize(): Int {
       return if(mOldDatas == null) 0 else mOldDatas!!.size
    }

    //新数据集 size
    override fun getNewListSize(): Int {
        return if(mNewDatas == null) 0 else mNewDatas!!.size
    }

    /**
     * Called by the DiffUtil to decide whether two object represent the same Item.
     * 被 DiffUtil 调用，用来判断两个对象是否是相同的 Item。
     * For example, if your items have unique ids, this method should check their id equality.
     * 例如，如果你的Item有唯一的id字段，这个方法就判断id是否相等。
     *
     * @param oldItemPosition The position of the item in the old list
     * @param newItemPosition The position of the item in the new list
     * @return True if the two items represent the same object or false if they are different.
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if (mOldDatas == null && mNewDatas == null) false else mOldDatas!!.get(oldItemPosition).equals(mNewDatas?.get(newItemPosition))
    }


    /**
     * Called by the DiffUtil when it wants to check whether two items have the same data.
     * 被 DiffUtil 调用，用来检查两个 item 是否含有相同的数据
     * DiffUtil uses this information to detect if the contents of an item has changed.
     * DiffUtil 用返回的信息（true false）来检测当前 item 的内容是否发生了变化
     * DiffUtil uses this method to check equality instead of {@link Object#equals(Object)}
     * DiffUtil 用这个方法替代 equals 方法去检查是否相等。
     * so that you can change its behavior depending on your UI.
     * 所以你可以根据你的 UI 去改变它的返回值
     * For example, if you are using DiffUtil with a
     * {@link android.support.v7.widget.RecyclerView.Adapter RecyclerView.Adapter}, you should
     * return whether the items' visual representations are the same.
     * 例如，如果你用 RecyclerView.Adapter 配合 DiffUtil 使用，你需要返回 Item 的视觉表现是否相同。
     * This method is called only if {@link #areItemsTheSame(int, int)} returns
     * {@code true} for these items.
     * 这个方法仅仅在 areItemsTheSame() 返回 true 时，才会被调用。
     *
     * @param oldItemPosition The position of the item in the old list
     * @param newItemPosition The position of the item in the new list which replaces the
     *                        oldItem
     * @return True if the contents of the items are the same or false if they are different.
     */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEntity:MapleEntity? = mOldDatas?.get(oldItemPosition)
        val newEntity:MapleEntity? = mNewDatas?.get(oldItemPosition)
        return if(oldEntity == null && newEntity == null) false else oldEntity!!.equals(newEntity)
    }
}