package com.art.task

import com.art.taskPrivate.ParentOfUserAndTag



fun main()
{
    menu()
}


fun menu()
{
    val userSuggestionController: SuggestionController<ParentOfUserAndTag> = UserSuggestionController(userList)
    val tagSuggestionController: SuggestionController<ParentOfUserAndTag> = TagSuggestionController(tagList)
    do {
        descriptionOfMenu()

        val input = inputWithAsperandOrOctothorpe()
        when {
            input == "@" -> println("Result: ${userSuggestionController.recent}")
            input == "#" -> println("Result: ${tagSuggestionController.recent}")
            input[0] == '@' -> searchingTagOrUser(userSuggestionController, input)
            input[0] == '#' -> searchingTagOrUser(tagSuggestionController, input)
        }

    }while(input != "exit")
}




fun searchingTagOrUser(ref: SuggestionController<ParentOfUserAndTag>, userInput: String)
{
    var input = userInput.removeRange(0,1) // this line removes # and @ characters
    val searchedResult: MutableList<String> = ref.search(input)
    println("Result: $searchedResult\n")

    println("Type item that you interested in")
    input = notNullInput()
    val tagOrUserInfo: ParentOfUserAndTag? = ref.getInformation(input)

    if(tagOrUserInfo != null) {
        println("Selected user: $tagOrUserInfo")
    }
    else {
        println("Nothing is found")
    }



}

fun descriptionOfMenu()
{
    println("\nPlease enter username or hashtag")
    println("Note: hashtags should start with # and username with @")
    println("Enter # to see recent tags")
    println("Enter @ to see recent users")
    println("Enter \"exit\" to end the program")
}

fun notNullInput() : String
{
    var userInput : String?

    do {

        userInput = readLine()
        if(userInput != null) return userInput

    }while (true)

}

// startsWithAmpersatOrOctothorpe should return string which first character is either # or @
fun inputWithAsperandOrOctothorpe(): String {

    var input: String

    do {
        input = notNullInput()

        when {
            input.isEmpty() -> input = " " // in this line we're not letting input to be empty
            input == "exit" -> return input
            input[0] != '@' && input[0] != '#' -> {
                println("Wrong input")
                println("Your input should start with # or @")
            }
        }
    }while(input[0] != '@' && input[0] != '#')

    return input
}


