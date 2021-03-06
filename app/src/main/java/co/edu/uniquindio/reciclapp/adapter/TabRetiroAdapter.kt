package co.edu.uniquindio.reciclapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.edu.uniquindio.reciclapp.ui.fragment.TabRetiroPendienteFragment
import co.edu.uniquindio.reciclapp.ui.fragment.TabRetiroRealizadoFragment

class TabRetiroAdapter(fa: FragmentActivity) :  FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> TabRetiroPendienteFragment()
            else -> TabRetiroRealizadoFragment()
        }
    }

}