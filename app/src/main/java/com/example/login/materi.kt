package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_daftarguru.*

class materi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        val arrayList = ArrayList<Model>()

        arrayList.add(Model("Kimia", "adalah cabang dari ilmu fisik yang mempelajari tentang susunan, struktur, sifat, dan perubahan materi.[1][2] Ilmu kimia meliputi topik-topik seperti sifat-sifat atom, cara atom membentuk ikatan kimia untuk menghasilkan senyawa kimia, interaksi zat-zat melalui gaya antarmolekul yang menghasilkan sifat-sifat umum dari materi, dan interaksi antar zat melalui reaksi kimia untuk membentuk zat-zat yang berbeda.", R.drawable.chemistry))
        arrayList.add(Model("Biologi", "adalah kajian tentang kehidupan, dan organisme hidup, termasuk struktur, fungsi, pertumbuhan, evolusi, persebaran, dan taksonominya.[1] Ilmu biologi modern sangat luas, dan eklektik, serta terdiri dari berbagai macam cabang, dan subdisiplin.", R.drawable.biologi))
        arrayList.add(Model("Fisika", "adalah salah satu disiplin akademik paling tua, mungkin yang tertua melalui astronomi yang juga termasuk di dalamnya.[6] Lebih dari dua milenia, fisika menjadi bagian dari Ilmu Alam bersama dengan kimia, biologi, dan cabang tertentu matematika, tetapi ketika munculnya revolusi ilmiah pada abad ke-17, ilmu alam berkembang sebagai program penelitian sendiri.", R.drawable.fisika))
        arrayList.add(Model("Matematika", "adalah ilmu yang mempelajari besaran, struktur, ruang, dan perubahan. Para matematikawan merangkai dan menggunakan berbagai pola, kemudian menggunakannya untuk merumuskan konjektur baru, dan membangun kebenaran melalui metode deduksi yang ketat diturunkan dari aksioma-aksioma dan definisi-definisi yang bersesuaian.", R.drawable.matematika))
        arrayList.add(Model("Pemrograman", "adalah proses menulis, menguji dan memperbaiki (debug), dan memelihara kode yang membangun suatu program komputer.Kode ini ditulis dalam berbagai bahasa pemrograman. Tujuan dari pemrograman adalah untuk memuat suatu program yang dapat melakukan suatu perhitungan atau 'pekerjaan' sesuai dengan keinginan si pemrogram. Untuk melakukan pemrograman, diperlukan keterampilan dalam algoritme, logika, bahasa pemrograman, dan pada banyak kasus, pengetahuan-pengetahuan lain seperti matematika.", R.drawable.komputer))

        val myAdapter = MyAdapter(arrayList, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter

    }
}