package com.frogobox.kickstart.mvvm.consumable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.frogobox.frogonewsapi.data.model.Article
import com.frogobox.kickstart.core.BaseFragment
import com.frogobox.kickstart.databinding.ContentArticleHorizontalBinding
import com.frogobox.kickstart.databinding.ContentArticleVerticalBinding
import com.frogobox.kickstart.databinding.ContentCategoryBinding
import com.frogobox.kickstart.databinding.FragmentConsumableBinding
import com.frogobox.kickstart.mvvm.detail.DetailActivity
import com.frogobox.kickstart.util.Constant
import com.frogobox.recycler.core.IFrogoBindingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConsumableFragment : BaseFragment<FragmentConsumableBinding>() {

    private val consumableViewModel: ConsumableViewModel by viewModel()

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup
    ): FragmentConsumableBinding {
        return FragmentConsumableBinding.inflate(inflater, container, false)
    }

    override fun setupViewModel() {
        consumableViewModel.apply {

            getCategory()
            getRandomTopHeadline()
            getTopHeadline(Constant.NewsConstant.CATEGORY_BUSINESS)

            listCategory.observe(requireActivity(), {
                setupCategory(it)
            })

            listArticle.observe(requireActivity(), {
                setupRvNews(it)
            })

            listArticleRandom.observe(requireActivity(), {
                setupRvHeader(it)
            })

            eventFailed.observe(requireActivity(), {
                showToast(it)
            })

            eventShowProgress.observe(requireActivity(), {
                setupEventProgressView(binding?.progressView!!, it)
            })

        }

    }

    override fun setupUI(savedInstanceState: Bundle?) {}

    private fun setupCategory(data: List<String>) {

        val adapterCallback = object : IFrogoBindingAdapter<String, ContentCategoryBinding> {
            override fun onItemClicked(data: String) {
                consumableViewModel.getTopHeadline(data)
                binding?.tvTopHeadline?.text = "category $data"
            }

            override fun onItemLongClicked(data: String) {}

            override fun setViewBinding(parent: ViewGroup): ContentCategoryBinding {
                return ContentCategoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }

            override fun setupInitComponent(view: ContentCategoryBinding, data: String) {
                view.tvCategory.text = data
            }
        }

        binding?.apply {
            rvCategory.injectorBinding<String, ContentCategoryBinding>()
                .addCallback(adapterCallback)
                .addData(data)
                .createLayoutLinearHorizontal(false)
                .build()
        }

    }


    private fun setupRvHeader(data: List<Article>) {

        val adapterCallback =
            object : IFrogoBindingAdapter<Article, ContentArticleHorizontalBinding> {
                override fun onItemClicked(data: Article) {
                    baseStartActivity<DetailActivity, Article>(DetailActivity.EXTRA_DATA, data)
                    setupShowAdsInterstitial()
                }

                override fun onItemLongClicked(data: Article) {
                    data.description?.let { showToast(it) }
                }

                override fun setViewBinding(parent: ViewGroup): ContentArticleHorizontalBinding {
                    return ContentArticleHorizontalBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                }

                override fun setupInitComponent(
                    view: ContentArticleHorizontalBinding,
                    data: Article
                ) {
                    view.apply {
                        tvTitle.text = data.title
                        tvPublished.text = data.publishedAt
                        tvDescription.text = data.description
                        Glide.with(requireContext()).load(data.urlToImage).into(ivUrl)
                    }
                }
            }

        binding?.apply {

            rvNewsGeneral.injectorBinding<Article, ContentArticleHorizontalBinding>()
                .addCallback(adapterCallback)
                .addData(data)
                .createLayoutLinearHorizontal(false)
                .build()
        }
    }

    private fun setupRvNews(data: List<Article>) {

        val adapterCallback =
            object : IFrogoBindingAdapter<Article, ContentArticleVerticalBinding> {
                override fun onItemClicked(data: Article) {
                    baseStartActivity<DetailActivity, Article>(DetailActivity.EXTRA_DATA, data)
                    setupShowAdsInterstitial()
                }

                override fun onItemLongClicked(data: Article) {
                    data.description?.let { showToast(it) }
                }

                override fun setViewBinding(parent: ViewGroup): ContentArticleVerticalBinding {
                    return ContentArticleVerticalBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                }

                override fun setupInitComponent(
                    view: ContentArticleVerticalBinding,
                    data: Article
                ) {
                    view.apply {
                        tvTitle.text = data.title
                        tvPublished.text = data.publishedAt
                        tvDescription.text = data.description
                        Glide.with(requireContext()).load(data.urlToImage).into(ivUrl)
                    }
                }
            }

        binding?.apply {

            rvNewsCategory.injectorBinding<Article, ContentArticleVerticalBinding>()
                .addCallback(adapterCallback)
                .addData(data)
                .createLayoutLinearVertical(false)
                .build()
        }
    }

}