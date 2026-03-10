
package com.company.psreadings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.company.psreadings.data.Repos
import com.company.psreadings.data.db.AppDatabase
import com.company.psreadings.ui.DayScreen
import com.company.psreadings.ui.MonthScreen
import androidx.compose.material3.*
import androidx.compose.runtime.*
import java.time.*

class MainActivity: ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Repos.db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "ps.db").build()
    setContent {
      MaterialTheme { AppNav() }
    }
  }
}

@Composable
fun AppNav(){
  var selected by remember { mutableStateOf(LocalDate.now()) }
  var mode by remember { mutableStateOf("MONTH") }
  Scaffold(topBar={ TopAppBar(title={ Text(if (mode=="MONTH") "اختر يومًا" else "تفاصيل اليوم") }) }){ pad ->
    Surface(modifier= androidx.compose.ui.Modifier.padding(pad)){
      if (mode=="MONTH") MonthScreen(selected){ d -> selected=d; mode="DAY" }
      else DayScreen(selected)
    }
  }
}
