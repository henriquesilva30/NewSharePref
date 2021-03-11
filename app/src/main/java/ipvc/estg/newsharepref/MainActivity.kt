package ipvc.estg.newsharepref

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref: SharedPreferences = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        val soundValue = sharedPref.getBoolean(getString(R.string.sound), false)
        Log.d("***SHAREDPREF", "READ $soundValue")

        if (soundValue) {
            findViewById<CheckBox>(R.id.checkbox).isChecked = true
        }

    }

    fun checkboxClicked(view: View) {
        if (view is CheckBox) {
            val sharedPref: SharedPreferences = getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean(getString(R.string.sound), view.isChecked)
                commit()
            }
            Log.d("***SHAREDPREF", "Changed to  ${view.isChecked}")
        }
    }
}
