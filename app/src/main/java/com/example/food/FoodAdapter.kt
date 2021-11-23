package com.example.food

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class FoodAdapter(var mainActivity: MainActivity,
                  private val dataSource: ArrayList<CardFood>) : BaseAdapter() {

    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView =LayoutInflater.from(mainActivity).inflate(R.layout.activity_listview,parent,false)
       val textFood = rowView.findViewById(R.id.textFood) as TextView

        val imageFood = rowView.findViewById(R.id.imageFood) as ImageView
        val cardfood = getItem(position) as CardFood
        textFood.text=cardfood.cardName
        Picasso.get().load(cardfood.cardImage).into(imageFood)
        return rowView
    }
}