package rs.raf.projekatjun.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekatjun.datasources.EventDataBase
import rs.raf.projekatjun.datasources.EventService
import rs.raf.projekatjun.repositories.EventRepository
import rs.raf.projekatjun.repositories.EventRepositoryImpl
import rs.raf.projekatjun.viewmodel.MainViewModel

val eventModule = module {

    viewModel { MainViewModel(eventRepository = get()) }

    single<EventRepository> { EventRepositoryImpl(localDataSource = get(), remoteDataSource = get()) }

    single { get<EventDataBase>().getEventDao() }

    single<EventService> { create(retrofit = get()) }

}