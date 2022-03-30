package com.exer7um.guessthenumber

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.*


class MainActivity : AppCompatActivity() {
    var tv: TextView? = null
    var prompt: TextView? = null
    var te: TextInputEditText? = null
    var submit: Button? = null
    var ll: LinearLayout? = null
    var number = 0
    var difficulty = 0
    private fun start() {
        ll!!.visibility = View.VISIBLE
        prompt!!.visibility = View.GONE
        number = Random().nextInt(difficulty)
        tv!!.text = String.format("Guess the number from 0 to %s", difficulty)
        te!!.setText("")
        te!!.isEnabled = true
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView)
        te = findViewById(R.id.textField)
        submit = findViewById(R.id.button)
        ll = findViewById(R.id.linearLayout)
        prompt = findViewById(R.id.prompt)
        with(ll) { this?.setVisibility(View.GONE) }
        with(prompt) { this?.setVisibility(View.VISIBLE) }
        with(te) { this?.addTextChangedListener(tw) }
        difficulty = 100
        with(submit) { this?.setEnabled(false) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //    @Override
    //    public boolean onPrepareOptionsMenu(Menu menu) {
    //        return super.onPrepareOptionsMenu(menu);
    //    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_new -> start()
            R.id.submenu_e -> {
                difficulty = 50
                start()
            }
            R.id.submenu_n -> {
                difficulty = 100
                start()
            }
            R.id.submenu_h -> {
                difficulty = 200
                start()
            }
            R.id.menu_exit -> {
                finishAffinity()
            }

            else -> println(item.itemId)
        }
        return super.onOptionsItemSelected(item)
    }

    fun onSubmitClick(view: View) {
        if (te!!.text.toString().toInt() <= difficulty) {
            if (te!!.text.toString() === number.toString()) {
                tv!!.text = "Congrats! Wanna do it again?"
            } else {
                tv!!.text = String.format("Wrong, it was %s. Wanna do it again?", number)
            }
            submit?.isEnabled = false
            te!!.isEnabled = false
        } else {
            AlertDialog.Builder(this)
                .setTitle("Wrong number format")
                .setMessage("The number doesn't satisfy the required boundaries")
                .setCancelable(false)
                .setPositiveButton("ok"
                ) { _, _ -> }.show()
        }
    }

    private val tw: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            submit?.isEnabled = false
        }

        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            submit?.isEnabled = te!!.text!!.isNotEmpty()
        }

        override fun afterTextChanged(editable: Editable) {}
    }
}