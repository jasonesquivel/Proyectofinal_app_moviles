package ni.edu.uca.menudesplegablcoandrodi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import ni.edu.uca.menudesplegablcoandrodi.R
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentLoginBinding
import ni.edu.uca.menudesplegablcoandrodi.model.Shared.Companion.preferen
import ni.edu.uca.menudesplegablcoandrodi.model.Usuario


class Login : Fragment() {
    private lateinit var drawer: DrawerLayout
    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

            try {
                binding.btnLogIn.setOnClickListener {
                    val nameTemp: String = binding.etUsername.text.toString()
                    val pwdTemp: String = binding.etPassword.text.toString()

                    if (nameTemp == preferen.getUSer() && pwdTemp == preferen.getPass()) {
                        Navigation.findNavController(binding.root).navigate(R.id.nav_home)
                    } else {
                        Toast.makeText(this.context, "Datos erroneos", Toast.LENGTH_SHORT).show()
                    }
                    (activity as AppCompatActivity).supportActionBar?.show()
                }
            } catch (ex: Exception) {
            }



    }


}