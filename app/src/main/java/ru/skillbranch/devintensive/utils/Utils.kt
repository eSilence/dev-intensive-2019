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
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        val result: Pair<String?, String?> =
            Pair((if (firstName == "") null else firstName), (if (lastName == "") null else lastName))
        return result
    }

    /*
*toInitials
Необходимо реализовать утилитный метод toInitials(firstName lastName)
принимающий в качестве аргументов имя и фамилию пользователя и
возвращающий его инициалы
Реализуй метод Utils.toInitials(firstName lastName) принимающий в качестве
аргументов имя и фамилию пользователя (null, пустую строку) и возвращающий
строку с первыми буквами имени и фамилии в верхнем регистре
(если один из аргументов null то вернуть один инициал, если оба аргумента null
вернуть null)
Пример:
Utils.toInitials("john" ,"doe") //JD
Utils.toInitials("John", null) //J
Utils.toInitials(null, null) //null
Utils.toInitials(" ", "") //null
     */
    fun toInitials(firstName: String?, lastName: String?): String? {
        var part1 = when (firstName) {
            null -> null
            "" -> null
            " " -> null
            else -> firstName[0].toString().toUpperCase()
        }
        var part2 = when (lastName) {
            null -> null
            "" -> null
            " " -> null
            else -> lastName[0].toString().toUpperCase()
        }

        val result: String? =
            if (part1 != null && part2 != null) part1 + part2 else if (part1 == null && part2 == null) null else if (part1 == null) part2 else part1
        return result
    }
}

