
# appTraductionETLV

## Aperçu
appTraductionETLV est une application Android de traduction développée en Kotlin dans le cadre d'un micro-projet en Terminal STI2D . Elle permet aux utilisateurs de traduire des phrases prédéfinies du français à l'anglais et inclut une fonctionnalité de synthèse vocale (TTS) pour lire les traductions à voix haute. 

## Fonctionnalités
- **Traduction de phrases prédéfinies** : Traduction instantanée de phrases françaises courantes en anglais.
- **Synthèse vocale (TTS)** : Lecture à voix haute des phrases traduites.
- **Interface utilisateur intuitive** : Design simple et facile à utiliser.
- **Navigation entre activités** : Possibilité de passer d'une activité à une autre.

## Installation
Pour installer et exécuter ce projet localement, suivez ces étapes :

1. **Cloner le dépôt** :
    ```bash
    git clone https://github.com/pinpin-http/appTraductionETLV.git
    cd appTraductionETLV
    ```

2. **Ouvrir le projet dans Android Studio** :
    - Lancez Android Studio.
    - Sélectionnez "Open an existing Android Studio project".
    - Naviguez vers le répertoire `appTraductionETLV` et sélectionnez-le.

3. **Exécuter l'application** :
    - Connectez un appareil Android ou utilisez un émulateur.
    - Cliquez sur le bouton "Run" (icône de lecture verte) dans Android Studio.

## Utilisation
Une fois l'application lancée, voici comment l'utiliser :

1. **Traduire une phrase** :
    - Saisissez une phrase en français dans le champ de texte.
    - Cliquez sur le bouton "Traduire" pour obtenir la traduction en anglais. Si la phrase est prédéfinie, la traduction s'affichera ; sinon, un message d'erreur apparaîtra.

2. **Utiliser la synthèse vocale (TTS)** :
    - Après avoir obtenu la traduction, cliquez sur le bouton TTS (icône de haut-parleur) pour entendre la traduction à voix haute.

3. **Naviguer vers une autre activité** :
    - Cliquez sur le bouton de navigation (icône de flèche) pour passer à l'activité suivante.
    - Dans l'activité suivante, utilisez le bouton de retour pour revenir à l'activité principale.

## Code Source
### MainActivity.kt
Le fichier `MainActivity.kt` contient la logique principale de l'application :

- **Initialisation de TextToSpeech (TTS)** :
    ```kotlin
    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            val result = tts!!.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","The language specified is not supported or installed !")
            } else {
                Log.e("tts","Initialization Failed!")
            }
        }
    }
    ```


- **Synthèse vocale** :
    ```kotlin
    ttsbtn.setOnClickListener {
        val txtPhrasetts = resultat.text.toString().trim()
        if (txtPhrasetts.isEmpty()) {
            Toast.makeText(this, "Enter a text to use TTS", Toast.LENGTH_SHORT).show()
        } else {
            speakOut(txtPhrasetts)
        }
    }
    ```

### activity_list.kt
Le fichier `activity_list.kt` gère la navigation vers l'activité principale :

- **Navigation vers l'activité principale** :
    ```kotlin
    previousPage.setOnClickListener {
        val intentToPreviousPage: Intent = Intent(this, MainActivity::class.java)
        startActivity(intentToPreviousPage)
    }
    ```

## Contribuer
Les contributions sont les bienvenues ! Pour contribuer :

1. **Forkez le dépôt**.
2. **Créez une nouvelle branche** :
    ```bash
    git checkout -b nom-de-la-fonctionnalité
    ```
3. **Apportez vos modifications**.
4. **Committez vos modifications** :
    ```bash
    git commit -m "Description de la fonctionnalité"
    ```
5. **Pushez vers la branche** :
    ```bash
    git push origin nom-de-la-fonctionnalité
    ```
6. **Créez une pull request**.

## Auteur
Développé par [Soheib Bouazzaoui](https://github.com/pinpin-http).

