package br.com.livrokotlin.listacompras

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

        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        lv_produtos.adapter = produtosAdapter

        bt_adicionar.setOnClickListener {
            val produto = et_produto.text.toString()
            if (produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                et_produto.text.clear()
            } else {
                et_produto.error = "Preencha um produto"
            }
        }

        lv_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            // return para indicar que o click deu certo
            true
        }
    }
}
