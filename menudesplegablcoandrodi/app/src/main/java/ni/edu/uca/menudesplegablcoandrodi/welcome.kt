package ni.edu.uca.menudesplegablcoandrodi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentWelcomeBinding

class welcome : Fragment() {

    lateinit var binding: FragmentWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (activity as AppCompatActivity).supportActionBar?.hide()
        super.onViewCreated(view, savedInstanceState)

        //(activity as AppCompatActivity).supportActionBar?.hide()
        binding.btnLogin.setOnClickListener {

            it.findNavController().navigate(R.id.welcome_login)


        }

        binding.btnRegistrarse.setOnClickListener {

            it.findNavController().navigate(R.id.welcome_creacionDeCuenta)


        }

    }



}