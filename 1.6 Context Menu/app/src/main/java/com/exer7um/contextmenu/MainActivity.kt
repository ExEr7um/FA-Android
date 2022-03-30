package com.exer7um.contextmenu

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var tw1: TextView? = null
    var tw2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tw1 = findViewById(R.id.textView)
        tw2 = findViewById(R.id.textView2)
        registerForContextMenu(tw1)
        registerForContextMenu(tw2)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        when (v.id) {
            R.id.textView -> {
                // you can set menu header with title icon etc
                menu.setHeaderTitle("Choose a color")
                // add menu items
                menu.add(0, v.id, 0, "Red")
                menu.add(0, v.id, 0, "Green")
                menu.add(0, v.id, 0, "Blue")
            }
            R.id.textView2 -> {
                // you can set menu header with title icon etc
                menu.setHeaderTitle("Choose size")
                // add menu items
                menu.add(0, v.id, 0, "14")
                menu.add(0, v.id, 0, "28")
                menu.add(0, v.id, 0, "52")
            }
        }
    }

    // menu item select listener
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.title.toString()) {
            "Red" -> tw1!!.setBackgroundColor(Color.RED)
            "Green" -> tw1!!.setBackgroundColor(Color.GREEN)
            "Blue" -> tw1!!.setBackgroundColor(Color.BLUE)
            "14" -> tw2!!.textSize = 14f
            "28" -> tw2!!.textSize = 28f
            "52" -> tw2!!.textSize = 52f
            else -> println("SS")
        }
        return true
    }
}