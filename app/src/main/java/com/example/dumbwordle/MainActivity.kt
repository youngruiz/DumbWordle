package com.example.dumbwordle

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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

        var ansWord = FourLetterWordList.getAFourLetterWord()
        Log.i("Daniel", ansWord)

        // Change the answer TextView to generated Wordle answer, but will initially be hidden.
        var textView: TextView = findViewById(R.id.theWordTextView) as TextView
        textView.text = ansWord

        val resetButton = findViewById<Button>(R.id.resetButton)
        resetButton.setOnClickListener {

            // Reset turns and get new four letter word.
            turn = 0
            ansWord = FourLetterWordList.getAFourLetterWord()
            ansWord = ansWord.uppercase()
            Log.i("Daniel", ansWord)

            // Reset text boxes to empty and make them invisible
            var g1: TextView = findViewById(R.id.guessAttempt1)
            g1.setText("")
            g1.visibility = View.INVISIBLE
            var g1c: TextView = findViewById(R.id.guessAttempt1Check)
            g1c.setText("")
            g1c.visibility = View.INVISIBLE
            var g2: TextView = findViewById(R.id.guessAttempt2)
            g2.setText("")
            g2.visibility = View.INVISIBLE
            var g2c: TextView = findViewById(R.id.guessAttempt2Check)
            g2c.setText("")
            g2c.visibility = View.INVISIBLE
            var g3: TextView = findViewById(R.id.guessAttempt3)
            g3.setText("")
            g3.visibility = View.INVISIBLE
            var g3c: TextView = findViewById(R.id.guessAttempt3Check)
            g3c.setText("")
            g3c.visibility = View.INVISIBLE

            var ans: TextView = findViewById(R.id.theWordTextView)
            ans.visibility = View.INVISIBLE
            ans.setText(ansWord)

        }

        val guessButton = findViewById<Button>(R.id.guessButton)
        guessButton.setOnClickListener {

            if (turn == 0){

                var guess1: String
                userGuess = findViewById(R.id.userGuess) as TextView
                guess1 = userGuess.text.toString()



                var guessAttempt1: TextView = findViewById(R.id.guessAttempt1)
                guessAttempt1.text = guess1
                guessAttempt1.visibility = View.VISIBLE

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

                var checkRes1: String
                guess1 = guess1.uppercase()
                Log.v("Daniel", guess1)
                checkRes1 = checkGuess(guess1, ansWord)

                var checkBox1: TextView = findViewById(R.id.guessAttempt1Check) as TextView
                checkBox1.text = checkRes1
                checkBox1.visibility = View.VISIBLE


                if ("OOOO" == checkRes1){
                    Toast.makeText(this, "You Win! You Guessed the Word!", Toast.LENGTH_LONG).show()
                    turn = 4
                    var theWordTextView: TextView = findViewById(R.id.theWordTextView)
                    theWordTextView.setTextColor(Color.GREEN)
                    theWordTextView.visibility = View.VISIBLE
                }

                turn += 1
            }

            else if (turn == 1){
                //Log.v("Daniel", "You made 2nd guess!")

                var guess2: String
                userGuess = findViewById(R.id.userGuess) as TextView
                guess2 = userGuess.text.toString()

                Log.v("Daniel", guess2)

                var guessAttempt2: TextView = findViewById(R.id.guessAttempt2)
                guessAttempt2.text = guess2
                guessAttempt2.visibility = View.VISIBLE

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

                var checkRes2: String
                guess2 = guess2.uppercase()
                checkRes2 = checkGuess(guess2, ansWord)

                var checkBox2: TextView = findViewById(R.id.guessAttempt2Check) as TextView
                checkBox2.text = checkRes2
                checkBox2.visibility = View.VISIBLE


                if ("OOOO" == checkRes2){
                    Toast.makeText(this, "You Win! You Guessed the Word!", Toast.LENGTH_LONG).show()
                    turn = 4
                    var theWordTextView: TextView = findViewById(R.id.theWordTextView)
                    theWordTextView.setTextColor(Color.GREEN)
                    theWordTextView.visibility = View.VISIBLE
                }

                turn += 1
            }

            else if (turn == 2){

                var guess3: String
                userGuess = findViewById(R.id.userGuess) as TextView
                guess3 = userGuess.text.toString()

                Log.v("Daniel", guess3)

                var guessAttempt3: TextView = findViewById(R.id.guessAttempt3)
                guessAttempt3.text = guess3
                guessAttempt3.visibility = View.VISIBLE

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

                var checkRes3: String
                guess3 = guess3.uppercase()
                checkRes3 = checkGuess(guess3, ansWord)

                var checkBox3: TextView = findViewById(R.id.guessAttempt3Check) as TextView
                checkBox3.text = checkRes3
                checkBox3.visibility = View.VISIBLE

                if ("OOOO" == checkRes3){
                    Toast.makeText(this, "You Win! You Guessed the Word!", Toast.LENGTH_LONG).show()
                    turn = 4
                    var theWordTextView: TextView = findViewById(R.id.theWordTextView)
                    theWordTextView.setTextColor(Color.GREEN)
                    theWordTextView.visibility = View.VISIBLE
                }

                turn += 1
                if (turn == 3){
                    Toast.makeText(this, "You lost! You did not guess the word.", Toast.LENGTH_LONG).show()
                    turn += 1
                    var theWordTextView: TextView = findViewById(R.id.theWordTextView)
                    theWordTextView.setTextColor(Color.RED)
                    theWordTextView.visibility = View.VISIBLE
                }
            }


            else {
                Toast.makeText(this, "Game is over. No More turns can be made.", Toast.LENGTH_LONG).show()

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


/**
 * Parameters / Fields:
 *   wordToGuess : String - the target word the user is trying to guess
 *   guess : String - what the user entered as their guess
 *
 * Returns a String of 'O', '+', and 'X', where:
 *   'O' represents the right letter in the right place
 *   '+' represents the right letter in the wrong place
 *   'X' represents a letter not in the target word
 */
private fun checkGuess(guess: String, wordToGuess: String) : String {
    var result = ""
    Log.v("Daniel", "BEGIN")
    Log.v("Daniel", guess)
    Log.v("Daniel", wordToGuess)
    Log.v("Daniel", "END")
    for (i in 0..3) {
        if (guess[i] == wordToGuess[i]) {
            result += "O"
        }
        else if (guess[i] in wordToGuess) {
            result += "+"
        }
        else {
            result += "X"
        }
    }
    return result
}

