package kg.geektech.blurresults.presentation.results

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.blurresults.core.BaseFragment
import kg.geektech.blurresults.databinding.FragmentResultsBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ResultsFragment : BaseFragment<FragmentResultsBinding>() {

    private val adapter: ResultsAdapter by lazy {
        ResultsAdapter()
    }
    private val viewModel: ResultsViewModel by viewModels()

    override fun initBinding(): FragmentResultsBinding {
        return FragmentResultsBinding.inflate(layoutInflater)
    }

    override fun setupUi() {
        initRv()
    }

    override fun setupListeners() {
        with(adapter) {
            onClick = {
                it.id?.let { id ->
                    navController.navigate(
                        ResultsFragmentDirections.actionResultsFragmentToResultFragment(
                            id
                        )
                    )
                }
            }
            onLongClick = {
                AlertDialog.Builder(requireContext()).apply {
                    setTitle("Attention")
                    setMessage("Are you sure you want to delete the selected item?")
                    setPositiveButton("Yes") { _, _ ->
                        viewModel.removeResult(it)
                        adapter.notifyDataSetChanged()
                    }
                    setNegativeButton("No") { _, _ -> }
                    show()
                }
            }
        }
    }

    override fun setupObservers() {
        viewModel.resultList.flowWithLifecycle(lifecycle).onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)
    }

    private fun initRv() {
        binding.recyclerResults.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = this@ResultsFragment.adapter
        }
    }

}