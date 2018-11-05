package br.com.livrokotlin.listacompras

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    val COD_IMAGE = 101
    var imageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        bt_inserir.setOnClickListener {
            val produto = et_produto.text.toString()
            val qtde = et_qtde.text.toString()
            val valor = et_valor.text.toString()

            if (produto.isNotEmpty() && qtde.isNotEmpty() && valor.isNotEmpty()) {

                val prod = Produto(produto, qtde.toInt(), valor.toDouble(), imageBitmap)
                produtosGlobal.add(prod)

                et_produto.text.clear()
                et_qtde.text.clear()
                et_valor.text.clear()

            } else {
                et_produto.error = if (et_produto.text.isEmpty()) "Preencha um produto !"  else null
                et_qtde.error = if (et_qtde.text.isEmpty()) "Preencha qtde !" else null
                et_valor.error = if (et_valor.text.isEmpty()) "Preencha valor !"  else null
            }
        }

        img_foto_produto.setOnClickListener { abrirGaleria() }
    }

    fun abrirGaleria() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), COD_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == COD_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                val inputStream = contentResolver.openInputStream(data.data)
                imageBitmap = BitmapFactory.decodeStream(inputStream)
                img_foto_produto.setImageBitmap(imageBitmap)
            }
        }
    }
}
