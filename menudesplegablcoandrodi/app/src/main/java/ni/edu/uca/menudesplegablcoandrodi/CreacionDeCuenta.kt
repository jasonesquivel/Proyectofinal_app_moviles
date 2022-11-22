package ni.edu.uca.menudesplegablcoandrodi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import ni.edu.uca.menudesplegablcoandrodi.R
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentCreacionDeCuentaBinding
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentLoginBinding
import ni.edu.uca.menudesplegablcoandrodi.model.Shared.Companion.preferen


class CreacionDeCuenta : Fragment() {
    private lateinit var drawer: DrawerLayout
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
        binding = FragmentCreacionDeCuentaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.hide()
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegistro.setOnClickListener {
            val name = binding.etNombre.text.toString()
            val lastname = binding.etApellido.text.toString()
            val email = binding.etCorreo.text.toString()
            val sal = binding.etSaldoactual.text.toString()
            val salario = binding.etSalario.text.toString()
            val user = binding.etUsuario.text.toString()
            val pass = binding.etContraseA.text.toString()
            val Cpass = binding.etCfContraseA.text.toString()

            if (name.isEmpty() || lastname.isEmpty() || email.isEmpty() || user.isEmpty()
                || pass.isEmpty() || sal.isEmpty() || salario.isEmpty() || Cpass.isEmpty()) {
                Toast.makeText(this.context, "Campos vacios", Toast.LENGTH_SHORT).show()
            } else {
                preferen.SaveUsuario(user)
                preferen.SavePass(pass)
                preferen.SaveSal(sal)
                preferen.SaveSalario(salario)
                it.findNavController().navigate(R.id.login)

                (activity as AppCompatActivity).supportActionBar?.show()
            }
        }

    }


}