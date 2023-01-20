package com.tabris.js.app.hibernation

import com.eclipsesource.tabris.android.ActivityScope
import com.eclipsesource.tabris.android.ObjectHandler
import com.eclipsesource.tabris.android.internal.ktx.getEntangled
import com.eclipsesource.v8.V8Function
import com.eclipsesource.v8.V8Object

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class AppHibernationHandler(private val scope: ActivityScope) :
  ObjectHandler<AppHibernation> {

  override val type = "plugin.AppHibernation"

  override fun create(id: String, properties: V8Object) = AppHibernation(scope)

  override fun call(appHibernation: AppHibernation, method: String, properties: V8Object) =
    when (method) {
      "getUnusedAppRestrictionsStatus" -> getUnusedAppRestrictionsStatus(appHibernation, properties)
      "openAppSettings" -> appHibernation.openAppSettings()
      else -> super.call(appHibernation, method, properties)
    }

  private fun getUnusedAppRestrictionsStatus(appHibernation: AppHibernation, properties: V8Object) {
    val (onSuccess, onError) = properties.getEntangled<V8Function>(scope, "onSuccess", "onError")
    appHibernation.getUnusedAppRestrictionsStatus(onSuccess, onError)
  }

}
