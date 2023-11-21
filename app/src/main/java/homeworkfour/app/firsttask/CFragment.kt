package homeworkfour.app.firsttask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import homeworkfour.app.databinding.FragmentCBinding
import homeworkfour.app.firsttask.BFragment.Companion.B_FRAGMENT_TAG
import homeworkfour.app.navigation

class CFragment : Fragment() {

    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    private var textHello: String = ERROR_ARGUMENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textHello = arguments?.getString(KEY_ARGUMENT) ?: ERROR_ARGUMENT
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvArgument.text = textHello
            btnShowFragmentD.setOnClickListener {
                navigation()?.showDFragment()
            }
            btnShowFragmentA.setOnClickListener {
                navigation()?.goToFragment(B_FRAGMENT_TAG)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val C_FRAGMENT_TAG = "C_FRAGMENT_TAG"

        private const val KEY_ARGUMENT = "KEY_ARGUMENT"
        private const val ERROR_ARGUMENT = "ERROR_ARGUMENT"

        fun newInstance(text: String): CFragment = CFragment().apply {
            arguments = bundleOf(KEY_ARGUMENT to text)
        }
    }
}
