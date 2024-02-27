package com.example.comicslibrary

import java.math.BigInteger
import java.security.MessageDigest

fun getHash(timestamp: String, publicKey: String, privateKey: String): String {
    val hashStr = timestamp + publicKey + privateKey
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(hashStr.toByteArray())).toString(16).padStart(32, '0')
}