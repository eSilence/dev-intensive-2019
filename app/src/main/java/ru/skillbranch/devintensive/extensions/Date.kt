package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

/*
Date.format
Необходимо реализовать extension для форматирования вывода даты экземпляра класса Date по заданному паттерну
Реализуй extension Date.format(pattern) возвращающий отформатированную дату по паттерну передаваемому в качестве аргумента (значение по умолчанию "HH:mm:ss dd.MM.yy" локаль "ru")
Пример:
Date().format() //14:00:00 27.06.19
Date().format("HH:mm") //14:00
 */
fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("rus"))
    return dateFormat.format(this)
}