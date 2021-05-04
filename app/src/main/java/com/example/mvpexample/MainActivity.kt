package com.example.mvpexample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvpexample.model.Model
import com.example.mvpexample.presenter.Presenter


class MainActivity : AppCompatActivity(), Contract.View {

    private var textView: TextView? = null
    private var button: Button? = null
    private var progressBar: ProgressBar? = null

    // creating object of Presenter interface in Contract
    var presenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)


        presenter = Presenter(this, Model())
        this.button!!.setOnClickListener(View.OnClickListener { presenter!!.onButtonClick() })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }


    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        textView!!.visibility = View.INVISIBLE
    }


    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        textView!!.visibility = View.VISIBLE
    }

    // method to set random string
    // in the Course Detail TextView
    override fun setString(string: String?) {
        textView!!.text = string
    }
}

