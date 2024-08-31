package com.hav.antidebugapp

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.aheaditec.talsec_security.security.api.Talsec
import com.aheaditec.talsec_security.security.api.TalsecConfig
import com.aheaditec.talsec_security.security.api.ThreatListener
import dagger.hilt.android.HiltAndroidApp
import java.security.KeyStore
import java.security.cert.Certificate
import javax.inject.Inject

@HiltAndroidApp
class TalsecApplication : Application(), ThreatListener.ThreatDetected {
    companion object {

        private const val expectedPackageName = "com.hav.antidebugapp" // Thay thế bằng tên gói thực của bạn
        private val expectedSigningCertificateHashBase64 = arrayOf(
            "DyOfG5U8BfwMtfoD5aKIyCLsyrn1ci5cy4dfdky347c=" // Thay thế bằng hash chứng chỉ đúng của bạn
        )
        private const val watcherMail = "hoanganhvu271103@gmail.com"
        private val supportedAlternativeStores = arrayOf(
            "com.sec.android.app.samsungapps"
        )
        private val isProd = false
    }

    override fun onCreate() {
        super.onCreate()

        Log.d("Talsec", "Hello2")
        val config = TalsecConfig(
            expectedPackageName,
            expectedSigningCertificateHashBase64,
            watcherMail,
            supportedAlternativeStores,
            isProd
        )

        // ThreatListener(this).registerListener(this)
        ThreatListener(this, deviceStateListener).registerListener(this)

        Talsec.start(this, config)
    }

    override fun onRootDetected() {
        Log.d("Talsec", "Root detected")
        SharedLiveData.root.value = true
    }

    override fun onDebuggerDetected() {
        Log.d("Talsec", "Debugger detected")
        SharedLiveData.debugger.value = true
    }

    override fun onEmulatorDetected() {
        Log.d("Talsec", "Emulator detected")
        SharedLiveData.emulator.value = true
    }

    override fun onTamperDetected() {
        Log.d("Talsec", "Tamper detected")
        SharedLiveData.tamper.value = true
    }

    override fun onUntrustedInstallationSourceDetected() {
        Log.d("Talsec", "Untrusted installation source detected")
    }

    override fun onHookDetected() {
        Log.d("Talsec", "Hook detected")
        SharedLiveData.hook.value = true
    }

    override fun onDeviceBindingDetected() {
        Log.d("Talsec", "Device binding detected")
        SharedLiveData.deviceBinding.value = true
    }

    override fun onObfuscationIssuesDetected() {
        Log.d("Talsec", "Obfuscation issues detected")
        SharedLiveData.onfuscationIsues.value = true
    }

    private val deviceStateListener = object : ThreatListener.DeviceState {
        override fun onUnlockedDeviceDetected() {
            Log.d("Talsec", "Unlocked device detected")
            SharedLiveData.unlock.value = true

        }
        override fun onHardwareBackedKeystoreNotAvailableDetected() {
            Log.d("Talsec", "Hardware backed keystore not available detected")
            SharedLiveData.hardware.value = true
        }

        override fun onDeveloperModeDetected() {
            Log.d("Talsec", "Developer mode detected")
            SharedLiveData.deverloper.value = true
        }

        override fun onSystemVPNDetected() {
            Log.d("Talsec", "System VPN detected")
            SharedLiveData.vpn.value = true
        }
    }


}
