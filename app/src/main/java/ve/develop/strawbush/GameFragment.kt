package ve.develop.strawbush


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_game.*


private const val SAVED_SCORE = "saved_game_score"

class GameFragment : Fragment() {

    private val gameFragmentViewModel: GameFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(GameFragmentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            gameFragmentViewModel.score = savedInstanceState.getInt(SAVED_SCORE, 0)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            gameFragmentViewModel.score = GameFragmentArgs.fromBundle(arguments!!).shopScore
        }
        score_text_view.setText(gameFragmentViewModel.score.toString())
        setListenersForStrawberry()
        bush_imageview.setOnClickListener {
            when (gameFragmentViewModel.currentIndex) {
                0 -> {
                    mini_strawberry_imageview.visibility = View.VISIBLE
                    mini_strawberry_imageview.animate().scaleX(3.0f).scaleY(2.0f).withEndAction {
                        mini_strawberry_imageview.animate().translationY(500.0f).withEndAction {
                            mini_strawberry_imageview.isEnabled = true
                        }.duration = 2000
                    }.duration = 15000
                    updateIndex()
                }
                1 -> {
                    mini_strawberry_imageview2.visibility = View.VISIBLE
                    mini_strawberry_imageview2.animate().scaleX(3.0f).scaleY(2.0f).withEndAction {
                        mini_strawberry_imageview2.animate().translationY(500.0f).withEndAction {
                            mini_strawberry_imageview2.isEnabled = true
                        }.duration = 2000
                    }.duration = 15000
                    updateIndex()
                }
                2 -> {
                    mini_strawberry_imageview3.visibility = View.VISIBLE
                    mini_strawberry_imageview3.animate().scaleX(3.0f).scaleY(2.0f).withEndAction {
                        mini_strawberry_imageview3.animate().translationY(300.0f).withEndAction {
                            mini_strawberry_imageview3.isEnabled = true
                        }.duration = 2000
                    }.duration = 15000

                    updateIndex()
                }
                3 -> {
                    mini_strawberry_imageview4.visibility = View.VISIBLE
                    mini_strawberry_imageview4.animate().scaleX(3.0f).scaleY(2.0f).withEndAction {
                        mini_strawberry_imageview4.animate().translationY(350.0f).withEndAction {
                            mini_strawberry_imageview4.isEnabled = true
                        }.duration = 2000
                    }.duration = 15000

                    updateIndex()
                }
                4 -> {
                    mini_strawberry_imageview5.visibility = View.VISIBLE
                    mini_strawberry_imageview5.animate().scaleX(3.0f).scaleY(2.0f).withEndAction {
                        mini_strawberry_imageview5.animate().translationY(300.0f).withEndAction {
                            mini_strawberry_imageview5.isEnabled = true
                        }.duration = 2000
                    }.duration = 15000
                    gameFragmentViewModel.currentIndex = 0
                    bush_imageview.isEnabled = false
                }
                else -> {

                }
            }
        }
        shop_imageview.setOnClickListener {
            findNavController().navigate(
                GameFragmentDirections.actionGameFragmentToShopFragment(gameFragmentViewModel.score)
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SAVED_SCORE, gameFragmentViewModel.score)
    }


    private fun setListenersForStrawberry() {
        val strawberryViewsList = listOf<ImageView>(
            mini_strawberry_imageview,
            mini_strawberry_imageview2,
            mini_strawberry_imageview3,
            mini_strawberry_imageview4,
            mini_strawberry_imageview5
        )
        strawberryViewsList.forEach { strawberryImage ->
            strawberryImage.isEnabled = false
            strawberryImage.setOnClickListener { view ->
                when (view) {
                    mini_strawberry_imageview -> {
                        bush_imageview.isEnabled = true
                        addOneToScore()
                        mini_strawberry_imageview.visibility = View.GONE
                        mini_strawberry_imageview.animate().translationY(-30.0f).scaleX(1.0f)
                            .scaleY(1.0f).duration = 1000
                        updateScoreText()
                        mini_strawberry_imageview.isEnabled = false
                    }
                    mini_strawberry_imageview2 -> {
                        bush_imageview.isEnabled = true
                        addOneToScore()
                        mini_strawberry_imageview2.visibility = View.GONE
                        mini_strawberry_imageview2.animate().translationY(-30.0f).scaleX(1.0f)
                            .scaleY(1.0f).duration = 1000
                        updateScoreText()
                        mini_strawberry_imageview2.isEnabled = false
                    }
                    mini_strawberry_imageview3 -> {
                        bush_imageview.isEnabled = true
                        addOneToScore()
                        mini_strawberry_imageview3.visibility = View.GONE
                        mini_strawberry_imageview3.animate().translationY(-40.0f).scaleX(1.0f)
                            .scaleY(1.0f).duration = 100
                        updateScoreText()
                        mini_strawberry_imageview3.isEnabled = false
                    }
                    mini_strawberry_imageview4 -> {
                        bush_imageview.isEnabled = true
                        addOneToScore()
                        mini_strawberry_imageview4.visibility = View.GONE
                        mini_strawberry_imageview4.animate().translationY(-40.0f).scaleX(1.0f)
                            .scaleY(1.0f).duration = 1000
                        updateScoreText()
                        mini_strawberry_imageview4.isEnabled = false
                    }
                    mini_strawberry_imageview5 -> {
                        bush_imageview.isEnabled = true
                        addOneToScore()
                        mini_strawberry_imageview5.visibility = View.GONE
                        mini_strawberry_imageview5.animate().translationY(-40.0f).scaleX(1.0f)
                            .scaleY(1.0f).duration = 1000
                        updateScoreText()
                        mini_strawberry_imageview5.isEnabled = false
                    }
                }
            }
        }
    }

    private fun addOneToScore() {
        gameFragmentViewModel.score += 1
    }

    private fun updateScoreText() {
        score_text_view.setText(gameFragmentViewModel.score.toString())
    }

    private fun updateIndex() {
        gameFragmentViewModel.currentIndex++
    }

    private fun resetState() {

    }


}
