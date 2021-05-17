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
        dateRanges.add(new DateRange(LocalDate.of(2014, 3, 10), LocalDate.of(2014, 4, 15)));
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
            
            if(startDate.isBefore(endDate)) {
                for(DateRange mergedDate : mergedDateRange){
                    LocalDate startDateM = mergedDate.getStartDate();
                    LocalDate endDateM = mergedDate.getEndDate();
                    
                    if(startDate.isBefore(endDateM)) {
                        startDate =  startDateM;
                        
                    }
                    if(endDate.isBefore(endDateM)) {
                        endDate = endDateM;
                    }
                }
            }else {
                mergedDateRange.add(new DateRange(startDate, endDate));
            }
            mergedDateRange.clear();
            mergedDateRange.add(new DateRange(startDate, endDate));
        }
        
        return mergedDateRange;
    }

}