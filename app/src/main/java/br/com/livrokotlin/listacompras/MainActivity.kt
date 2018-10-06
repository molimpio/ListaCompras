package br.com.livrokotlin.listacompras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_adicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

//        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
//        lv_produtos.adapter = produtosAdapter
//
//        lv_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
//
//            val item = produtosAdapter.getItem(position)
//            produtosAdapter.remove(item)
//            // return para indicar que o click deu certo
//            true
//        }
    }
}
