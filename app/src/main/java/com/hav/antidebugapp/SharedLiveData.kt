package com.hav.antidebugapp

import androidx.lifecycle.MutableLiveData

object SharedLiveData {
    val root = MutableLiveData<Boolean>()
    val debugger = MutableLiveData<Boolean>()
    val emulator = MutableLiveData<Boolean>()
    val tamper = MutableLiveData<Boolean>()
    val hook = MutableLiveData<Boolean>()
    val deviceBinding = MutableLiveData<Boolean>()
    val onfuscationIsues = MutableLiveData<Boolean>()
    val deverloper = MutableLiveData<Boolean>()
    val hardware = MutableLiveData<Boolean>()
    val unlock = MutableLiveData<Boolean>()
    val vpn = MutableLiveData<Boolean>()
}