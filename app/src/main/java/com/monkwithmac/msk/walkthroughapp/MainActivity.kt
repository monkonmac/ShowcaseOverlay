package com.monkwithmac.msk.walkthroughapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import smartdevelop.ir.eram.showcaseviewlib.GuideView


class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var textViewRound: TextView
    lateinit var textViewDummy: TextView
    lateinit var editTextInput: EditText
    lateinit var buttonResetView1: Button
    lateinit var buttonResetView2: Button
    lateinit var buttonResetView3: Button
    lateinit var buttonResetView4: Button
    lateinit var buttonResetView5: Button
    lateinit var buttonResetView6: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        textViewRound = findViewById(R.id.textViewRound)
        textViewDummy = findViewById(R.id.textViewDummy)
        editTextInput = findViewById(R.id.et)
        buttonResetView1 = findViewById(R.id.resetView1)
        buttonResetView2 = findViewById(R.id.resetView2)
        buttonResetView3 = findViewById(R.id.resetView3)
        buttonResetView4 = findViewById(R.id.resetView4)
        buttonResetView5 = findViewById(R.id.resetView5)
        buttonResetView6 = findViewById(R.id.resetView6)


        buttonResetView1.setOnClickListener {
            reset(1)
        }
        buttonResetView2.setOnClickListener {
            reset(2)
        }
        buttonResetView3.setOnClickListener {
            reset(3)
        }
        buttonResetView4.setOnClickListener {
            reset(4)
        }
        buttonResetView5.setOnClickListener {
            reset(5)
        }
        buttonResetView6.setOnClickListener {
            reset(6)
        }


        textView.setOnClickListener {
            showToast("Text clicked")
        }
        textViewRound.setOnClickListener {
            showToast("Round clicked")
        }
        textViewDummy.setOnClickListener {
            showToast("Dummy Clicked")
        }

    }

    private fun showDialog(){
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle("title")
        //set message for alert dialog
        builder.setMessage("message")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing positive action
        builder.setPositiveButton("Yes"){dialogInterface, which ->
            Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_LONG).show()
        }
        //performing cancel action
        builder.setNeutralButton("Cancel"){dialogInterface , which ->
            Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
        }
        //performing negative action
        builder.setNegativeButton("No"){dialogInterface, which ->
            Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun reset(i : Int){
        when(i){
            1-> setTargetView1()
            2-> setTargetView2()
            3-> setTargetView3()
            4-> showNoTargetView()
            5-> showNoTargetViewWithCustomView()
            6-> setTargetViewWithFocus()
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun setTargetView1() {
        GuideView.Builder(this)
            .setTitle("Target View")
            .setContentText("Click to dismiss")
            .setTargetView(textView)
            .setDismissType(smartdevelop.ir.eram.showcaseviewlib.config.DismissType.targetView)
            .build()
            .show()
    }

    private fun setTargetView2() {
        GuideView.Builder(this)
            .setTitle("Target View Round")
            .setContentText("Click to dismiss")
            .setTargetView(textViewRound)
            .setDismissType(smartdevelop.ir.eram.showcaseviewlib.config.DismissType.targetView)
            .build()
            .show()
    }

    private fun setTargetView3() {
        CustomGuideView.Builder(this)
            .setTargetView(textViewDummy)
            .setBgColor(0x99000000.toInt())
            .setDismissType(DismissType.targetView)
            .build()
            .show()
    }

    private fun setTargetViewWithFocus() {
        CustomGuideView.Builder(this)
            .setTargetView(editTextInput, true)
            .setDismissType(DismissType.externalTrigger)
            .setBgColor(Color.parseColor("#99FFFF00"))
            .build()
            .show()
    }

    private fun showNoTargetView() {
        OverlayView.Builder(this)
            .setBgColor(Color.parseColor("#99FFFF00"))
            .setDismissType(smartdevelop.ir.eram.showcaseviewlib.config.DismissType.anywhere)
            .build()
            .show()
    }

    private fun showNoTargetViewWithCustomView() {
        val view = layoutInflater.inflate(R.layout.custom_view, null)
        OverlayView.Builder(this)
            .setBgColor(Color.parseColor("#99FFFFFF"))
            .setDismissType(smartdevelop.ir.eram.showcaseviewlib.config.DismissType.anywhere)
            .addCustomView(view)
            .build()
            .show()
    }
}
