package com.example.dumbwordle

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var turn = 0
        var userGuess: TextView

        val ansWord = FourLetterWordList.getAFourLetterWord()
        Log.i("Daniel", ansWord)

        // Change the answer TextView to generated Wordle answer, but will initially be hidden.
        var textView: TextView = findViewById(R.id.theWordTextView) as TextView
        textView.text = ansWord

        Log.v("Daniel", "You made 3rd guess!")

        val guessButton = findViewById<Button>(R.id.guessButton)
        guessButton.setOnClickListener {
            //Log.v("Daniel", "Button Clicked")
            Toast.makeText(this, "You Made A Guess!", Toast.LENGTH_LONG).show()

            if (turn == 0){
                Log.v("Daniel", "You made 1st guess!")

                var guess1: String
                userGuess = findViewById(R.id.userGuess) as TextView
                guess1 = userGuess.text.toString()

                Log.v("Daniel", guess1)

                var guessAttempt1: TextView = findViewById(R.id.guessAttempt1)
                guessAttempt1.text = guess1

                // To close keyboard.
                val view = currentFocus
                if (view != null) {
                    view.clearFocus()
                    val inputMethodManager =
                        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(
                        view.windowToken,
                        InputMethodManager.HIDE_NOT_ALWAYS
                    )
                }

                // To clear EditText
                userGuess.setText("")

                turn += 1
            }

            else if (turn == 1){
                Log.v("Daniel", "You made 2nd guess!")

                var guess2: String
                userGuess = findViewById(R.id.userGuess) as TextView
                guess2 = userGuess.text.toString()

                Log.v("Daniel", guess2)

                var guessAttempt2: TextView = findViewById(R.id.guessAttempt2)
                guessAttempt2.text = guess2

                // To close keyboard.
                val view = currentFocus
                if (view != null) {
                    view.clearFocus()
                    val inputMethodManager =
                        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(
                        view.windowToken,
                        InputMethodManager.HIDE_NOT_ALWAYS
                    )
                }

                // To clear EditText
                userGuess.setText("")

                turn += 1
            }

            else if (turn == 2){
                Log.v("Daniel", "You made 3rd guess!")

                var guess3: String
                userGuess = findViewById(R.id.userGuess) as TextView
                guess3 = userGuess.text.toString()

                Log.v("Daniel", guess3)

                var guessAttempt3: TextView = findViewById(R.id.guessAttempt3)
                guessAttempt3.text = guess3

                // To close keyboard.
                val view = currentFocus
                if (view != null) {
                    view.clearFocus()
                    val inputMethodManager =
                        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(
                        view.windowToken,
                        InputMethodManager.HIDE_NOT_ALWAYS
                    )
                }

                // To clear EditText
                userGuess.setText("")

                turn += 1
            }

            else {
                Log.v("Daniel", "No more turns can be made!")

                // To close keyboard.
                val view = currentFocus
                if (view != null) {
                    view.clearFocus()
                    val inputMethodManager =
                        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(
                        view.windowToken,
                        InputMethodManager.HIDE_NOT_ALWAYS
                    )
                }

                // To clear EditText
                userGuess = findViewById(R.id.userGuess) as TextView
                userGuess.setText("")
            }
        }

    }
}

object FourLetterWordList {

    // List of most common 4 letter words from: https://7esl.com/4-letter-words/
    val fourLetterWords =
        "Area,Army,Baby,Back,Ball,Band,Bank,Base,Bill,Body,Book,Call,Card,Care,Case,Cash,City,Club,Cost,Date,Deal,Door,Duty,East,Edge,Face,Fact,Farm,Fear,File,Film,Fire,Firm,Fish,Food,Foot,Form,Fund,Game,Girl,Goal,Gold,Hair,Half,Hall,Hand,Head,Help,Hill,Home,Hope,Hour,Idea,Jack,John,Kind,King,Lack,Lady,Land,Life,Line,List,Look,Lord,Loss,Love,Mark,Mary,Mind,Miss,Move,Name,Need,News,Note,Page,Pain,Pair,Park,Part,Past,Path,Paul,Plan,Play,Post,Race,Rain,Rate,Rest,Rise,Risk,Road,Rock,Role,Room,Rule,Sale,Seat,Shop,Show,Side,Sign,Site,Size,Skin,Sort,Star,Step,Task,Team,Term,Test,Text,Time,Tour,Town,Tree,Turn,Type,Unit,User,View,Wall,Week,West,Wife,Will,Wind,Wine,Wood,Word,Work,Year,Bear,Beat,Blow,Burn,Call,Care,Cast,Come,Cook,Cope,Cost,Dare,Deal,Deny,Draw,Drop,Earn,Face,Fail,Fall,Fear,Feel,Fill,Find,Form,Gain,Give,Grow,Hang,Hate,Have,Head,Hear,Help,Hide,Hold,Hope,Hurt,Join,Jump,Keep,Kill,Know,Land,Last,Lead,Lend,Lift,Like,Link,Live,Look,Lose,Love,Make,Mark,Meet,Mind,Miss,Move,Must,Name,Need,Note,Open,Pass,Pick,Plan,Play,Pray,Pull,Push,Read,Rely,Rest,Ride,Ring,Rise,Risk,Roll,Rule,Save,Seek,Seem,Sell,Send,Shed,Show,Shut,Sign,Sing,Slip,Sort,Stay,Step,Stop,Suit,Take,Talk,Tell,Tend,Test,Turn,Vary,View,Vote,Wait,Wake,Walk,Want,Warn,Wash,Wear,Will,Wish,Work,Able,Back,Bare,Bass,Blue,Bold,Busy,Calm,Cold,Cool,Damp,Dark,Dead,Deaf,Dear,Deep,Dual,Dull,Dumb,Easy,Evil,Fair,Fast,Fine,Firm,Flat,Fond,Foul,Free,Full,Glad,Good,Grey,Grim,Half,Hard,Head,High,Holy,Huge,Just,Keen,Kind,Last,Late,Lazy,Like,Live,Lone,Long,Loud,Main,Male,Mass,Mean,Mere,Mild,Nazi,Near,Neat,Next,Nice,Okay,Only,Open,Oral,Pale,Past,Pink,Poor,Pure,Rare,Real,Rear,Rich,Rude,Safe,Same,Sick,Slim,Slow,Soft,Sole,Sore,Sure,Tall,Then,Thin,Tidy,Tiny,Tory,Ugly,Vain,Vast,Very,Vice,Warm,Wary,Weak,Wide,Wild,Wise,Zero,Ably,Afar,Anew,Away,Back,Dead,Deep,Down,Duly,Easy,Else,Even,Ever,Fair,Fast,Flat,Full,Good,Half,Hard,Here,High,Home,Idly,Just,Late,Like,Live,Long,Loud,Much,Near,Nice,Okay,Once,Only,Over,Part,Past,Real,Slow,Solo,Soon,Sure,That,Then,This,Thus,Very,When,Wide"

    // Returns a list of four letter words as a list.
    fun getAllFourLetterWords(): List<String> {
        return fourLetterWords.split(",")
    }

    fun getAFourLetterWord(): String {
        val allWords = getAllFourLetterWords()
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }
}

