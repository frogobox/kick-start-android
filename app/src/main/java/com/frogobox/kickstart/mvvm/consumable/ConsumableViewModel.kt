package com.frogobox.kickstart.mvvm.consumable

import androidx.lifecycle.MutableLiveData
import com.frogobox.coreutil.news.NewsConstant.CATEGORY_ENTERTAIMENT
import com.frogobox.coreutil.news.NewsConstant.CATEGORY_GENERAL
import com.frogobox.coreutil.news.NewsConstant.CATEGORY_HEALTH
import com.frogobox.coreutil.news.NewsConstant.CATEGORY_SCIENCE
import com.frogobox.coreutil.news.NewsConstant.CATEGORY_SPORTS
import com.frogobox.coreutil.news.NewsConstant.CATEGORY_TECHNOLOGY
import com.frogobox.coreutil.news.NewsConstant.COUNTRY_ID
import com.frogobox.coreutil.news.response.ArticleResponse
import com.frogobox.coreutil.news.NewsConstant.CATEGORY_BUSINESS
import com.frogobox.coreutil.news.model.Article
import com.frogobox.kickstart.core.BaseViewModel
import com.frogobox.kickstart.source.ProjectDataRepository
import com.frogobox.kickstart.source.callback.ProjectConsumeApiCallback

class ConsumableViewModel(
    private val repository: ProjectDataRepository
) : BaseViewModel(repository) {

    var listArticleRandom = MutableLiveData<List<Article>>()
    var listArticle = MutableLiveData<List<Article>>()
    var listCategory = MutableLiveData<MutableList<String>>()

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
                    _eventFailed.postValue(errorMessage)
                }

                override fun onFinish() {

                }

                override fun onEmptyData(check: Boolean) {
                    _eventEmptyState.postValue(check)
                }

                override fun onShowProgress() {
                    _eventShowProgressState.postValue(true)
                }

                override fun onHideProgress() {
                    _eventShowProgressState.postValue(false)
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
                    _eventFailed.postValue(errorMessage)
                }

                override fun onFinish() {

                }

                override fun onEmptyData(check: Boolean) {
                    _eventEmptyState.postValue(check)
                }

                override fun onShowProgress() {
                    _eventShowProgressState.postValue(true)
                }

                override fun onHideProgress() {
                    _eventShowProgressState.postValue(false)
                }
            }
        )
    }

}