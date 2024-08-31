package com.hav.antidebugapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel(){
    private var _root = MutableLiveData<Boolean>()
    val root: LiveData<Boolean> = _root

    private var _debugger = MutableLiveData<Boolean>()
    val debugger: LiveData<Boolean> = _debugger

    private var _emulator = MutableLiveData<Boolean>()
    val emulator: LiveData<Boolean> = _emulator

    private var _tamper = MutableLiveData<Boolean>()
    val tamper: LiveData<Boolean> = _tamper

    private var _hook = MutableLiveData<Boolean>()
    val hook: LiveData<Boolean> = _hook

    private var _deviceBinding = MutableLiveData<Boolean>()
    val deviceBinding: LiveData<Boolean> = _deviceBinding

    private var _onfuscationIsues = MutableLiveData<Boolean>()
    val onfuscationIsues: LiveData<Boolean> = _onfuscationIsues

    private var _deverloper = MutableLiveData<Boolean>()
    val deverloper: LiveData<Boolean> = _deverloper

    private var _hardware = MutableLiveData<Boolean>()
    val hardware: LiveData<Boolean> = _hardware

    private var _unlock = MutableLiveData<Boolean>()
    val unlock: LiveData<Boolean> = _unlock

    private var _vpn = MutableLiveData<Boolean>()
    val vpn: LiveData<Boolean> = _vpn


    fun setHook(value: Boolean){
        _hook.value = value
    }

    fun setDeviceBinding(value: Boolean){
        _deviceBinding.value = value
    }

    fun setOnfuscationIsues(value: Boolean){
        _onfuscationIsues.value = value
    }

    fun setDeverloper(value: Boolean){
        _deverloper.value = value
    }

    fun setHardware(value: Boolean){
        _hardware.value = value
    }

    fun setUnlock(value: Boolean){
        _unlock.value = value
    }

    fun setVpn(value: Boolean){
        _vpn.value = value
    }

    fun setRoot(value: Boolean){
        _root.value = value
    }

    fun setDebugger(value: Boolean){
        _debugger.value = value
    }

    fun setEmulator(value: Boolean){
        _emulator.value = value
    }

    fun setTamper(value: Boolean){
        _tamper.value = value
    }



    fun clear(){
        _root.value = false
        _debugger.value = false
        _emulator.value = false
        _tamper.value = false
        _hook.value = false
        _deviceBinding.value = false
        _onfuscationIsues.value = false
        _deverloper.value = false
        _hardware.value = false
        _unlock.value = false
        _vpn.value = false
    }
}