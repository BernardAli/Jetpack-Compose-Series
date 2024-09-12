package com.example.tutorial_series

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorial_series.ui.theme.Tutorial_seriesTheme
import org.w3c.dom.Text
import kotlin.math.sin


val imageId = arrayOf(
    R.drawable.cbg,
    R.drawable.dispensary,
    R.drawable.cbg,
    R.drawable.mathematics,
    R.drawable.maths_tutor,
    R.drawable.todo,
)

val names = arrayOf(
    "Bank",
    "Hospital",
    "Business",
    "Academic",
    "Home",
    "Activity",
)

val activities = arrayOf(
    "Banking",
    "Health",
    "Money making",
    "Pop OS is a free and open-source Linux distribution, based on Ubuntu, and featuring a customized GNOME desktop environment known as COSMIC. The distribution is developed by American Linux computer manufacturer ",
    "Refreshment",
    "Progress",
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {

            val languages = listOf(
                "Java",
                "Kotlin",
                "Python",
                "JavaScript",
                "PHP",
                "C++",
                "C#",
                "Dart",
                "C",
                "Pearl",
                "Go",
                "Swift",
            )

//            Tutorial_seriesTheme {
//                Items(modifier = Modifier, languages)
//            }

             Surface(
                 modifier = Modifier.fillMaxSize(),
                 color = MaterialTheme.colorScheme.background
             ) {
                LazyExample(imageId, names, activities)
             }
        }
    }
}


@Composable
fun LazyExample(imageId:Array<Int>, names:Array<String>, activities:Array<String>, modifier: Modifier=Modifier){
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        val itemCount = imageId.size
//        items(count = 10){
//            Text(text = "$it")
//        }

        items(itemCount){ item ->
            ColItem(
                itemIndex = item,
                painter = imageId,
                title = names,
                activities = activities,
                modifier
                )
        }
    }
}

@Composable
fun ColItem(
    itemIndex: Int,
    painter: Array<Int>,
    title: Array<String>,
    activities: Array<String>,
    modifier: Modifier
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
            ){
                Image(
                    painter = painterResource(id = painter[itemIndex]),
                    contentDescription = title[itemIndex],
                    modifier.size(140.dp))

                Column(
                    modifier.padding(12.dp)
                ) {
                    Text(
                        text = title[itemIndex],
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = activities[itemIndex],
//                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape
                    ) {
                        Text(text = "Read More")
                    }
                }
        }
    }
}


@Composable
fun Items(modifier:Modifier = Modifier, languages: List<String>){
    Column(
        modifier.fillMaxSize()
    ) {
        LazyRow(
            contentPadding = PaddingValues(10.dp)
        ) {
            items(items = languages){ item ->
//            Text(text = "$item")
                RowItems(modifier = modifier, name = item )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(10.dp)
        ){
            items(items = languages){ item ->
//            Text(text = "$item")
                ColumnItem(modifier = modifier, name = item )
            }
        }
    }
}

@Composable
fun ColumnItem(modifier: Modifier, name: String) {
    Card(
        modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(3f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(
                id = R.color.teal_200
            ))
        }
    }
}


@Composable
fun RowItems(modifier:Modifier, name:String){
    Card(
        modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(
                id = R.color.teal_200
            ))
        }
    }
}

@Composable
fun CardExample(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Card(
            modifier = Modifier
                .width(250.dp)
                .height(380.dp),
//            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(10.dp),
//            border = BorderStroke(1.dp, Color.Gray),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mathematics),
                    contentDescription = "todo",
                )
                Text(
                    text = "Title Page",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(text = "Cards don't come with inherent scroll or dismiss actions, but can integrate into composables offering these features. For example, to implement swipe to dismiss on a card, integrate it with the SwipeToDismiss composable. To intore information.",
                    modifier = Modifier.padding(horizontal = 10.dp),
                    textAlign = TextAlign.Justify,
                    fontSize = 12.sp,
                    maxLines = 8,
                    overflow = TextOverflow.Ellipsis
                    )
            }
        }
    }
}


@Composable
fun ImageExample(){
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.maths_tutor),
            contentDescription = "pic",
            modifier = Modifier
                .size(350.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(width = 1.dp, color = Color.Red),
//            Alignment.Center,
            contentScale = ContentScale.Fit,
//            alpha = .5f
            )

        Image(
            painter = painterResource(id = R.drawable.todo),
            contentDescription = "todo",
            modifier = Modifier
                .size(250.dp)
                .border(width = 5.dp, color = Color.Gray, shape = CircleShape),
        )
    }
}


@Composable
fun TextFieldExample(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        var newTextvalue by remember {
            mutableStateOf("")
        }

        val context = LocalContext.current

        val keyboardController = LocalSoftwareKeyboardController.current

        val focusManager = LocalFocusManager.current

        val myColor = Color(0xFFE91111)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(150.dp)
        ) {
            TextField(value = newTextvalue, onValueChange = {
                newTextvalue = it
            },
                label = {
                    Text(text = "Enter your email")
                },
//                maxLines = 2,
                singleLine = true,
                modifier = Modifier.width(300.dp),
                placeholder = {
                    Text(text = "test@example.com")
                },
//                visualTransformation = PasswordVisualTransformation()
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, newTextvalue, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "")
                    }
                }
            )


            OutlinedTextField(value = newTextvalue, onValueChange = {
                newTextvalue = it
            },
                modifier = Modifier.width(300.dp),
                label = {
                    Text(text = "Enter username")
                },
                placeholder = {
                    Text(text = "BenAli")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, newTextvalue, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "")
                    }
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Send
                ),
                keyboardActions = KeyboardActions(
                    onSend = {
                        keyboardController?.hide()
                        Toast.makeText(context, newTextvalue, Toast.LENGTH_SHORT).show()
                        focusManager.clearFocus()
                    }
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedLabelColor = myColor,

                ),
                shape = RoundedCornerShape(5.dp)
            )


            BasicTextField(value = newTextvalue, onValueChange = {
                newTextvalue = it
            },
                modifier = Modifier
                    .background(Color.Gray)
                    .width(300.dp)
                    .padding(10.dp),
            )


        }
    }
}


@Composable
fun StateExample(){
    var value by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Counter")
        Text(text = "$value", fontSize = 80.sp)
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(onClick = {
                value--
                Log.d("Count", "$value")
            }) {
                Text(text = "Decrease")
            }
            Button(onClick = { value = 0 }) {
                Text(text = "Reset")
            }
            Button(onClick = { value++ }) {
                Text(text = "Increase")
            }
        }
    }
}


@Composable
fun ButtonExamples(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 6.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfffedbd0),
                contentColor = Color.Gray
            ),
            border = BorderStroke(1.dp, Color.Red)
            ) {
            Text(text = "Click Me")
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(topStart = 5.dp)
        ) {
            Text(text = "Click Me")
        }

        ElevatedButton(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Click Me")
        }

        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(70.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
        TextButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Create,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Update")
        }
    }
}


@Composable
fun MyApp(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Text(text = "Hello World!",
            modifier = Modifier
                .padding(top = 15.dp)
                .background(colorResource(id = R.color.teal_200))
                .fillMaxWidth()
                .padding(10.dp)
            ,
            textAlign = TextAlign.Center
        )
        Text(text = "Hello World!",
            modifier = Modifier
                .background(colorResource(id = R.color.purple_200))
                .fillMaxWidth()
                .height(200.dp)
                .padding(70.dp)
            ,
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.purple_700))
                .size(800.dp)
                .border(BorderStroke(2.dp, Color.Red)),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Hi There!", color = Color.White, fontSize = 40.sp)
        }
    }
}


@Composable
fun BoxExample(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .width(250.dp)
                .height(500.dp)
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(300.dp)
                    .background(Color.Yellow),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Hello World", fontWeight = FontWeight.Bold)
            }
        }
    }
}


@Composable
fun RowExample(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Hello Memuna",
            fontSize = 20.sp,
        )
        Text(
            text = "Hello Ben",
            fontSize = 20.sp,
        )
    }
}


@Composable
fun ColumnExample(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello Memuna",
            fontSize = 32.sp,
            modifier = Modifier.padding(70.dp)
        )
        Text(
            text = "Hello Ben",
            fontSize = 32.sp,
            modifier = Modifier.padding(70.dp)
        )
    }
}


@Composable
fun SurfaceExample(){
    Surface(
        modifier = Modifier
            .padding(top = 20.dp)
            .height(200.dp)
            .width(500.dp)
            .padding(2.dp),
        color = Color.LightGray,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color.Red),
        shadowElevation = 10.dp
    ){
        Text(
            text = "Hello Memuna",
            fontSize = 32.sp,
            modifier = Modifier.padding(70.dp),
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun TextExample(){
//    val fontName = FontFamily(Font(R.font.alata))
//    Text(
//        // modifier = Modifier.background(Color.Gray).width(450.dp),
//        text = stringResource(id = R.string.welcome).repeat(100),
//        color = Color.Red,
//        fontWeight = FontWeight.W300,
//        fontSize = 18.sp,
//        fontStyle = FontStyle.Italic,
//        fontFamily = FontFamily.Monospace,
////        letterSpacing = 5.sp,
////        textDecoration = TextDecoration.Underline,
//        //textAlign = TextAlign.Center,
//        lineHeight = 30.sp,
//        maxLines = 3,
//        overflow = TextOverflow.Ellipsis
//    )

    Text(text = buildAnnotatedString {
        withStyle(ParagraphStyle(textIndent = TextIndent(firstLine = 20.sp))){
            append("Hello World".repeat(50))
        }
        withStyle(SpanStyle(color = Color.Blue, fontSize = 32.sp)){
            append("J")
        }
        append("etpack")
        append(" ")
        withStyle(SpanStyle(color = Color.Blue, fontSize = 32.sp)){
            append("C")
        }
        append("ompose")
    },
        textAlign = TextAlign.Justify)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tutorial_seriesTheme {
        val languages = listOf(
            "Java",
            "Kotlin",
            "Python",
            "JavaScript",
            "PHP",
            "C++",
            "C#",
            "Dart",
            "C",
            "Pearl",
            "Go",
            "Swift",
        )

//        Tutorial_seriesTheme {
//            Items(modifier = Modifier, languages)
//        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyExample(imageId, names, activities)
        }
    }
}