package ve.develop.strawbush


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class StartGameFragment : Fragment() {

private lateinit var startGameTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start_game, container, false)

        startGameTextView = view.findViewById(R.id.start_game_textview)
        startGameTextView.setOnClickListener {
            findNavController().navigate(R.id.action_startGameFragment_to_gameFragment)
        }

        return view
    }


}
