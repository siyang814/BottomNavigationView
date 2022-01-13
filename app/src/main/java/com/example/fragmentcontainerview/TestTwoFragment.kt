package com.example.fragmentcontainerview

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val KEY_MSG = "MSG"
private const val KEY_NUM = "NUM"
// private var count = 1
class TestTwoFragment : Fragment() {
    companion object {
        /*这里传入参数*/
        fun newInstance(msg: String, num: Int) = TestFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_MSG,msg)
                putInt(KEY_NUM, num)
            }
        }
    }
    private lateinit var viewModel: TestViewModel
    private var msg: String? = null
    private var num: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        /*获取参数*/
        arguments?.let {
            msg = it.getString(KEY_MSG)
            num = it.getInt(KEY_NUM)
        }
        /*此时不能使用参数num,否则会报错*/
        var result = num?.plus(1)
        Log.i("FCVT","MSG: $msg, NUM: ${num}")
        //count++
    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.w("MYUTIL", "onCreateView=${javaClass.simpleName};code=${javaClass.hashCode()}")
        val rootView:View = inflater.inflate(R.layout.test_fragment, container, false)
        val tvMsg: TextView = rootView.findViewById(R.id.tvMsg)
        tvMsg.text = "MSG: $msg, NUM: $num"
        return rootView
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onResume() {
        super.onResume()
        Log.w("MYUTIL", "onResume=${javaClass.simpleName}")
    }

    override fun onStart() {
        super.onStart()
        Log.w("MYUTIL", "onStart=${javaClass.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("MYUTIL", "onDestroy=${javaClass.simpleName};code=${javaClass.hashCode()}")
    }

}