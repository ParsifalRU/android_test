package com.sirius.test_app

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import rvadapter.CommentAdapter

class MainActivity : AppCompatActivity() {

    private val dm = DataModel()
    private val adapter = CommentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        loadImage()
        loadLogo()
        initTextViews()
        initRatingBar()
        initButtons()
    }

    private fun loadImage() {
        val dotaImage = findViewById<ImageView>(R.id.imgv)
        Picasso.with(this)
            .load(dm.image)
            .placeholder(R.drawable.ic_baseline_data_usage_24)
            .error(R.drawable.ic_launcher_foreground)
            .into(dotaImage)
    }

    private fun loadLogo() {
        val logoImage = findViewById<ImageView>(R.id.img_logo)

        Picasso.with(this)
            .load(dm.logo)
            .placeholder(R.drawable.ic_baseline_data_usage_24)
            .error(R.drawable.ic_launcher_foreground)
            .into(logoImage)
    }

    private fun initTextViews() {
        val title = findViewById<TextView>(R.id.tv_title)
        title.text = dm.name

        val marksCount = findViewById<TextView>(R.id.tv70)
        marksCount.text = dm.gradeCnt

        val tag1 = findViewById<TextView>(R.id.tv_moba)
        tag1.text = dm.tags[0]

        val tag2 = findViewById<TextView>(R.id.tv_multip)
        tag2.text = dm.tags[1]

        val tag3 = findViewById<TextView>(R.id.tv_strat)
        tag3.text = dm.tags[2]

        val description = findViewById<TextView>(R.id.tv_description)
        description.text = dm.description

        val review = findViewById<TextView>(R.id.tv_review)
        review.text = dm.rev_rat

        val reviewsCount = findViewById<TextView>(R.id.tv_numb_rev)
        reviewsCount.text = "${dm.gradeCnt} ${dm.rev_rat.removeRange(6..15)}s"
        val rating = findViewById<TextView>(R.id.tv_big_numb)
        rating.text = dm.rating.toString()
    }

    private fun initRatingBar() {
        val ratingBar1 = findViewById<RatingBar>(R.id.rtb)
        ratingBar1.rating = dm.rating

        val ratingBar2 = findViewById<RatingBar>(R.id.rtb_2)
        ratingBar2.rating = dm.rating
    }

    private fun initButtons() {
        val installButton = findViewById<Button>(R.id.btn)
        installButton.setBackgroundColor(resources.getColor(R.color.yel_more))
        installButton.text = dm.action.name
    }

    private fun initRecycler() {
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler.adapter = adapter
    }
}