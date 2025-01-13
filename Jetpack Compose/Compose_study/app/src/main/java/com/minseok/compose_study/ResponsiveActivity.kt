package com.minseok.compose_study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize

//반응형 디자인

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class ResponsiveActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val windowSizeClass = calculateWindowSizeClass(this)
                ResponsiveLayout(windowSizeClass)
            }
        }
    }
}

@Composable
fun ResponsiveLayout(windowSizeClass: WindowSizeClass) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                Text("📱 스마트폰 화면", fontSize   = 30.sp)
                Spacer(modifier = Modifier.height(50.dp))  // ✅ 간격 추가
                Button(onClick = {}) { Text("작은 버튼") }
            }
            WindowWidthSizeClass.Medium -> {
                Text("📟 폴더블/작은 태블릿 화면", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {}) { Text("중간 버튼") }
            }
            WindowWidthSizeClass.Expanded -> {
                Text("💻 태블릿/TV 화면", fontSize = 24.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {}) { Text("큰 버튼") }
            }
        }

}
}
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview
@Composable
fun PreviewResponsiveLayout() {
    MaterialTheme {
        ResponsiveLayout(
            windowSizeClass = WindowSizeClass.calculateFromSize(
                DpSize(400.dp, 800.dp)
            )
        )
    }
}