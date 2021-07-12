package com.frogobox.kickstart.mvvm.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.frogonewsapi.data.model.Article
import com.frogobox.kickstart.R

import com.frogobox.kickstart.core.BaseFragment
import com.frogobox.kickstart.databinding.FragmentMainBinding
import com.frogobox.kickstart.mvvm.detail.DetailActivity
import com.frogobox.recycler.core.IFrogoViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun setupViewModel() {
        mainViewModel.apply {

            getTopHeadline()

            topHeadlineLive.observe(requireActivity(), {
                it.articles?.let { it1 -> setupRvNews(it1) }
            })

            eventShowProgress.observe(requireActivity(), {
                binding?.progressView?.let { it1 -> setupEventProgressView(it1, it) }
            })

        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {}

    private fun setupRvNews(data: List<Article>) {

        val newsAdapter = object : IFrogoViewAdapter<Article> {
            override fun onItemClicked(data: Article) {
                baseStartActivity<DetailActivity, Article>(DetailActivity.EXTRA_DATA, data)
            }

            override fun onItemLongClicked(data: Article) {}

            override fun setupInitComponent(view: View, data: Article) {
                view.findViewById<TextView>(R.id.tv_title).text = data.title
                view.findViewById<TextView>(R.id.tv_description).text = data.publishedAt
                view.findViewById<TextView>(R.id.tv_published).text = data.description
                Glide.with(view.context).load(data.urlToImage).into(view.findViewById(R.id.iv_url))
            }
        }

        binding?.rvNews?.apply {
            injector<Article>()
                .addData(data)
                .addCustomView(R.layout.content_article_vertical)
                .addEmptyView(null)
                .addCallback(newsAdapter)
                .createLayoutLinearVertical(false)
                .build()
        }
    }

}
