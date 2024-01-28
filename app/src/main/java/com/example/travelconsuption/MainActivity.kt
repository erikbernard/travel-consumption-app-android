package com.example.travelconsuption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.set
import com.example.travelconsuption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalc.setOnClickListener(this)

    }

    private fun isvalid(): Boolean {
        return (binding.editDistance.text.toString().isNotEmpty()
                && binding.editPricePerLiter.text.toString().isNotEmpty()
                && binding.editAutonomy.text.toString().isNotEmpty()
                )
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_Calc) (
                calculate()
                )
    }

    private fun calculate() {
        if (isvalid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPricePerLiter.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            if (autonomy == 0f) {
                Toast.makeText(applicationContext, R.string.no_div_zero, Toast.LENGTH_SHORT).show()
                binding.textResult.text = "R$ 0"
            } else {
                val totalValue = (price * distance) / autonomy
                binding.textResult.text = "R$ ${"%.2f".format(totalValue)}"
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.validation_fill_all_fields,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}