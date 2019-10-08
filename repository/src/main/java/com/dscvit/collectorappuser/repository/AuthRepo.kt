package com.dscvit.collectorappuser.repository

import android.content.SharedPreferences
import com.dscvit.collectorappuser.common.Constants
import com.dscvit.collectorappuser.common.PreferenceHelper.get
import com.dscvit.collectorappuser.common.PreferenceHelper.set
import com.dscvit.collectorappuser.model.OtpVerification
import com.dscvit.collectorappuser.model.UserLogin
import com.dscvit.collectorappuser.model.UserSignup
import com.dscvit.collectorappuser.remote.auth.AuthWebClient

class AuthRepo(
    private val webClient: AuthWebClient,
    private val prefs: SharedPreferences
) : BaseRepo() {

    fun userCreation(user: UserSignup) = makeRequest {
        webClient.createUser(user)
    }

    fun otpVerification(otp: OtpVerification) = makeRequest {
        webClient.confirmOtp(otp)
    }

    fun login(user: UserLogin) = makeRequest {
        webClient.login(user)
    }

    fun storePhoneNumber(phNo: String) {
        prefs[Constants.PREF_PHONE_NUMBER] = phNo
    }

    fun getPhoneNumber() = prefs[Constants.PREF_PHONE_NUMBER, ""]

    fun saveToken(token: String?) {
        prefs[Constants.PREF_ACCESS_TOKEN] = token
        changeFirstTime()
    }

    private fun changeFirstTime() {
        prefs[Constants.PREF_IS_FIRST_TIME] = false
    }
}