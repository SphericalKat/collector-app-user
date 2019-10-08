package com.dscvit.collectorappuser.repository

import androidx.lifecycle.liveData
import com.dscvit.collectorappuser.model.ApiResponse
import com.dscvit.collectorappuser.model.Result

open class BaseRepo {

    protected fun makeRequest(request: suspend () -> Result<ApiResponse>) = liveData {
        emit(Result.loading())

        val response = request.invoke()

        when (response.status) {
            Result.Status.SUCCESS -> {
                emit(Result.success(response.data))
            }
            Result.Status.ERROR -> {
                emit(Result.error(response.message!!))
            }
            else -> {
            }
        }
    }
}