package rs.raf.projekatjun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekatjun.contract.MainContract
import rs.raf.projekatjun.databinding.ActivityMainBinding
import rs.raf.projekatjun.models.EventEntity
import rs.raf.projekatjun.viewmodel.MainViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        initUI()
        initListeners()
    }

    private fun initUI(){

    }

    private fun initListeners(){
        binding.btnAddEvent.setOnClickListener(){
            val intent = Intent(this, AddEventActivity::class.java)
            startActivity(intent)
        }

        binding.btnShowEvents.setOnClickListener{
            val intent = Intent(this, ShowEventActivity::class.java)
            startActivity(intent)
        }

    }

}