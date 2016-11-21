# nepali-english-date-conversion-for-java
Trying to build a reusable simple java class for nepali to english date conversion and vice-versa
NOT READY YET


##English to Nepali Conversion

```
        Converter converter = new Converter();
        NepaliDate nepaliDate = converter.getNepaliDate(1992, 4, 20);
        
        System.out.println("Equivalent Nepali date is " + nepaliDate.toString());
        System.out.println("Nepali year is " + nepaliDate.getSaal());
        System.out.println("Nepali month is " + nepaliDate.getMahinaInWords());
        System.out.println("Nepali date is " + nepaliDate.getGatey());
```
Output: 
>Equivalent Nepali date is 2049 / 1 / 8 Monday <br>
Nepali year is 2049 <br>
>Nepali month is Baisakh <br>
>Nepali date is 8 <br>

##Nepali to English Conversion
```
        Converter converter = new Converter();
        EnglishDate englishDate = converter.getEnglishDate(2049, 1, 8);

        System.out.println("Equivalent English date is " + englishDate.toString());
        System.out.println("English year is " + englishDate.getYear());
        System.out.println("English month is " + englishDate.getMonthAsText());
        System.out.println("English date is " + englishDate.getDate());
```
Output:
>Equivalent English date is 1992 / 4 / 20 Monday<br>
>English year is 1992<br>
>English month is April<br>
>English date is 20<br>


##A complete Nepali month
List of all days in a month can be obtained (which can be useful to render as a calendar)

```
        Converter converter = new Converter();

        List<NepaliDate> nepaliDateList = converter.getFullNepaliMonthOf(1992, 4, 20);

        for (NepaliDate nepaliDate: nepaliDateList){
            System.out.println(nepaliDate.toString());
        }
```

Thank you!
