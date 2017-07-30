package com.sci.bpm.controller.base;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;

public class DateEditor extends CustomDateEditor {

	private DateFormat format;
	private final boolean allowEmpty;

	private final int exactDateLength;


	public DateEditor(DateFormat dateFormat, boolean allowEmpty) {
		
		super(dateFormat,allowEmpty);
		this.format = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;

	}

	@Override
	public String getAsText() {
		System.out.println("inside date get");
		Date value = (Date) getValue();
		return (value != null ? this.format.format(value) : "");

	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		}
		else if (text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength) {
			throw new IllegalArgumentException(
					"Could not parse date: it is not exactly" + this.exactDateLength + "characters long");
		}
		else {
			try {
				setValue(this.format.parse(text));
			}
			catch (ParseException ex) {
				IllegalArgumentException iae =
						new IllegalArgumentException("Could not parse date: " + ex.getMessage());
				iae.initCause(ex);
				throw iae;
			}
		}


	}

}
