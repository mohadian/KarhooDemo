package com.example.karhoodemo.presentation.addresses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.example.karhoodemo.R
import com.example.karhoodemo.databinding.FragmentAddressesBinding
import com.example.karhoodemo.di.Injectable
import com.example.karhoodemo.di.KarhooViewModelFactory
import com.example.karhoodemo.presentation.common.RetryCallback
import com.example.karhoodemo.presentation.common.autoCleared
import com.example.karhoodemo.threading.AppExecutors
import javax.inject.Inject

class AddressesFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: KarhooViewModelFactory
    @Inject
    lateinit var appExecutors: AppExecutors

    lateinit var viewModel: AddressAutocompleteViewModel

    var binding by autoCleared<FragmentAddressesBinding>()
    var adapter by autoCleared<AddressAutocompleteListAdapter>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_addresses,
            container,
            false
        )
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.address_autocomplete_title)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel =
            ViewModelProviders.of(this, viewModelFactory)
                .get(AddressAutocompleteViewModel::class.java)

        binding.setLifecycleOwner(viewLifecycleOwner)

        adapter = AddressAutocompleteListAdapter(appExecutors) {
            //            navController().navigate(
//                SearchMoviesFragmentDirections.actionSearchMovieFragmentToMovieFragment(
//                    it.id
//                )
//            )
        }

        binding.retryCallback = object : RetryCallback {
            override fun retry() {
                viewModel.retry()
            }
        }

        binding.addresses = viewModel.addresses

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.setQuery(it)
                }
                binding.searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    viewModel.setQuery("")
                    return true
                }
                return false
            }
        })

        initAddressesList()

    }

    private fun initAddressesList() {
        binding.addressesList.adapter = adapter
        viewModel.addresses.observe(viewLifecycleOwner, Observer {
            if (it?.data != null) {
                adapter.submitList(it.data.values)
            } else {
                adapter.submitList(emptyList())
            }
        })
    }

    private fun navController() = findNavController()
}
