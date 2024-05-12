package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.noteapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddBinding
    private lateinit var db:NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=NoteDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title=binding.titleEditText.text.toString()
            val content=binding.contentEditText.text.toString()
            val note=Note(0,title,content)
            db.insertNotes(note)
            finish()
            Toast.makeText(this,"note saved",Toast.LENGTH_SHORT).show()


        }


    }
}