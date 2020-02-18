package ve.develop.strawbush


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_shop.*
import java.util.*

private const val SAVED_SHOP_SCORE = "saved_shop_score"

class ShopFragment : Fragment() {

    private val shopFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(ShopFragmentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            shopFragmentViewModel.score = savedInstanceState.getInt(SAVED_SHOP_SCORE, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shop, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shopFragmentViewModel.score = ShopFragmentArgs.fromBundle(arguments!!).score
        score_text_view.setText(shopFragmentViewModel.score.toString())
        setListeners()
        back_imageview.setOnClickListener {
            findNavController().navigate(ShopFragmentDirections.actionShopFragmentToGameFragment().apply {
                setShopScore(
                    shopFragmentViewModel.score
                )
            })
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SAVED_SHOP_SCORE, shopFragmentViewModel.score)
    }

    private fun setListeners() {
        val clickableViews = listOf<ImageView>(
            shop_item_one,
            shop_item_one2,
            shop_item_one3,
            shop_item_two,
            shop_item_two2,
            shop_item_two3,
            shop_item_three,
            shop_item_three2,
            shop_item_three3,
            shop_item_four,
            shop_item_four2,
            shop_item_four3
        )
        clickableViews.forEach { view ->
            val randomNumber = Random().nextInt(3)
            view.setImageResource(
                when (randomNumber) {
                    0 -> R.drawable.kartoshka
                    1 -> R.drawable.lopata
                    2 -> R.drawable.meshok
                    else -> View.GONE
                }
            )
        }
        clickableViews.forEach { view ->
            view.setOnClickListener {
                choosedShopItem(it)
            }
        }
    }

    private fun choosedShopItem(shopItem: View) {
        when (shopItem.id) {
            R.id.shop_item_one -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_one2 -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_one3 -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_two -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_two2 -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_two3 -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_three -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_three2 -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_three3 -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_four -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_four2 -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
            R.id.shop_item_four3 -> {
                shopItem.visibility = View.GONE
                shopFragmentViewModel.score += 3
                score_text_view.setText(shopFragmentViewModel.score.toString())
            }
        }
    }
}
