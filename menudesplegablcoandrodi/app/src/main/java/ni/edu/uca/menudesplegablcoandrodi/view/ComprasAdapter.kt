package ni.edu.uca.menudesplegablcoandrodi.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.menudesplegablcoandrodi.R
import ni.edu.uca.menudesplegablcoandrodi.model.ComprasData
import org.w3c.dom.Text

class ComprasAdapter(val c: Context, val comprasList: ArrayList<ComprasData>) :
    RecyclerView.Adapter<ComprasAdapter.ComprasHolder>() {

    inner class ComprasHolder(val v: View) : RecyclerView.ViewHolder(v) {

        var name: TextView
        var cantidad: TextView
        var precio: TextView
        var mMenus: ImageView

        init {
            name = v.findViewById<TextView>(R.id.tvNombreProd)
            cantidad = v.findViewById<TextView>(R.id.tvCantidadProd)
            precio = v.findViewById<TextView>(R.id.tvPrecioProd)
            mMenus = v.findViewById(R.id.mMenus)
            mMenus.setOnClickListener({ popupMenus(it) })
        }

        private fun popupMenus(v: View) {
            val position = comprasList[adapterPosition]
            val popupMenus = PopupMenu(c, v)
            popupMenus.inflate(R.menu.show_menu)
            popupMenus.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.editText -> {

                        val v = LayoutInflater.from(c)
                            .inflate(R.layout.fragment_agregar_productos, null)

                        val nombre = v.findViewById<EditText>(R.id.etNombreProd)
                        val canti = v.findViewById<EditText>(R.id.etCantProd)
                        val precio = v.findViewById<EditText>(R.id.etPrecioProd)

                        AlertDialog.Builder(c)
                            .setView(v)
                            .setPositiveButton("Ok") { dialog, _ ->

                                position.nombreProd = ("Producto: " + nombre.text.toString())
                                position.cantidadProd = ("Cant: " + canti.text.toString())
                                position.precioProd = ("Precio: " + precio.text.toString())

                                notifyDataSetChanged()
                                Toast.makeText(c, "User Information is Edited", Toast.LENGTH_SHORT)
                                    .show()
                                dialog.dismiss()

                            }
                            .setNegativeButton("Cancel") { dialog, _ ->
                                dialog.dismiss()

                            }
                            .create()
                            .show()
                        true
                    }

                    R.id.delete -> {
                        /**set delete*/
                        AlertDialog.Builder(c)
                            .setTitle("Delete")
                            .setIcon(R.drawable.ic_warning)
                            .setMessage("Are you sure delete this Information")
                            .setPositiveButton("Yes") { dialog, _ ->
                                comprasList.removeAt(adapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(c, "Deleted this Information", Toast.LENGTH_SHORT)
                                    .show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("No") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .create()
                            .show()

                        true
                    }
                    else -> true
                }

            }
            popupMenus.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenus)
            menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(menu, true)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComprasHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.fragment_items_productos, parent, false)
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



