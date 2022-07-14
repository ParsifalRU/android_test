package com.sirius.test_app


import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import rvadapter.CommentAdapter
import java.time.temporal.TemporalAdjusters.previous


class MainActivity : AppCompatActivity() {

    val dm = DataModel()
    val adapter = CommentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recview()

        loadImage()

        loadlogo()

        bars()

        settv()

        setrtb()

        setbtn()
    }

    fun loadImage() {
        val imgv_dota = findViewById<ImageView>(R.id.imgv)
        Picasso.with(this)
            .load(dm.image)
            .placeholder(R.drawable.ic_baseline_data_usage_24)
            .error(R.drawable.ic_launcher_foreground)
            .into(imgv_dota)

    }

    fun loadlogo(){
        val imgv_logo = findViewById<ImageView>(R.id.img_logo)

        Picasso.with(this)
            .load(dm.logo)
            .placeholder(R.drawable.ic_baseline_data_usage_24)
            .error(R.drawable.ic_launcher_foreground)
            .into(imgv_logo)
    }

    fun bars(){
        supportActionBar?.hide()
        actionBar?.hide()
    }

    fun settv(){
        val tv_title = findViewById<TextView>(R.id.tv_title)
        tv_title.text = dm.name

        val tv70 = findViewById<TextView>(R.id.tv70)
        tv70.text = dm.gradeCnt

        val tv_moba = findViewById<TextView>(R.id.tv_moba)
        tv_moba.text = dm.tags[0]

        val tv_mult = findViewById<TextView>(R.id.tv_multip)
        tv_mult.text = dm.tags[1]

        val tv_strat = findViewById<TextView>(R.id.tv_strat)
        tv_strat.text = dm.tags[2]

        val tv_description = findViewById<TextView>(R.id.tv_description)
        tv_description.text = dm.description

        val tv_review = findViewById<TextView>(R.id.tv_review)
        tv_review.text = dm.rev_rat

        val tv_numb_rev = findViewById<TextView>(R.id.tv_numb_rev)
        tv_numb_rev.text = dm.gradeCnt + " " + dm.rev_rat.removeRange(6..15) + "s"

        val tv_big_numb = findViewById<TextView>(R.id.tv_big_numb)
        tv_big_numb.text = dm.rating.toString()


    }

    fun setrtb(){
        val rtb = findViewById<RatingBar>(R.id.rtb)
        rtb.rating = dm.rating

        val rtb_2 = findViewById<RatingBar>(R.id.rtb_2)
        rtb_2.rating = dm.rating
    }

    fun setbtn(){
        val btn = findViewById<Button>(R.id.btn)
        btn.setBackgroundColor(resources.getColor(R.color.yel_more))
        btn.text = dm.action.name

    }

    fun recview(){
        val rvw = findViewById<RecyclerView>(R.id.recyclerView)
        rvw.layoutManager = LinearLayoutManager(this@MainActivity)
        rvw.adapter = adapter
    }

}