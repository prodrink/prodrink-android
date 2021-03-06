package io.prodrink.ui.catalog

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.viewholders.FlexibleViewHolder
import io.prodrink.R
import io.prodrink.data.models.Category
import kotlinx.android.synthetic.main.catalog_item.view.*

class CatalogHolder(private val view: View, adapter: FlexibleAdapter<*>) :
        FlexibleViewHolder(view, adapter) {

    fun onSetValues(category: Category) {
        view.title.text = category.title

        setImage(category)
    }

    private fun setImage(category: Category) {
        Glide.with(view.context).clear(view.thumbnail)
        if (!category.thumbnail_url.isEmpty()) {
            Glide.with(view.context)
                    .load(category.thumbnail_url)
                    .apply(RequestOptions.centerCropTransform()
                            .placeholder(R.drawable.ic_broken_image_grey_24dp))
                    .into(view.thumbnail)
        }
    }
}