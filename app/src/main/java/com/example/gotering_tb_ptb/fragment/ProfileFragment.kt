package com.example.gotering_tb_ptb.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.gotering_tb_ptb.Activity.EditProfileActivity
import com.example.gotering_tb_ptb.Activity.TambahMenuActivity
import com.example.gotering_tb_ptb.Activity.TentangKamiActivity
import com.example.gotering_tb_ptb.Activity.TransaksiActivity
import com.example.gotering_tb_ptb.R

class ProfileFragment : Fragment() {

    private lateinit var profileImageView: ImageView
    private lateinit var imageUri: Uri



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        profileImageView = view.findViewById(R.id.photo_profile)


        val chooseImageButton: Button = view.findViewById(R.id.chooseImageButton)
        val editProfileButton: Button = view.findViewById(R.id.editprofileButton)
        val tambahmenuButton: Button = view.findViewById(R.id.tambahmenuButton)
        val transaksiButton: Button = view.findViewById(R.id.transaksiButton)
        val tentangkamiButton: Button = view.findViewById(R.id.tentangkamiButton)
        val exitButton: Button = view.findViewById(R.id.exitButton)


        chooseImageButton.setOnClickListener {
            pickImageFromGallery()
        }

        editProfileButton.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }
        tambahmenuButton.setOnClickListener {
            val intent = Intent(activity, TambahMenuActivity::class.java)
            startActivity(intent)
        }
        transaksiButton.setOnClickListener {
            val intent = Intent(activity, TransaksiActivity::class.java)
            startActivity(intent)
        }
        tentangkamiButton.setOnClickListener {
            val intent = Intent(activity, TentangKamiActivity::class.java)
            startActivity(intent)
        }




        return view
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    private fun captureImageFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                PICK_IMAGE_REQUEST -> {
                    val selectedImageUri: Uri? = data?.data
                    if (selectedImageUri != null) {
                        // Menampilkan gambar yang dipilih di ImageView
                        profileImageView.setImageURI(selectedImageUri)
                    }
                }

            }

        }


    }

    fun setUserEmail(s: String) {

    }


    companion object {
        private const val PICK_IMAGE_REQUEST = 1

    }


}





