package com.example.mad_ind05_jaffri_faisal
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_ind05_jaffri_faisal.databinding.ListItemsBinding
import layout.State

import android.widget.AdapterView.OnItemClickListener


class MyAdapter(val stateList: List<State>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

private lateinit var mlistner: OnItemClickListener
    interface OnItemClickListener{

        fun onItemClick(position: Int)


    }

    fun setOnItemClickListner(listner: OnItemClickListener){
        mlistner = listner
    }

    inner class MyViewHolder(val binding: ListItemsBinding, listner: OnItemClickListener ) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(state: State){
            binding.stateName.text = state.name
            binding.nickName.text = state.nickname

        }
        init {
                itemView.setOnClickListener{
                    listner.onItemClick(bindingAdapterPosition)

                }
        }


    }
    // Holds the views for adding it to image and text

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false),mlistner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val state = stateList[position]
        holder.bindItem(state)




    }

    override fun getItemCount(): Int {
        return stateList.size
    }

}

private fun OnItemClickListener.onItemClick(bindingAdapterPosition: Int) {
}


