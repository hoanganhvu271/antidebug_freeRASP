package com.hav.antidebugapp

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.aheaditec.talsec_security.security.api.Talsec
import com.aheaditec.talsec_security.security.api.TalsecConfig
import com.aheaditec.talsec_security.security.api.ThreatListener

class TalsecApplication : Application(), ThreatListener.ThreatDetected {
    override fun onCreate() {
        super.onCreate()
        val config = TalsecConfig(
            expectedPackageName,
            expectedSigningCertificateHashBase64,
            watcherMail,
            supportedAlternativeStores,
            isProd
        )
        Talsec.start(this, config)
    }

    companion object {
        private const val expectedPackageName = "com.aheaditec.talsec.demoapp" // Don't use Context.getPackageName!
        private val expectedSigningCertificateHashBase64 = arrayOf(
            "mVr/qQLO8DKTwqlL+B1qigl9NoBnbiUs8b4c2Ewcz0k=",
            "ZjLPK1Dle5JS1aUu1NuNEVVXarMEsCXvni/Kv/FK+tw="
        ) // Replace with your release (!) signing certificate hashes
        private const val watcherMail = "hoanganhvu271103@gmail.com" // for Alerts and Reports
        private val supportedAlternativeStores = arrayOf(
            "com.sec.android.app.samsungapps" // Add other stores, such as the Samsung Galaxy Store
        )
        private val isProd = true
    }

    override fun onRootDetected() {
        //thong bao khi phat hien co root
        Log.d("Talsec", "Root detected")
        Toast.makeText(this, "Root detected", Toast.LENGTH_SHORT).show()
    }

    override fun onDebuggerDetected() {
        //thong bao khi phat hien co debugger
        Log.d("Talsec", "Debugger detected")
        Toast.makeText(this,   "Debug", Toast.LENGTH_SHORT).show()
    }

    override fun onEmulatorDetected() {
        //thong bao khi phat hien co may ao
        Log.d("Talsec", "Emulator detected")
        Toast.makeText(this,   "Emulator", Toast.LENGTH_SHORT).show()
    }

    override fun onTamperDetected() {
        //thong bao khi phat hien co tamper
        Log.d("Talsec", "Tamper detected")
        Toast.makeText(this,   "Tamper", Toast.LENGTH_SHORT).show()
    }

    override fun onUntrustedInstallationSourceDetected() {
        //thong bao khi phat hien co nguon cai dat khong tin cay
        Log.d("Talsec", "Untrusted installation source detected")
        Toast.makeText(this,   "onUntrustedInstallation", Toast.LENGTH_SHORT).show()
    }

    override fun onHookDetected() {
        //thong bao khi phat hien co hook
        Log.d("Talsec", "Hook detected")
        Toast.makeText(this,   "Hooking Detetecion", Toast.LENGTH_SHORT).show()
    }

    override fun onDeviceBindingDetected() {
        //thong bao khi phat hien co device binding
        Log.d("Talsec", "Device binding detected")
    }

    override fun onObfuscationIssuesDetected() {
        //thong bao khi phat hien co obfuscation issues
        Log.d("Talsec", "Obfuscation issues detected")
    }
}
