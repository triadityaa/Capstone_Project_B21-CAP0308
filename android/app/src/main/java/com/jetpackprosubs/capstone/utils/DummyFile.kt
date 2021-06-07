package com.jetpackprosubs.capstone.utils

import com.jetpackprosubs.capstone.data.Provinsi

//Data berasal dari https://kekerasan.kemenpppa.go.id/ringkasan
//diambil sekitar pukul 11:00 , 2 Juni 2021
object DummyFile {
    fun dummyProv(): ArrayList<Provinsi>{
        val provinsi = ArrayList<Provinsi>()
        provinsi.add(Provinsi("Aceh",227,189,144))
        provinsi.add(Provinsi("Bali",38,30,16))
        provinsi.add(Provinsi("Bangka Belitung",53,45,30))
        provinsi.add(Provinsi("Banten",182,160,119))
        provinsi.add(Provinsi("Bengkulu",25,25,22))
        provinsi.add(Provinsi("DIY Yogyakarta",217,191,94))
        provinsi.add(Provinsi("DKI Jakarta",57,40,49))
        provinsi.add(Provinsi("Gorontalo",102,78,65))
        provinsi.add(Provinsi("Jambi",116,91,72))
        provinsi.add(Provinsi("Jawa Barat",427,372,311))
        provinsi.add(Provinsi("Jawa Tengah",674,624,390))
        provinsi.add(Provinsi("Jawa Timur",467,398,324))
        provinsi.add(Provinsi("Kalimantan Barat",115,108,81))
        provinsi.add(Provinsi("Kalimantan Selatan",78,66,55))
        provinsi.add(Provinsi("Kalimantan Tengah",40,34,37))
        provinsi.add(Provinsi("Kalimantan Timur",170,151,114))
        provinsi.add(Provinsi("Kalimantan Utara",54,48,32))
        provinsi.add(Provinsi("Kepulauan Riau",119,119,91))
        provinsi.add(Provinsi("Lampung",177,168,154))
        provinsi.add(Provinsi("Maluku",82,67,53))
        provinsi.add(Provinsi("Maluku Utara",45,42,26))
        provinsi.add(Provinsi("NTB",202,178,112))
        provinsi.add(Provinsi("NTT",167,147,81))
        provinsi.add(Provinsi("Papua",10,9,4))
        provinsi.add(Provinsi("Papua Barat",35,24,13))
        provinsi.add(Provinsi("Riau",106,90,101))
        provinsi.add(Provinsi("Sulawesi Barat",2,2,1))
        provinsi.add(Provinsi("Sulawesi Selatan",562,448,265))
        provinsi.add(Provinsi("Sulawesi Tengah",128,114,59))
        provinsi.add(Provinsi("Sulawesi Tenggara",97,83,71))
        provinsi.add(Provinsi("Sulawesi Utara",106,97,76))
        provinsi.add(Provinsi("Sumatera Barat",95,66,80))
        provinsi.add(Provinsi("Sumatera Selatan",71,59,41))
        provinsi.add(Provinsi("Sumatera Utara",259,225,218))
        return provinsi
    }
}