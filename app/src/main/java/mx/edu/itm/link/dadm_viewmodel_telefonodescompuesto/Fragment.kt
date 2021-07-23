package mx.edu.itm.link.dadm_viewmodel_telefonodescompuesto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import mx.edu.itm.link.dadm_viewmodel_telefonodescompuesto.databinding.FragmentBinding


class Fragment : Fragment() {

    private var _binding: FragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: Fragment2ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mensaje = binding.editTextFragmento1
        binding.btnEnviarFragmento1.setOnClickListener {
            //Se obtiene el mensaje con el observe(), de l avariable que se tienen en el viewModel
            viewModel.setMensaje("Fragmento 1 dijo: ${mensaje.text}")
            viewModel.mensaje.observe(viewLifecycleOwner, Observer<String> { datos ->
                println("Desde Fragmento 1> $datos")
            })
            //Se limpia el campo
            binding.editTextFragmento1.setText("")
        }
    }
}