package com.ubs.opsit.interviews;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Arrays;

/**
 * The Berlin Clock converter supporting both 24hr and 12hr clock conversion  
 * 
 * @author Vishwas
 *
 */
public class BerlinClockTimeConverter implements TimeConverter {

	private TimeFormatEnum timeFormat;
	private DateTimeFormatter formatter;
	public BerlinClockTimeConverter(String timeFormat){
		this.timeFormat = TimeFormatEnum.getFormat(timeFormat);
		formatter=getDateFormater();
	}
	public String convertTime(String aTime) {
		String hour=getHourFormat(aTime);
		String minute=getMinuteFormat(aTime);
		String second=getSecondFormat(aTime);
		String resultTime=concatinateTime(hour,minute,second);
		return resultTime;
	}
	
	// convert the hour format to the Berlin clock hour format
	private String getHourFormat(String aTime){
		String result="OOOO"+System.lineSeparator()+"OOOO";
		int hour=0;
		
		// Edge case 00:00:00 == 24:00:00 == 12:00:00 AM , if user pass 24 or 12  it should be treat like 24 and 12 not 00  
		if((aTime.equals("24:00:00") && timeFormat.equals(TimeFormatEnum.TWENTYFOURHOUR))
				 || (aTime.equals("12:00:00 AM") && timeFormat.equals(TimeFormatEnum.TWELVEHHOUR))){
			hour=24;
		}else{
			LocalDateTime time = LocalDateTime.parse(aTime ,formatter);
		    hour=time.getHour();
		}
		if(hour != 0){
			int hour_5=hour/5;
			int hour_1=hour%5;
			result=getOutputFormat(4,hour_5,'R','O')+System.lineSeparator();
			result = result + getOutputFormat(4,hour_1,'R','O');
		}	    
	    return result;
	}
	
	// Convert minute format to the Berlin clock minute format
	private String getMinuteFormat(String aTime){
		String result= "OOOOOOOOOOO"+System.lineSeparator()+"OOOO";
		LocalDateTime time = LocalDateTime.parse(aTime ,formatter);
		int minute=time.getMinute();
		if(minute != 0){
			int min_5=minute/5;
			int min_1=minute%5;
			result=getOutputFormat(11,min_5,'Y','O')+System.lineSeparator();
			// Every third value in minute is 'R' not 'Y' in test cases  so handling that
			if(min_5 >=3){
				char[] min_arr=result.toCharArray();
				for(int i=0;i<min_5;i++){
					if((i+1)%3 == 0 && min_arr[i] == 'Y'){
						min_arr[i]='R';
					}
				}
				result = new String(min_arr);
			}
			
			result = result + getOutputFormat(4,min_1,'Y','O');
		}
		return result;
	}
	//Convert the Second to the Berlin clock second format
	private String getSecondFormat(String aTime){
		LocalDateTime time = LocalDateTime.parse(aTime ,formatter);
		int second=time.getSecond();
		return second%2 == 0? "Y" : "O";
	}
	
	// Combine all Second , Hour , Minute  format to get Berlin CLock Format
	private String concatinateTime(String hour, String minute , String second){
		return second+System.lineSeparator()+
				hour+System.lineSeparator()+minute;
	}

	private DateTimeFormatter getDateFormater(){
		DateTimeFormatter FORMATTER =  
				 new DateTimeFormatterBuilder().appendPattern("[dd/MM/yyyy ]"+timeFormat.toString())
	            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
	            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
	            .parseDefaulting(ChronoField.YEAR, 0)
	            .toFormatter(); 
		return FORMATTER;
		
	}
	
	private String getOutputFormat(int length , int times, char out , char defaultchar){
		char[] outchar= new char[length];
		Arrays.fill(outchar, defaultchar);
		if(times > 0 ) {
			for(int i=0;i<times;i++){
				outchar[i]=out;
			}
		}
		return new String(outchar);
	}
	
	
}


