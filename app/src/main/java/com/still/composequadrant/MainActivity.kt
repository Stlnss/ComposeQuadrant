package com.still.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.still.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrantScreen()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantScreen() {
    val modifier = Modifier
    ComposableCards(
        textComposableTitle = stringResource(id = R.string.text_composable),
        textComposableBody = stringResource(id = R.string.text_composable_body),
        rowComposableTitle = stringResource(id = R.string.row_composable),
        rowComposableBody = stringResource(id = R.string.row_composable_body),
        imageComposableTitle = stringResource(id = R.string.image_composable),
        imageComposableBody = stringResource(id = R.string.image_composable_body),
        columnComposableTitle = stringResource(id = R.string.column_composable),
        columnComposableBody = stringResource(id = R.string.column_composable_body),
        modifier = modifier
    )
}

@Composable
fun ComposableCards(
    textComposableTitle: String,
    textComposableBody: String,
    rowComposableTitle: String,
    rowComposableBody: String,
    imageComposableTitle: String,
    imageComposableBody: String,
    columnComposableTitle: String,
    columnComposableBody: String,
    modifier: Modifier
) {
    Row(modifier = modifier.fillMaxHeight()) {
        Column(modifier.weight(1F, true)) {
            ComposableInfoCard(
                title = textComposableTitle,
                body = textComposableBody,
                backGroundColor = Color.Green,
                modifier = modifier.weight(1F)
            )
            ComposableInfoCard(
                title = rowComposableTitle,
                body = rowComposableBody,
                backGroundColor = Color.Cyan,
                modifier = modifier.weight(1F)
            )
        }
        Column(modifier.weight(1F, true)) {
            ComposableInfoCard(
                title = imageComposableTitle,
                body = imageComposableBody,
                backGroundColor = Color.Yellow,
                modifier = modifier.weight(1F)
            )
            ComposableInfoCard(
                title = columnComposableTitle,
                body = columnComposableBody,
                backGroundColor = Color.LightGray,
                modifier = modifier.weight(1F)
            )
        }
    }
}

@Composable
fun ComposableInfoCard(title: String, body: String, backGroundColor: Color, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(backGroundColor)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantScreen()
    }
}