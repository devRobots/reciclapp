package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.edu.uniquindio.reciclapp.R
import com.getbase.floatingactionbutton.FloatingActionsMenu
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeAdminFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_admin, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fab: FloatingActionsMenu? = activity?.findViewById(R.id.fabMenuAdmin)
        fab?.visibility = View.VISIBLE
    }

}