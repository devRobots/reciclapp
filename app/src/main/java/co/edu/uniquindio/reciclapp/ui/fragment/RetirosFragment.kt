package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.adapter.TabRetiroAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RetirosFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    //private val adapter by lazy { TabRetiroAdapter(requireContext() as FragmentActivity) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

        ): View? {
        val root = inflater.inflate(R.layout.fragment_retiros, container, false)

        tabLayout = root.findViewById(R.id.tab_layout)
        viewPager = root.findViewById(R.id.view_pager)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        val adapter = TabRetiroAdapter(context as FragmentActivity)
        viewPager.adapter = adapter
        val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager,
                TabLayoutMediator.TabConfigurationStrategy{ tab, position ->
                    when(position){
                        0 -> {
                            tab.text = "Lista Retiros" }
                        1 -> {
                            tab.text = "Lista Pendientes??"
                        }
                    }
                })
        tabLayoutMediator.attach()

    }

}