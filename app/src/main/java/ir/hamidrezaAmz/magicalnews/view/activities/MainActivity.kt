package ir.hamidrezaAmz.magicalnews.view.activities

import android.os.Bundle
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.databinding.ActivityMainBinding
import ir.hamidrezaAmz.magicalnews.view.base.BaseActivityBinding

class MainActivity : BaseActivityBinding<ActivityMainBinding>() {

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
    }

}