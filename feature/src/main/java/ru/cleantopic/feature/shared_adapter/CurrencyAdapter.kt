package ru.cleantopic.feature.shared_adapter

import android.view.ViewGroup
import ru.cleantopic.common.base.BaseAdapter
import ru.cleantopic.common.extensions.viewBinding
import ru.cleantopic.feature.databinding.ItemCurrencyCardBinding
import ru.cleantopic.feature.domain.model.Currency
import ru.cleantopic.feature.shared_adapter.view_holder.CurrencyViewHolder

class CurrencyAdapter(private val onFavoriteItemClickListener: (Currency) -> Unit) :
    BaseAdapter<Currency, CurrencyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CurrencyViewHolder(parent.viewBinding(ItemCurrencyCardBinding::inflate))

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(differ.currentList[position], this.onFavoriteItemClickListener)
    }
}
