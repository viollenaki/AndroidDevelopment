package com.example.mbank

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbank.ui.theme.ClassesTheme
import kotlin.collections.listOf

class MainActivity : ComponentActivity() {

    // State list for logs
    private val lifecycleLogs = mutableStateListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        addLog(getString(R.string.log_on_create))

        setContent {
            ClassesTheme {
                Scaffold { innerPadding ->
                    ResumeScreen(
                        modifier = Modifier.padding(innerPadding),
                        logs = lifecycleLogs
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        addLog(getString(R.string.log_on_start))
    }

    override fun onResume() {
        super.onResume()
        addLog(getString(R.string.log_on_resume))
    }

    override fun onPause() {
        super.onPause()
        addLog(getString(R.string.log_on_pause))
    }

    override fun onDestroy() {
        super.onDestroy()
        addLog(getString(R.string.log_on_destroy))
    }

    private fun addLog(message: String) {
        Log.d("MainActivity", message)
        lifecycleLogs.add(message)
    }
}


@Composable
fun ResumeScreen(
    modifier: Modifier = Modifier,
    logs: List<String>
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFF1B3A4B)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                ProfileHeader()
                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = stringResource(R.string.lifecycle_logs_title),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            items(logs) { log ->
                Text(
                    text = log,
                    color = Color(0xFFB0D0E0),
                    fontSize = 14.sp
                )
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }

            items(contactList) { contact ->
                ContactItem(icon = contact.icon, textResId = contact.textResId)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}


@Composable
fun ProfileHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = stringResource(R.string.profile_icon_description),
            modifier = Modifier.size(120.dp),
            tint = Color.White
        )

        Text(
            text = stringResource(R.string.profile_name),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = stringResource(R.string.profile_role),
            fontSize = 18.sp,
            color = Color(0xFFB0D0E0)
        )
    }
}

@Composable
fun ContactItem(icon: ImageVector, textResId: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2C5364))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = stringResource(textResId),
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

data class ContactInfo(
    val icon: ImageVector,
    val textResId: Int
)

val contactList = listOf(
    ContactInfo(Icons.Default.Phone, R.string.contact_phone),
    ContactInfo(Icons.Default.Person, R.string.contact_telegram),
    ContactInfo(Icons.Default.Email, R.string.contact_email)
)

@Preview(showBackground = true)
@Composable
fun PreviewResume() {
    ClassesTheme {
        ResumeScreen(logs = listOf(
            "onCreate called",
            "onStart called",
            "onResume called"
        ))
    }
}
