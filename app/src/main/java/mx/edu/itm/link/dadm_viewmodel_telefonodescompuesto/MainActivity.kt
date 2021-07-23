package mx.edu.itm.link.dadm_viewmodel_telefonodescompuesto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import mx.edu.itm.link.dadm_viewmodel_telefonodescompuesto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Llamada del Fragmneto al activity
        val fragmento = supportFragmentManager.findFragmentById(R.id.fragmento) as Fragment
        //editText de nuestro activity
        val editText = binding.editTextActivity

        binding.btnEnviarActivity.setOnClickListener {
            //Sacra el editText del activity
            val texto = "Activity dijo: ${editText.text}"
            //Vaciar campo (editText)
            editText.setText("")
            //Llamado del editText del Fragmento 1
            val ediTextFragment1 = fragmento.activity?.findViewById<EditText>(R.id.editTextFragmento1)
            //Se llama el texto al ediText
            ediTextFragment1?.setText(texto)

        }
    }
}