package rs.raf.projekatjun.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.projekatjun.contract.MainContract
import rs.raf.projekatjun.models.EventEntity
import rs.raf.projekatjun.models.EventResponse
import rs.raf.projekatjun.repositories.EventRepository
import timber.log.Timber

class MainViewModel(private val eventRepository: EventRepository): ViewModel(), MainContract.ViewModel{

    private val subscriptions = CompositeDisposable()

    override val events: MutableLiveData<List<EventEntity>> = MutableLiveData()
    override val time: MutableLiveData<EventResponse> = MutableLiveData()


    override fun addEvent(eventEntity: EventEntity) {
        val subscription = eventRepository
            .insert(eventEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("COMPLETE")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getAllEvents() {
        val subscription = eventRepository
            .getAllEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    events.value=it
                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("ON COMPLETE")
                }
            )
        subscriptions.add(subscription)
    }

    override fun deleteEvent(eventEntity: EventEntity) {
        val subscription = eventRepository
            .deleteEvent(eventEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("Yes")
                },
                {
                    Timber.e("NO")
                }
            )
        subscriptions.add(subscription)
    }

    override fun fetchAll(par: String) {
        val subscription = eventRepository
            .fetchAll(par)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    time.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    //override fun fetchAll(par: String) {
        //val subscription = eventRepository
            //.fetchAll(par)
            //.subscribeOn(Schedulers.io())
            //.observeOn(AndroidSchedulers.mainThread())
            //.subscribe(
               // {
                  //  Timber.e("$it")
                //},
                //{

                   // Timber.e(it)
                //}
            //)
        //subscriptions.add(subscription)
    //}


    override fun onCleared() {
        subscriptions.clear()
        super.onCleared()
    }
}