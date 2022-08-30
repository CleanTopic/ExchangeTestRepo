package ru.cleantopic.feature.popular.presentation

import by.kirich1409.viewbindingdelegate.viewBinding
import ru.cleantopic.common.base.BaseFragment
import ru.cleantopic.common.di.FeatureUtils
import ru.cleantopic.feature.R
import ru.cleantopic.feature.databinding.FragmentPopularBinding
import ru.cleantopic.feature.di.FeatureApi
import ru.cleantopic.feature.di.FeatureComponent
import ru.cleantopic.feature.domain.model.FilterType
import ru.cleantopic.feature.interactors.IUpdatable
import ru.cleantopic.feature.shared_adapter.CurrencyAdapter
import ru.cleantopic.feature.shared_view_model.SharedCurrencyViewModel

class PopularFragment :
    BaseFragment<SharedCurrencyViewModel>(R.layout.fragment_popular), IUpdatable {

    override val binding: FragmentPopularBinding by viewBinding(FragmentPopularBinding::bind)

    private val currencyAdapter by lazy {
        CurrencyAdapter {
            viewModel.changeFavoriteState(it)
        }
    }

    override fun setupViews() {
        super.setupViews()
        binding.rvPopular.adapter = currencyAdapter
    }

    override fun setupViewModelSubscriber() {
        super.setupViewModelSubscriber()
        viewModel.currencyList.observe {
            currencyAdapter.bindData(it)
        }
    }

    override fun update(currencyName: String) {
        viewModel.updateCurrencyInfo(currencyName)
    }

    override fun load(currencyName: String) {
    }

    override fun filterBy(filterType: FilterType) {
        viewModel.filterBy(filterType)
    }

    override fun inject() {
        FeatureUtils.getFeature<FeatureComponent>(this, FeatureApi::class.java)
            .popularComponentFactory()
            .create(this)
            .inject(this)
    }

    companion object {
        fun newInstance(): PopularFragment {
            return PopularFragment()
        }
    }
}
