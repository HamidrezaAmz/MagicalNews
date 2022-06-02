package ir.hamidrezaAmz.magicalnews.view.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivityBinding<B : ViewDataBinding> : AppCompatActivity() {

    private lateinit var binding: B

    abstract fun getLayoutResourceId(): Int

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, getLayoutResourceId())
    }

    fun getBinding() = binding

}