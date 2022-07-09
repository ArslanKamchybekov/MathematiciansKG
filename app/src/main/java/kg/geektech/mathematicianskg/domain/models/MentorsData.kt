package kg.geektech.mathematicianskg.domain.models

import android.os.Parcel
import android.os.Parcelable

data class CoursesData(
    val id: Int?,
    val name: String?,
    val teacher: String?,
    val time: String?,
    val description: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(teacher)
        parcel.writeString(time)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CoursesData> {
        override fun createFromParcel(parcel: Parcel): CoursesData {
            return CoursesData(parcel)
        }

        override fun newArray(size: Int): Array<CoursesData?> {
            return arrayOfNulls(size)
        }
    }
}

data class MentorsData(
    val id: Int?,
    val name: String?,
    val school: String?,
    val description: String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(school)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MentorsData> {
        override fun createFromParcel(parcel: Parcel): MentorsData {
            return MentorsData(parcel)
        }

        override fun newArray(size: Int): Array<MentorsData?> {
            return arrayOfNulls(size)
        }
    }

}
