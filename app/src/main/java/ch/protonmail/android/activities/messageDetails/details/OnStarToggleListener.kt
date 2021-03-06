/*
 * Copyright (c) 2020 Proton Technologies AG
 * 
 * This file is part of ProtonMail.
 * 
 * ProtonMail is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ProtonMail is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ProtonMail. If not, see https://www.gnu.org/licenses/.
 */
package ch.protonmail.android.activities.messageDetails.details

import android.widget.CompoundButton
import ch.protonmail.android.jobs.PostStarJob
import ch.protonmail.android.jobs.PostUnstarJob
import com.birbit.android.jobqueue.JobManager

/**
 * Created by Kamil Rajtar on 13.08.18.
 */
internal class OnStarToggleListener(private val jobManager: JobManager,
									private val messageId: String) : CompoundButton.OnCheckedChangeListener {

	override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
		if (!buttonView.isPressed) {
			return
		}
		val messageList = listOf(messageId)
		val job = if (isChecked) {
			PostStarJob(messageList)
		} else {
			PostUnstarJob(messageList)
		}
		jobManager.addJobInBackground(job)
	}
}
