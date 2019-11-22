package com.art.task


interface SuggestionController<out T> {

    var recent: MutableList<String>

    fun search(searchingItem: String): MutableList<String>
    fun getInformation(username: String): T?
}

