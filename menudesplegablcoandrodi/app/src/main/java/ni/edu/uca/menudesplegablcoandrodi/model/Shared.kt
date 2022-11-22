package ni.edu.uca.menudesplegablcoandrodi.model

import android.app.Application

class Shared : Application() {
    companion object {
        lateinit var preferen: Preferen
    }

    override fun onCreate() {
        super.onCreate()
        preferen = Preferen(applicationContext)
    }
}
