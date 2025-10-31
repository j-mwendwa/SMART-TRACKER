package com.example.smarttracker.auth

import android.os.Message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class AuthState{
    object idle: AuthState()
    object loading: AuthState()
    data class success(val message: String): AuthState()
    data class error(val message: String): AuthState()

}
class AuthViewModel: ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val _authstate = MutableStateFlow<AuthState>(AuthState.idle)
    val authstate : StateFlow<AuthState> = _authstate


    fun checkLoginStatus() {
        viewModelScope.launch {
            _authstate.value = AuthState.loading
            if (auth.currentUser != null) {
                // A message for logged in users
                _authstate.value = AuthState.success("User is logged in")
            } else {
                // A message for users not logged in
                _authstate.value = AuthState.error("User not logged in")
            }
        }
    }
    fun signUp(email: String, password: String){
        viewModelScope.launch {
            _authstate.value = AuthState.loading

            try {
                auth.createUserWithEmailAndPassword(email, password).await()
                _authstate.value = AuthState.success("SIGNUP SUCCESSFUL")
            }catch (e: Exception){
                _authstate.value = AuthState.error("SIGNUP FAILED")

            }

        }
    }
    fun resetState() {
        _authstate.value = AuthState.idle
    }

    fun login(email: String, password: String){
        viewModelScope.launch {
            _authstate.value = AuthState.loading

            try {
                auth.signInUserWithEmailAndPassword(email, password).await()
                _authstate.value = AuthState.success("LOGIN SUCCESSFUL")
            }catch (e: Exception){
                _authstate.value = AuthState.error("LOGIN FAILED")
            }
        }
    }

    fun idUserLoggedIn(): Boolean = auth.currentUser != null


}