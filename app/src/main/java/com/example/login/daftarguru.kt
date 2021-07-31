package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_daftarguru.*

class daftarguru : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftarguru)

        val arrayList = ArrayList<Model>()

        arrayList.add(Model("Aksal Abitahta Turipan", "087758561234", R.drawable.guru))
        arrayList.add(Model("Fauzan Dwi KurniaMega", "0897123141212", R.drawable.guru))
        arrayList.add(Model("Andika Pramono", "087456123453", R.drawable.guru))
        arrayList.add(Model("Asdhi Putra Baskara", "08512345676543", R.drawable.guru))
        arrayList.add(Model("Alexander Morgan", "087765645342", R.drawable.guru))

        val myAdapter = MyAdapter(arrayList, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter

    }
}