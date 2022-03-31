package com.frogobox.kickstart.source.remote.network

import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.coreapi.news.response.SourceResponse
import com.frogobox.kickstart.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * Created by faisalamir on 06/07/21
 * KickStartProject
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface ProjectApiService {

    // Get Top Headline
    @GET(Constant.ApiUrl.NEWS_URL_TOP_HEADLINE)
    suspend fun getTopHeadline(
        @Query(Constant.NewsConstant.QUERY_API_KEY) apiKey: String,
        @Query(Constant.NewsConstant.QUERY_Q) q: String?,
        @Query(Constant.NewsConstant.QUERY_SOURCES) sources: String?,
        @Query(Constant.NewsConstant.QUERY_CATEGORY) category: String?,
        @Query(Constant.NewsConstant.QUERY_COUNTRY) country: String?,
        @Query(Constant.NewsConstant.QUERY_PAGE_SIZE) pageSize: Int?,
        @Query(Constant.NewsConstant.QUERY_PAGE) page: Int?
    ): Response<ArticleResponse>

    // Get Everythings
    @GET(Constant.ApiUrl.NEWS_URL_EVERYTHING)
    fun getEverythings(
        @Query(Constant.NewsConstant.QUERY_API_KEY) apiKey: String,
        @Query(Constant.NewsConstant.QUERY_Q) q: String?,
        @Query(Constant.NewsConstant.QUERY_FROM) from: String?,
        @Query(Constant.NewsConstant.QUERY_TO) to: String?,
        @Query(Constant.NewsConstant.QUERY_Q_IN_TITLE) qInTitle: String?,
        @Query(Constant.NewsConstant.QUERY_SOURCES) sources: String?,
        @Query(Constant.NewsConstant.QUERY_DOMAINS) domains: String?,
        @Query(Constant.NewsConstant.QUERY_EXCLUDE_DOMAINS) excludeDomains: String?,
        @Query(Constant.NewsConstant.QUERY_LANGUAGE) language: String?,
        @Query(Constant.NewsConstant.QUERY_SORT_BY) sortBy: String?,
        @Query(Constant.NewsConstant.QUERY_PAGE_SIZE) pageSize: Int?,
        @Query(Constant.NewsConstant.QUERY_PAGE) page: Int?
    ): Response<ArticleResponse>

    // Get Sources
    @GET(Constant.ApiUrl.NEWS_URL_SOURCES)
    fun getSources(
        @Query(Constant.NewsConstant.QUERY_API_KEY) apiKey: String,
        @Query(Constant.NewsConstant.QUERY_LANGUAGE) language: String,
        @Query(Constant.NewsConstant.QUERY_COUNTRY) country: String,
        @Query(Constant.NewsConstant.QUERY_CATEGORY) category: String
    ): Response<SourceResponse>

}