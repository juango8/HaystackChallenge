package com.juango.haystackchallenge.ui

import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import com.juango.haystackchallenge.model.Card

class CardPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = CustomCardView(parent.context)
        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true

        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        (viewHolder.view as CustomCardView).bind(item as Card)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with(viewHolder.view as CustomCardView){
            photo = null
            imageTitle = null
            imageAuthorDate = null
        }
    }

}