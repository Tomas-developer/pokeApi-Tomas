package com.tomdeveloper.pokeapi.commons

import androidx.fragment.app.Fragment
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.uicomponents.ErrorDialog
import java.io.File

abstract class BaseFragment: Fragment() {
    var errorDialog: ErrorDialog? = null

}

