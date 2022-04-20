package kg.geektech.blurresults.presentation.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.blurresults.databinding.ItemPlayerInfoBinding
import kg.geektech.blurresults.domain.entity.PlayerResult

class PlayerResultInfoAdapter :
    ListAdapter<PlayerResult, PlayerResultInfoAdapter.ViewHolder>(PlayerResultInfoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPlayerInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemPlayerInfoBinding) :
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

    }

    class PlayerResultInfoDiffCallback : DiffUtil.ItemCallback<PlayerResult>() {

        override fun areItemsTheSame(oldItem: PlayerResult, newItem: PlayerResult) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PlayerResult, newItem: PlayerResult) =
            oldItem == newItem

    }
}