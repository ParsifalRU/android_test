package rvadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.DataModel
import com.sirius.test_app.MainActivity
import com.sirius.test_app.R
import com.squareup.picasso.Picasso

class CommentAdapter: RecyclerView.Adapter<CommentAdapter.CommentHolder>() {

    val dm = DataModel()

    class CommentHolder(view: View):RecyclerView.ViewHolder(view) {

        val textvw0: TextView
        val textvw1: TextView
        val textvw2: TextView
        val imgv: ImageView

        init {
            textvw0 = view.findViewById(R.id.tv_rec1)
            textvw1 = view.findViewById(R.id.tv_rec2)
            textvw2 = view.findViewById(R.id.tv_rec3)
            imgv = view.findViewById(R.id.imgv)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CommentHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_rv, viewGroup, false)

        return CommentHolder(view)
    }

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        Picasso.with(MainActivity().baseContext)
            .load(dm.reviews[position].userImage)
            .placeholder(R.drawable.ic_baseline_data_usage_24)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.imgv)

        holder.textvw0.text = dm.reviews[position].userName
        holder.textvw1.text = dm.reviews[position].date
        holder.textvw2.text = dm.reviews[position].message

    }

    override fun getItemCount(): Int {
        return dm.reviews.size
    }

}