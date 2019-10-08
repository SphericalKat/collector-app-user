package com.dscvit.collectorappuser.remote.auth

import com.dscvit.collectorappuser.model.ApiResponse
import com.dscvit.collectorappuser.model.OtpVerification
import com.dscvit.collectorappuser.model.UserLogin
import com.dscvit.collectorappuser.model.UserSignup
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthWebService {

    @POST("user/")
    suspend fun createUser(@Body user: UserSignup): Response<ApiResponse>

    @POST("confirm/")
    suspend fun confirmOtp(@Body otp: OtpVerification): Response<ApiResponse>

    @POST("login/")
    suspend fun login(@Body creds: UserLogin): Response<ApiResponse>
}