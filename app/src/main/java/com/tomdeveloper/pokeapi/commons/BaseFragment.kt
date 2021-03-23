package com.tomdeveloper.pokeapi.commons

import androidx.fragment.app.Fragment
import com.tomdeveloper.pokeapi.commons.uicomponents.ErrorDialog

abstract class BaseFragment: Fragment() {
    var errorDialog: ErrorDialog? = null
}