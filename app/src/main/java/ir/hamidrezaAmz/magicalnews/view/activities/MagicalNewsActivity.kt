package ir.hamidrezaAmz.magicalnews.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ir.hamidrezaAmz.magicalnews.R

@AndroidEntryPoint
class MagicalNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magical_news)
    }
}