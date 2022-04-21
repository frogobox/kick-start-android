package com.frogobox.kickstart.source.callback

import com.frogobox.coreapi.ConsumeApiResponse


/*
 * Created by faisalamir on 21/04/22
 * FrogoKickStartProject
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */

interface ProjectConsumeApiCallback<T> : ConsumeApiResponse<T> {
    fun onEmptyData(check: Boolean)
}