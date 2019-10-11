package com.dscvit.collectorappuser.feature_auth.login

import androidx.lifecycle.ViewModel
import com.dscvit.collectorappuser.model.UserLogin
import com.dscvit.collectorappuser.repository.AuthRepo

class LoginViewModel(private val repo: AuthRepo) : ViewModel() {

    fun login(phNo: String)
        = repo.login(UserLogin(phNo))

}
