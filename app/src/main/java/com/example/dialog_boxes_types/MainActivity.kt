package com.example.dialog_boxes_types

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.example.dialog_boxes_types.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button1.setOnClickListener {

            val builder1 = AlertDialog.Builder(this)

            builder1.setIcon(R.drawable.notification_icon)
            builder1.setTitle("Alert Dialog Box")
            builder1.setMessage("message box")
            builder1.setPositiveButton("Yes"){dialogInterface, _ ->
                Toast.makeText(this, "U clicked Yes", Toast.LENGTH_SHORT).show()
            }
            builder1.setNegativeButton("No"){dialogInterface, _ ->
                Toast.makeText(this, "U clicked No", Toast.LENGTH_SHORT).show()

            }
            builder1.setNeutralButton("Cancel"){dialogInterface, _ ->
                dialogInterface.dismiss()
            }
             builder1.show()
        }

        binding.button2.setOnClickListener {
            val builder2 = AlertDialog.Builder(this)

            builder2.setIcon(R.drawable.notification_icon)
            builder2.setTitle("Array Dialog Box")
            val arr = arrayOf("A","B","C","D")

            builder2.setSingleChoiceItems(arr,0){_, which ->
                Toast.makeText(this, "U clicked on ${arr[which]}", Toast.LENGTH_SHORT).show()
            }
            builder2.setPositiveButton("Yes"){dialogInterface, _ ->
                Toast.makeText(this, "U clicked Yes", Toast.LENGTH_SHORT).show()
            }
            builder2.setNegativeButton("No"){dialogInterface, _ ->
                Toast.makeText(this, "U clicked No", Toast.LENGTH_SHORT).show()
            }
            builder2.setNeutralButton("Cancel"){dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            builder2.show()
        }

        binding.button3.setOnClickListener {

            val builder3 = AlertDialog.Builder(this)

            builder3.setIcon(R.drawable.notification_icon)
            builder3.setTitle("Array Dialog Box")
            val arr = arrayOf("A","B","C","D")
            var checked = booleanArrayOf(false,false,false,false)

            builder3.setMultiChoiceItems(arr,checked){_,which,isChecked ->
                if(isChecked)
                {
                    Toast.makeText(this, "U clicked on ${arr[which]}", Toast.LENGTH_SHORT).show()
                }
            }
            builder3.setPositiveButton("Yes"){dialogInterface, _ ->
                Toast.makeText(this, "U clicked Yes", Toast.LENGTH_SHORT).show()
            }
            builder3.setNegativeButton("No"){dialogInterface, _ ->
                Toast.makeText(this, "U clicked No", Toast.LENGTH_SHORT).show()
            }
            builder3.setNeutralButton("Cancel"){dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            builder3.show()
        }

    }
}
