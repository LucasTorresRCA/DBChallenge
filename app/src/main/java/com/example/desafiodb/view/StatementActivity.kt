package com.example.desafiodb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodb.R
import com.example.desafiodb.adapter.InstallmentAdapter
import com.example.desafiodb.model.Statement
import com.example.desafiodb.network.service.BackendService
import kotlinx.android.synthetic.main.activity_statement.*

class StatementActivity : AppCompatActivity() {
    private val service = BackendService()

    private val adapter: InstallmentAdapter by lazy {
        return@lazy InstallmentAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statement)

        rvStatement.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvStatement.adapter = adapter

        val token = intent.getStringExtra("token") ?: return
        flLoader.visibility = View.VISIBLE
        service.getStatement(token) { statement, error ->
            flLoader.visibility = View.GONE
            if (statement == null || !error.isNullOrBlank() || !error.isNullOrEmpty()) {
                Toast.makeText(this, error ?: getString(R.string.error_unexpected), Toast.LENGTH_LONG).show()
                return@getStatement
            }
            //Populate Recycler and Header
            populateScreen(statement)
        }
    }

    private fun populateScreen(statement: Statement) {
        tvClientName.text = statement.name
        tvAvailable.text = statement.limits?.available
        tvLimit.text = statement.limits?.total
        tvUsed.text = statement.limits?.expent
        adapter.installments = statement.installments
    }
}