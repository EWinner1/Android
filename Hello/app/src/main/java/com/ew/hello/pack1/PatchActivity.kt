package com.ew.hello.pack1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ew.hello.IClass.Msg
import com.ew.hello.IClass.MsgAdapter
import com.ew.hello.R
import kotlinx.android.synthetic.main.activity_patch.*

class PatchActivity : AppCompatActivity(), View.OnClickListener {

        private val msgList = ArrayList<Msg>()

        private lateinit var adapter: MsgAdapter//延迟初始化

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_patch)
            initMsg()
            val layoutManager = LinearLayoutManager(this)
            patchRe.layoutManager = layoutManager
            if (!::adapter.isInitialized) {
                adapter = MsgAdapter(msgList)
            }
            patchRe.adapter = adapter
            patchButton.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when (v) {
                patchButton -> {
                    val content = patchET.text.toString()
                    if (content.isNotEmpty()) {
                        val msg = Msg(content, Msg.TYPE_SENT)
                        msgList.add(msg)
                        adapter.notifyItemInserted(msgList.size - 1) // 当有新消息时，刷新RecyclerView中的显示
                        patchRe.scrollToPosition(msgList.size - 1)  // 将 RecyclerView定位到最后一行
                        patchET.setText("") // 清空输入框中的内容
                        val tempmsg = Msg("??", Msg.TYPE_RECEIVED)
                        msgList.add(tempmsg)
                        patchRe.scrollToPosition(msgList.size - 1)  // 将 RecyclerView定位到最后一行
                    }
                }
            }
        }

        private fun initMsg() {
            val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
            msgList.add(msg1)
            val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
            msgList.add(msg2)
            val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
            msgList.add(msg3)
        }

    }
