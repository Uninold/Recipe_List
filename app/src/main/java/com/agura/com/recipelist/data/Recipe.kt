package com.agura.com.recipelist.data

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by SmartStart on 12/7/17.
 */
data class Recipe(
                    val food_img: Int =0,
                    val food_name: String =" ",
                    val food_desc: String =" ",
                    val food_ingred: String =" ",
                    val food_proced: String =" "
                 ): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(food_img)
        parcel.writeString(food_name)
        parcel.writeString(food_desc)
        parcel.writeString(food_ingred)
        parcel.writeString(food_proced)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}
