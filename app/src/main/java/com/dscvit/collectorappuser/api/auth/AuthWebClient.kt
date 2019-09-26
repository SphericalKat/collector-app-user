package com.dscvit.collectorappuser.api.auth

import com.dscvit.collectorappuser.api.BaseApiClient
import com.dscvit.collectorappuser.model.OtpVerification
import com.dscvit.collectorappuser.model.UserLogin
import com.dscvit.collectorappuser.model.UserSignup

class AuthWebClient(private val webService: AuthWebService) : BaseApiClient() {

    suspend fun createUser(user: UserSignup) = getResult {
        webService.createUser(user)
    }

    suspend fun confirmOtp(otp: OtpVerification) = getResult {
        webService.confirmOtp(otp)
    }

    suspend fun login(creds: UserLogin) = getResult {
        webService.login(creds)
    }
}