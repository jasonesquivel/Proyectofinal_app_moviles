package ni.edu.uca.menudesplegablcoandrodi.model

import android.content.Context

class Preferen(val context: Context) {
    val SHARED_NAME = "Bd"
    val SHARED_USER_LOGIN = "User"
    val SHARED_USER_PASS = "Pass"
    val SHARED_USER_SAL = "Sal"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun SaveUsuario(User: String) {
        storage.edit().putString(SHARED_USER_LOGIN, User).apply()
    }

    fun SavePass(Pass: String) {
        storage.edit().putString(SHARED_USER_PASS, Pass).apply()
    }

    fun getUSer(): String {
        return storage.getString(SHARED_USER_LOGIN, "")!!
    }

    fun getPass(): String {
        return storage.getString(SHARED_USER_PASS, "")!!
    }
    fun SaveSal(Sal: String) {
        storage.edit().putString(SHARED_USER_SAL, Sal).apply()
    }

    fun getSal(): String {
        return storage.getString(SHARED_USER_SAL, "")!!
    }


}