
package com.company.psreadings

import android.app.Application
import com.company.psreadings.util.NotifUtils

class App: Application() {
  override fun onCreate() {
    super.onCreate()
    NotifUtils.ensureReminderChannel(this)
  }
}
