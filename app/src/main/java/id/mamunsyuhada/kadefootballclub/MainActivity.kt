package id.mamunsyuhada.kadefootballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listClub = findViewById<RecyclerView>(R.id.rvClubList)
        inisialisasiKomponen()

        listClub.layoutManager = LinearLayoutManager(this)
        listClub.adapter = RecyclerViewAdapter(this, items){
            klubDiklik(it)
        }
    }

    private fun klubDiklik(it: Item) {
        val toast = Toast.makeText(applicationContext, it.namaKlub, Toast.LENGTH_SHORT)
        toast.show()

        startActivity<DetailClubActivity>(
                DetailClubActivity.NAMAKLUB to it.namaKlub,
                DetailClubActivity.LOGOKLUB to it.logoKlub,
                DetailClubActivity.DESKRIPSIKLUB to it.deskripsiKlub)
    }

    private fun inisialisasiKomponen() {
        val namaClub = resources.getStringArray(R.array.nama_klub)
        val imgClub = resources.obtainTypedArray(R.array.img_klub)
        val descriptionClub = resources.getStringArray(R.array.deskripsi_klub)

        items.clear()
        for (i in namaClub.indices) {
            items.add(Item(namaClub[i],
                    imgClub.getResourceId(i, 0), descriptionClub[i]))
        }

        imgClub.recycle()
    }
}
