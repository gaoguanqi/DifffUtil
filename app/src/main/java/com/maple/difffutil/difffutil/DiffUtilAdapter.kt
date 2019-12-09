package com.maple.difffutil.difffutil

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maple.difffutil.OnItemClickListener
import com.maple.difffutil.R
import com.maple.difffutil.entity.MapleEntity

/**
 * author: gaogq
 * time: 2019/4/22 11:59
 * description:
 */
class DiffUtilAdapter: RecyclerView.Adapter<DiffUtilAdapter.ViewHolder>() {


    var mData:List<MapleEntity>? = null
    var mListener:OnItemClickListener? = null

    fun setData(data:List<MapleEntity>){
        this.mData = data
        notifyDataSetChanged()
    }


    fun upData(data:List<MapleEntity>){

    }


    fun setOnItemClickListener(listener: OnItemClickListener){
        this.mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_diffutil,parent,false))
    }

    override fun getItemCount(): Int {
        return if(mData == null) 0 else mData!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(mData?.get(position))
        if(mListener != null){
            holder.itemRoot?.setOnClickListener { mListener?.onItemClick(position,mData?.get(position)) }
        }
    }


     class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
         var itemRoot: LinearLayout? = null

        fun setData(entity: MapleEntity?) {
            itemRoot = itemView.findViewById(R.id.room)
            itemView.findViewById<TextView>(R.id.item_tv_text).setText(entity?.content)
        }
    }
}
