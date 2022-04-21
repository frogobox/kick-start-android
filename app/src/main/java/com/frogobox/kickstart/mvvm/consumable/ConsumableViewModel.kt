package com.frogobox.kickstart.mvvm.consumable

import android.app.Application
import com.frogobox.coreapi.news.NewsConstant.CATEGORY_BUSINESS
import com.frogobox.coreapi.news.NewsConstant.CATEGORY_ENTERTAIMENT
import com.frogobox.coreapi.news.NewsConstant.CATEGORY_GENERAL
import com.frogobox.coreapi.news.NewsConstant.CATEGORY_HEALTH
import com.frogobox.coreapi.news.NewsConstant.CATEGORY_SCIENCE
import com.frogobox.coreapi.news.NewsConstant.CATEGORY_SPORTS
import com.frogobox.coreapi.news.NewsConstant.CATEGORY_TECHNOLOGY
import com.frogobox.coreapi.news.NewsConstant.COUNTRY_ID
import com.frogobox.coreapi.news.model.Article
import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.kickstart.core.BaseViewModel
import com.frogobox.kickstart.source.ProjectDataRepository
import com.frogobox.kickstart.source.callback.ProjectConsumeApiCallback
import com.frogobox.sdk.util.FrogoMutableLiveData

class ConsumableViewModel(
    private val context: Application,
    private val repository: ProjectDataRepository
) : BaseViewModel(context, repository) {

    var listArticleRandom = FrogoMutableLiveData<List<Article>>()
    var listArticle = FrogoMutableLiveData<List<Article>>()
    var listCategory = FrogoMutableLiveData<MutableList<String>>()

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

    fun getTopHeadline(category: String?) {

        repository.consumeNewsApi.getTopHeadline(
            null,
            null,
            category,
            COUNTRY_ID,
            null,
            null,
            object : ProjectConsumeApiCallback<ArticleResponse> {
                override fun onSuccess(data: ArticleResponse) {
                    data.articles?.let { listArticle.postValue(it) }
                }

                override fun onFailed(statusCode: Int, errorMessage: String) {
                    eventFailed.postValue(errorMessage)
                }

                override fun onFinish() {

                }

                override fun onEmptyData(check: Boolean) {
                    eventEmpty.postValue(check)
                }

                override fun onShowProgress() {
                    eventShowProgress.postValue(true)
                }

                override fun onHideProgress() {
                    eventShowProgress.postValue(false)
                }
            }
        )
    }

    fun getRandomTopHeadline() {
        repository.consumeNewsApi.getTopHeadline(
            null,
            null,
            null,
            COUNTRY_ID,
            null,
            null,
            object : ProjectConsumeApiCallback<ArticleResponse> {
                override fun onSuccess(data: ArticleResponse) {
                    data.articles?.let { listArticleRandom.postValue(it) }
                }

                override fun onFailed(statusCode: Int, errorMessage: String) {
                    eventFailed.postValue(errorMessage)
                }

                override fun onFinish() {

                }

                override fun onEmptyData(check: Boolean) {
                    eventEmpty.postValue(check)
                }

                override fun onShowProgress() {
                    eventShowProgress.postValue(true)
                }

                override fun onHideProgress() {
                    eventShowProgress.postValue(false)
                }
            }
        )
    }

}