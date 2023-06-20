package com.gquesada.notes

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.fragment.app.Fragment
import com.gquesada.notes.ui.notes.NoteListFragment
import java.util.Locale

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSystemLanguage()

        navigateToFragment(NoteListFragment())
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun setSystemLanguage() {
        val systemLocale = Locale.getDefault().language
        val supportedLanguages = listOf("en", "es")

        val appLocale = if (supportedLanguages.contains(systemLocale)) {
            Locale(systemLocale)
        } else {
            Locale("en") // Establecer inglés como idioma predeterminado si el idioma del sistema no es compatible
        }

        val config = Configuration()
        config.setLocale(appLocale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
    }


}