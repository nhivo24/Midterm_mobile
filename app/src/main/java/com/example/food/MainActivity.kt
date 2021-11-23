package com.example.food

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import android.widget.TextView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import android.widget.ArrayAdapter
import com.squareup.picasso.Picasso


data class CardFood(
    val cardName: String,
    val cardImage: Int
)

val cardFoods: ArrayList<CardFood> = arrayListOf(
    CardFood("Cá Hồi Thượng Hạng", R.drawable.a1),
    CardFood("Bánh Xèo Đại Nam", R.drawable.a2),
    CardFood("Sườn Nướng Hải Châu", R.drawable.a3),
    CardFood("Lòng Nướng Phú Quốc", R.drawable.a4),
    CardFood("Thịt Bò Nộm", R.drawable.a5)
)

class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var button: Button
    lateinit var textView: TextView
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, cardFoods
        )
        listView = findViewById<ListView>(R.id.listview)
        textView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)
        listView.adapter = FoodAdapter(this, cardFoods)

        button.setOnClickListener {
            val randomIndex = Random.nextInt(cardFoods.size - 1)
            imageView.setImageResource(cardFoods[randomIndex].cardImage)
            textView.setText(cardFoods[randomIndex].cardName)
        }


    }
}

