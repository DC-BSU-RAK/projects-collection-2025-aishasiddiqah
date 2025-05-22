package com.example.culinarynotes

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val instructionsBtn : ImageButton = findViewById(R.id.instructBtn)
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

        val profileBtn : ImageButton = findViewById(R.id.profileBtn)
        profileBtn.setOnClickListener{
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }
        val breakfastBtn : ImageButton = findViewById(R.id.breakfastBtn)
        breakfastBtn.setOnClickListener{
            val intent = Intent(this,BreakfastActivity::class.java)
            startActivity(intent)
        }
        val lunchBtn : ImageButton = findViewById(R.id.lunchBtn)
        lunchBtn.setOnClickListener{
            val intent = Intent(this,LunchActivity::class.java)
            startActivity(intent)
        }
        val dinnerBtn : ImageButton = findViewById(R.id.dinnerBtn)
        dinnerBtn.setOnClickListener{
            val intent = Intent(this,DinnerActivity::class.java)
            startActivity(intent)
        }
        val allRecipesBtn : ImageButton = findViewById(R.id.allrecsBtn)
        allRecipesBtn.setOnClickListener{
            val intent = Intent(this,AllRecipesActivity::class.java)
            startActivity(intent)
        }


    }
}