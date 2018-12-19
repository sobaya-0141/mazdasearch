package sobaya.app.mazdasearch.ext

import android.app.Activity
import android.arch.lifecycle.*
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import org.reactivestreams.Publisher


fun <X, Y> LiveData<X>.switchMap(func: (X) -> LiveData<Y>)
        = Transformations.switchMap(this, func)!!

fun <X, Y> LiveData<X>.map  (func: (X) -> LiveData<Y>)
        = Transformations.map(this, func)!!

fun <T> Publisher<T>.toLiveData() = LiveDataReactiveStreams.fromPublisher(this)

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T?) -> Unit) = observe(owner, object : Observer<T> {
    override fun onChanged(v: T?) {
        observer.invoke(v)
    }
})

fun isEmptyOrNull(value: Any?): Boolean = null == value || value == ""

fun isNotEmptyAndNull(value: Any?): Boolean = !isEmptyOrNull(value)

fun hideKeybord(activity: Activity, view: View) {

    (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(view.windowToken, 0)
}

fun showKeybord(activity: Activity, view: View) {
    (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(view, 0)
}