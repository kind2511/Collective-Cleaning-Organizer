package com.example.collectivecleaningorganizer.ui.collective

import android.widget.Spinner

interface onDataChange {
    fun collectiveMemberRolesChanged(updatedMembersMap: MutableMap<String, String>)

}
interface ResultListener {
    fun onResult(isAdded: Boolean)
}