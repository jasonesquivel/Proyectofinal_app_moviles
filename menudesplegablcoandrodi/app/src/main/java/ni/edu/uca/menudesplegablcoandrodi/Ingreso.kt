package ni.edu.uca.menudesplegablcoandrodi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentIngresoBinding


class Ingreso : Fragment() {
    private lateinit var binding: FragmentIngresoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIngresoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.btnGuardarSaldo.setOnClickListener {
            calcularIngresos()

        }

    }



    private fun calcularIngresos(){
        val stringInTextField = binding.etIngreso.text.toString()
        val valueInTextField = binding.etRazonIngreso.text.toString()
        val dateInTextField = binding.etFechaIngreso.text.toString()




        if(stringInTextField.isEmpty() || valueInTextField.isEmpty() || dateInTextField.isEmpty()  ){
            Toast.makeText(context,"Por favor llene todos los campos!", Toast.LENGTH_SHORT).show()

        }
        else{
            Toast.makeText(context,"El proceso ha sido exitoso!", Toast.LENGTH_SHORT).show()
        }

        //Error en esta parte del codigo, la aplicacion se detiene cuando se guardan todos los datos
        binding.btnGuardarSaldo.setOnClickListener {
            var saldoActual: Int = binding.etIngreso.text.toString().toInt()
            var saldoIngresado : Int = binding.etRazonIngreso.text.toString().toInt()
            var total : Int = (saldoActual + saldoIngresado)
            binding.tvSaldoActual.setText(total)


        }


    }



}