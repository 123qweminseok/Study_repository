package com.minseok.compose_study

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

// ✅ 1. 기본적인 UI 요소 (Text, Button, Image, TextField)
@Composable
fun BasicComponents() {
    var text by remember { mutableStateOf("Hello, Jetpack Compose!") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = 20.sp) // 기본 텍스트

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter text") }
        ) // 입력 필드

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { text = "Button Clicked!" },
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Click Me")
        } // 버튼

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_camera),
            contentDescription = "Sample Image",
            modifier = Modifier.size(50.dp)
        ) // 이미지
    }
}

// ✅ 2. LazyColumn을 이용한 리스트 UI
@Composable
fun ListExample() {
    val itemsList = List(10) { "Item #${it + 1}" } // 리스트 생성

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(itemsList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 18.sp
                )
            }
        }
    }
}

// ✅ 3. Row & Box 레이아웃
@Composable
fun RowAndBoxLayout() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Box 1")
        }

        Box(
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Box 2")
        }
    }
}

// ✅ 4. 최상위 Composable 함수
@Composable
fun MyApp() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Jetpack Compose Preview Examples", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(8.dp))
            BasicComponents() // 기본적인 UI 요소
            Spacer(modifier = Modifier.height(16.dp))
            ListExample() // 리스트 UI
            Spacer(modifier = Modifier.height(16.dp))
            RowAndBoxLayout() // Row & Box UI
        }
    }
}

// ✅ 5. 다양한 `@Preview` 예제들

