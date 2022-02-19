package com.mavra.core.view

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.mavra.core.viewmodel.BaseViewModel


abstract class BaseFragment<ViewModel : BaseViewModel, T : ViewBinding> : Fragment() {

    private var _binding: T? = null
    val binding get() = _binding!!
    abstract fun getViewBinding(): T
    protected abstract fun getViewModelClass(): Class<ViewModel>


    protected val viewModel: ViewModel by lazy { ViewModelProvider(this).get(getViewModelClass()) }
    private var runOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()

        initUI(inflater, container, savedInstanceState)

        if (!runOnce) {
            runOnce = true
            runOnce()
        } else {
            againOpened()
        }


        setOnClickListener()

        return binding.root
    }



    open fun runOnce() {}

    open fun initUI(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
    }

    open fun againOpened() {}


    open fun setOnClickListener() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}