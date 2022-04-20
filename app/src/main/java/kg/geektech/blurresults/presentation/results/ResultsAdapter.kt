package kg.geektech.blurresults.presentation.results

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.blurresults.databinding.ItemResultInfoBinding
import kg.geektech.blurresults.domain.entity.ResultGameEntity

class ResultsAdapter :
    ListAdapter<ResultGameEntity, ResultsAdapter.ViewHolder>(ResultDiffCallback()) {

    var onClick: ((player: ResultGameEntity) -> Unit)? = null
    var onLongClick: ((player: ResultGameEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemResultInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.onClick(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemResultInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(result: ResultGameEntity) {

            val date = "Date: ${result.date}"
            val duration = "Game Duration: ${result.gameDuration}"
            val rounds = "Rounds: ${result.numberOfRounds}"
            val winner = "Winner: ${result.winnerPlayerName}"

            with(binding) {
                binding.tvGameDate.text = date
                binding.tvGameDuration.text = duration
                binding.tvNumberOfRounds.text = rounds
                binding.tvWinnerPlayerName.text = winner
            }

        }

        fun onClick(result: ResultGameEntity) {
            with(binding) {
                itemView.setOnClickListener {
                    this@ResultsAdapter.onClick?.invoke(result)
                }
                itemView.setOnLongClickListener {
                    this@ResultsAdapter.onLongClick?.invoke(result)
                    return@setOnLongClickListener true
                }
            }
        }

    }

    class ResultDiffCallback : DiffUtil.ItemCallback<ResultGameEntity>() {

        override fun areItemsTheSame(
            oldItem: ResultGameEntity,
            newItem: ResultGameEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ResultGameEntity,
            newItem: ResultGameEntity
        ): Boolean {
            return oldItem == newItem
        }
    }

}