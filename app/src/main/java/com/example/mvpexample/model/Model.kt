package com.example.mvpexample.model

import android.os.Handler
import com.example.mvpexample.Contract
import java.util.*


class Model : Contract.Model {
    // array list of strings from which
    // random strings will be selected
    // to display in the activity
    private val arrayList =
        listOf(
            "DSA Self Paced: Master the basics of Data Structures and Algorithms to solve complex problems efficiently. ",
            "Cyber Security: This course will guide you with theory,lecture videos, weekly assignments " +
                    "contests and doubt assistance.",
            "Android Series: Test your skill & give the final touch to your preparation for " +
                    "Android development.",
            "Complete Interview Preparation: Cover all the important concepts and topics required for the interviews. " +
                    "Get placement ready before the interviews begin",
            "Low Level Design : Learn Object-oriented Analysis and Design to prepare"

        )

    // this method will invoke when
    // user clicks on the button
    // and it will take a delay of
    // 1200 milliseconds to display next course detail
    override fun getNextCourse(onFinishedListener: Contract.Model.OnFinishedListener?) {
        Handler().postDelayed({ onFinishedListener!!.onFinished(getRandomString) }, 1200)
    }


    // method to select random
    // string from the list of strings
    private val getRandomString: String
        private get() {
            val random = Random()
            val index = random.nextInt(arrayList.size)
            return arrayList[index]
        }
}

