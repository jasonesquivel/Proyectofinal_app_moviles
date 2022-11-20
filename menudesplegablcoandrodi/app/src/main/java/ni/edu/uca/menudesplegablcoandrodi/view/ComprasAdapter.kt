package ni.edu.uca.menudesplegablcoandrodi.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.menudesplegablcoandrodi.R
import ni.edu.uca.menudesplegablcoandrodi.model.ComprasData

class ComprasAdapter(val c: Context, val comprasList: ArrayList<ComprasData>) :
    RecyclerView.Adapter<ComprasAdapter.ComprasHolder>() {

    inner class ComprasHolder(val v: View) : RecyclerView.ViewHolder(v) {

        val name = v.findViewById<TextView>(R.id.tvNombreProd)
        val cantidad = v.findViewById<TextView>(R.id.tvCantidadProd)
        val precio = v.findViewById<TextView>(R.id.tvPrecioProd)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComprasHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.fragment_items_productos,parent,false)
        return ComprasHolder(v)
    }

    override fun onBindViewHolder(holder: ComprasHolder, position: Int) {
        val newList = comprasList[position]
        holder.name.text = newList.nombreProd
        holder.cantidad.text = newList.cantidadProd
        holder.precio.text = newList.precioProd
    }

    override fun getItemCount(): Int = comprasList.size
}
