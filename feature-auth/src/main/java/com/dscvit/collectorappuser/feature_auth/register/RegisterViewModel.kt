package com.dscvit.collectorappuser.feature_auth.register

import androidx.lifecycle.ViewModel
import com.dscvit.collectorappuser.model.UserSignup
import com.dscvit.collectorappuser.repository.AuthRepo

class RegisterViewModel(private val repo: AuthRepo) : ViewModel() {

    fun register(aadhaarId: String,name: String, dob: String, phNo: String)
        = repo.userCreation(UserSignup(aadhaarId, name, dob, phNo))
}
