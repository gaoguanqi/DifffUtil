package com.maple.difffutil.difffutil

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.maple.difffutil.OnItemClickListener
import com.maple.difffutil.R
import com.maple.difffutil.entity.MapleEntity
import kotlinx.android.synthetic.main.activity_diff_util.*

class DiffUtilActivity : AppCompatActivity() {
    var mAdapter:DiffUtilAdapter? = null
    var mData:MutableList<MapleEntity>? = null
    var mEntity:MapleEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util)

        srl_diffutil.setColorSchemeColors(ContextCompat.getColor(this@DiffUtilActivity,R.color.colorAccent))
        srl_diffutil.setOnRefreshListener { onRefresh() }
        val decoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        decoration.setDrawable(this@DiffUtilActivity.resources.getDrawable(R.drawable.divider_list_line))
        rv_diffutil.addItemDecoration(decoration)

        mAdapter = DiffUtilAdapter()
        mData = mutableListOf()
        for (i in 0..50){
            mEntity = MapleEntity("title${i}","content${i}","url")
            mData?.add(mEntity!!)
        }
        mAdapter?.mData = mData

        mAdapter?.setOnItemClickListener(object: OnItemClickListener{
            override fun onItemClick(pos: Int, any: Any?) {
                Toast.makeText(this@DiffUtilActivity,(any as MapleEntity).content,Toast.LENGTH_SHORT).show()
            }
        })
        rv_diffutil.adapter = mAdapter
    }


    fun hasRefresh(isRefresh:Boolean){
        srl_diffutil.isRefreshing = isRefresh
    }

    private fun onRefresh() {
        hasRefresh(false)

        mData?.clear()
        mAdapter?.notifyDataSetChanged()
    }
}
