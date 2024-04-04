package com.dicoding.mytugas

import android.os.Parcel
import android.os.Parcelable

data class Destinasi(
    val name: String,
    val description: String,
    val detailDescription: String,
    val photo: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
//        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(detailDescription)
        parcel.writeInt(photo)
    }

    companion object CREATOR : Parcelable.Creator<Destinasi> {
        override fun createFromParcel(parcel: Parcel): Destinasi {
            return Destinasi(parcel)
        }

        override fun newArray(size: Int): Array<Destinasi?> {
            return arrayOfNulls(size)
        }
    }
}
