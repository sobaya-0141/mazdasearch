package sobaya.app.mazdasearch.util

import android.graphics.*
import com.squareup.picasso.Transformation
import java.util.*

class RoundTransformation(val radius: Float = 500f, val margin: Float = 0f): Transformation {

    override fun key(): String {
        return "key" + Random().nextInt()
    }

    override fun transform(source: Bitmap): Bitmap {

        val paint = Paint()

        paint.isAntiAlias = true
        paint.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        val output = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_4444)
        val canvas = Canvas(output)

        canvas.drawRoundRect(RectF(margin, margin, source.width - margin, source.height - margin),
                radius, radius, paint)

        if (source != output)
            source.recycle()

        return output
    }
}