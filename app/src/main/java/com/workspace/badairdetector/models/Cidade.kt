package com.workspace.badairdetector.models

import java.io.Serializable

data class Cidade (
    var aqi : Int? = 0,
    var idx : Int? = 0
    //var city : City? = null
) : Serializable