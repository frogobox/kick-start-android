package com.frogobox.kickstart.mvvm.ui.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.frogobox.kickstart.R
import com.frogobox.kickstart.base.view.ui.BaseActivity
import com.frogobox.kickstart.mvvm.model.Article
import com.frogobox.kickstart.mvvm.viewmodel.MainViewModel
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapterCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_news_article_vertical.view.*

class MainActivity : BaseActivity() {

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()

    }

    private fun obtainMainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)

    private fun setupViewModel() {
        mViewModel = obtainMainViewModel().apply {

            topHeadlineLive.observe(this@MainActivity, Observer {
                it.articles?.let { it1 -> setupRvNews(it1) }
            })

            eventShowProgress.observe(this@MainActivity, Observer {
                setupEventProgressView(progress_view, it)
            })

        }

        mViewModel.getTopHeadline()
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
