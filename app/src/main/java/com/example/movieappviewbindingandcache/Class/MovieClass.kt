package com.example.movieappviewbindingandcache.Class

import java.io.Serializable

class MovieClass:Serializable {

    var date: String? = null
    var title: String? = null
    var subtitle: String? = null
    var authors: String? = null

    constructor()
    constructor(date: String?, title: String?, subtitle: String?, authors: String?) {
        this.date = date
        this.title = title
        this.subtitle = subtitle
        this.authors = authors
    }
}