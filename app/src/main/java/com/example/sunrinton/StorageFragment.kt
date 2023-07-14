@file:Suppress("UNREACHABLE_CODE")

package com.example.sunrinton

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.sunrinton.databinding.FragmentStorageBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StorageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StorageFragment : Fragment() {
    val db = Firebase.firestore// Firestore 인스턴스 선언
    val booklist = arrayListOf<Book>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_storage, container, false)
        db.collection( "books")
            .get()
            .addOnSuccessListener { result ->
                booklist.clear()
                for (document in result) {  // 가져온 문서들은 result에 들어감
                    val item = Book(document["name"] as String, document["audio"] as String, document["author"] as String, document["image"] as String)
                    booklist.add(item)
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(context, "${exception}", Toast.LENGTH_SHORT).show();
            }
        for ( i in booklist )
        {
            var url: Uri? = Uri.parse("${i.image}")
            Glide.with(this)
                .load(url)
                .placeholder(R.drawable.chaeho)
                .into(myView.findViewById(R.id.audio1))
        }

        return myView

    }

}