package com.gquesada.notes.ui.notes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.gquesada.notes.R
import com.gquesada.notes.domain.models.NoteModel
import com.gquesada.notes.domain.models.TagModel
import com.gquesada.notes.ui.notes.viewmodels.NoteListViewModel
import java.util.Date
import kotlin.random.Random


class AddNoteFragment : Fragment() {

    private lateinit var viewModel: NoteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_note, container, false)
        viewModel = ViewModelProvider(this)[NoteListViewModel::class.java]
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById(R.id.button_add_note)

        button.setOnClickListener {

            val title: String = view.findViewById<EditText?>(R.id.editText_title_note).text.toString()
            val description: String = view.findViewById<EditText?>(R.id.editText_description_note).text.toString()
            val tagTitle: String = view.findViewById<EditText?>(R.id.editText_tag_title).text.toString()
            val date: String = view.findViewById<EditText?>(R.id.editTextDate_note_date).text.toString()
            val noteModel = NoteModel(generateRandomNumber(),title,description, TagModel(generateRandomNumber(),tagTitle), date.toInt())

            Log.v("Tag", noteModel.toString())

            addNote(noteModel)
        }

        viewModel.onViewReady()
    }

    fun addNote(noteModel: NoteModel) {
        viewModel.addNote(noteModel)
        requireFragmentManager().popBackStack()
    }


    fun generateRandomNumber(): Int {
        val randomNumber: Int = Random.nextInt(100000, 999999)
        return randomNumber
    }

}