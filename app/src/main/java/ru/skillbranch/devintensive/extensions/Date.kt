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

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

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

/*
*Date.humanizeDiff
Необходимо реализовать extension для форматирования вывода разницы между текущим экземпляром Date
и текущим моментом времени (или указанным в качестве аргумента) в человекообразном формате
Реализуй extension Date.humanizeDiff(date) (значение по умолчанию текущий момент времени) для
форматирования вывода разницы между датами в человекообразном формате, с учетом склонения числительных.
Временные интервалы преобразований к человекообразному формату:
0с - 1с "только что"
1с - 45с "несколько секунд назад"
45с - 75с "минуту назад"
75с - 45мин "N минут назад"
45мин - 75мин "час назад"
75мин 22ч "N часов назад"
22ч - 26ч "день назад"
26ч - 360д "N дней назад"
>360д "более года назад"

Пример:
Date().add(-2, TimeUnits.HOUR).humanizeDiff() //2 часа назад
Date().add(-5, TimeUnits.DAY).humanizeDiff() //5 дней назад
Date().add(2, TimeUnits.MINUTE).humanizeDiff() //через 2 минуты
Date().add(7, TimeUnits.DAY).humanizeDiff() //через 7 дней
Date().add(-400, TimeUnits.DAY).humanizeDiff() //более года назад
Date().add(400, TimeUnits.DAY).humanizeDiff() //более чем через год
 */
fun minutes(num:Long):String{
    if (num % 10 == 1L && num % 100 != 11L) return "минута"
    if (num%10 > 1L && num%10 < 5L && !(num%100>11L && num %100<15L)) return "минуты"
    return "минут"
}
fun hours(num:Long):String{
    if (num % 10 == 1L && num % 100 != 11L) return "час"
    if (num%10 > 1L && num%10 < 5L && !(num%100>11L && num %100<15L)) return "часа"
    return "часов"
}
fun days(num:Long):String{
    if (num % 10 == 1L && num % 100 != 11L) return "день"
    if (num%10 > 1L && num%10 < 5L && !(num%100>11L && num %100<15L)) return "дня"
    return "дней"
}

fun Date.humanizeDiff(nowDate:Date = Date()):String{
    var time = this.time
    var time2:Long = nowDate.time
    var dif = time2 - time
    var result:String
    if (dif>0) {
        if (dif > 0 && dif <= SECOND) result = "только что"
        else if (dif > SECOND && dif <= 45 * SECOND) result = "несколько секунд назад"
        else if (dif > 45 * SECOND && dif <= 75 * SECOND) result = "минуту назад"
        else if (dif > 75 * SECOND && dif <= 45 * MINUTE) result = "${dif / MINUTE} ${minutes(dif / MINUTE)} назад"
        else if (dif > 45 * MINUTE && dif <= 75 * MINUTE) result = "час назад"
        else if (dif > 75 * MINUTE && dif <= 22 * HOUR) result = "${dif / HOUR} ${hours(dif / HOUR)} назад"
        else if (dif > 22 * HOUR && dif <= 26 * HOUR) result = "день назад"
        else if (dif > 26 * HOUR && dif <= 360 * DAY) result = "${dif / DAY} ${days(dif / DAY)} назад"
        else result = "более года назад"
    }else{
        dif = -dif
        if (dif > 0 && dif <= SECOND) result = "только что"
        else if (dif > SECOND && dif <= 45 * SECOND) result = "через несколько секунд"
        else if (dif > 45 * SECOND && dif <= 75 * SECOND) result = "через минуту"
        else if (dif > 75 * SECOND && dif <= 45 * MINUTE) result = "через ${dif / MINUTE} ${minutes(dif / MINUTE)}"
        else if (dif > 45 * MINUTE && dif <= 75 * MINUTE) result = "через час"
        else if (dif > 75 * MINUTE && dif <= 22 * HOUR) result = "через ${dif / HOUR} ${hours(dif / HOUR)}"
        else if (dif > 22 * HOUR && dif <= 26 * HOUR) result = "через день"
        else if (dif > 26 * HOUR && dif <= 360 * DAY) result = "через ${dif / DAY} ${days(dif / DAY)}"
        else result = "более чем через год"
    }
    return  result
    }
