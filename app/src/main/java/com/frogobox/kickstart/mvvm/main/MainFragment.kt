package com.frogobox.kickstart.mvvm.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.coreutil.news.model.Article
import com.frogobox.kickstart.R
import com.frogobox.kickstart.core.BaseFragment
import com.frogobox.kickstart.databinding.FragmentMainBinding
import com.frogobox.kickstart.mvvm.detail.DetailActivity
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.frogobox.sdk.ext.progressViewHandle
import com.frogobox.sdk.ext.startActivityExt
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun setupViewModel() {
        mainViewModel.apply {

            getTopHeadline()

            topHeadlineLive.observe(requireActivity()) {
                it.articles?.let { it1 -> setupRvNews(it1) }
            }

            eventShowProgressState.observe(requireActivity()) {
                binding.progressView.progressViewHandle(it)
            }

        }
    }


    override fun onViewCreatedExt(view: View, savedInstanceState: Bundle?) {
        super.onViewCreatedExt(view, savedInstanceState)
    }

    private fun setupRvNews(data: List<Article>) {

        val newsAdapter = object : IFrogoViewAdapter<Article> {
            override fun onItemClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                requireContext().startActivityExt<DetailActivity, Article>(DetailActivity.EXTRA_DATA, data)
            }

            override fun onItemLongClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
            }

            override fun setupInitComponent(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                view.findViewById<TextView>(R.id.tv_title).text = data.title
                view.findViewById<TextView>(R.id.tv_description).text = data.publishedAt
                view.findViewById<TextView>(R.id.tv_published).text = data.description
                Glide.with(view.context)
                    .load(data.urlToImage)
                    .placeholder(R.drawable.ic_frogobox)
                    .into(view.findViewById(R.id.iv_url))
            }
        }

        binding.rvNews.apply {
            injector<Article>()
                .addData(data)
                .addCustomView(R.layout.content_article_vertical)
                .addEmptyView(null)
                .addCallback(newsAdapter)
                .createLayoutLinearVertical(false)
                .build()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainViewModel.onClearDisposable()
    }

}
