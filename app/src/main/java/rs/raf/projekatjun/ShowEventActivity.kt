package rs.raf.projekatjun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekatjun.contract.MainContract
import rs.raf.projekatjun.databinding.ActivityShowEventBinding
import rs.raf.projekatjun.recycler.EventAdapter
import rs.raf.projekatjun.recycler.EventDiffer
import rs.raf.projekatjun.viewmodel.MainViewModel
import rs.raf.projekatjun.viewmodel.TestViewModel
import timber.log.Timber

class ShowEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowEventBinding
    private val mainViewModel: MainContract.ViewModel by viewModel<MainViewModel>()
    private lateinit var eventAdapter: EventAdapter

    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        initUI()
        initObservers()
    }

    private fun initUI(){
        initRecycler()
    }

    private fun initRecycler(){
        binding.listRv.layoutManager = LinearLayoutManager(this)
        eventAdapter = EventAdapter(EventDiffer()){
            Timber.e(it.ime)
            mainViewModel.deleteEvent(it)
        }
        binding.listRv.adapter=eventAdapter
    }

    private fun initObservers(){
        mainViewModel.getAllEvents()
        mainViewModel.events.observe(this, Observer{
            eventAdapter.submitList(it)
        })

    }

}