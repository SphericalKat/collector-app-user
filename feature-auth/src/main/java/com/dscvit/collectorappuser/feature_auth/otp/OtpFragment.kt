package com.dscvit.collectorappuser.feature_auth.otp

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.dscvit.collectorappuser.common.extensions.hideKeyboard
import com.dscvit.collectorappuser.common.extensions.toast

import com.dscvit.collectorappuser.feature_auth.R
import com.dscvit.collectorappuser.model.Result
import kotlinx.android.synthetic.main.otp_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class OtpFragment : Fragment() {

    companion object {
        fun newInstance() = OtpFragment()
    }

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
                .observe(this, Observer { result ->
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
                        }
                    }

                })
        }
    }

    private fun showLayout(shouldShowLayout: Boolean) {

    }

    private fun showLoading(shouldShowLoading: Boolean) {

    }
}
