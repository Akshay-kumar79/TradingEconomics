package com.example.tradingeconomics

import com.example.tradingeconomics.models.CalendarModel
import com.example.tradingeconomics.models.Market
import com.example.tradingeconomics.models.News
import java.util.*
import kotlin.collections.ArrayList

//TODO() time convertor for news
//TODO() remove this class
object TempTesting {

    fun getHomePageNews(): ArrayList<News>{
        val news: ArrayList<News> = ArrayList()
        news.add(News("Australia Holds Rates", "The Reserve Bank of Australia kept the cash rate unchanged at a record low of 0.1% during its November meeting, as widely expected.", "49m ago", "Commodity"))
        news.add(News("Dollar Steady Ahead of Fed Policy Meeting", "The US dollar index held near 94 on Tuesday, trading half a percent below a 52-week high hit early in October amid rising expectations for earlier US interest rate hikes after the latest inflation data rose faster than expected. The headline inflation jumped 4.4% YoY while the Fed-preferred core inflation increased 3.6% YoY in September, challenging the Federal Reserve’s “transitory” narrative. Analysts brought forward US rate hike projections, with Goldman Sachs pinning the first hike in July next year followed by another increase in November 2022. Meanwhile, markets now await policy outlook guidance from the conclusion of the Nov. 2-3 FOMC meeting.", "57m ago","United States"))
        news.add(News("Brent Crude Rises as OPEC Output Disappoints", "Brent crude futures rose towards \$85 per barrel on Tuesday, amid reports that OPEC failed to reach output targets in October. OPEC’s oil output rose 190,000 barrels per day in October, falling short of the 254,00 increase permitted under a supply deal as higher production from Saudi Arabia and Iraq were offset by involuntary outages in African producers Nigeria, Libya, Congo, Equatorial Guinea and Gabon, according to a Reuters survey. Meanwhile, OPEC+ is expected to stick with a planned 400,000 barrels per day output increase in December ahead of its Nov. 4 meeting, despite calls from big oil consumers including the US to raise production. Elsewhere, US crude oil inventory reports from API and EIA are due for release on Tuesday and Wednesday, respectively.", "1h 35m ago", "Australia"))

        return news
    }

    fun getMarketList(): ArrayList<Market>{
        val marketList: ArrayList<Market> = ArrayList()
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))
        marketList.add((Market("US30", "South africa", 1.15245, 2.45147)))

        return marketList
    }

//    fun getCalendarList(): ArrayList<CalendarModel>{
//        val calendarList: ArrayList<CalendarModel> = ArrayList()
//        calendarList.add(CalendarModel("Inflation Rate YoY", "3:30", "Thailand", "(Oct)", 1.68, 1.91))
//        calendarList.add(CalendarModel("Inflation Rate YoY", "3:30", "Thailand", "(Oct)", 1.68, 1.91))
//        calendarList.add(CalendarModel("Inflation Rate YoY", "3:30", "Thailand", "(Oct)", 1.68, 1.91))
//        calendarList.add(CalendarModel("Inflation Rate YoY", "4:30", "Thailand", "(Oct)", 1.68, 1.91))
//        calendarList.add(CalendarModel("Inflation Rate YoY", "4:30", "Thailand", "(Oct)", 1.68, 1.91))
//        calendarList.add(CalendarModel("Inflation Rate YoY", "4:30", "Thailand", "(Oct)", 1.68, 1.91))
//        calendarList.add(CalendarModel("Inflation Rate YoY", "3:30", "Thailand", "(Oct)", 1.68, 1.91))
//        calendarList.add(CalendarModel("Inflation Rate YoY", "5:30", "Thailand", "(Oct)", 1.68, 1.91))
//        calendarList.add(CalendarModel("Inflation Rate YoY", "5:30", "Thailand", "(Oct)", 1.68, 1.91))
//        calendarList.add(CalendarModel("Inflation Rate YoY", "5:30", "Thailand", "(Oct)", 1.68, 1.91))
//
//        return  calendarList
//    }

}