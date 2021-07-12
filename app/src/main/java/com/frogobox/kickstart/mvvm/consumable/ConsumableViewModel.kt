package com.frogobox.kickstart.mvvm.consumable

import android.app.Application
import com.frogobox.frogonewsapi.data.model.Article
import com.frogobox.frogonewsapi.data.response.ArticleResponse
import com.frogobox.frogonewsapi.util.NewsConstant.COUNTRY_ID
import com.frogobox.kickstart.core.BaseViewModel
import com.frogobox.kickstart.source.FrogoDataRepository
import com.frogobox.kickstart.source.FrogoDataSource
import com.frogobox.kickstart.util.Constant
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

        repository.consumeTopHeadline(
            Constant.ApiUrl.NEWS_API_KEY,
            null,
            null,
            category,
            COUNTRY_ID,
            null,
            null,
            object : FrogoDataSource.GetRemoteCallback<ArticleResponse> {
                override fun onSuccess(data: ArticleResponse) {
                    data.articles?.let { listArticle.postValue(it) }
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    eventFailed.postValue(errorMessage)
                }

                override fun onEmptyData(check: Boolean) {
                    eventEmptyData.postValue(check)
                }

                override fun onShowProgressDialog() {
                    eventShowProgress.postValue(true)
                }

                override fun onHideProgressDialog() {
                    eventShowProgress.postValue(false)
                }
            }
        )
    }

    fun getRandomTopHeadline() {
        repository.consumeTopHeadline(
            Constant.ApiUrl.NEWS_API_KEY,
            null,
            null,
            null,
            COUNTRY_ID,
            null,
            null,
            object : FrogoDataSource.GetRemoteCallback<ArticleResponse> {
                override fun onSuccess(data: ArticleResponse) {
                    data.articles?.let { listArticleRandom.postValue(it) }
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    eventFailed.postValue(errorMessage)
                }

                override fun onEmptyData(check: Boolean) {
                    eventEmptyData.postValue(check)
                }

                override fun onShowProgressDialog() {
                    eventShowProgress.postValue(true)
                }

                override fun onHideProgressDialog() {
                    eventShowProgress.postValue(false)
                }
            }
        )
    }

}