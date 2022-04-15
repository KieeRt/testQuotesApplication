package com.example.testapplication.model

data class Result(
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
){
    fun print(){
        println("_id:$_id")
        println("author:$author")
        println("authorslug:$authorSlug")
        println("content:$content")
        println("dateAdded:$dateAdded")
        println("dateModified:$dateModified")
        println("lenght:$length")
        println("tags:${tags.joinToString(separator = "") { "${it.toString()}\n" }} ")

    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true

        if(other is Result){
            val tmp : Result = other
            if(this._id == other._id) return true
        }

        return false
    }

    override fun hashCode(): Int {
        return this._id.toInt()
    }


}
