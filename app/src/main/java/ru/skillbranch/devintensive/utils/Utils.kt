package ru.skillbranch.devintensive.utils
/* 3 задание
Реализуй метод Utils.parseFullName(fullName) принимающий в качестве аргумента полное имя пользователя (null, пустую строку) и возвращающий пару значений Pair(firstName, lastName) при невозможности распарсить полное имя или его часть вернуть null null/"firstName" null
Пример:
Utils.parseFullName(null) //null null
Utils.parseFullName("") //null null
Utils.parseFullName(" ") //null null
Utils.parseFullName("John") //John null
*/

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        val result: Pair<String?, String?> = Pair((if(firstName == "")null else firstName), (if(lastName == "")null else lastName))
        return result
    }
}