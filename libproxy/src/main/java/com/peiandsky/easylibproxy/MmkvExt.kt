package com.peiandsky.easylibproxy

import android.content.Context
import com.tencent.mmkv.MMKV

//针对mmkv的扩展使用，可以替代SharedPreference，无关Context


fun initMMKV(context: Context) {
    MMKV.initialize(context)
}


fun containSpKey(key: String): Boolean {
    return MMKV.defaultMMKV().containsKey(key)
}

fun saveSPString(key: String, value: String?) {
    MMKV.defaultMMKV().putString(key, value)
}

fun getSPString(key: String, defaultValue: String?): String? {
    return MMKV.defaultMMKV().getString(key, defaultValue)
}

fun saveSPInt(key: String, value: Int?) {
    MMKV.defaultMMKV().putInt(key, value ?: Int.MAX_VALUE)
}

fun getSPInt(key: String, defaultValue: Int?): Int? {
    val v = MMKV.defaultMMKV().getInt(key, defaultValue ?: Int.MAX_VALUE)
    if (v == Int.MAX_VALUE) {
        return null
    }
    return v
}

fun saveSPLong(key: String, value: Long?) {
    MMKV.defaultMMKV().putLong(key, value ?: Long.MAX_VALUE)
}

fun getSPLong(key: String, defaultValue: Long?): Long? {
    val v = MMKV.defaultMMKV().getLong(key, defaultValue ?: Long.MAX_VALUE)
    if (v == Long.MAX_VALUE) {
        return null
    }
    return v
}

fun saveSPBoolean(key: String, value: Boolean) {
    MMKV.defaultMMKV().putBoolean(key, value)
}

fun getSPBoolean(key: String, defaultValue: Boolean): Boolean {
    return MMKV.defaultMMKV().getBoolean(key, defaultValue)
}



