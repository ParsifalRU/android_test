package rvadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.DataModel
import com.sirius.test_app.MainActivity
import com.sirius.test_app.R
import com.sirius.test_app.ReviewModel
import com.squareup.picasso.Picasso

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.CommentHolder>() {

    private val dm = DataModel()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CommentHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_rv, viewGroup, false)

        return CommentHolder(view)
    }

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        holder.onBind(dm.reviews[position])
    }

    override fun getItemCount(): Int {
        return dm.reviews.size
    }

    class CommentHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val username: TextView = view.findViewById(R.id.tv_rec1)
        private val reviewDate: TextView = view.findViewById(R.id.tv_rec2)
        private val review: TextView = view.findViewById(R.id.tv_rec3)
        private val avatar: ImageView = view.findViewById(R.id.imgv)

        fun onBind(reviewModel: ReviewModel) {
            Picasso.with(MainActivity().baseContext)
                .load(reviewModel.userImage)
                .placeholder(R.drawable.ic_baseline_data_usage_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(avatar)

            username.text = reviewModel.userName
            reviewDate.text = reviewModel.date
            review.text = reviewModel.message
        }
    }
}