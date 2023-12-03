package com.example.gotering_tb_ptb.Activity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.gotering_tb_ptb.R
import com.example.gotering_tb_ptb.databinding.ActivityMainBinding
import com.example.gotering_tb_ptb.fragment.HomeFragment
import com.example.gotering_tb_ptb.fragment.PesananFragment
import com.example.gotering_tb_ptb.fragment.ProfileFragment
import com.example.gotering_tb_ptb.fragment.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fragmentHome: Fragment = HomeFragment()
    private val fragmentPesanan: Fragment = PesananFragment()
    private val fragmentSearch: Fragment = SearchFragment()
    private val fragmentProfile: Fragment = ProfileFragment()

    private val fragmentManager: FragmentManager = supportFragmentManager
    private var active: Fragment = fragmentHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonNavigation()
    }

    private fun callFragment(index: Int, fragment: Fragment) {
        val menuItem: MenuItem = binding.navView.menu.getItem(index)
        menuItem.isChecked = true
        fragmentManager.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }

    private fun buttonNavigation() {
        fragmentManager.beginTransaction().add(binding.container.id, fragmentHome).show(fragmentHome).commit()
        fragmentManager.beginTransaction().add(binding.container.id, fragmentPesanan).hide(fragmentPesanan).commit()
        fragmentManager.beginTransaction().add(binding.container.id, fragmentSearch).hide(fragmentSearch).commit()
        fragmentManager.beginTransaction().add(binding.container.id, fragmentProfile).hide(fragmentProfile).commit()

        binding.navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_pesanan -> {
                    callFragment(1, fragmentPesanan)
                }
                R.id.navigation_search -> {
                    callFragment(2, fragmentSearch)
                }
                R.id.navigation_profile -> {
                    callFragment(3, fragmentProfile)
                }
            }
            false
        }
    }
}
