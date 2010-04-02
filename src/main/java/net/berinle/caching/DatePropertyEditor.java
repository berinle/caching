package net.berinle.caching;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DatePropertyEditor extends PropertyEditorSupport {
	private static Logger log = Logger.getLogger(DatePropertyEditor.class);
	private String format = "MM/dd/yyyy";
	
	public void setAsText(String text) {
		SimpleDateFormat sdf = new SimpleDateFormat( format );
		Date date = null;
		
		if ( text != null && text.trim().length() > 0 ) {
			try {
				date = sdf.parse( text.trim() );
			} catch (ParseException e) {
				log.error( "Could not parse date text - ParseException" );
				e.printStackTrace();
			}
		}
		setValue( date );
	}
	
	public String getAsText() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat( format );
		String returnStr = "";
		
		if ( getValue() != null && getValue() instanceof Date ) {
			log.info( "This is the current value: " + getValue() );
			log.info( "Converting Date: " + (Date) getValue() + " to a string: " + simpleDateFormat.format( (Date) getValue() ) );
			returnStr = simpleDateFormat.format( (Date) getValue() );
		}
		
		return returnStr;
	}
	
}
