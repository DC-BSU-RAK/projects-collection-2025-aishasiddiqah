package com.example.culinarynotes

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AllRecipesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_all_recipes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val instructionsBtn : ImageButton = findViewById(R.id.instructBtn3)
        instructionsBtn.setOnClickListener{
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_instruction_popup,null)
            val objectWindow = PopupWindow(popupView, 960,1750,true)
            objectWindow.showAtLocation(popupView, Gravity.CENTER,0,0)

            val closeButton : ImageButton = popupView.findViewById(R.id.closeBtn)
            closeButton.setOnClickListener{
                objectWindow.dismiss()
            }
        }

        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val soupBtn = findViewById<ImageButton>(R.id.soupBtn)

        scrollView.post {
            scrollView.scrollTo(0, soupBtn.top)
        }

        val homeBtn: ImageButton = findViewById(R.id.homeBtn3)
        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val profileBtn: ImageButton = findViewById(R.id.profileBtn3)
        profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val allRecipesBtn : ImageButton = findViewById(R.id.allrecsBtn2)
        allRecipesBtn.setOnClickListener{
            val intent = Intent(this,AllRecipesActivity::class.java)
            startActivity(intent)
        }
    }


    fun getRecipeButtonClick(view: View) {
        val intent = Intent(this, RecipeDisplayActivity::class.java).apply {
            putExtra("RECIPE_ID", view.id)
        }
        startActivity(intent)
    }

}