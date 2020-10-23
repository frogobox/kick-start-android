package com.frogobox.kickstart.mvvm.ui.activity

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.frogobox.kickstart.R
import com.frogobox.kickstart.base.view.ui.BaseActivity
import com.frogobox.kickstart.mvvm.model.Article
import com.frogobox.kickstart.mvvm.viewmodel.MainViewModel
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapterCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_news_article_vertical.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
    }

    private fun setupViewModel() {
        mainViewModel.apply {

            usingChuck()
            getTopHeadline()
            topHeadlineLive.observe(this@MainActivity, {
                it.articles?.let { it1 -> setupRvNews(it1) }
            })

            eventShowProgress.observe(this@MainActivity, {
                setupEventProgressView(progress_view, it)
            })

        }

    }

    private fun setupRvNews(data: List<Article>) {

        val newsAdapter = object : FrogoViewAdapterCallback<Article> {
            override fun onItemClicked(data: Article) {
                data.title?.let { showToast(it) }
            }

            override fun onItemLongClicked(data: Article) {

            }

            override fun setupInitComponent(view: View, data: Article) {
                view.tv_title.text = data.title
                view.tv_description.text = data.publishedAt
                view.tv_published.text = data.description
                Glide.with(view.context).load(data.urlToImage).into(view.iv_url)
            }
        }

        rv_news.injector<Article>()
            .addData(data)
            .addCustomView(R.layout.list_news_article_vertical)
            .addEmptyView(null)
            .addCallback(newsAdapter)
            .createLayoutLinearVertical(false)
            .build()
    }

}
