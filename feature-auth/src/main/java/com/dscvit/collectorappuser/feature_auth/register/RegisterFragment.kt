package com.dscvit.collectorappuser.feature_auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dscvit.collectorappuser.common.base.BaseFragment
import com.dscvit.collectorappuser.common.extensions.getInput
import com.dscvit.collectorappuser.common.extensions.isValidInput
import com.dscvit.collectorappuser.common.extensions.isValidPhone
import com.dscvit.collectorappuser.feature_auth.R
import kotlinx.android.synthetic.main.register_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment() {

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
                    .observe(this, getObserver {
                        findNavController()
                            .navigate(R.id.action_registerFragment_to_otpFragment)
                    })
            }
        }
    }

    override fun showLayout(shouldShowLayout: Boolean) {

    }

    override fun showLoading(shouldShowLoading: Boolean) {

    }
}
