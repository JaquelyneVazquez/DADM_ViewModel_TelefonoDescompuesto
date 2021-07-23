package mx.edu.itm.link.dadm_viewmodel_telefonodescompuesto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment2ViewModel : ViewModel() {
    val mensaje = MutableLiveData<String>()

    //Función para lograr editar la variable
    fun setMensaje(datos: String){
        mensaje.value = datos
    }
}