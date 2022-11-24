package ni.edu.uca.menudesplegablcoandrodi
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.menudesplegablcoandrodi.databinding.FragmentVarianzaSalarialBinding
import ni.edu.uca.menudesplegablcoandrodi.model.Shared
import ni.edu.uca.menudesplegablcoandrodi.model.Shared.Companion.preferen


class VarianzaSalarial : Fragment() {
    private lateinit var binding: FragmentVarianzaSalarialBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVarianzaSalarialBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        var msnsal = Shared.preferen.getSal()
        var msnsalario = Shared.preferen.getSalSalario()
        binding.tvSalarioActual.setText(msnsalario)
        binding.tvSaldoActual.setText(msnsal)
        binding.btnGuardar.setOnClickListener {
            calcularIngresoActual()
        }

    }




    private fun calcularIngresoActual() {

        val valueInTextField = binding.etNuevoSalarioCordobas.text.toString()


        if (valueInTextField.isEmpty() ) {
            Toast.makeText(context, "Por favor llene todos los campos!", Toast.LENGTH_SHORT).show()

        }
        else {
            var msnsal = Shared.preferen.getSal().toInt()
            var msnsalario = Shared.preferen.getSalSalario().toInt()
            var nuevoSalario: Int = binding.etNuevoSalarioCordobas.text.toString().toInt()
            var total = (msnsal + nuevoSalario)
            var totalS = (msnsalario + nuevoSalario)
            preferen.SaveSal(total.toString())
            preferen.SaveSalario(totalS.toString())
            binding.tvSaldoActual.setText(total.toString())
            binding.tvSalarioActual.setText(totalS.toString())


            Toast.makeText(context, "Información laboral actualizada!", Toast.LENGTH_SHORT).show()
            binding.etNuevoSalarioCordobas.setText("")
        }


    }


}