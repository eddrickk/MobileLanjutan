package com.example.pertemuan2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pertemuan2.fragments.FragmentA
import com.example.pertemuan2.fragments.FragmentB
import com.example.pertemuan2.fragments.InterfaceData

class MainActivity : AppCompatActivity(), InterfaceData {
    var datatext: String? = ""
    var datapass: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var datatext = intent.getStringExtra("123")
        var datapass = intent.getStringExtra("1234")
        var tambah = 12345

        val fragmentA = FragmentA.newInstance(datatext.toString(),datapass.toString(),tambah.toInt())
        supportFragmentManager
            .beginTransaction().replace(R.id.fragmentContainer, fragmentA).commit()
    }

    override fun kirimData(editText: String) {
        val bundle = Bundle()
        bundle.putString("Pesan", editText)

        val fragmentB = FragmentB()
        fragmentB.arguments = bundle

        val transaksi = this.supportFragmentManager.beginTransaction()
        transaksi.replace(R.id.fragmentContainer, fragmentB)
        transaksi.addToBackStack(null)
        transaksi.commit()
    }

    override fun terimaData() {
        TODO("Not yet implemented")
    }

    //override fun terimaData(): FragmentA {
    //    val bundle = Bundle()
    //    bundle.putString("111", datatext)
    //    bundle.putString("112", datapass)
    //    val fragment = FragmentA()
    //    fragment.arguments = bundle
    //    return fragment
    //}
}