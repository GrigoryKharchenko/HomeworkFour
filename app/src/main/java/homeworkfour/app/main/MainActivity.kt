package homeworkfour.app.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import homeworkfour.app.Navigation
import homeworkfour.app.R
import homeworkfour.app.firsttask.AFragment
import homeworkfour.app.firsttask.AFragment.Companion.A_FRAGMENT_TAG
import homeworkfour.app.firsttask.BFragment
import homeworkfour.app.firsttask.BFragment.Companion.B_FRAGMENT_TAG
import homeworkfour.app.firsttask.CFragment
import homeworkfour.app.firsttask.CFragment.Companion.C_FRAGMENT_TAG
import homeworkfour.app.firsttask.DFragment
import homeworkfour.app.firsttask.DFragment.Companion.D_FRAGMENT_TAG
import homeworkfour.app.main.MainFragment.Companion.MAIN_FRAGMENT_TAG

class MainActivity : AppCompatActivity(R.layout.activity_main), Navigation {

    override fun showMainFragment() {
        replaceFragment(MainFragment.newInstance(), MAIN_FRAGMENT_TAG)
    }

    override fun showAFragment() {
        replaceFragment(AFragment.newInstance(), A_FRAGMENT_TAG)
    }

    override fun showBFragment() {
        replaceFragment(BFragment.newInstance(), B_FRAGMENT_TAG)
    }

    override fun showCFragment(text: String) {
        replaceFragment(CFragment.newInstance(text), C_FRAGMENT_TAG)
    }

    override fun showDFragment() {
        replaceFragment(DFragment.newInstance(), D_FRAGMENT_TAG)
    }

    override fun goToBack() {
        supportFragmentManager.popBackStack()
    }

    override fun goToFragment(fragmentTag: String) {
        supportFragmentManager.popBackStack(fragmentTag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(tag)
            replace(R.id.fragmentContainer, fragment, tag)
        }
    }
}
