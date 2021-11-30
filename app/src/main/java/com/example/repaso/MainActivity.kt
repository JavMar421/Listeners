package com.example.repaso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.repaso.databinding.ActivityMainBinding
import kotlin.random.Random

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Los Listeners espera a un evento para ejecutarse

        //binding.id_del_objeto.etc...


        //Cuando Click Hacer{}

        //Cuando se Pulse Boton se escribe un numero aleatorio del 1 al 100 en un textview
        binding.b1.setOnClickListener {
            val nAleatorio = Random.nextInt(1, 101)
            binding.tv1.text = nAleatorio.toString()
            binding.tv1.visibility= View.VISIBLE
        }
        //Cuando se Pulse Boton se escribe una letra aleatoria en un textview
        binding.b1.setOnClickListener {
            val letras = 'a'..'z'
            var lAleatorio = letras.random()
            binding.tv1.text = lAleatorio.toString()
            binding.tv1.visibility= View.VISIBLE
        }
        //Cuando se Pulse Boton se escribe una palabra de 5 car aleatoria en un textview
        binding.b1.setOnClickListener {
            val letras = 'a'..'z'
            var pAleatorio = ""
            repeat(5){pAleatorio=pAleatorio+letras.random()}
            binding.tv1.text = pAleatorio
            binding.tv1.visibility= View.VISIBLE
        //Toas MEnsaje emergente
            Toast.makeText(this, "Escribe algo primero", Toast.LENGTH_LONG).show()
        }

        //Hacer cada vez que cambia el Texto
        binding.t1.doOnTextChanged { text, start, before, count ->
            text?.let { safeText->
                var con=0
                safeText.forEach {
                    if(it == ' '){con++}
                }
                if (con==4){binding.b1.visibility= View.VISIBLE}

                else{binding.b1.visibility= View.GONE}
                }

            }


    }
}
