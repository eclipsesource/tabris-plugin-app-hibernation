package com.tabris.js.app.hibernation

import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat
import androidx.core.content.PackageManagerCompat
import androidx.core.content.UnusedAppRestrictionsConstants.*
import com.eclipsesource.tabris.android.ActivityScope
import com.eclipsesource.tabris.android.internal.ktx.callAsyncAndClose
import com.eclipsesource.v8.V8Function

class AppHibernation(private val scope: ActivityScope) {

  fun getUnusedAppRestrictionsStatus(success: V8Function, error: V8Function) {
    val future = PackageManagerCompat.getUnusedAppRestrictionsStatus(scope.context)
    future.addListener(
      { onUnusedAppRestrictionsStatusResult(future.get(), success, error) },
      ContextCompat.getMainExecutor(scope.context)
    )
  }

  fun openAppSettings() {
    val intent = IntentCompat.createManageUnusedAppRestrictionsIntent(
      scope.context, scope.activity.packageName
    )
    scope.activity.startActivity(intent)
  }

  private fun onUnusedAppRestrictionsStatusResult(
    appRestrictionsStatus: Int, success: V8Function, error: V8Function
  ) = when (appRestrictionsStatus) {
    ERROR -> error.callAsyncAndClose(scope, "Couldn't fetch status.")
    FEATURE_NOT_AVAILABLE -> success.callAsyncAndClose(scope, "feature-not-available")
    DISABLED -> success.callAsyncAndClose(scope, "disabled")
    API_30_BACKPORT, API_30, API_31 -> success.callAsyncAndClose(scope, "enabled")
    else -> success.callAsyncAndClose(scope, "unknown")
  }

}
