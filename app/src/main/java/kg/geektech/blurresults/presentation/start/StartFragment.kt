package kg.geektech.blurresults.presentation.start

import kg.geektech.blurresults.core.BaseFragment
import kg.geektech.blurresults.databinding.FragmentStartBinding

class StartFragment : BaseFragment<FragmentStartBinding>() {

    override fun initBinding(): FragmentStartBinding {
        return FragmentStartBinding.inflate(layoutInflater)
    }

    override fun setupListeners() {
        binding.btnStartGame.setOnClickListener {
            navController.navigate(StartFragmentDirections.actionStartFragmentToGameFragment())
        }
    }
}