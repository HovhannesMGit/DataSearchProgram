package com.art.task

import com.art.taskPrivate.Tag


class TagSuggestionController (private val dataList: List<Tag>) : SuggestionController<Tag>
{
    override var recent: MutableList<String> = mutableListOf()

    override fun getInformation(username: String): Tag? {

        for (el in dataList) {
            if(el.art == username) {

                if(!recent.contains(el.art)) {
                    recent.add(el.art)
                }
                return el
            }
        }

        return null
    }

    override fun search(searchingItem: String): MutableList<String> {
        val matchedArt: MutableList<String> = mutableListOf()

        for(el in searchOfTags(searchingItem) ){
            matchedArt.add(el.art)
        }
        return matchedArt
    }

    private fun searchOfTags(searchingItem: String): MutableList<Tag> {

        val allMatchedTags: MutableList<Tag> = mutableListOf()

        for(el in dataList){

            if(el.art.contains(searchingItem,false)) {

                allMatchedTags.add(el)
            }
        }

        return allMatchedTags
    }
}