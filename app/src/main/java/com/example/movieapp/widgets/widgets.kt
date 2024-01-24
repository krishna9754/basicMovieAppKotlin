package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.movieapp.model.getData
import com.example.movieapp.model.movieData

//@Preview
@Composable
fun MovieRow (movie: movieData = getData()[0], onItemClick: (String) -> Unit = {}){
    var expand by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()

            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row(modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = CircleShape,
                tonalElevation = 8.dp
            ) {
                Image(painter = rememberAsyncImagePainter(model = movie.image[0],),
                    contentDescription = "Movie Image")

               // Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Movie Image")
            }
            Column() {
                Text(text = movie.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(text ="Genre: ${movie.genre} ")
                Text(text = "Released ${movie.year}")

                AnimatedVisibility(visible = expand) {
                    Column {

                       // Text(text = "Des: ${movie.description}")
                        Text( buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray)){
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(color = Color.DarkGray)){
                                append(movie.description)
                            }
                        } )
                        Divider()
                        Column(modifier = Modifier.padding(top = 8.dp)) {
                            Text(text = "Actor: ${movie.actor}",modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.Bold)
                            Text(text = "Rating: ${movie.rating}", modifier = Modifier.padding(top = 5.dp))
                            Text(text = "Year: ${movie.year}",modifier = Modifier.padding(top = 8.dp))
                        }
                    }
                }

                Icon(imageVector = if (!expand) Icons.Filled.KeyboardArrowDown
                else Icons.Filled.KeyboardArrowUp,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expand = !expand
                        },
                    contentDescription = "")
            }

        }
    }
}