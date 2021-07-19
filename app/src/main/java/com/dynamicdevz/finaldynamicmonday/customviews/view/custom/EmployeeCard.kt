package com.dynamicdevz.finaldynamicmonday.customviews.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.dynamicdevz.finaldynamicmonday.databinding.EmployyeCardLayoutBinding

class EmployeeCard(context: Context, attr: AttributeSet): CardView(context, attr) {

    private val binding = EmployyeCardLayoutBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    init {

    }




}