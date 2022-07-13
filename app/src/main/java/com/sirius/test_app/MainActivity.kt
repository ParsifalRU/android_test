package com.sirius.test_app

import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.android.volley.toolbox.ImageLoader
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.squareup.picasso.Picasso
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    val dm = DataModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadImage()

        g()

        settv()

        setrtb()

        loadlogo()
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

    fun g(){
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
    }

    fun setrtb(){
        val rtb = findViewById<RatingBar>(R.id.rtb)
        rtb.rating = dm.rating
    }

}