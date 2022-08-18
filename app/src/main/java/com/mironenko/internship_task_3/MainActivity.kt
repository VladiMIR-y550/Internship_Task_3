package com.mironenko.internship_task_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mironenko.internship_task_3.ui.list.UserListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container_fragments, UserListFragment.newInstance())
                .commit()
        }
    }
}