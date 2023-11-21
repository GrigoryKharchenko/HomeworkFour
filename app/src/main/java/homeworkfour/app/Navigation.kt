package homeworkfour.app

import androidx.fragment.app.Fragment

interface Navigation {

    fun showMainFragment()

    fun showAFragment()

    fun showBFragment()

    fun showCFragment(text: String)

    fun showDFragment()

    fun goToBack()

    fun goToFragment(fragmentTag: String)

}

fun Fragment.navigation(): Navigation? = (requireActivity() as? Navigation)
