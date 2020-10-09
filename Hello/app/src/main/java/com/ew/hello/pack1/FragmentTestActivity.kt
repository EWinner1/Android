package com.ew.hello.pack1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ew.hello.IClass.AnotherRightFragment
import com.ew.hello.R
import kotlinx.android.synthetic.main.left_fragment.*

class FragmentTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)
        //replaceFragment(RightFragment())
        change.setOnClickListener(){
            replaceFragment(AnotherRightFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout,fragment)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }
}