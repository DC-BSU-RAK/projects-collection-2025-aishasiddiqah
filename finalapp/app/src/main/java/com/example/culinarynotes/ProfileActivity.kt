package com.example.culinarynotes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    private lateinit var username: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val instructionsBtn : ImageButton = findViewById(R.id.instructBtn2)
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

        username = findViewById(R.id.username)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")
        username.text = text

        val homeBtn : ImageButton = findViewById(R.id.homeBtn2)
        homeBtn.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val logoutBtn : ImageButton = findViewById(R.id.logoutBtn)
        logoutBtn.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        val allRecipesBtn : ImageButton = findViewById(R.id.allrecsBtn3)
        allRecipesBtn.setOnClickListener{
            val intent = Intent(this,AllRecipesActivity::class.java)
            startActivity(intent)
        }
    }
}