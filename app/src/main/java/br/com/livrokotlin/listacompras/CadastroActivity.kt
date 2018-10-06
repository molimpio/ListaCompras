package br.com.livrokotlin.listacompras

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

//        bt_adicionar.setOnClickListener {
//            val produto = et_produto.text.toString()
//            if (produto.isNotEmpty()) {
//
//                et_produto.text.clear()
//            } else {
//                et_produto.error = "Preencha um produto"
//            }
//        }
    }
}
