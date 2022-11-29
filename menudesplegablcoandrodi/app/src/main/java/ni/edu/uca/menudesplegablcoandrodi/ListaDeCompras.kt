package ni.edu.uca.menudesplegablcoandrodi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentListaDeComprasBinding
import ni.edu.uca.menudesplegablcoandrodi.model.ComprasData
import ni.edu.uca.menudesplegablcoandrodi.model.Shared
import ni.edu.uca.menudesplegablcoandrodi.view.ComprasAdapter
import ni.edu.uca.menudesplegablcoandrodi.view.ComprasViewModel


class ListaDeCompras : Fragment() {
    private var _binding: FragmentListaDeComprasBinding? = null

    // TODO: Rename and change types of parameters
    private val binding get() = _binding!!
    private lateinit var addBtn: Button
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recView: RecyclerView
    private lateinit var comprasList: ArrayList<ComprasData>
    private lateinit var comprasAdapter: ComprasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        comprasList = ArrayList<ComprasData>()

        val comprasVieModel =
            ViewModelProvider(this).get(ComprasViewModel::class.java)

        _binding = FragmentListaDeComprasBinding.inflate(inflater, container, false)
        val root: View = binding.root


        comprasVieModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inflter = LayoutInflater.from(context)
        var msnsal = Shared.preferen.getSal()
        binding.tvSaldoActual.setText(msnsal)
        val v = inflter.inflate(R.layout.fragment_lista_de_compras, null)
        recView = v.findViewById<RecyclerView>(R.id.rvListaCompra)

        binding.addBtn.setOnClickListener {
            addInfo()
        }
        binding.btnPagoProd.setOnClickListener{
            restargasto()
        }

    }

    private fun restargasto() {
        var msnsal = Shared.preferen.getSal().toInt()
        var saldoIngresado: Int = binding.prodTotal.text.toString().toInt()
        var total = (msnsal - saldoIngresado)
        Shared.preferen.SaveSal(total.toString())
        binding.tvSaldoActual.setText(total.toString())

        Toast.makeText(context, "El proceso ha sido exitoso!", Toast.LENGTH_SHORT).show()
    }

    private fun addInfo() {
        with(binding) {
            val inflater = LayoutInflater.from(context)
            val v = inflater.inflate(R.layout.fragment_agregar_productos, null)

            val nombre = v.findViewById<EditText>(R.id.etNombreProd)
            val cantidad = v.findViewById<EditText>(R.id.etCantProd)
            val precio = v.findViewById<EditText>(R.id.etPrecioProd)

            val addDialog = context?.let { AlertDialog.Builder(it) }
            addDialog?.setView(v)
            addDialog?.setPositiveButton("Confirmar") { dialog, _ ->
                val prodName = nombre.text
                val prodCant = cantidad.text.toString()
                var prodPrecio = precio.text.toString()
                var prodTotal = prodPrecio.toInt() * prodCant.toInt()
                var T = prodTotal.toString()


                comprasList.add(

                    ComprasData(

                        "Producto: $prodName",
                        "Cant:  $prodCant",
                        "C$: $prodPrecio",
                        "Total: $T"

                    )
                )
              prodTotal=prodTotal+binding.prodTotal.text.toString().toInt()
                binding.prodTotal.setText(prodTotal.toString())

                dialog.dismiss()
            }
            addDialog?.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            rvListaCompra.layoutManager = LinearLayoutManager(context)
            rvListaCompra.adapter = context?.let { ComprasAdapter(it, comprasList) }


            addDialog?.create()
            addDialog?.show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}