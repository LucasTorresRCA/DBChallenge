package com.example.desafiodb.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.desafiodb.R
import com.example.desafiodb.network.service.BackendService
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val service: BackendService = BackendService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || username.isBlank()) {
                etUsername.error = getString(R.string.error_username)
                return@setOnClickListener
            }

            if (password.isEmpty() || password.isBlank()) {
                etPassword.error = getString(R.string.error_password)
                return@setOnClickListener
            }

            flLoader.visibility = View.VISIBLE
            service.postLogin(username, password) { login, message ->
                flLoader.visibility = View.GONE
                if (!message.isNullOrEmpty() || !message.isNullOrBlank() || login === null) {
                    AlertDialog.Builder(this).apply {
                        setTitle(R.string.title_error)
                        setMessage(message ?: getString(R.string.error_unexpected))
                        setNeutralButton(R.string.action_ok, null)
                    }.show()
                    return@postLogin
                }

                startActivity(
                    Intent(this, StatementActivity::class.java)
                        .putExtra("token", login.token)
                )
            }
        }
    }
}