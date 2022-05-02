import org.junit.Test;

import java.util.Date;

public class test {



    /*
    * 要求：
    * 1911=<year<=2050,
    * 1=<month<=12,
    * 1=<day<=31
    * */
    private String nextDate(int year,int month,int day){


        //判断是否是闰年
        boolean b=false;
        if ((year%4==0&&year%100!=0)||(year%400==0)){
            b=true;

        }

        if (year<1911||year>2050){
            return "年份不在范围";
        }
        if (month<1||month>12){
            return "月分不在范围";
        }

        //判断是否是2月
        if (month==2){
            //判断是否是闰年
            if (b){
                if (day<1||day>28){
                    return "闰年2月只有28天";
                }
                if (day==28){
                    day=1;
                    month++;
                    if (month>12){
                        month=1;
                        year++;
                        if (year>2050){
                            return "日期超过范围";
                        }
                    }
                }else {
                    day++;
                }
            }else{
                if (day<1||day>29){
                    return "2月最多29天";
                }
                if (day==29){
                    day=1;
                    month++;
                    if (month>12){
                        month=1;
                        year++;
                        if (year>2050){
                            return "日期超过范围";
                        }
                    }
                } else {
                    day++;
                }
            }
        }else {
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day<1||day>31){
                        return "日期格式不对";
                    }
                    if (day==31){
                        day=1;
                        month++;
                        if (month>12){
                            month=1;
                            year++;
                            if (year>2050){
                                return "日期超过范围";
                            }
                        }
                    } else {
                        day++;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day<1||day>30){
                        return "日期格式不对";
                    }
                    if (day==30){
                        day=1;
                        month++;
                        if (month>12){
                            month=1;
                            year++;
                            if (year>2050){
                                return "日期超过范围";
                            }
                        }
                    } else {
                        day++;
                    }
                    break;

            }
        }


        return "明天是"+year+"年"+month+"月"+day+"日";
    }


    @Test
    public void  testNextDate(){


        System.out.println("------------------------一般测试--------------------------------");
        System.out.println(nextDate(2022, 4, 18));
        System.out.println("------------------------边界测试--------------------------------");
        System.out.println("===上边界===");
        System.out.println(nextDate(2050,12,30));
        System.out.println(nextDate(2050, 12, 31));
        System.out.println("===下边界===");
        System.out.println(nextDate(1910,12,31));
        System.out.println(nextDate(1911, 1, 1));
        System.out.println("------------------------特殊值测试--------------------------------");
        System.out.println("===闰年的2月===");
        System.out.println(nextDate(2000,2,28));
        System.out.println(nextDate(2000,2,29));
        System.out.println("===非闰年的2月===");
        System.out.println(nextDate(2100,2,30));
        System.out.println(nextDate(2100,2,29));
        System.out.println("===day最值===");
        System.out.println(nextDate(2000,3,31));
        System.out.println(nextDate(2000,4,30));
        System.out.println("===month最值===");
        System.out.println(nextDate(2000,12,31));

    }



}

