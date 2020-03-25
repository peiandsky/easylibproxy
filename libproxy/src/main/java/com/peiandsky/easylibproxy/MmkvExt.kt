package com.peiandsky.easylibproxy

import android.content.Context
import com.tencent.mmkv.MMKV

//针对mmkv的扩展使用，可以替代SharedPreference，无关Context

object KvExt {
    fun init(context: Context) {
        MMKV.initialize(context)
    }


    fun containKey(key: String): Boolean {
        return MMKV.defaultMMKV().containsKey(key)
    }

    fun saveString(key: String, value: String?) {
        MMKV.defaultMMKV().putString(key, value)
    }

    fun getString(key: String, defaultValue: String?): String? {
        return MMKV.defaultMMKV().getString(key, defaultValue)
    }

    fun saveInt(key: String, value: Int?) {
        MMKV.defaultMMKV().putInt(key, value ?: 0)
    }

    fun getInt(key: String, defaultValue: Int?): Int? {
        return MMKV.defaultMMKV().getInt(key, defaultValue ?: 0)
    }

    fun saveLong(key: String, value: Long?) {
        MMKV.defaultMMKV().putLong(key, value ?: 0)
    }

    fun getLong(key: String, defaultValue: Long?): Long? {
        return MMKV.defaultMMKV().getLong(key, defaultValue ?: 0)
    }

    fun saveBoolean(key: String, value: Boolean) {
        MMKV.defaultMMKV().putBoolean(key, value)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return MMKV.defaultMMKV().getBoolean(key, defaultValue)
    }
}






