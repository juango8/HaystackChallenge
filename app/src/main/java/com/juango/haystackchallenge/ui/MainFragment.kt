package com.juango.haystackchallenge.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.leanback.app.VerticalGridSupportFragment
import androidx.leanback.widget.*
import com.juango.haystackchallenge.R
import com.juango.haystackchallenge.model.Card

class MainFragment : VerticalGridSupportFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val gridPresenter = VerticalGridPresenter(ZOOM_FACTOR)
        gridPresenter.numberOfColumns = COLUMNS
        setGridPresenter(gridPresenter)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        badgeDrawable = ResourcesCompat.getDrawable(resources, R.drawable.title, null)
        title = "PHOTO SEARCH"

        setOnSearchClickedListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }
        searchAffordanceColor = R.color.colorSearchButton

        setupRowAdapter()
    }

    private fun setupRowAdapter() {
        val mAdapter = ArrayObjectAdapter(CardPresenter())
        adapter = mAdapter

        prepareEntranceTransition()
        createRows(mAdapter)
        startEntranceTransition()
    }

    private fun createRows(mAdapter: ArrayObjectAdapter) {
        (1..9).forEach { image ->
            mAdapter.add(
                Card(
                    title = "Nüsse",
                    author = "$3.99/lb",
                    localImageResource = "food_0$image"
                )
            )
        }
    }

    companion object {
        private const val COLUMNS = 3
        private const val ZOOM_FACTOR = FocusHighlight.ZOOM_FACTOR_MEDIUM
    }
}