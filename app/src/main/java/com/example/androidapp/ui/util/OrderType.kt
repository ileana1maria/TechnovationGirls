package com.example.androidapp.ui.util


// The types of ordering ascending and descending
sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}