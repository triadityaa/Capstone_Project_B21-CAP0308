package com.jetpackprosubs.capstone.utils

object DummyResponse {

    fun simpleResponse(_message: String): String{
        val random = (0..1).random()
        val message = _message.toLowerCase()
        return when{
            //Hello
            message.contains("halo") ->{
                when(random){
                    0 -> "Halo, apakah ada yang bisa saya bantu ?"
                    1 -> "Hai, anda terhubung dengan SiPAPA "
                    else -> "error"
                }
            }
            //skenario pelaporan sederahana, belum rampung
            message.contains("saya ingin lapor") -> "Silahkan jawab pertanyaan berikut satu persatu." +
                    "Kekerasan apa yang dilakukan pelaku?\n" +
                    "Kekerasan seksual\n atau fisik"
            message.contains("fisik") -> "Apakah anda mengalaminya sendiri ?\n Saya sendiri atau orang lain"
            message.contains("orang lain") -> "Apa anda mengenal orang tersebut?"
            message.contains("kenal, mengenal") -> "Silahkan ketikkan alamat lokasi kejadian kekerasan yang anda lihat"
            message.contains("tidak kenal, tidak mengenal") -> "Silahkan ketikkan alamat lokasi kejadian kekerasan yang anda lihat"
            message.contains("saya sendiri") -> "Apakah saat ini anda berada di tempat aman/ jauh dari pelaku?\nsaya sudah aman atau belum aman"
            message.contains("belum aman")-> "Mohon tunggu, kami sedang menghubungi polisi/pihak berwenang setempat"
            message.contains("sudah aman") -> "Silahkan ketikan alamat/lokasi pasti anda saat ini \n jika memungkinkan cari tempat yang ada keramaian, jika tidak memungkinkan tetaplah di posisi anda sekarang"
            message.contains("lokasi")||message.contains("jalan") -> "segera mengirimkan petugas"
            else -> {
                when(random){
                    0 -> "Ketik, saya ingin lapor, untuk melapor"
                    1 -> "Hai, anda terhubung dengan SiPAPA "
                    else -> "error"
                }
            }
        }
    }
}