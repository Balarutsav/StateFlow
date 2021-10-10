package com.utsav.stateflowdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginRequest {

    constructor(
        username: String,
        password: String,
        device_type: String,
        device_token: String,
        lat: String,
        lng: String
    ) {
        this.username = username
        this.password = password
        this.device_type = device_type
        this.device_token = device_token
        this.lat = lat
        this.lng = lng
    }

    @Expose
    @SerializedName("username")
    var username: String = ""

    @Expose
    @SerializedName("password")
    var password: String = ""

    @Expose
    @SerializedName("device_type")
    var device_type: String = ""

    @Expose
    @SerializedName("device_token")
    var device_token: String = ""

    @Expose
    @SerializedName("lat")
    var lat: String = ""

    @Expose
    @SerializedName("lng")
    var lng: String = ""

}