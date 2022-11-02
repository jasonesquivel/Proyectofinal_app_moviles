package ni.edu.uca.yourwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.yourwallet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}