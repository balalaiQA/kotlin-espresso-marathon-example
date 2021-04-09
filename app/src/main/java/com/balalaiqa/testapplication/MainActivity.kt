package com.balalaiqa.testapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var loginAdapter: LoginAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginAdapter = LoginAdapter(mutableListOf())

        loginList.adapter = loginAdapter
        loginList.layoutManager = LinearLayoutManager(this)

        addLoginButton.setOnClickListener {
            val loginTitle = loginInput.text.toString()
            if(loginTitle.isNotEmpty()) {
                val login = Login(loginTitle)
                loginAdapter.addLogin(login)
                loginInput.text.clear()
            }
        }
        deleteSelectedLoginsButton.setOnClickListener {
            loginAdapter.deleteSelectedLogins()
        }
    }
}