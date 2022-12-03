package com.example.assignment2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bt1: Button = findViewById(R.id.bt_Action)
        var bt2: Button = findViewById(R.id.bt_Puzzle)
        val f1 = ActionFragment()
        val f2 = PuzzleFragment()
        val f3 = Movie_ActionFragment()
        val f4 = Movie_PuzzleFragment()
        var flag1: String = "Games"
        val spinner: Spinner = findViewById(R.id.spinner1)
        var options = arrayOf("Games","Movies")
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag1 = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        bt1.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply{
                if(flag1=="Games")
                    replace(R.id.FLfragment, f1)
                else
                    replace(R.id.FLfragment, f3)
                commit()
            }
        }
        bt2.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply{
                if(flag1=="Games")
                    replace(R.id.FLfragment, f2)
                else
                    replace(R.id.FLfragment, f4)
                commit()
            }
        }
        var radio: RadioButton = findViewById(R.id.radioBlue)
        var radio1: RadioButton = findViewById(R.id.radioBlack)

        var txt1: TextView = findViewById(R.id.textView)
        radio.setOnClickListener(){
            if(radio.isChecked)
            {
                radio1.isChecked = false
                txt1.setTextColor(Color.parseColor("#0000FF"))
            }
        }
        radio1.setOnClickListener(){
            if(radio1.isChecked)
            {
                radio.isChecked = false
                txt1.setTextColor(Color.parseColor("#000000"))
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.years, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.year_2022-> Toast.makeText(this, "2022", Toast.LENGTH_SHORT).show()
            R.id.year_2021-> Toast.makeText(this, "2021", Toast.LENGTH_SHORT).show()
            R.id.year_2020-> Toast.makeText(this, "2020", Toast.LENGTH_SHORT).show()
        }
        return true;
    }
}