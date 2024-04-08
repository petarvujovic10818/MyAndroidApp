package rs.raf.projekatjun.datasources

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import rs.raf.projekatjun.models.EventResponse

interface EventService{

    @GET("Europe/{city}")
    fun getAll(@Path("city") city:String): Observable<EventResponse>

}