package ru.cleantopic.feature.favorite.presentation

import by.kirich1409.viewbindingdelegate.viewBinding
import ru.cleantopic.common.base.BaseFragment
import ru.cleantopic.common.di.FeatureUtils
import ru.cleantopic.feature.R
import ru.cleantopic.feature.databinding.FragmentFavoriteBinding
import ru.cleantopic.feature.di.FeatureApi
import ru.cleantopic.feature.di.FeatureComponent
import ru.cleantopic.feature.domain.model.FilterType
import ru.cleantopic.feature.interactors.IUpdatable
import ru.cleantopic.feature.shared_adapter.CurrencyAdapter
import ru.cleantopic.feature.shared_view_model.SharedCurrencyViewModel

class FavoriteFragment : BaseFragment<SharedCurrencyViewModel>(R.layout.fragment_favorite), IUpdatable {

    override val binding: FragmentFavoriteBinding by viewBinding(FragmentFavoriteBinding::bind)

    private val currencyAdapter by lazy {
        CurrencyAdapter {
            viewModel.changeFavoriteState(it)
        }
    }

    override fun setupViews() {
        super.setupViews()
        binding.rvFavorite.adapter = currencyAdapter
    }

    override fun setupViewModelSubscriber() {
        super.setupViewModelSubscriber()
        viewModel.favoriteCurrencies.observe {
            currencyAdapter.bindData(it)
        }
    }

    override fun update(currencyName: String) {
        viewModel.updateCurrencyInfo(currencyName)
    }

    override fun load(currencyName: String) {
        viewModel.loadFavoriteCurrencyInfo()
    }

    override fun filterBy(filterType: FilterType) {
        viewModel.filterBy(filterType)
    }

    override fun inject() {
        FeatureUtils.getFeature<FeatureComponent>(this, FeatureApi::class.java)
            .favoriteComponentFactory()
            .create(this)
            .inject(this)
    }

    companion object {
        fun newInstance(): FavoriteFragment {
            return FavoriteFragment()
        }
    }
}
