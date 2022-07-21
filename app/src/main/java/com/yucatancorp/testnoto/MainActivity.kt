package com.yucatancorp.testnoto

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yucatancorp.testnoto.ui.theme.TestNotoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestNotoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greetings()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, isAllerFont: Boolean) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name = name, isAllerFont)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestNotoTheme {
        Greeting("Android", true)
    }
}

@Composable
private fun Greetings(names: List<String> = listOf(
    LocalContext.current.resources.getString(R.string.mMessage),
    "பிரான்சின் பொதுவாக தொழில்துறை பகுதியானது நோர்டின் துறையாகும்,",
    "ಫ್ರಾನ್ಸ್‌ನ ವಿಶಿಷ್ಟವಾಗಿ ಕೈಗಾರಿಕಾ ಪ್ರದೇಶವು ಉಣ್ಣೆಯ ಉದ್ಯಮದ ಕೇಂದ್ರವಾದ ನಾರ್ಡ್‌ನ ಇಲಾಖೆಯಾಗಿದೆ, ಆದರೆ ಇತರ ಜವಳಿ ಕೈಗಾರಿಕೆಗಳಲ್ಲಿ, ಲೋಹದ ಕೆಲಸದಲ್ಲಿ ಮತ್ತು ಇತರ ವಿವಿಧ ಕ್ಷೇತ್ರಗಳಲ್ಲಿ ಪ್ರಮುಖವಾಗಿ ಕಾಳಜಿ ವಹಿಸುತ್ತದೆ.",
    "ଫ୍ରାନ୍ସର ଶିଳ୍ପାଞ୍ଚଳ ହେଉଛି ନର୍ଡ ବିଭାଗ, ପଶମ ଶିଳ୍ପର ଆସନ, କିନ୍ତୁ ଅନ୍ୟ ବୟନ ଶିଳ୍ପ, ଧାତୁ କାର୍ଯ୍ୟରେ ଏବଂ ଅନ୍ୟାନ୍ୟ କ୍ଷେତ୍ରରେ ମଧ୍ୟ ସେ ଚିନ୍ତିତ",
    "فرانس کا عام طور پر صنعتی علاقہ نورڈ کا محکمہ ہے، جو اونی صنعت کا مرکز ہے، لیکن ٹیکسٹائل کی دیگر صنعتوں، دھاتی کام کرنے اور دیگر مختلف ص",
    "ఫ్రాన్స్‌లోని సాధారణంగా పారిశ్రామిక ప్రాంతం నోర్డ్ డిపార్ట్‌మెంట్, ఇది ఉన్ని పరిశ్రమ యొక్క స్థానం, కానీ ఇతర వస్త్ర పరిశ్రమలలో, మెటల్ పనిలో మరియు అనేక ఇతర రంగాలలో ప్రముఖంగా ఉంటుంది."
)) {

    val isAllerFont = remember { mutableStateOf(false) }
    val activity = (LocalContext.current as? Activity)

    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        TopAppBar(
            title = {
                Text(text = "Compose")
            },
            navigationIcon = {
                IconButton(onClick = { activity?.finish() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back Btn")
                }
            },
            backgroundColor = androidx.compose.ui.graphics.Color.White,
            contentColor = androidx.compose.ui.graphics.Color.Black,
            elevation = 2.dp
        )
        Row(modifier = Modifier.padding(5.dp)) {
            Switch(checked = isAllerFont.value, onCheckedChange = { isAllerFont.value = it }, modifier = Modifier.weight(.5f))
            Text(text = if (isAllerFont.value) "Noto" else "Aller", modifier = Modifier.weight(.5f))
        }
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                Greeting(name = name, isAllerFont.value)
            }
        }
    }
}

@Composable
private fun CardContent(name: String, isAllerFont: Boolean) {

    val notoSansFamily = FontFamily(
        Font(R.font.notosans_regular, FontWeight.Normal),
    )

    val allerFamily = FontFamily(
        Font(R.font.aller_regular, FontWeight.Normal),
    )

    Row(
        modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column (
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = name,
                fontFamily = if (isAllerFont) notoSansFamily else allerFamily
            )
        }
    }
}