package Interview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateMerger {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<DateRange> dateRanges = new ArrayList<>();
        dateRanges.add(new DateRange(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 1, 30)));
        dateRanges.add(new DateRange(LocalDate.of(2014, 1, 15), LocalDate.of(2014, 2, 15)));
        dateRanges.add(new DateRange(LocalDate.of(2014, 3, 10), LocalDate.of(2014, 4, 10)));
        dateRanges.add(new DateRange(LocalDate.of(2014, 4, 10), LocalDate.of(2014, 5, 15)));
        
        System.out.println("==============INPUT====================");
        for(DateRange maDate : dateRanges) {
            
            System.out.println("StartDate : "+maDate.getStartDate() + " And EndDate : " +maDate.getEndDate());
        }
        
        System.out.println();
        
        List<DateRange> mergedDates = mergeDates(dateRanges);
        
        System.out.println("==============OUTPUT====================");
        
        for(DateRange mDate : mergedDates) {
            
            System.out.println("StartDate : "+mDate.getStartDate() + " And EndDate : " +mDate.getEndDate());
            
        } 
    }
    
    private static List<DateRange> mergeDates(List<DateRange> dateRanges) {
        // TODO Auto-generated method stub
        List<DateRange> mergedDateRange = new ArrayList<>();
        for(DateRange date : dateRanges) {
            
            LocalDate startDate = date.getStartDate();
            LocalDate endDate = date.getEndDate();
            
            int startMonth=startDate.getMonthValue();
            boolean isClear = false;
            
            if(startDate.isBefore(endDate)) {
            	for(DateRange mergeDate: mergedDateRange) {
            		 LocalDate startDateM =mergeDate.getStartDate();
            		 LocalDate endDateM =mergeDate.getEndDate();
            		 
            		 int endMonth = endDateM.getMonthValue();
            		 
            		 if(startDate.isBefore(endDate) && startMonth == endMonth) {
            			 startDate = startDateM;
            			 isClear = true;
            		 }
            		 if(endDate.isBefore(endDate)) {
            			 endDate =endDateM;
            		 }           		 
            	}          	
            }
            else {
            	mergedDateRange.add(new DateRange(startDate, endDate));
            }
            if(isClear) {
            	int index = mergedDateRange.size()-1;
            	mergedDateRange.remove(index);
            }
            mergedDateRange.add(new DateRange(startDate, endDate));
        }
		return mergedDateRange;
		}
    }
