package com.example.pertemuan1


import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan1.ui.theme.Pertemuan1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column() {
  //              NameInputScreen()
                TodoApp()
  //              ProfileCard()
  //              styledButton()
  //              CounterButton()
  //              AnimalList()
            }

 //           MyApp()
//            Pertemuan1Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Column (modifier = Modifier.padding((innerPadding))) {
//

//
//                    }
//
//                    }
//
//            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pertemuan1Theme {
        Greeting("Android")
    }
}

@Composable
fun ProfileCard() {
    // Membuat susunan vertikal
    Column(
        modifier = Modifier.padding(16.dp) // memberi jarak 16dp
    ) {
        Text (text = "Nama: M Aqmal Firdaus", fontSize = 24.sp)
        Text (text = "Pekerjaan: Mahasiswa", fontSize = 16.sp)
        Text (text = "Hobi: Jalan jalan", fontSize = 16.sp)
        Text (text = "Kampus: STT MANDALA BANDUNG")

        // Spacer memberi jarak kosong
        Row {
            Text(text ="Umur: 23")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Kota: Sukabumi")

        }
    }
}

@Composable
fun styledButton() {
    Text (
        text = "Klik Saya",
        modifier = Modifier
            .padding(20.dp)
            .background(Color.Blue)
            .padding(10.dp)
            .clickable { println("Tombol diklik!") }
    )
}

@Composable
fun CounterButton() {


    var count by remember { mutableStateOf(0)}

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Angka saat ini: $count", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count++ }) {
            Text(text = "Tambah +1")
        }
        Button(onClick = { count-- }){
            Text(text ="Kurang -1")
        }
        Button(onClick = {count = count*2 }) {
            Text(text = "Kali *2" )
        }
    }
}

@Composable
fun MyApp() {
    // state untuk menyimpan status online/offline
    var isOnline by remember { mutableStateOf(false) }

    // Layout utama (Layar penuh di tengah)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Kartu profil
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Akmal",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold
                )
                Spacer (modifier = Modifier.height(8.dp))

// Teks Status berubah sesuai variabel 'isonline'
                Text(
                    text = if (isOnline) " status: Online" else "Status: Offline",
                    fontSize = 18.sp
                )
                Spacer (modifier = Modifier.height(16.dp))
// Tombol untuk mengubah status
                Button(onClick = { isOnline = !isOnline }) {
                    Text(text = "Ubah Status")
                }

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}

@Composable
fun AnimalList() {
    // Data dummy (bisa dari database/Api)
    val animals = listOf(
        "Kucing","Anjing","Burung","Gajah","Ikan","Ular","Harimau","Singa","Kelinci","Kuda",
        "Sapi","Kambing","Kerbau","Ayam","Bebek","Angsa","Merpati","Elang","Cendrawasih","Rajawali",
        "Buaya","Kadal","Komodo","Katak","Salamander","Penyu","KuraKura","Hiu","LumbaLumba","Paus",
        "Gurita","CumiCumi","Udang","Kepiting","Kerang","Siput","Belut","Lele","Nila","Mujair",
        "Tuna","Salmon","Sarden","Makarel","Bandeng","Kakap","Barakuda","Koi","Arwana","Cupang",
        "Hamster","Marmut","Tikus","Landak","Beruang","Panda","Serigala","Rubah","Cheetah","MacanTutul",
        "Badak","KudaNil","Jerapah","Zebra","Kanguru","Koala","Walabi","Tapir","Bison","Antelop",
        "Gazelle","Lemur","Orangutan","Gorila","Simpanse","Monyet","Babun","Kelelawar","Musang","Luwak",
        "Trenggiling","Armadillo","Sloth","Opossum","Rakoon","Skunk","Dingo","Hyena","Meerkat","Surikat",
        "Tokek","Cicak","Iguana","Chameleon","Python","Cobra","Viper","Boa","Anaconda","KudaLaut"
    )

    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement =Arrangement.spacedBy(8.dp) // jarak antar item
    ) {
        // items () adalah fungsi untuk mengiterasi data
        items(animals) { animal->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray)
            ) {
                Text(
                    text = animal,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )

            }
        }
    }
}

@Composable
fun NameInputScreen() {
    // state di simpan di sini (induk)
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Halo, $name!", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name, // Nilai saat ini
            onValueChange = { newText ->
                name = newText // aksi saat user mengetik
            },
            label = { Text("Masukan Nama") },
            modifier = Modifier.fillMaxWidth()
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp() {
    var tasks by remember { mutableStateOf(listOf<String>())}
    var inputText by remember {mutableStateOf("")}

    Scaffold(
        // Header
        topBar = {
            TopAppBar(
                title = { Text("Aplikasi Tugas Saya")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (inputText.isNotBlank()) {
                    tasks = tasks + inputText
                    inputText = ""
                }
            }) {
                Icon(Icons.Default.Add, contentDescription = "Tambah")
            }
        }
    ) { innerPadding ->
        // Content Area
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // input area
            OutlinedTextField(
                value = inputText,
                onValueChange = {inputText = it },
                label = { Text("Tugas Baru")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(tasks) { task ->
                    TaskItem(task)
                }
            }
        }

    }
}

@Composable
fun TaskItem(task: String) {
    var isChecked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = isChecked, onCheckedChange = {isChecked = !isChecked})
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = task, fontSize = 18.sp)
        }
    }
}