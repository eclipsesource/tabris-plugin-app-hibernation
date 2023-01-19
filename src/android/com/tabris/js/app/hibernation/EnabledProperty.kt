package com.tabris.js.app.hibernation

import com.eclipsesource.tabris.android.BooleanProperty

object EnabledProperty : BooleanProperty<AppHibernation>(
  "enabled",
  getter = { enabled }
)
