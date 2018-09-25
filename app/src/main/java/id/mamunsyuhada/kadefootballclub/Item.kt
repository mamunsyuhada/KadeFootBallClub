package id.mamunsyuhada.kadefootballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val namaKlub: String?, val logoKlub: Int?, val deskripsiKlub: String?) : Parcelable