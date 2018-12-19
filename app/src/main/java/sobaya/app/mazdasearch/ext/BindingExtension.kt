package sobaya.app.mazdasearch.ext

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.SearchView
import com.squareup.picasso.Picasso
import sobaya.app.mazdasearch.util.RoundTransformation


@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageurl: String?) {
    if (null != imageurl) {
        Picasso.with(this.context).load(imageurl).into(this)
    }
}

@BindingAdapter("imageResource")
fun ImageView.setImageResource(resource: Int?) {
    if (null != resource)
        Picasso.with(this.context).load(resource).into(this)
}

@BindingAdapter("userImage")
fun ImageView.setRountImage(imageUrl: String?) {
    if (null != imageUrl) {
        Picasso.with(this.context).load(imageUrl).transform(RoundTransformation()).into(this)
    }
}

@BindingAdapter("queryTextListener")
fun SearchView.queryTextListener(listener: SearchView.OnQueryTextListener) {
    setOnQueryTextListener(listener)
}