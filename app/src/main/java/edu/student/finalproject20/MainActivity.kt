package edu.student.finalproject20

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //bind objects
        val baseDamage = findViewById<TextView>(R.id.txtBaseDmg)
        val baseCrit = findViewById<TextView>(R.id.txtCrit)
        val baseSpd = findViewById<TextView>(R.id.txtAttackSpeed)
        val wpnDamage = findViewById<TextView>(R.id.txtWpnDmg)
        val wpnCrit = findViewById<TextView>(R.id.txtWpnCrit)
        val wpnSpd = findViewById<TextView>(R.id.txtWpnAttackSpeed)
        val armorDamage = findViewById<TextView>(R.id.txtArmorDamage)
        val armorCrit = findViewById<TextView>(R.id.txtArmorCrit)
        val armorSpd = findViewById<TextView>(R.id.txtArmorAttackSpeed)

        val btnNext = findViewById<Button>(R.id.btnCalculate)
        val txtDPS = findViewById<TextView>(R.id.txtDPS)

        btnNext.setOnClickListener(View.OnClickListener {
            val dmg1: Double = baseDamage.text.toString().toDouble()
            val dmg2: Double = wpnDamage.text.toString().toDouble()
            val dmg3: Double = armorDamage.text.toString().toDouble()
            val crit1: Double = baseCrit.text.toString().toDouble()
            val crit2: Double = wpnCrit.text.toString().toDouble()
            val crit3: Double = armorCrit.text.toString().toDouble()
            val spd1: Double = baseSpd.text.toString().toDouble()
            val spd2: Double = wpnSpd.text.toString().toDouble()
            val spd3: Double = armorSpd.text.toString().toDouble()

            val damage: Double = dmg1+dmg2+dmg3
            val crit: Double = (crit1+crit2+crit3)*0.01
            val spd: Double = spd1+spd2+spd3

            val dps = ((crit * damage)+(crit * (1.5*damage))*spd)

            txtDPS.text = "${dps}"
        })

        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }

    }

    //function to hide keyboard goes right before the last right bracket of Class MainActivity
//should auto import android.content.Context
//should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }

}