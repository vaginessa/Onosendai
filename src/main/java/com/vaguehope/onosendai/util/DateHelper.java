package com.vaguehope.onosendai.util;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import android.content.Context;

public final class DateHelper {

	private static final long ONE_DAY_MILLIS = TimeUnit.DAYS.toMillis(1);

	private DateHelper () {
		throw new AssertionError();
	}

	public static String friendlyAbsoluteDate (final Context context, final long now, final long time) {
		final StringBuilder s = new StringBuilder();
		final Date tweetDate = new Date(time);
		if (now - time >= ONE_DAY_MILLIS) {
			s.append(android.text.format.DateFormat.getDateFormat(context).format(tweetDate)).append(" ");
		}
		s.append(android.text.format.DateFormat.getTimeFormat(context).format(tweetDate));
		return s.toString();
	}

	public static String formatDurationSeconds (final long seconds) {
		if (seconds >= 3600) {
			return String.format(Locale.ENGLISH, "%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
		}
		return String.format(Locale.ENGLISH, "%d:%02d", (seconds % 3600) / 60, (seconds % 60));
	}

	public static String formatDurationMillis (final long millis) {
		return formatDurationSeconds(TimeUnit.MILLISECONDS.toSeconds(millis));
	}

}
