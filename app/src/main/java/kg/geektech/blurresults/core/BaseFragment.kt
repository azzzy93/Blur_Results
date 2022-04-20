package kg.geektech.blurresults.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import kg.geektech.blurresults.R

abstract class BaseFragment<VB : ViewBinding>() : Fragment() {

    protected lateinit var binding: VB
    protected abstract fun initBinding(): VB
    protected val navController: NavController by lazy {
        Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initBinding()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        setupObservers()
        setupListeners()
    }

    open fun setupListeners() {}

    open fun setupObservers() {}

    open fun setupUi() {}
}