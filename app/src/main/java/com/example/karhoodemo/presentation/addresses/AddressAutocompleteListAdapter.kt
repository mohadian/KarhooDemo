package com.example.karhoodemo.presentation.addresses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.example.karhoodemo.R
import com.example.karhoodemo.databinding.SearchAddressListItemBinding
import com.example.karhoodemo.domain.model.Address
import com.example.karhoodemo.presentation.common.binding.DataBoundListAdapter
import com.example.karhoodemo.threading.AppExecutors

class AddressAutocompleteListAdapter(
    appExecutors: AppExecutors,
    private val repoClickCallback: ((Address) -> Unit)?
) : DataBoundListAdapter<Address, SearchAddressListItemBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<Address>() {
        override fun areItemsTheSame(oldItem: Address, newItem: Address): Boolean {
            return oldItem.placeId == newItem.placeId
        }

        override fun areContentsTheSame(oldItem: Address, newItem: Address): Boolean {
            return oldItem.displayAddress.equals(newItem.displayAddress) && oldItem.placeId.equals(newItem.placeId)
        }
    }) {

    override fun createBinding(parent: ViewGroup): SearchAddressListItemBinding {
        val binding = DataBindingUtil.inflate<SearchAddressListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.search_address_list_item,
            parent,
            false
        )
        binding.root.setOnClickListener {
            binding.address?.let {
                repoClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: SearchAddressListItemBinding, item: Address) {
        binding.address = item
    }
}
