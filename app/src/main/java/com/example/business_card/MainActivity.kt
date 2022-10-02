package com.example.business_card

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_card.ui.theme.Business_CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Business_CardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    full_App()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun Logo_names_title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val image = painterResource(id = com.example.business_card.R.drawable.android)
        Image(painter = image, contentDescription = null, modifier = Modifier.width(200.dp))
        Text(
            text = stringResource(com.example.business_card.R.string.name),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(com.example.business_card.R.string.title),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun full_App(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Logo_names_title()
        Social()
    }
}

@Composable
fun Social(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .offset(y = 250.dp)) {
        SocialInfo(
            text = stringResource(com.example.business_card.R.string.telephone_number),
            id = com.example.business_card.R.drawable.call,
            modifier = Modifier.weight(1f)
        )
        SocialInfo(
            text = stringResource(com.example.business_card.R.string.facebook),
            id = com.example.business_card.R.drawable.facebook,
            modifier = Modifier.weight(1f)
        )
        SocialInfo(
            text = stringResource(com.example.business_card.R.string.Instagram),
            id = com.example.business_card.R.drawable.instagram,
            modifier = Modifier.weight(1f)
        )
    }

}

@Composable
fun SocialInfo(text: String, id: Int,modifier: Modifier){
    val image = painterResource(id = id)
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .height(50.dp)
        ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .width(50.dp)
                .height(50.dp)
        )
        Text(
            text = text,
            color = Color.Blue,
            modifier = modifier.fillMaxHeight().wrapContentHeight(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Business_CardTheme {
        full_App()
    }
}