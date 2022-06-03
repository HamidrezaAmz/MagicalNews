package ir.hamidrezaAmz.magicalnews.view.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivityBinding<B : ViewDataBinding> : AppCompatActivity() {

    protected val TAG = javaClass.simpleName + "_TAG"

    private lateinit var binding: B

    abstract fun getLayoutResourceId(): Int

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        try {
            binding = DataBindingUtil.setContentView(this, getLayoutResourceId())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getBinding() = binding

}