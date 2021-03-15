package com.example.pertemuan2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.pertemuan2.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_a.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    //Tambah interfaceData
    private lateinit var interfaceData: InterfaceData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //hapus "return" ganti dengan val View agar dapat memanggil property dari layout fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        //tambahkan interfacedata dengan aktivitas dari interfaceData
        interfaceData = activity as InterfaceData

        //Inisialisasi komponen atau property dari fragment
        val btn = view.findViewById<Button>(R.id.kirimBtn)
        val pesanTxt = view.findViewById<EditText>(R.id.pesanTxt)
        val edittext = view.findViewById<TextView>(R.id.idText)
        val edittext2 = view.findViewById<TextView>(R.id.idPass)
        val tmbh = view.findViewById<TextView>(R.id.idTambah)

        //Aksi ketika btn diklik
        btn.setOnClickListener {
            interfaceData.kirimData(pesanTxt.text.toString())
        }

        val datatext = arguments?.getString(ARG_NAME)
        val datapass = arguments?.getString(ARG_PASS)
        val datatambah = arguments?.getInt(ARG_ADD)
        edittext.text = datatext
        edittext2.text = datapass
        tmbh.text = datatambah.toString()
        return view
    }

    companion object {
        const val ARG_NAME = "NAME"
        const val ARG_PASS = "PASS"
        const val ARG_ADD = "123"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentA.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: Int) =
            FragmentA().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, param1)
                    putString(ARG_PASS, param2)
                    putInt(ARG_ADD, param3)
                }
            }
        //fun newInstance(text: String, pass: String) =
        //    FragmentA.apply {
        //
        //    }
    }
}