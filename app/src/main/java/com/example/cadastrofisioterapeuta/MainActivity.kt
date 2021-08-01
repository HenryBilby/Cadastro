package com.example.cadastrofisioterapeuta

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_fisioterapeuta_layout)

        var edtNome = findViewById<EditText>(R.id.edtNome)
        var edtCrefito = findViewById<EditText>(R.id.edtCrefito)
        var rbSexo = findViewById<RadioGroup>(R.id.rdgSexo).checkedRadioButtonId
        var radioButtonSelected = findViewById<RadioButton>(rbSexo)
        var salvar = findViewById<Button>(R.id.btnSalvar)

        salvar?.setOnClickListener{
//            Toast.makeText(this, edtNome.toString(), Toast.LENGTH_LONG).show()

            var fisio = Fisioterapeuta(2,
                edtNome.text.toString(),
                edtCrefito.text.toString().toInt(),
                radioButtonSelected.text.toString())

            lifecycleScope.launch {
                insereFisioterapeuta(fisio)
            }
        }
    }

    suspend fun insereFisioterapeuta(fisioterapeuta: Fisioterapeuta){
        MyDb.getInstance(this).fisioterapeutaDao().insertFisioterapeuta(fisioterapeuta)
    }
}