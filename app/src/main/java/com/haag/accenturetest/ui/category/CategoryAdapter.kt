package com.haag.accenturetest.ui.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haag.accenturetest.R
import com.haag.accenturetest.model.Book
import com.haag.accenturetest.model.Character
import com.haag.accenturetest.model.House
import com.haag.accenturetest.model.Response
import com.haag.accenturetest.util.region
import kotlinx.android.synthetic.main.item_books.view.*
import kotlinx.android.synthetic.main.item_character.view.*
import kotlinx.android.synthetic.main.item_house.view.*

class CategoryAdapter(
    private val response: Response
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_BOOK = 0
        const val TYPE_HOUSE = 1
        const val TYPE_CHARACTER = 2
    }

    override fun getItemCount(): Int = response.list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (response.type) {
            TYPE_BOOK -> {
                BookViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_books,
                        parent,
                        false
                    )
                )
            }

            TYPE_CHARACTER -> {
                CharacterViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_character,
                        parent,
                        false
                    )
                )

            }

            else -> {
                HouseViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_house,
                        parent,
                        false
                    )
                )

            }
        }


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (response.type) {
            TYPE_BOOK -> {
                val book: Book = response.list[position] as Book

                val viewHolder = holder as BookViewHolder
                viewHolder.bind(book)
            }
            TYPE_CHARACTER -> {
                val character: Character = response.list[position] as Character

                val viewHolder = holder as CharacterViewHolder
                viewHolder.bind(character)
            }

            TYPE_HOUSE -> {
                val house: House = response.list[position] as House

                val viewHolder = holder as HouseViewHolder
                viewHolder.bind(house, holder.itemView)
            }
        }

    }
}

class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var title = view.titleTxt
    private var author = view.authorTxt
    private var pages = view.pagesTxt
    private var mediaType = view.mediaTypeTxt
    private var isnb = view.isnbTxt
    private var publisher = view.publisherTxt
    private var country = view.countryTxt
    private var released = view.releasedTxt

    fun bind(b: Book) {
        title.text = b.title
        for (a in b.authors) author.append("${a}, ")
        pages.text = b.numberOfPages.toString()
        mediaType.text = b.mediaType
        isnb.text = b.isbn
        publisher.text = b.publisher
        country.text = b.country
        released.text = b.released
    }
}

class HouseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var name = view.nameHouseTxt
    private var title = view.titleHouseTxt
    private var img = view.houseImg

    fun bind(h: House, view: View) {
        name.text = h.name
        title.text = h.title

        Glide
            .with(view)
            .load(region(h.region))
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(img);
    }
}

class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var name = view.nameTxt
    private var gender = view.genderTxt
    private var culture = view.cultureTxt
    private var born = view.bornTxt
    private var died = view.deadTxt
    private var titles = view.titleCharacterTxt
    private var aliases = view.aliasestxt
    private var playedBy = view.playedByTxt

    fun bind(c: Character) {
        name.text = c.name
        gender.text = c.gender
        culture.text = c.culture
        born.text = c.born
        died.text = c.died
        for (c in c.titles) titles.append("${c}, ")
        for (c in c.aliases) aliases.append("${c}, ")
        for (c in c.playedBy) playedBy.append("${c}, ")
    }
}