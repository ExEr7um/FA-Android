package com.exer7um.basicelements

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.*


class MainActivity : AppCompatActivity() {
    var tw: TextView? = null
    var ti: TextInputEditText? = null
    var names: ArrayList<String>? = null
    var adapter: ArrayAdapter<String>? = null
    var lw: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<View>(R.id.btn) as Button
        btn.text = "Update the TextView"
        tw = findViewById<View>(R.id.textView5) as TextView
        tw!!.text = "Set in Java!"
        ti = findViewById<View>(R.id.textInput) as TextInputEditText
        ti!!.hint = "Name"
        names = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names!!)
        lw = findViewById<View>(R.id.lw) as ListView
        lw!!.adapter = adapter
        lw!!.onItemClickListener =
            OnItemClickListener { _, _, position, _ ->
                names!!.removeAt(position)
                adapter!!.notifyDataSetChanged()
            }
    }

    fun onBtnClick(view: View?) {
        if (ti!!.text.toString().isNotEmpty()) {
            tw!!.text = ti!!.text.toString() + " is learning Android development"
            names!!.add(ti!!.text.toString())
            adapter!!.notifyDataSetChanged()
            ti!!.setText("")
        } else {
            AlertDialog.Builder(this)
                .setTitle("Empty string")
                .setMessage("String can't be empty")
                .setCancelable(false)
                .setPositiveButton(
                    "ok"
                ) { _, _ -> }.show()
        }
    }

    fun onSortClick(view: View?) {
        names?.sort()
        adapter!!.notifyDataSetChanged()
    }

    fun onDupDelClick(view: View?) {
        val newList = HashSet(names)
        names!!.clear()
        names!!.addAll(newList)
        println(names)
        adapter!!.notifyDataSetChanged()
    }
}