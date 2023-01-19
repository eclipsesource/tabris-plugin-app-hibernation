package com.tabris.js.app.hibernation

import com.eclipsesource.tabris.android.ActivityScope
import com.eclipsesource.tabris.android.ObjectHandler
import com.eclipsesource.tabris.android.Property
import com.eclipsesource.v8.V8Object

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class AppHibernationHandler(private val scope: ActivityScope) :
  ObjectHandler<AppHibernation> {

  override val type = "plugin.AppHibernation"

  override val properties: List<Property<AppHibernation, *>> = listOf(
    EnabledProperty
  )

  override fun create(id: String, properties: V8Object) = AppHibernation(scope)

  override fun call(appHibernation: AppHibernation, method: String, properties: V8Object) =
    when (method) {
      "openAppSettings" -> appHibernation.openAppSettings()
      else -> super.call(appHibernation, method, properties)
    }

}
