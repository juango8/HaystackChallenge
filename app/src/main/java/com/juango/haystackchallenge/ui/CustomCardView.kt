package com.juango.haystackchallenge.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.leanback.widget.BaseCardView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.juango.haystackchallenge.R
import com.juango.haystackchallenge.model.Card

class CustomCardView : BaseCardView {
    var photo: ImageView? = null
    var imageTitle: TextView? = null
    var imageAuthorDate: TextView? = null

    constructor(context: Context?) : super(context) {
        initLayout()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initLayout()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        initLayout()
    }

    private fun initLayout() {
        isFocusable = true
        isFocusableInTouchMode = true
        val inflater = LayoutInflater.from(context)
        val v = inflater.inflate(layoutResource, this)
        imageTitle = v.findViewById(R.id.image_title)
        imageAuthorDate = v.findViewById(R.id.image_author_date)
        photo = v.findViewById(R.id.photo)
    }

    @SuppressLint("SetTextI18n")
    fun bind(card: Card) {
        val resourceId: Int = context.resources.getIdentifier(
            card.localImageResource,
            IMAGE_PACKAGE,
            context.packageName
        )
        photo?.let {
            Glide.with(context)
                .load(resourceId)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(it)
        }
        imageTitle?.text = card.title
        imageAuthorDate?.text = "${card.title}/${card.author}"
    }

    private val layoutResource: Int
        get() = R.layout.custom_card_view

    companion object {
        const val IMAGE_PACKAGE = "drawable"
    }
}