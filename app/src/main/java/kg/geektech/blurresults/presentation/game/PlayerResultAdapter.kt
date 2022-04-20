package kg.geektech.blurresults.presentation.game

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.blurresults.databinding.ItemPlayerBinding
import kg.geektech.blurresults.domain.entity.PlayerResult

class PlayerResultAdapter :
    ListAdapter<PlayerResult, PlayerResultAdapter.ViewHolder>(PlayerResultDiffCallback()) {

    var btnWinPlus: ((player: PlayerResult) -> Unit)? = null
    var btnWinMinus: ((player: PlayerResult) -> Unit)? = null
    var btnLossPlus: ((player: PlayerResult) -> Unit)? = null
    var btnLossMinus: ((player: PlayerResult) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.onClick(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(player: PlayerResult) {

            val total = "Total: ${player.total}"
            val winCount = "Player Win: ${player.winCount}"
            val loseCount = "Player Lose: ${player.lossCount}"

            with(binding) {
                tvPlayerName.text = player.name
                tvTotal.text = total
                tvPlayerWinCount.text = winCount
                tvPlayerLoseCount.text = loseCount
            }

        }

        fun onClick(player: PlayerResult) {
            with(binding) {
                btnWinMinus.setOnClickListener {
                    this@PlayerResultAdapter.btnWinPlus?.invoke(player)
                }
                btnWinMinus.setOnLongClickListener {
                    this@PlayerResultAdapter.btnWinMinus?.invoke(player)
                    return@setOnLongClickListener true
                }
                btnLoseMinus.setOnClickListener {
                    this@PlayerResultAdapter.btnLossPlus?.invoke(player)
                }
                btnLoseMinus.setOnLongClickListener {
                    this@PlayerResultAdapter.btnLossMinus?.invoke(player)
                    return@setOnLongClickListener true
                }
            }
        }

    }

    class PlayerResultDiffCallback : DiffUtil.ItemCallback<PlayerResult>() {

        override fun areItemsTheSame(oldItem: PlayerResult, newItem: PlayerResult) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PlayerResult, newItem: PlayerResult) =
            oldItem == newItem

    }

}