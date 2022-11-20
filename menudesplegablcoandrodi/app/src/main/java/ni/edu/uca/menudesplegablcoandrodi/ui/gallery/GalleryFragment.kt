package ni.edu.uca.menudesplegablcoandrodi.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.menudesplegablcoandrodi.R
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentGalleryBinding
import ni.edu.uca.menudesplegablcoandrodi.model.UserData
import ni.edu.uca.menudesplegablcoandrodi.view.UserAdapter

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root


        galleryViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lista= listOf("Vacaciones","Remuneracion economica")
        val adaptador = context?.let { ArrayAdapter(it,android.R.layout.simple_spinner_item,lista) }
        binding.mySpinner.adapter=adaptador

        binding.mySpinner.onItemSelectedListener= object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2==1){
                    addInfo()
                }
                else{

                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun addInfo() {
        with(binding) {
            val inflter = LayoutInflater.from(context)
            val v = inflter.inflate(R.layout.add_remuneracion_vacaciones, null)
            val username = v.findViewById<EditText>(R.id.etuserNa)

            val addDialog = context?.let { AlertDialog.Builder(it) }
            addDialog?.setView(v)
            addDialog?.setPositiveButton("ok"){
                    dialog,_->  val names = username.text.toString()
                dialog.dismiss()
            }
            addDialog?.setNegativeButton("cancel"){
                    dialog,_->
                dialog.dismiss()
            }



            addDialog?.create()
            addDialog?.show()



        }
    }

}