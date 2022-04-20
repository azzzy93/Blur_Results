package kg.geektech.blurresults.presentation.game

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.blurresults.core.BaseFragment
import kg.geektech.blurresults.databinding.FragmentGameBinding
import kg.geektech.blurresults.domain.entity.PlayerResult
import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class GameFragment : BaseFragment<FragmentGameBinding>() {

    private val adapter: PlayerResultAdapter by lazy {
        PlayerResultAdapter()
    }
    private val viewModel: GameViewModel by viewModels()
    private var startTime: Long = 0
    private lateinit var list: List<PlayerResult>

    init {
        startTime = Calendar.getInstance().time.time
    }

    override fun initBinding(): FragmentGameBinding {
        return FragmentGameBinding.inflate(layoutInflater)
    }

    override fun setupUi() {
        initRv()
    }

    private fun initRv() {
        binding.recyclerGame.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@GameFragment.adapter
        }
    }

    override fun setupObservers() {
        viewModel.playersList.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)
    }

    override fun setupListeners() {
        with(adapter) {
            btnWinPlus = { player ->
                val winCount = player.winCount.plus(1)
                val total = winCount - player.lossCount
                viewModel.editPlayer(player.copy(winCount = winCount, total = total))
                adapter.notifyDataSetChanged()
            }
            btnWinMinus = { player ->
                val winCount = player.winCount.minus(1)
                val total = winCount - player.lossCount
                viewModel.editPlayer(player.copy(winCount = winCount, total = total))
                adapter.notifyDataSetChanged()
            }
            btnLossPlus = { player ->
                val loseCount = player.lossCount.plus(1)
                val total = player.winCount - loseCount
                viewModel.editPlayer(player.copy(lossCount = loseCount, total = total))
                adapter.notifyDataSetChanged()
            }
            btnLossMinus = { player ->
                val loseCount = player.lossCount.minus(1)
                val total = player.winCount - loseCount
                viewModel.editPlayer(player.copy(lossCount = loseCount, total = total))
                adapter.notifyDataSetChanged()
            }
        }

        binding.btnFinishGame.setOnClickListener {
            createResult()
            navController.navigateUp()
        }
    }

    private fun createResult() {
        val endTime = Calendar.getInstance().time.time
        val gameTime = endTime - startTime
        val gameDuration = getTime(gameTime, "HH'h' mm'm'", "GMT")
        val date = getTime(startTime, "dd.MM.yyyy HH:mm", "GMT+6")
        var numberOfRounds = 0
        var winnerPlayerName = ""
        list = adapter.currentList.sortedBy {
            it.total
        }
        list.last().name?.let {
            winnerPlayerName = it
        }
        list.forEach {
            numberOfRounds += it.winCount
        }

        viewModel.insertResult(
            ResultGameEntity(
                date = date,
                gameDuration = gameDuration,
                numberOfRounds = numberOfRounds,
                winnerPlayerName = winnerPlayerName,
                playersResults = list
            )
        )

    }

    private fun getTime(timeInt: Long, timeFormat: String, gmt: String): String {
        val date = Date(timeInt)
        val format = SimpleDateFormat(timeFormat)
        format.timeZone = TimeZone.getTimeZone(gmt)
        return format.format(date)
    }
}