package kg.geektech.blurresults.presentation.result

import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.blurresults.core.BaseFragment
import kg.geektech.blurresults.databinding.FragmentResultBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ResultFragment : BaseFragment<FragmentResultBinding>() {

    private val args: ResultFragmentArgs by navArgs()
    private val viewModel: ResultViewModel by viewModels()
    private val adapter: PlayerResultInfoAdapter by lazy {
        PlayerResultInfoAdapter()
    }

    override fun setupUi() {
        initRv()
    }

    private fun initRv() {
        with(binding.recyclerPlayersInfo) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ResultFragment.adapter
        }
    }

    override fun initBinding(): FragmentResultBinding {
        return FragmentResultBinding.inflate(layoutInflater)
    }

    override fun setupObservers() {
        viewModel.getResult(args.id)
        viewModel.result.flowWithLifecycle(lifecycle).onEach {
            with(binding) {
                val date = "Date: ${it.date}"
                val duration = "Game Duration: ${it.gameDuration}"
                val rounds = "Rounds: ${it.numberOfRounds}"
                val winner = "Winner: ${it.winnerPlayerName}"

                tvDate.text = date
                tvGameDuration.text = duration
                tvNumberOfRounds.text = rounds
                tvWinnerPlayerName.text = winner
            }
            adapter.submitList(it.playersResults)
        }.launchIn(lifecycleScope)
    }

    override fun setupListeners() {
        binding.btnClose.setOnClickListener {
            navController.navigateUp()
        }
    }

}