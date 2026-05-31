package com.example.dialog_boxes_types

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialog_boxes_types.databinding.ActivityMainBinding
import com.example.dialog_boxes_types.databinding.CustomDailogMakingBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setIcon(R.drawable.notification_icon)
            builder1.setTitle("Alert Dialog Box")
            builder1.setMessage("This is a simple alert dialog")
            builder1.setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You clicked Yes", Toast.LENGTH_SHORT).show()
            }
            builder1.setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You clicked No", Toast.LENGTH_SHORT).show()
            }
            builder1.setNeutralButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            builder1.show()
        }

        binding.button2.setOnClickListener {
            val builder2 = AlertDialog.Builder(this)
            builder2.setIcon(R.drawable.notification_icon)
            builder2.setTitle("Single Choice Dialog")
            val arr = arrayOf("A", "B", "C", "D")

            builder2.setSingleChoiceItems(arr, 0) { _, which ->
                Toast.makeText(this, "You clicked on ${arr[which]}", Toast.LENGTH_SHORT).show()
            }
            builder2.setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "Selection accepted", Toast.LENGTH_SHORT).show()
            }
            builder2.setNegativeButton("Decline") { dialog, _ ->
                dialog.dismiss()
            }
            builder2.show()
        }

        binding.button3.setOnClickListener {
            val builder3 = AlertDialog.Builder(this)
            builder3.setIcon(R.drawable.notification_icon)
            builder3.setTitle("Multi Choice Dialog")
            val arr = arrayOf("A", "B", "C", "D")
            val checked = booleanArrayOf(false, false, false, false)

            builder3.setMultiChoiceItems(arr, checked) { _, which, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "Checked: ${arr[which]}", Toast.LENGTH_SHORT).show()
                }
            }
            builder3.setPositiveButton("Done") { _, _ ->
                Toast.makeText(this, "Multi-choice complete", Toast.LENGTH_SHORT).show()
            }
            builder3.setNeutralButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            builder3.show()
        }

        binding.button4.setOnClickListener {

            val dialogBinding = CustomDailogMakingBinding.inflate(layoutInflater)
            val builder4 = AlertDialog.Builder(this)
            builder4.setView(dialogBinding.root)

            val dialog = builder4.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialogBinding.dialogWebview.webViewClient = WebViewClient()
            dialogBinding.dialogWebview.loadUrl("https://github.com/tejasjadhav0704-sketch")

            dialogBinding.button1.setOnClickListener {
                Toast.makeText(this, "Opening GitHub...", Toast.LENGTH_SHORT).show()
                val url = "https://github.com/tejasjadhav0704-sketch"
                startActivity(Intent(Intent.ACTION_VIEW, url.toUri()))
                dialog.dismiss()
            }

            dialogBinding.button2.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}
