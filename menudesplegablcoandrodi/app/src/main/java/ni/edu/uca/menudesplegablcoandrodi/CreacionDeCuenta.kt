package ni.edu.uca.menudesplegablcoandrodi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import ni.edu.uca.menudesplegablcoandrodi.R
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentCreacionDeCuentaBinding
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentLoginBinding
import ni.edu.uca.menudesplegablcoandrodi.model.Shared.Companion.preferen


class CreacionDeCuenta : Fragment() {
    private lateinit var  drawer: DrawerLayout
    lateinit var binding: FragmentCreacionDeCuentaBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCreacionDeCuentaBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.hide()
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegistro.setOnClickListener {
            val user = binding.etUsuario.text.toString()
            val pass = binding.etContraseA.text.toString()
            preferen.SaveUsuario(user)
            preferen.SavePass(pass)
            it.findNavController().navigate(R.id.login)

            (activity as AppCompatActivity).supportActionBar?.show()
        }

    }


}