package com.tabris.js.app.hibernation

import com.eclipsesource.tabris.android.ActivityScope

class AppHibernation(private val scope: ActivityScope) {

  val enabled = false

  fun openAppSettings() {
    println("------- openAppSettings -------")
  }

}
