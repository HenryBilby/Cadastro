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
        var rdgSexo = findViewById<RadioGroup>(R.id.rdgSexo)
        var salvar = findViewById<Button>(R.id.btnSalvar)

        salvar?.setOnClickListener{
            var rbSelected = findViewById<RadioButton>(
                rdgSexo!!.checkedRadioButtonId)

            var fisio = Fisioterapeuta(2,
                edtNome.text.toString(),
                edtCrefito.text.toString().toInt(),
                rbSelected.text.toString())

            lifecycleScope.launch {
                insereFisioterapeuta(fisio)
            }

            Toast.makeText(this,
                "Fisioterapeuta salvo com sucesso",
                Toast.LENGTH_SHORT).show()
        }
    }

    suspend fun insereFisioterapeuta(fisioterapeuta: Fisioterapeuta){
        MyDb.getInstance(this).fisioterapeutaDao().insertFisioterapeuta(fisioterapeuta)
    }
}