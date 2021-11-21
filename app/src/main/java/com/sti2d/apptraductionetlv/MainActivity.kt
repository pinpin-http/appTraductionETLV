package com.sti2d.apptraductionetlv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*


//var tts
var tts: TextToSpeech? = null

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialisation du tts
        var tts = TextToSpeech(this,this)

        //importation des items dans le layout
        val traduct = findViewById<Button>(R.id.translateBtn)
        val phrase = findViewById<EditText>(R.id.textInput)
        val resultat = findViewById<TextView>(R.id.output)
        val nextPage = findViewById<ImageButton>(R.id.nextPage)
        val ttsbtn = findViewById<ImageButton>(R.id.ttsBtn)

        //mise en listner du btn traduct
        traduct.setOnClickListener(View.OnClickListener {

            //recup String phrase listner btn
            val txtPhrase = phrase.text.toString()

            //correspondance anglais francais
            if (txtPhrase.trim() == "Où pouvons-nous trouver un taxi?") {
                //phrase 1
                resultat.text = "Where can we find a cab?"
            }
            if (txtPhrase.trim() == "Excusez moi, je dois y aller!") {
                //phrase2
                resultat.text = "Excuse me, I have to go"
            }
            if (txtPhrase.trim() == "Peut-on reporter la réunion?") {
                //phrase3
                resultat.text = "Can we postpone the meeting?"
            }
            if (txtPhrase.trim() == "Est ce que ce chargeur est compatible avec mon appareil?") {
                //phrase4
                resultat.text = "Is this charger compatible with my device?"
            }
            if (txtPhrase.trim() == "Pourriez vous m'indiquer où est cette rue?") {
                //phrase5
                resultat.text = "Could you tell me where that street is?"
            }
            if (txtPhrase.trim() == "Non merci, je suis allergique") {
                //phrase6
                resultat.text = "No thanks I am allergic"
            }
            if (txtPhrase.trim() == "Comment je peux vous contacter?") {
                //phrase7
                resultat.text = "How can I contact you?"
            }
            if (txtPhrase.trim() == "Connaissez vous une bonne boulangerie dans le coin?") {
                //phrase8
                resultat.text = "Do you know a good bakery nearby?"
            }
            if (txtPhrase.trim() == "Comment je peux acheter des tickets ?") {
                //phrase9
                resultat.text = "How can I buy tickets?"
            }
            if (txtPhrase.trim() == "Pouvez vous nous prendre en photo s'il vous plait?") {
                //phrase10
                resultat.text = "Can you take a picture of us please?"
            }

            //cas ou champ vide
            if (txtPhrase.trim().isEmpty()) {
                Toast.makeText(this, "sorry but, you can't do this... ", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "sorry but, I cant translate this ...   ", Toast.LENGTH_LONG).show()
            }

        })


        //bouton pour passer a l'activité List
        nextPage.setOnClickListener(View.OnClickListener {
            val intentToNextPage: Intent = Intent(this, activity_list::class.java)
            startActivity(intentToNextPage)

        })

        //bouton tts
        ttsbtn.setOnClickListener { view ->
            val txtPhrasetts = resultat.text.toString()
            if (txtPhrasetts.trim().isEmpty()) {
                Toast.makeText(this, "enter a text to use tts ", Toast.LENGTH_SHORT).show()
            } else {
                speakOut(txtPhrasetts)
            }
        }



    }

    override fun onInit(status: Int) {

        if(status == TextToSpeech.SUCCESS){
            //set voix anglais pour tts
            val result = tts!!.setLanguage(Locale.US)
            if(result ==TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","The language specified is not supported or installed !")
            }
            else{
                Log.e("tts","Initialisation Failed!")
            }
        }
    }

    public override fun onDestroy(){
        if(tts != null){
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

}

//declaration de la methode speak out
    private fun speakOut(text: String){
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }


