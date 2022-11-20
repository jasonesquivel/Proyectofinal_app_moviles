package ni.edu.uca.menudesplegablcoandrodi.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComprasViewModel : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is items Fragment"
    }
    val text: LiveData<String> = _text
}