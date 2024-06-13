package chaintech.qrkit.demo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AskQuestionScreen() {
    val roomNameState = remember { mutableStateOf("") }
    val questionState = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A)),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 50.dp, bottom = 80.dp, start = 12.dp, end = 12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                RoomNameField(roomNameState)
                Spacer(modifier = Modifier.height(20.dp))
                QuestionField(questionState)
            }
            Spacer(modifier = Modifier.height(16.dp))
            BasicButton()
        }
    }
}

@Composable
fun RoomNameField(
    roomNameState: MutableState<String>
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Your Room: ",
            color = Color.White,
            fontSize = 22.sp,
        )
        Spacer(modifier = Modifier.width(5.dp))
        BasicTextField(
            value = roomNameState.value,
            onValueChange = { newRoomName -> roomNameState.value = newRoomName },
            textStyle = TextStyle(color = Color.White),
            modifier = Modifier
                .background(Color(0xFF333333), shape = MaterialTheme.shapes.small)
                .padding(8.dp)
        )
    }
}

@Composable
fun QuestionField(
    questionState: MutableState<String>
){
    Box(
        modifier = Modifier
            .background(Color(0xFF333333), shape = MaterialTheme.shapes.small)
            .padding(start = 10.dp, end = 10.dp, top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        if (questionState.value.isEmpty()) {
            Text(
                text = "Enter your question here...",
                color = Color.Gray
            )
        }
        BasicTextField(
            value = questionState.value,
            onValueChange = { newQuestion -> questionState.value = newQuestion },
            textStyle = TextStyle(color = Color.White),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .clip(RoundedCornerShape(12.dp))
        )
    }
}

@Composable
fun BasicButton(){
    TextButton(
        onClick = { /* Action when we press submit */ },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A73E8), shape = MaterialTheme.shapes.small)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Text(text = "Submit", color = Color.White)
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    AskQuestionScreen()
}
