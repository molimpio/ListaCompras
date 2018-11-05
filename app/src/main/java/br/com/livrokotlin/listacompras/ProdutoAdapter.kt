package br.com.livrokotlin.listacompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.NumberFormat
import java.util.Locale

class ProdutoAdapter(contexto: Context) : ArrayAdapter<Produto>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v:View
        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
        }

        val item = getItem(position)
        val tvProduto = v.findViewById<TextView>(R.id.tv_item_produto)
        val tvQtde = v.findViewById<TextView>(R.id.tv_item_qtde)
        val tvValor = v.findViewById<TextView>(R.id.tv_item_valor)
        val ivProduto = v.findViewById<ImageView>(R.id.img_item_foto)

        tvQtde.text = item.quantidade.toString()
        tvProduto.text = item.nome

        val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        tvValor.text = f.format(item.valor)

        if (item.foto != null) ivProduto.setImageBitmap(item.foto)

        return v
    }
}