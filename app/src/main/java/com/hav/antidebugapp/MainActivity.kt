package com.hav.antidebugapp

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.hav.antidebugapp.ui.theme.AntidebugAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var viewmodel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(this).get(AppViewModel::class.java)
        setContent {
            AntidebugAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StatusScreen(viewmodel)
                }
            }
        }
    }


}

@Composable
fun StatusScreen( viewmodel: AppViewModel) {

    val root by SharedLiveData.root.observeAsState(false)
    val debugger by SharedLiveData.debugger.observeAsState(false)
    val emulator by SharedLiveData.emulator.observeAsState(false)
    val tamper by SharedLiveData.tamper.observeAsState(false)
    val hook by SharedLiveData.hook.observeAsState(false)
    val deviceBinding by SharedLiveData.deviceBinding.observeAsState(false)
    val onfuscationIsues by SharedLiveData.onfuscationIsues.observeAsState(false)
    val deverloper by SharedLiveData.deverloper.observeAsState(false)
    val hardware by SharedLiveData.hardware.observeAsState(false)
    val unlock by SharedLiveData.unlock.observeAsState(false)
    val vpn by SharedLiveData.vpn.observeAsState(false)


    Log.d("Talsec", "Root: $root, Debugger: $debugger, Emulator: $emulator, Tamper: $tamper, Hook: $hook, DeviceBinding: $deviceBinding, OnfuscationIsues: $onfuscationIsues, Deverloper: $deverloper, Hardware: $hardware, Unlock: $unlock, VPN: $vpn")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(40.dp)
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(15.dp),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    text = "FreeRASP Demo",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            LazyColumn {
                item{
                    StatusItem("Root Detect", root)
                    StatusItem("Debugger Detect", debugger)
                    StatusItem("Emulator Detect", emulator)
                    StatusItem("Tamper Detect", tamper)
                    StatusItem("Hook Detect", hook)
                    StatusItem("Device Binding Detect", deviceBinding)
                    StatusItem("Obfuscation Issues Detect", onfuscationIsues)
                    StatusItem("Developer Detect", deverloper)
                    StatusItem("Hardware BackedKeystore", hardware)
                    StatusItem("Unlock Device Detect", unlock)
                    StatusItem("System VPN Detect", vpn)
                }
            }
        }

    }
}

@Composable
fun StatusItem(name: String, value: Boolean) {

    val color = if (value) Color.Red else Color.Green


    Column(){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color)
                .padding(15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Spacer(modifier = Modifier.padding(10.dp))
    }





}