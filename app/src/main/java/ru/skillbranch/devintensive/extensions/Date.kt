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

/*
Date.add
Необходимо реализовать extension для изменения значения экземпляра Data
(добавление/вычитание) на указанную временную единицу
Реализуй extension Date.add(value, TimeUnits) добавляющий или вычитающий
значение переданное первым аргументом в единицах измерения второго аргумента
(enum TimeUnits [SECOND, MINUTE, HOUR, DAY]) и возвращающий модифицированный
экземпляр Date
Пример:
Date().add(2, TimeUnits.SECOND) //Thu Jun 27 14:00:02 GST 2019
Date().add(-4, TimeUnits.DAY) //Thu Jun 23 14:00:00 GST 2019
 */
const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR



fun Date.add(value:Int, units:TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}