package com.dscvit.collectorappuser.feature_auth.register

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.dscvit.collectorappuser.common.extensions.*

import com.dscvit.collectorappuser.feature_auth.R
import com.dscvit.collectorappuser.model.Result
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.register_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private val viewModel: RegisterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        register_button_create.setOnClickListener {
            if (register_input_aadhaar.isValidInput() &&
                register_input_name.isValidInput() &&
                register_input_dob.isValidInput() &&
                register_input_phno.isValidPhone()
            ) {
                viewModel.register(
                    register_input_aadhaar.getInput(),
                    register_input_name.getInput(),
                    register_input_dob.getInput(),
                    register_input_phno.getInput()
                )
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

                            }
                        }
                    })
            }
        }
    }

    private fun showLayout(shouldShowLayout: Boolean) {

    }

    private fun showLoading(shouldShowLoading: Boolean) {

    }
}
