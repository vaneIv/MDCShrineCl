package com.vane.android.mdcshrinecl

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vane.android.mdcshrinecl.network.ImageRequester
import com.vane.android.mdcshrinecl.network.ProductEntry

/**
 * Adapter used to show a simple grid of products.
 */
class ProductCardRecyclerViewAdapter(private val productList: List<ProductEntry>) :
    RecyclerView.Adapter<ProductCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardViewHolder {
        val layoutView =
            LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)

        return ProductCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
        // TODO: Put ViewHolder binding code here in MDC-102
        if (position < productList.size) {
            val product = productList[position]
            holder.productTitle.text = product.title
            holder.productPrice.text = product.price
            ImageRequester.setImageFromUrl(holder.productImage, product.url)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}