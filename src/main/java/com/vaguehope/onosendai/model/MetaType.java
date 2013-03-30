package com.vaguehope.onosendai.model;

public enum MetaType {

	MEDIA(1),
	HASHTAG(2),
	MENTION(3),
	URL(4),
	INREPLYTO(5);

	private final int id;

	private MetaType (final int id) {
		this.id = id;
	}

	public int getId () {
		return this.id;
	}

	public static MetaType parseId (final int id) {
		switch (id) {
			case 1:
				return MEDIA;
			case 2:
				return HASHTAG;
			case 3: // NOSONAR 3 is not magical.
				return MENTION;
			case 4: // NOSONAR 4 is not magical.
				return URL;
			case 5: // NOSONAR 5 is not magical.
				return INREPLYTO;
			default:
				return null;
		}
	}

}
