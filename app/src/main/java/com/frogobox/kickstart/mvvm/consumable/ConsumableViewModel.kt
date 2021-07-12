package com.frogobox.kickstart.mvvm.consumable

import android.app.Application
import android.util.Log
import com.frogobox.frogonewsapi.ConsumeNewsApi
import com.frogobox.frogonewsapi.callback.NewsResultCallback
import com.frogobox.frogonewsapi.data.model.Article
import com.frogobox.frogonewsapi.data.response.ArticleResponse
import com.frogobox.frogonewsapi.util.NewsConstant.COUNTRY_ID
import com.frogobox.frogonewsapi.util.NewsUrl
import com.frogobox.kickstart.core.BaseViewModel
import com.frogobox.kickstart.source.FrogoDataRepository
import com.frogobox.kickstart.util.Constant.NewsConstant.CATEGORY_BUSINESS
import com.frogobox.kickstart.util.Constant.NewsConstant.CATEGORY_ENTERTAIMENT
import com.frogobox.kickstart.util.Constant.NewsConstant.CATEGORY_GENERAL
import com.frogobox.kickstart.util.Constant.NewsConstant.CATEGORY_HEALTH
import com.frogobox.kickstart.util.Constant.NewsConstant.CATEGORY_SCIENCE
import com.frogobox.kickstart.util.Constant.NewsConstant.CATEGORY_SPORTS
import com.frogobox.kickstart.util.Constant.NewsConstant.CATEGORY_TECHNOLOGY
import com.frogobox.kickstart.util.SingleLiveEvent

class ConsumableViewModel(
    private val context: Application,
    private val repository: FrogoDataRepository
) : BaseViewModel(context) {

    var listArticleRandom = SingleLiveEvent<List<Article>>()
    var listArticle = SingleLiveEvent<List<Article>>()
    var listCategory = SingleLiveEvent<MutableList<String>>()

    fun getCategory() {
        val categories = mutableListOf<String>()
        categories.add(CATEGORY_BUSINESS)
        categories.add(CATEGORY_HEALTH)
        categories.add(CATEGORY_ENTERTAIMENT)
        categories.add(CATEGORY_GENERAL)
        categories.add(CATEGORY_SCIENCE)
        categories.add(CATEGORY_SPORTS)
        categories.add(CATEGORY_TECHNOLOGY)
        listCategory.postValue(categories)
    }

    fun getTopHeadline(category: String) {
        val consumeNewsApi = ConsumeNewsApi(NewsUrl.NEWS_API_KEY)
        consumeNewsApi.usingChuckInterceptor(context)
        consumeNewsApi.getTopHeadline( // Adding Base Parameter on main function
            null,
            null,
            category,
            COUNTRY_ID,
            null,
            null,
            object : NewsResultCallback<ArticleResponse> {
                override fun getResultData(data: ArticleResponse) {
                    // Your Ui or data
                    data.articles?.let { listArticle.postValue(it) }
                }

                override fun failedResult(statusCode: Int, errorMessage: String?) {
                    // Your failed to do
                    eventFailed.postValue(errorMessage)
                }

                override fun onShowProgress() {
                    // Your Progress Show
                    Log.d("RxJavaShow", "Show Progress")
                    eventShowProgress.postValue(true)
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                    Log.d("RxJavaHide", "Hide Progress")
                    eventShowProgress.postValue(false)
                }

            })
    }

    fun getRandomTopHeadline() {
        val consumeNewsApi = ConsumeNewsApi(NewsUrl.NEWS_API_KEY)
        consumeNewsApi.usingChuckInterceptor(context)
        consumeNewsApi.getTopHeadline( // Adding Base Parameter on main function
            null,
            null,
            null,
            COUNTRY_ID,
            null,
            null,
            object : NewsResultCallback<ArticleResponse> {
                override fun getResultData(data: ArticleResponse) {
                    // Your Ui or data
                    data.articles?.let { listArticleRandom.postValue(it) }
                }

                override fun failedResult(statusCode: Int, errorMessage: String?) {
                    // Your failed to do
                    eventFailed.postValue(errorMessage)
                }

                override fun onShowProgress() {
                    // Your Progress Show
                    Log.d("RxJavaShow", "Show Progress")
                    eventShowProgress.postValue(true)
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                    Log.d("RxJavaHide", "Hide Progress")
                    eventShowProgress.postValue(false)
                }

            })
    }

}