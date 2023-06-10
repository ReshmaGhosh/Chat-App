package com.app.chatgptapp

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatgptapp.R

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        startHeavyTask();
    }

    private fun startHeavyTask() {
       LongOperation().execute()

    }

    private open inner class LongOperation : AsyncTask<String?, Void?, String?>(){
        override fun doInBackground(vararg params: String?): String? {
            for (i in 0.. 3){
                try {
                    Thread.sleep(1000)
                }
              catch (e:Exception)
              {
                Thread.interrupted()
              }
            }
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
        }

    }
}