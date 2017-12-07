package com.agura.com.recipelist.data

import android.content.Intent
import android.support.v4.content.ContextCompat.createDeviceProtectedStorageContext
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.agura.com.recipelist.Activity.RecipeDetail
import com.agura.com.recipelist.R

/**
 * Created by SmartStart on 12/7/17.
 */
class CustomAdapter(val recipeList: ArrayList<Recipe>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    companion object {
        val KEY_RECIPE = "111"
    }
    override fun getItemCount(): Int {
    return recipeList.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtFoodName = itemView.findViewById<TextView>(R.id.txtFoodName) as TextView
        val txtFoodDesc = itemView.findViewById<TextView>(R.id.txtFoodDesc) as TextView


        val mCardView = itemView.findViewById<CardView>(R.id.cardView) as CardView
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val food: Recipe = recipeList[position]
        holder?.txtFoodName?.text = food.food_name
        holder?.txtFoodDesc?.text = food.food_desc

        holder?.mCardView?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View){
                val changePage = Intent(v.context, RecipeDetail::class.java)
                changePage.putExtra(KEY_RECIPE, food)
                v.context.startActivity(changePage)
            }



        })
    }




}