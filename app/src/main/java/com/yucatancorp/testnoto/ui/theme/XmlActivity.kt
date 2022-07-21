package com.yucatancorp.testnoto.ui.theme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.font.Typeface
import androidx.core.content.res.ResourcesCompat
import com.yucatancorp.testnoto.MainActivity
import com.yucatancorp.testnoto.R
import com.yucatancorp.testnoto.databinding.ActivityXmlBinding


class XmlActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.mButton.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }

        supportActionBar?.title = "xml"

        binding.mSwitch.setOnCheckedChangeListener { _, b ->
            if(b) {
                binding.mTextViewEnglish.typeface = ResourcesCompat.getFont(this, R.font.notosans_regular)
                binding.mTextViewTamil.typeface = ResourcesCompat.getFont(this, R.font.notosans_regular)
                binding.mTextViewKannada.typeface = ResourcesCompat.getFont(this, R.font.notosans_regular)
                binding.mTextViewOriya.typeface = ResourcesCompat.getFont(this, R.font.notosans_regular)
                binding.mTextViewUrdu.typeface = ResourcesCompat.getFont(this, R.font.notosans_regular)
                binding.mTextViewTelugu.typeface = ResourcesCompat.getFont(this, R.font.notosans_regular)
                binding.fontLabel.text = resources.getString(R.string.noto_font_name)
            } else {
                binding.mTextViewEnglish.typeface = ResourcesCompat.getFont(this, R.font.aller_regular)
                binding.mTextViewTamil.typeface = ResourcesCompat.getFont(this, R.font.aller_regular)
                binding.mTextViewKannada.typeface = ResourcesCompat.getFont(this, R.font.aller_regular)
                binding.mTextViewOriya.typeface = ResourcesCompat.getFont(this, R.font.aller_regular)
                binding.mTextViewUrdu.typeface = ResourcesCompat.getFont(this, R.font.aller_regular)
                binding.mTextViewTelugu.typeface = ResourcesCompat.getFont(this, R.font.aller_regular)
                binding.fontLabel.text = resources.getString(R.string.aller_font_name)
            }
        }
    }
}