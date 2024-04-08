package rs.raf.projekatjun

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

import rs.raf.projekatjun.contract.MainContract
import rs.raf.projekatjun.databinding.ActivityAddEventBinding
import rs.raf.projekatjun.models.EventEntity
import rs.raf.projekatjun.viewmodel.MainViewModel
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class AddEventActivity : AppCompatActivity() {

    private val mainViewModel: MainContract.ViewModel by viewModel<MainViewModel>()

    private lateinit var binding: ActivityAddEventBinding

    private lateinit var calendar: Calendar
    private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener

    private lateinit var calendar2: Calendar
    private lateinit var timeSetListener: TimePickerDialog.OnTimeSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        initUI()
        initListeners()
    }

    private fun initUI(){
        initDatePicker()
        initTimePicker()
        initSpinner()
        initAutoComplete()
        //mainViewModel.fetchAll("Belgrade")
        //Timber.e(mainViewModel.time.value?.datetime.toString())
    }

    private fun initDatePicker(){
        calendar = Calendar.getInstance()
         dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            binding.btnSetdate.setText(sdf.format(calendar.time))

        }
    }

    private fun initTimePicker(){
        calendar2 = Calendar.getInstance()
        timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            calendar2.set(Calendar.HOUR_OF_DAY, hour)
            calendar2.set(Calendar.MINUTE, minute)
            binding.btnSettime.setText(SimpleDateFormat("HH:mm").format(calendar2.time))
        }
    }

    private fun initSpinner(){
        val difficulties = resources.getStringArray(R.array.difficulties)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, difficulties)
        binding.eventSpinner.adapter = adapter
    }

    private fun initAutoComplete(){
        val cities = resources.getStringArray(R.array.cities)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
        binding.eventAutocomplete.setAdapter(adapter)

    }

    private fun initListeners(){
        binding.btnSetdate.setOnClickListener{
            DatePickerDialog(this@AddEventActivity, dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.btnSettime.setOnClickListener{
            TimePickerDialog(this, timeSetListener, calendar2.get(Calendar.HOUR_OF_DAY), calendar2.get(Calendar.MINUTE), true).show()
        }

        binding.btnSaveEvent.setOnClickListener{
            val ime = binding.eventName.text.toString()
            val opis = binding.eventDescription.text.toString()
            val datum = binding.btnSetdate.text.toString()
            val vreme = binding.btnSettime.text.toString()
            val url = binding.eventUrl.text.toString()
            val difficulty = binding.eventSpinner.selectedItem.toString()

            val eventEntity = EventEntity(0,ime,opis,datum,vreme,url,difficulty)

            mainViewModel.addEvent(eventEntity)

            binding.eventName.setText("")
            binding.eventDescription.setText("")
            binding.btnSetdate.setText("set date")
            binding.btnSettime.setText("set time")
            binding.eventUrl.setText("")

        }

        binding.btnChecktime.setOnClickListener(){
            val myCity = binding.eventAutocomplete.text.toString()
            mainViewModel.fetchAll(myCity)
            Timber.e(mainViewModel.time.value?.datetime.toString())
            if(mainViewModel.time.value?.datetime!=null)
            binding.btnChecktime.setText(mainViewModel.time.value?.datetime.toString())
        }

    }

}