package com.example.myapplication

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class InteractionActivity : AppCompatActivity() {
    lateinit var btnSnackBar: Button
    lateinit var btnAlertDlg: Button
    lateinit var btnToast: Button
    lateinit var main: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_interaction)

        main=findViewById(R.id.main)
        btnSnackBar=findViewById(R.id.btnSnackBar)
        btnToast=findViewById(R.id.btnToast)
        btnAlertDlg=findViewById(R.id.btnAlertdlg)

        btnToast.setOnClickListener{
            Toast.makeText(this@InteractionActivity,
                "Login Success",Toast.LENGTH_LONG).show()
        }

        btnSnackBar.setOnClickListener{
            Snackbar.make(main,
                "Invalid login",
                Snackbar.LENGTH_LONG).setAction("Close",{})
                .show()
        }
        btnAlertDlg.setOnClickListener{
            var alert = AlertDialog.Builder(this@InteractionActivity)
            alert.setTitle("Confirmation")
                .setMessage("Are you sure?")
                .setIcon(R.drawable.wall)
                .setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() })
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->  })

            alert.create().show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSnackBar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}