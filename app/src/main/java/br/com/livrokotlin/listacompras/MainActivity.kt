package br.com.livrokotlin.listacompras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ProdutoAdapter(this)
        lv_produtos.adapter = produtosAdapter

        bt_adicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val adapter = lv_produtos.adapter as ProdutoAdapter
        adapter.clear()
        adapter.addAll(produtosGlobal)
        val soma = produtosGlobal.sumByDouble { it.valor * it.quantidade }
        val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        tv_total.text = "Total: ${f.format(soma)}"
    }

}
