package com.ew.hello.IClass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ew.hello.R

/*----------------------------------
* @创建者 EWinner
* @创建时间 2020.10.2020/10/3-13:54
*---------------------------------*/
class LeftFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.left_fragment,container,false)
    }
}