package com.dscvit.collectorappuser.feature_auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.dscvit.collectorappuser.common.extensions.getInput
import com.dscvit.collectorappuser.common.extensions.isValidPhone
import com.dscvit.collectorappuser.common.extensions.show
import com.dscvit.collectorappuser.common.extensions.toast
import com.dscvit.collectorappuser.feature_auth.R
import com.dscvit.collectorappuser.model.Result
import kotlinx.android.synthetic.main.login_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login_button_request_otp.setOnClickListener {
            if (login_input_phno.isValidPhone()) {
                viewModel.login(login_input_phno.getInput())
                    .observe(this, Observer {
                        when (it.status) {
                            Result.Status.LOADING -> {
                                showLoading(true)
                                showLayout(false)
                            }
                            Result.Status.ERROR -> {
                                showLoading(false)
                                showLayout(true)
                                toast(it.message!!)
                            }
                            Result.Status.SUCCESS -> {
                                findNavController()
                                    .navigate(R.id.action_loginFragment_to_otpFragment)
                            }
                        }
                    })
            }
        }
    }

    private fun showLayout(shouldShowLayout: Boolean) {
        login_input_phno.show(shouldShowLayout)
    }

    private fun showLoading(shouldShowLoading: Boolean) {

    }

}
