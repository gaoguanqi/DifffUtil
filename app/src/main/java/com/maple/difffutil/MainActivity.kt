package com.maple.difffutil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maple.difffutil.difffutil.DiffUtilActivity
import com.maple.difffutil.paging.PagingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_diffutil.setOnClickListener {
            startActivity(Intent(this@MainActivity,DiffUtilActivity::class.java))
        }

        btn_paging.setOnClickListener {
            startActivity(Intent(this@MainActivity,PagingActivity::class.java))
        }

        //获取证书指纹
        //联调彩站推荐列表接口
    }
}
