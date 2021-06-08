package com.example.desafiodb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodb.R
import com.example.desafiodb.model.Installment
import kotlinx.android.synthetic.main.row_statement.view.*

class InstallmentAdapter(context: Context) :
    RecyclerView.Adapter<InstallmentAdapter.InstallmentViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var items: ArrayList<Installment> = ArrayList()
    var installments: List<Installment>
        set(value) {
            items = ArrayList(value)
            notifyDataSetChanged()
        }
        get() = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstallmentViewHolder {
        return InstallmentViewHolder(
            inflater.inflate(R.layout.row_statement, parent, false)
        )
    }

    override fun onBindViewHolder(holder: InstallmentViewHolder, position: Int) {
        val installment: Installment = items[position]
        holder.itemView.run {
            tvStoreName.text = installment.detail.store
            tvProductName.text = installment.detail.name
            tvQuota.text =
                String.format(context.getString(R.string.format_quota), installment.installment)
            tvValue.text = installment.value
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class InstallmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}