package com.agura.com.recipelist.Activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.agura.com.recipelist.R
import com.agura.com.recipelist.data.Recipe
import org.w3c.dom.Text

/**
 * Created by SmartStart on 12/7/17.
 */
class RecipeDetail : AppCompatActivity() {

    companion object {
        val KEY_RECIPE = "111"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_layout)



        val recipe: Recipe = intent.getParcelableExtra(KEY_RECIPE)

        val txtIngred = findViewById<TextView>(R.id.txtIngred) as TextView
        val txtProced = findViewById<TextView>(R.id.txtProced) as TextView
        val imgPic = findViewById<ImageView>(R.id.imageView) as ImageView
        txtIngred.append(recipe.food_ingred)
        txtProced.append(recipe.food_proced)
        val drawable: Drawable = resources.getDrawable(recipe.food_img)
        imgPic.setImageDrawable(drawable)

        val toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setBackgroundColor(Color.BLACK)
        toolbar.setSubtitleTextColor(Color.GRAY)
        toolbar.setSubtitle(recipe.food_name)

        setSupportActionBar(toolbar)
        if (getSupportActionBar() != null){
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
            getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}
