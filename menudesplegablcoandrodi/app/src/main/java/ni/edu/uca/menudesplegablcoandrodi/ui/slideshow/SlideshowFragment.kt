package ni.edu.uca.menudesplegablcoandrodi.ui.slideshow

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ni.edu.uca.menudesplegablcoandrodi.R
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentSlideshowBinding
import ni.edu.uca.menudesplegablcoandrodi.databinding.ListItemGastosBinding
import ni.edu.uca.menudesplegablcoandrodi.model.UserData
import ni.edu.uca.menudesplegablcoandrodi.view.UserAdapter

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var addsbtn:FloatingActionButton
    private lateinit var recv:RecyclerView
    private lateinit var userList:ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userList = ArrayList<UserData>()

        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root


        slideshowViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inflter = LayoutInflater.from(context)

        val v = inflter.inflate(R.layout.fragment_slideshow, null)
        recv= v.findViewById<RecyclerView>(R.id.mRecycler)




        binding.addingBtn.setOnClickListener{
            addInfo()

        }

    }

    private fun addInfo() {
        with(binding) {
            val inflter = LayoutInflater.from(context)
            val v = inflter.inflate(R.layout.add_item_gasto, null)
            val username = v.findViewById<EditText>(R.id.etuserNa)
            val userno = v.findViewById<EditText>(R.id.etuserNo)
            val addDialog = context?.let { AlertDialog.Builder(it) }
            addDialog?.setView(v)
            addDialog?.setPositiveButton("ok"){
                    dialog,_->  val names = username.text.toString()
                val number = userno.text.toString()
                userList.add(UserData("Nombre: $names","Numero de telefono: $number"))
                dialog.dismiss()
            }
            addDialog?.setNegativeButton("cancel"){
                    dialog,_->
                dialog.dismiss()
            }
            mRecycler.layoutManager = LinearLayoutManager(context)
            mRecycler.adapter = context?.let { UserAdapter(it,userList) }


            addDialog?.create()
            addDialog?.show()



        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}