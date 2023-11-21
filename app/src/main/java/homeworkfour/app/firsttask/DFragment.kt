package homeworkfour.app.firsttask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import homeworkfour.app.databinding.FragmentDBinding
import homeworkfour.app.firsttask.CFragment.Companion.C_FRAGMENT_TAG
import homeworkfour.app.navigation

class DFragment : Fragment() {

    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnShowFragmentB.setOnClickListener {
            navigation()?.goToFragment(C_FRAGMENT_TAG)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val D_FRAGMENT_TAG = "D_FRAGMENT_TAG"

        fun newInstance() = DFragment()
    }
}
