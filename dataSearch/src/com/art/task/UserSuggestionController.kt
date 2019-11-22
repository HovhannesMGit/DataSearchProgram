package com.art.task

import com.art.taskPrivate.User

class UserSuggestionController (private val dataList: List<User>) : SuggestionController<User>
{
    override var recent: MutableList<String> = mutableListOf()

    override fun getInformation(username: String): User? {

        for (el in dataList) {
            if(el.username == username) {

                if(!recent.contains(el.username)) {
                    recent.add(el.username)
                }
                return el
            }
        }

        return null
    }

    override fun search(searchingItem: String): MutableList<String> {

        val matchedUsersUsername: MutableList<String> = mutableListOf()

        for(el in searchOfUsers(searchingItem) ){
            matchedUsersUsername.add(el.username)
        }
        return matchedUsersUsername
    }

    private fun searchOfUsers(searchingItem: String): MutableList<User>
    {
        val allMatchedUsers: MutableList<User> = mutableListOf()

        for(el in dataList){

            if(el.username.contains(searchingItem,false) ||
                el.name.contains(searchingItem,false) ||
                el.surname.contains(searchingItem,false)) {

                allMatchedUsers.add(el)
            }
        }

        return allMatchedUsers
    }
}