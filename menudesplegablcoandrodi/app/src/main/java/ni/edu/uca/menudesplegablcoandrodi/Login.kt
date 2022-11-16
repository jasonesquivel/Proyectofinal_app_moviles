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
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentLoginBinding
import ni.edu.uca.menudesplegablcoandrodi.model.Usuario


class Login : Fragment() {
    private lateinit var  drawer: DrawerLayout
    lateinit var binding: FragmentLoginBinding
    val users = ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.btnLogIn.setOnClickListener {
            var user = binding.etUsername.text.toString()
            var pass = binding.etPassword.text.toString()

            users.add(Usuario("Admin","1234"))
            users.add(Usuario("Jason","Esquivel"))

            if(users.contains(Usuario(user,pass))){
                it.findNavController().navigate(R.id.login_navhome)
            }
            if(user.isEmpty() && pass.isEmpty()){
                Toast.makeText(context,"Campos vacios", Toast.LENGTH_SHORT).show()
            }

            (activity as AppCompatActivity).supportActionBar?.show()
        }

    }


}