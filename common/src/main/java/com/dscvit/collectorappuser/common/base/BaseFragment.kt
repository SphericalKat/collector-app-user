package com.dscvit.collectorappuser.common.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.dscvit.collectorappuser.common.extensions.toast
import com.dscvit.collectorappuser.model.ApiResponse
import com.dscvit.collectorappuser.model.Result

abstract class BaseFragment : Fragment() {

    protected fun getObserver(
        onSuccess: ((result: Result<ApiResponse?>) -> Unit)?
    ): Observer<Result<ApiResponse?>> {
        return Observer { result ->
            when (result.status) {
                Result.Status.LOADING -> {
                    showLoading(true)
                    showLayout(false)
                }
                Result.Status.ERROR -> {
                    showLoading(false)
                    showLayout(true)
                    toast(result.message!!)
                }
                Result.Status.SUCCESS -> {
                    onSuccess?.invoke(result)
                }
            }
        }
    }

    protected abstract fun showLayout(shouldShowLayout: Boolean)

    protected abstract fun showLoading(shouldShowLoading: Boolean)

}