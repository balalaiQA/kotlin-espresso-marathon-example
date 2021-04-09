package com.balalaiqa.testapplication

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_login.view.*

class LoginAdapter(
    private val logins: MutableList<Login>
) : RecyclerView.Adapter<LoginAdapter.LoginViewHolder>() {

    class LoginViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        return LoginViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_login,
                parent,
                false
            )
        )
    }

    fun addLogin(login: Login) {
        logins.add(login)
        notifyItemInserted(logins.size - 1)
    }

    fun deleteSelectedLogins() {
        logins.removeAll { login ->
            login.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(loginTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            loginTitle.paintFlags = loginTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            loginTitle.paintFlags = loginTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: LoginViewHolder, position: Int) {
        val currentLogin = logins[position]
        holder.itemView.apply {
            loginTitle.text = currentLogin.title
            loginCheckBox.isChecked = currentLogin.isChecked
            toggleStrikeThrough(loginTitle, currentLogin.isChecked)
            loginCheckBox.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(loginTitle, isChecked)
                currentLogin.isChecked = !currentLogin.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return logins.size
    }
}


















