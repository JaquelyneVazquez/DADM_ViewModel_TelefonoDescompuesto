package mx.edu.itm.link.dadm_viewmodel_telefonodescompuesto

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import mx.edu.itm.link.dadm_viewmodel_telefonodescompuesto.databinding.Fragment2FragmentBinding

class Fragment2 : Fragment() {

    companion object {
        fun newInstance() = Fragment2()
    }

    private var _binding: Fragment2FragmentBinding? = null
    private val binding get() = _binding!!

    //Uso del viewModel
    private val viewModel: Fragment2ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Las variables del viewModel tienen por defaul un metodo observe(),
        // que hace la revisión de cada una de la svariables del fragmento
        _binding = Fragment2FragmentBinding.inflate(inflater, container, false)
        //Se obtienen el mensaje con el observe() de la variable que tenemos en el viewModel
        viewModel.mensaje.observe(viewLifecycleOwner, Observer { datos ->
            binding.editTextFragmento2.setText(datos)

        })
        //Envio de datos al fragmento 2
        binding.btnEnviarFragmento2.setOnClickListener {
            //Obtencion del mensaje que viene del fragmento 1, desde el viewModel
            val mensaje: String = viewModel.mensaje.value.toString()
            //Se crea el nuevo mensaje
            val nuevoMensaje = "Fragmento 2 dijo: $mensaje"
            //Se limpia el campo
            binding.editTextFragmento2.setText("")
            //Se envia el nuevo mensaje al activity del primer fragmento
            activity?.findViewById<EditText>(R.id.editTextActivity)?.setText(nuevoMensaje)
        }
        return binding.root
    }

}