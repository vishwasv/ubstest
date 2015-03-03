package com.ubs.opsit.interviews;
public enum TimeFormatEnum {
	TWELVEHHOUR("h[h]:mm:ss a"),
	TWENTYFOURHOUR("H[H]:mm:ss");
	
	private final String format;       

    private TimeFormatEnum(String format) {
        this.format =format ;
    }

    public boolean equalsName(String otherformat) {
         return format.equals(otherformat);
    }

    public String toString() {
       return this.format;
    }
    public static TimeFormatEnum getFormat(String formatStr){
    	for(TimeFormatEnum format : TimeFormatEnum.values()){
    		if(formatStr.equals(format.toString())){
    			return format;
    		}
    	}
    	throw new IllegalArgumentException(
    		    "No enum const " + TimeFormatEnum.class + "@name." + formatStr);
    }
}
