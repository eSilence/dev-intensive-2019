package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/*  1 задание
DTO User, Factory
Необходимо создать data класс User и реализовать Factory для создания экземпляров класса
Создай data class User содержащий сделующие свойства:
val id : String,
var firstName : String?,
var lastName : String?,
var avatar : String?,
var rating : Int = 0,
var respect : Int = 0,
var lastVisit : Date? = Date(),
var isOnline : Boolean = false

Реализуй паттерн Factory с методом makeUser(fullName) принимающий в качесте аргумента полное имя пользователя и возвращающий экземпляр класса User
 */
data class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false){

    constructor(id:String, firstName:String?, lastName:String?) :
            this(id = id, firstName = firstName, lastName = lastName, avatar = null)

    constructor(id:String) :
            this(id, "John", "Doe $id")

    init{
        println("It's alive!! $id '$firstName' '$lastName'" )
    }

    companion object Factory { //перед созданием объекта необходимо сделать какие-либо преоразования
        private var lastId:Int = -1

        fun makeUser(fullName:String?): User{
            lastId++

            return User("$lastId",
                Utils.parseFullName(fullName).first,
                Utils.parseFullName(fullName).second)
        }
    }
/*
Паттерн Builder
Необходимо реализовать Builder для класса User
+2
Реализуй паттерн Builder для класса User.
User.Builder().id(s)
.firstName(s)
.lastName(s)
.avatar(s)
.rating(n)
.respect(n)
.lastVisit(d)
.isOnline(b)
.build() должен вернуть объект User
 */


}