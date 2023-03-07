package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceApp()
                }
            }
        }
    }
}

@Composable
fun DiceApp() {
    DiceWithButton()
}

@Composable
fun DiceWithButton() {
    var dice by remember { mutableStateOf(1) }
    val imageDice = when (dice) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        else -> R.drawable.dice6
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .wrapContentSize(Alignment.Center)
            , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(modifier = Modifier.size(250.dp),painter = painterResource(id = imageDice), contentDescription = null)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { dice = (1..6).random() }) {
            Text(text = "Roll")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    DiceRollerTheme {
        DiceApp()
    }
}