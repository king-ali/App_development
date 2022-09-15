package com.example.recorder1

import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    lateinit var mr : MediaRecorder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var path:String = Environment.getExternalStorageDirectory().toString() + "/myrec.3gp"
        val contextWrapper = ContextWrapper(applicationContext)
        val documentDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(documentDirectory, "recording" + "3gp")
        var path:String = file.path.toString()
//        var path:String = Environment.getExternalStorageDirectory().absolutePath.toString() + "/myrec.mp3"


        mr = MediaRecorder()

        button.isEnabled = false
        button2.isEnabled = false

//    Write code for permission
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO,
                                                                                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 111)

            button.isEnabled = true

//    Code for start recording
        button.setOnClickListener {
            mr.setAudioSource(MediaRecorder.AudioSource.MIC)
            mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            mr.setOutputFile(path)
            mr.prepare()
            mr.start()
            button2.isEnabled = true
            button.isEnabled = false
        }

//        Stop Recording
        button2.setOnClickListener {
            mr.stop()
            button.isEnabled = true
            button2.isEnabled = false
        }

//        Play recording
        button3.setOnClickListener {
            var mp = MediaPlayer()
            mp.setDataSource(path)
            mp.prepare()
            Thread.sleep(1000);
            mp.start()
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            button.isEnabled = true
    }


    private fun getFilePath(): String? {
        val contextWrapper = ContextWrapper(applicationContext)
        val documentDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(documentDirectory, "BoletaTikonsil" + "3gp")
        return file.path
    }






    
}


