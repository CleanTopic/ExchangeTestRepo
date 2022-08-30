package ru.cleantopic.feature.shared_adapter.view_holder

import ru.cleantopic.common.base.BaseViewHolder
import ru.cleantopic.common.extensions.setDebounceClickListener
import ru.cleantopic.feature.R
import ru.cleantopic.feature.databinding.ItemCurrencyCardBinding
import ru.cleantopic.feature.domain.model.Currency

class CurrencyViewHolder(private val binding: ItemCurrencyCardBinding) :
    BaseViewHolder<Currency, ItemCurrencyCardBinding>(binding) {
    fun bind(item: Currency, onFavoriteItemClickListener: (Currency) -> Unit) {
        binding.tvCurrency.text = item.name
        binding.chipCurrencyValue.text = item.value.toString()

        // Highlights the user's favorite currency
        when (item.isFavorite) {
            true -> {
                binding.ibLike.setImageResource(R.drawable.ic_star_24)
                binding.chipCurrencyValue.setChipBackgroundColorResource(android.R.color.holo_green_dark)
            }
            else -> {
                binding.ibLike.setImageResource(R.drawable.ic_star_outline_24)
                binding.chipCurrencyValue.setChipBackgroundColorResource(android.R.color.holo_blue_dark)
            }
        }

        binding.ibLike.setDebounceClickListener {
            onFavoriteItemClickListener(item)
        }
        itemView.setDebounceClickListener {
            onFavoriteItemClickListener(item)
        }
    }

    override fun bind(item: Currency) {
    }
}
