package com.example.booknooknancalculator


import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private lateinit var Items: TextView
    var stringList = mutableListOf<String>()
    private lateinit var firstInput: ImageView
    private lateinit var secondInput: ImageView

    private var firstInputImg: String? = null
    private var secondInputImg: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Items = findViewById(R.id.textView)
        firstInput = findViewById(R.id.input1)
        secondInput = findViewById(R.id.input2)

        findViewById<ImageButton>(R.id.magnifyButton).setOnClickListener {
            handleImageInput("magnifyingGlass")
        }

        findViewById<ImageButton>(R.id.mapButton).setOnClickListener {
            handleImageInput("map")
        }

        findViewById<ImageButton>(R.id.phoneButton).setOnClickListener {
            handleImageInput("phone")
        }

        findViewById<ImageButton>(R.id.roseButton).setOnClickListener {
            handleImageInput("rose")
        }

        findViewById<ImageButton>(R.id.crystalButton).setOnClickListener {
            handleImageInput("crystalBall")
        }

        val objectButton : ImageButton = findViewById(R.id.objectsButton)
        objectButton.setOnClickListener{
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_objects_popup,null)
            val objectWindow = PopupWindow(popupView, 960,1750,true)
            objectWindow.showAtLocation(popupView, Gravity.CENTER,0,0)

            val closeButton : ImageButton = popupView.findViewById(R.id.closeButton)
            closeButton.setOnClickListener{
                objectWindow.dismiss()
            }
        }

        val instructButton : ImageButton = findViewById(R.id.instructButton)
        instructButton.setOnClickListener {
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val instructPopupView = inflater.inflate(R.layout.activity_instructions_popup, null)
            val instructWindow = PopupWindow(instructPopupView, 960, 1750, true)
            instructWindow.showAtLocation(instructPopupView, Gravity.CENTER, 0, 0)

            val closeInstructButton : ImageButton = instructPopupView.findViewById(R.id.closeInstructButton)
            closeInstructButton.setOnClickListener{
                instructWindow.dismiss()
            }
        }
    }

    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun handleImageInput(value: String) {
        if (firstInputImg == value || secondInputImg == value) {
            showToast("An object can only be selected once")
            return
        }

        when {
            firstInputImg == null -> {
                firstInput.setImageResource(getImageRes(value))
                firstInputImg = value
            }
            secondInputImg == null -> {
                secondInput.setImageResource(getImageRes(value))
                secondInputImg = value
            }
            else -> {
                showToast("Only 2 inputs can be selected")
            }
        }
        val genre = when (value) {
            "magnifyingGlass" -> "Mystery"
            "map" -> "Adventure"
            "phone" -> "Young Adult"
            "rose" -> "Romance"
            "crystalBall" -> "Fantasy"
            else -> null
        }

        genre?.let {
            stringList.add(it)
        }
    }

    private fun getImageRes(value: String): Int {
        return when (value) {
            "magnifyingGlass" -> R.drawable.magnify
            "map" -> R.drawable.map
            "phone" -> R.drawable.phone
            "rose" -> R.drawable.rose
            "crystalBall" -> R.drawable.crystalball
            else -> 0
        }
    }

    private fun clearImg() {
        firstInput.setImageDrawable(null)
        secondInput.setImageDrawable(null)

        firstInputImg = null
        secondInputImg = null
    }

    fun onGetBookButtonClick(view: View){
        val selectedGenre = stringList

        val bookRec = when (selectedGenre.size){
            2 -> {
                if ("Fantasy" in selectedGenre && "Mystery" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val outputPopupView = inflater.inflate(R.layout.activity_output1, null)
                    val outputWindow = PopupWindow(outputPopupView, 910, 1700, true)
                    outputWindow.showAtLocation(outputPopupView, Gravity.CENTER, 0, 0)

                    val closeOutput1 : ImageButton = outputPopupView.findViewById(R.id.closeOutput1)
                    closeOutput1.setOnClickListener{
                        outputWindow.dismiss()
                    }
                    ""
                } else if ("Fantasy" in selectedGenre && "Romance" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val output2PopupView = inflater.inflate(R.layout.activity_output2, null)
                    val output2Window = PopupWindow(output2PopupView, 910, 1700, true)
                    output2Window.showAtLocation(output2PopupView, Gravity.CENTER, 0, 0)

                    val closeOutput2 : ImageButton = output2PopupView.findViewById(R.id.closeOutput2)
                    closeOutput2.setOnClickListener {
                        output2Window.dismiss()
                    }
                    ""
                } else if ("Fantasy" in selectedGenre && "Adventure" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val output3PopupView = inflater.inflate(R.layout.activity_output3, null)
                    val output3Window = PopupWindow(output3PopupView, 910, 1700, true)
                    output3Window.showAtLocation(output3PopupView, Gravity.CENTER, 0, 0)

                    val closeOutput3 : ImageButton = output3PopupView.findViewById(R.id.closeOutput3)
                    closeOutput3.setOnClickListener {
                        output3Window.dismiss()
                    }
                    ""
                } else if ("Fantasy" in selectedGenre && "Young Adult" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val output4PopupView = inflater.inflate(R.layout.activity_output4, null)
                    val output4Window = PopupWindow(output4PopupView, 910, 1700, true)
                    output4Window.showAtLocation(output4PopupView, Gravity.CENTER, 0, 0)

                    val closeOutput4 : ImageButton = output4PopupView.findViewById(R.id.closeOutput4)
                    closeOutput4.setOnClickListener {
                        output4Window.dismiss()
                    }
                    ""
                } else if ("Mystery" in selectedGenre && "Romance" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val output5PopupView = inflater.inflate(R.layout.activity_output5, null)
                    val output5Window = PopupWindow(output5PopupView, 910, 1700, true)
                    output5Window.showAtLocation(output5PopupView, Gravity.CENTER, 0, 0)

                    val closeOutput5 : ImageButton = output5PopupView.findViewById(R.id.closeOutput5)
                    closeOutput5.setOnClickListener {
                        output5Window.dismiss()
                    }
                    ""
                } else if ("Mystery" in selectedGenre && "Adventure" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val output6PopupView = inflater.inflate(R.layout.activity_output6, null)
                    val output6Window = PopupWindow(output6PopupView, 910, 1700, true)
                    output6Window.showAtLocation(output6PopupView, Gravity.CENTER, 0, 0)

                    val closeOutput6 : ImageButton = output6PopupView.findViewById(R.id.closeOutput6)
                    closeOutput6.setOnClickListener {
                        output6Window.dismiss()
                    }
                    ""
                } else if ("Mystery" in selectedGenre && "Young Adult" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val output7PopupView = inflater.inflate(R.layout.activity_output7, null)
                    val output7Window = PopupWindow(output7PopupView, 910, 1700, true)
                    output7Window.showAtLocation(output7PopupView, Gravity.CENTER, 0, 0)

                    val closeOutput7 : ImageButton = output7PopupView.findViewById(R.id.closeOutput7)
                    closeOutput7.setOnClickListener {
                        output7Window.dismiss()
                    }
                    ""
                } else if ("Romance" in selectedGenre && "Adventure" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val output8PopupView = inflater.inflate(R.layout.activity_output8, null)
                    val output8Window = PopupWindow(output8PopupView, 910, 1700, true)
                    output8Window.showAtLocation(output8PopupView, Gravity.CENTER, 0, 0)

                    val closeOutput8 : ImageButton = output8PopupView.findViewById(R.id.closeOutput8)
                    closeOutput8.setOnClickListener {
                        output8Window.dismiss()
                    }
                    ""
                } else if ("Romance" in selectedGenre && "Young Adult" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val output9PopupView = inflater.inflate(R.layout.activity_output9, null)
                    val output9Window = PopupWindow(output9PopupView, 910, 1700, true)
                    output9Window.showAtLocation(output9PopupView, Gravity.CENTER, 0, 0)

                    val closeOutput9 : ImageButton = output9PopupView.findViewById(R.id.closeOutput9)
                    closeOutput9.setOnClickListener {
                        output9Window.dismiss()
                    }
                    ""
                } else if ("Adventure" in selectedGenre && "Young Adult" in selectedGenre) {
                    val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val output10PopupView = inflater.inflate(R.layout.activity_output10, null)
                    val output10Window = PopupWindow(output10PopupView, 910, 1700, true)
                    output10Window.showAtLocation(output10PopupView, Gravity.CENTER, 0, 0)

                    val closeOutput10 : ImageButton = output10PopupView.findViewById(R.id.closeOutput10)
                    closeOutput10.setOnClickListener {
                        output10Window.dismiss()
                    }
                    ""
                } else {
                    ""
                }
            }
            else -> ""
        }
        Items.text = bookRec

        stringList.clear()
        clearImg()
    }

}