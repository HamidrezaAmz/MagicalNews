package ir.hamidrezaAmz.magicalnews.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragmentBinding<B : ViewDataBinding> : Fragment() {

    protected val TAG = javaClass.simpleName + "_TAG"

    private lateinit var binding: B

    abstract fun getLayoutResourceId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            getLayoutResourceId(),
            container,
            false
        )
        return binding.root
    }

    fun getBinding(): B = binding
}