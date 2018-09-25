package id.mamunsyuhada.kadefootballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailClubActivity : AppCompatActivity() {

    companion object {
        const  val NAMAKLUB = "namaKlub"
        const  val LOGOKLUB = "logoKlub"
        const  val DESKRIPSIKLUB = "deskripsiKlub"
    }

    private var namaKlub:String = ""
    private var logoKlub: Int = 0
    private var deskripsiKlub: String =""

    lateinit var tvNamaKlub: TextView
    lateinit var ivLogoKlub: ImageView
    lateinit var tvDeskripsiKlub: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scrollView {
            verticalLayout {
                padding = dip(14)

                ivLogoKlub = imageView()
                        .lparams(width = dip(200), height = wrapContent){
                            gravity = Gravity.CENTER
                        }
                tvNamaKlub = textView()
                        .lparams(width = matchParent, height = wrapContent){
                            gravity = Gravity.CENTER
                            topMargin = dip(10)
                        }

                tvDeskripsiKlub = textView()
                        .lparams(width = matchParent, height = wrapContent){
                            margin = dip(20)
                        }.lparams(width = matchParent, height = wrapContent)
            }.lparams(width = matchParent, height = wrapContent)
        }

        namaKlub = intent.getStringExtra(NAMAKLUB)
        logoKlub = intent.getIntExtra(LOGOKLUB, 0)
        deskripsiKlub = intent.getStringExtra(DESKRIPSIKLUB)

        tvNamaKlub.text= namaKlub
        tvNamaKlub.textSize = 40f
        Glide.with(ivLogoKlub).load(logoKlub).into(ivLogoKlub)
        tvDeskripsiKlub.text = deskripsiKlub

    }
}
