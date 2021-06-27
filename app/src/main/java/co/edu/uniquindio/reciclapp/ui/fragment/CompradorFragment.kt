package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.reciclapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [CompradorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompradorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comprador, container, false)
    }
}