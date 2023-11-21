package homeworkfour.app.firsttask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import homeworkfour.app.databinding.FragmentBBinding
import homeworkfour.app.navigation

class BFragment : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnShowFragmentC.setOnClickListener {
            navigation()?.showCFragment("Hello Fragment C")
        }
        binding.btnShowFragmentA.setOnClickListener {
            navigation()?.showAFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val B_FRAGMENT_TAG = "B_FRAGMENT_TAG"

        fun newInstance(): BFragment = BFragment()
    }
}
