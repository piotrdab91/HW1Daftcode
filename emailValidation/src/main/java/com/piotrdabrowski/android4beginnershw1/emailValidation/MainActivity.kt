package com.piotrdabrowski.android4beginnershw1.emailValidation

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkButton.setOnClickListener { view: View ->

                    if(isEmailValid(editText.text.toString())){
                                AlertDialog.Builder(this)
                                        .setMessage("Email poprawny")
                                        .setNeutralButton("OK", DialogInterface.OnClickListener {dialog: DialogInterface , id: Int ->
                                            dialog.dismiss()
                                        } )
                                        .show()
                            }
                    else {
                        AlertDialog.Builder(this)
                                .setMessage("Email jest niepoprawny. Czy chcesz go zachować ?")
                                .setNeutralButton("Zachowaj", DialogInterface.OnClickListener
                                    {dialog: DialogInterface , id: Int ->
                                        dialog.dismiss();} )
                                .setNegativeButton("Wyczyść", DialogInterface.OnClickListener
                                    {dialog: DialogInterface , id: Int ->
                                        editText.text.clear()
                                        dialog.dismiss();} )
                                .show()

                    }
        }


    }
}