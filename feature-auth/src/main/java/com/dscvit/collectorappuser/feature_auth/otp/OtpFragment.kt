package com.dscvit.collectorappuser.feature_auth.otp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.dscvit.collectorappuser.common.base.BaseFragment
import com.dscvit.collectorappuser.common.extensions.hideKeyboard
import com.dscvit.collectorappuser.common.extensions.toast

import com.dscvit.collectorappuser.feature_auth.R
import com.dscvit.collectorappuser.model.ApiResponse
import com.dscvit.collectorappuser.model.Result
import kotlinx.android.synthetic.main.otp_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class OtpFragment : BaseFragment() {

    private val viewModel: OtpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.otp_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        otp_view.setOtpCompletionListener { otp ->
            hideKeyboard()
            viewModel.verifyOtp(otp)
                .observe(this, getObserver {
                    startActivity(
                        Intent(
                            requireActivity(),
                            /*
                            We have to use reflections to navigate to MainActivity
                            because MainActivity resides in :app module
                            which cannot be accessed directly.
                            * */
                            Class.forName("com.dscvit.collectorappuser.MainActivity")
                        )
                    )
                    requireActivity().finish()
                })
        }
    }

    override fun showLayout(shouldShowLayout: Boolean) {

    }

    override fun showLoading(shouldShowLoading: Boolean) {

    }
}
