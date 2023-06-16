package com.example.lintfen.extensions

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun Activity.intentTo(to: Activity){
    startActivity(Intent(this, to::class.java))
}

fun Activity.intentToFinish(to: Activity){
    startActivity(Intent(this, to::class.java))
    this.finish()
}

fun Activity.intentToFinishPrevious(to: Activity){
    val intent = Intent(this, to::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
}

fun Activity.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.longToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.hideKeyboard() {
    val imm: InputMethodManager =
        this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view: View? = this.currentFocus
    //If no view currently has focus, create a new one, just so we can grab a window token from it
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}
