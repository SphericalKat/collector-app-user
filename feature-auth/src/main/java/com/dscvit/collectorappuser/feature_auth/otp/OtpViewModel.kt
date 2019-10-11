package com.dscvit.collectorappuser.feature_auth.otp

import androidx.lifecycle.ViewModel
import com.dscvit.collectorappuser.model.OtpVerification
import com.dscvit.collectorappuser.repository.AuthRepo

class OtpViewModel(private val repo: AuthRepo) : ViewModel() {

    fun verifyOtp(otp: String)
        = repo.verifyOtp(OtpVerification("phone number", otp))

}
